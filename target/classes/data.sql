-- Insert sample authors
INSERT INTO authors (name, email, bio, nationality, created_at, updated_at) VALUES
('J.K. Rowling', 'jk.rowling@email.com', 'British author best known for the Harry Potter series', 'British', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('George R.R. Martin', 'grrm@email.com', 'American novelist and short story writer', 'American', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('J.R.R. Tolkien', 'tolkien@email.com', 'English writer, poet, and academic', 'British', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Agatha Christie', 'agatha@email.com', 'English writer known for her detective novels', 'British', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert sample books
INSERT INTO books (title, isbn, description, publication_year, price, genre, page_count, publisher, author_id, created_at, updated_at) VALUES
('Harry Potter and the Philosopher''s Stone', '9780747532743', 'The first novel in the Harry Potter series', 1997, 19.99, 'Fantasy', 223, 'Bloomsbury', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('A Game of Thrones', '9780553103540', 'The first book in A Song of Ice and Fire series', 1996, 24.99, 'Fantasy', 694, 'Bantam Books', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('The Hobbit', '9780547928227', 'Fantasy novel and children''s book', 1937, 15.99, 'Fantasy', 310, 'Allen & Unwin', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Murder on the Orient Express', '9780062693662', 'A detective novel featuring Hercule Poirot', 1934, 12.99, 'Mystery', 256, 'Collins Crime Club', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Harry Potter and the Chamber of Secrets', '9780747538486', 'The second novel in the Harry Potter series', 1998, 21.99, 'Fantasy', 251, 'Bloomsbury', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('A Clash of Kings', '9780553108033', 'The second book in A Song of Ice and Fire series', 1998, 26.99, 'Fantasy', 768, 'Bantam Books', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);