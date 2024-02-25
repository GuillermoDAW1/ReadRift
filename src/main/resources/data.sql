INSERT INTO user_ (firstname, lastname, email, password, role) VALUES
    ('John', 'Doe', 'john@example.com', 'password', 'USER'),
    ('Jane', 'Smith', 'jane@example.com', 'password', 'USER');

INSERT INTO book (uuid, author, title, description, `condition`, available, url_image, isbn, owner_id) VALUES
    (uuid(), 'Author 1', 'Book 1', 'Description of Book 1', 'Good', TRUE, 'http://example.com/image1.jpg', '1234567890', 1),
    (uuid(), 'Author 2', 'Book 2', 'Description of Book 2', 'Fair', TRUE, 'http://example.com/image2.jpg', '0987654321', 2);

INSERT INTO exchange (uuid, borrower_id, donor_id,/* request_date*/ status) VALUES
    (uuid(), 1, 2,/* CURRENT_TIMESTAMP*/ 'PENDING'),
    (uuid(), 2, 1,/* CURRENT_TIMESTAMP*/ 'APPROVED');

/*INSERT INTO book_exchange (exchange_id, book_id) VALUES
    (1, 1),
    (2, 2);*/
