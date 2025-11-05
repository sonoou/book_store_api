package com.bookstore.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AuthorDTO {
    private Long id;
    private String name;
    private String email;
    private String bio;
    private String nationality;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<BookDTO> books;

    // Constructors
    public AuthorDTO() {
    }

    public AuthorDTO(Long id, String name, String email, String bio, String nationality) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.nationality = nationality;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public List<BookDTO> getBooks() { return books; }
    public void setBooks(List<BookDTO> books) { this.books = books; }
}