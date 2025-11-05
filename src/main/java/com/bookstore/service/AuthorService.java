package com.bookstore.service;

import com.bookstore.dto.AuthorDTO;
import com.bookstore.model.Author;
import com.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Page<AuthorDTO> getAllAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable)
                .map(this::convertToDTO);
    }

    public Optional<AuthorDTO> getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(this::convertToDTO);
    }

    public AuthorDTO createAuthor(Author author) {
        if (authorRepository.existsByEmail(author.getEmail())) {
            throw new RuntimeException("Author with email " + author.getEmail() + " already exists");
        }
        Author savedAuthor = authorRepository.save(author);
        return convertToDTO(savedAuthor);
    }

    public Optional<AuthorDTO> updateAuthor(Long id, Author authorDetails) {
        return authorRepository.findById(id)
                .map(author -> {
                    author.setName(authorDetails.getName());
                    author.setEmail(authorDetails.getEmail());
                    author.setBio(authorDetails.getBio());
                    author.setNationality(authorDetails.getNationality());
                    Author updatedAuthor = authorRepository.save(author);
                    return convertToDTO(updatedAuthor);
                });
    }

    public boolean deleteAuthor(Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<AuthorDTO> searchAuthorsByName(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Page<AuthorDTO> searchAuthorsByName(String name, Pageable pageable) {
        return authorRepository.findByNameContaining(name, pageable)
                .map(this::convertToDTO);
    }

    public List<AuthorDTO> getAuthorsByNationality(String nationality) {
        return authorRepository.findByNationality(nationality).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AuthorDTO convertToDTO(Author author) {
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setEmail(author.getEmail());
        dto.setBio(author.getBio());
        dto.setNationality(author.getNationality());
        dto.setCreatedAt(author.getCreatedAt());
        dto.setUpdatedAt(author.getUpdatedAt());
        return dto;
    }
}