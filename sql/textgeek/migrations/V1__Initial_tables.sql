CREATE TABLE author
(
    id BIGSERIAL PRIMARY KEY NOT NULL
);

CREATE TABLE book
(
    id          BIGSERIAL PRIMARY KEY NOT NULL,
    copies_sold INTEGER DEFAULT 0,
    genre       VARCHAR(30)
);
CREATE TABLE profile
(
    id BIGSERIAL PRIMARY KEY NOT NULL
);
CREATE TABLE book_rating
(
    book_id    BIGSERIAL NOT NULL,
    profile_id BIGSERIAL NOT NULL,
    rating     INTEGER,
    CONSTRAINT FK_Book_Rating FOREIGN KEY (book_id) REFERENCES book (id),
    CONSTRAINT FK_Profile_Rating FOREIGN KEY (profile_id) REFERENCES profile (id)
);
CREATE TABLE book_comment
(
    id BIGSERIAL PRIMARY KEY NOT NULL
);
CREATE TABLE credit_card
(
    id BIGSERIAL PRIMARY KEY NOT NULL
);
CREATE TABLE user_credit_card
(
    card_id    BIGSERIAL NOT NULL,
    profile_id BIGSERIAL NOT NULL,
    CONSTRAINT FK_Profile_Card FOREIGN KEY (profile_id) REFERENCES profile (id),
    CONSTRAINT FK_Card_Card FOREIGN KEY (card_id) REFERENCES credit_card (id)
);
CREATE TABLE shopping_cart
(
    id BIGSERIAL PRIMARY KEY NOT NULL
);
CREATE TABLE shopping_cart_books
(
    shopping_cart_id BIGSERIAL NOT NULL,
    book_id          BIGSERIAL NOT NULL,
    CONSTRAINT FK_Shopping_Cart FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart (id),
    CONSTRAINT FK_Shopping_Cart_Book FOREIGN KEY (book_id) REFERENCES book (id)
);
CREATE TABLE wishlist
(
    id BIGSERIAL PRIMARY KEY NOT NULL
);
CREATE TABLE wishlist_books
(
    wishlist_id BIGSERIAL NOT NULL,
    book_id     BIGSERIAL NOT NULL,
    CONSTRAINT FK_Wishlist FOREIGN KEY (wishlist_id) REFERENCES wishlist (id),
    CONSTRAINT FK_Wishlist_Book FOREIGN KEY (book_id) REFERENCES book (id)
);

INSERT INTO book (copies_sold, genre)
VALUES (15, 'fantasy');
INSERT INTO book (copies_sold, genre)
VALUES (100, 'romance');
INSERT INTO book (copies_sold, genre)
VALUES (55, 'fantasy');
INSERT INTO book (copies_sold, genre)
VALUES (67, 'romance');
INSERT INTO book (copies_sold, genre)
VALUES (324, 'fantasy');
INSERT INTO book (copies_sold, genre)
VALUES (347, 'romance');
INSERT INTO book (copies_sold, genre)
VALUES (34, 'fantasy');
INSERT INTO book (copies_sold, genre)
VALUES (75, 'romance');
INSERT INTO book (copies_sold, genre)
VALUES (85, 'fantasy');
INSERT INTO book (copies_sold, genre)
VALUES (43, 'romance');
INSERT INTO book (copies_sold, genre)
VALUES (23, 'fantasy');
INSERT INTO book (copies_sold, genre)
VALUES (2, 'romance');
INSERT INTO book (copies_sold, genre)
VALUES (954, 'fantasy');
INSERT INTO book (copies_sold, genre)
VALUES (346, 'romance');
INSERT INTO book (copies_sold, genre)
VALUES (357, 'fantasy');
INSERT INTO book (copies_sold, genre)
VALUES (235, 'romance');
INSERT INTO book (copies_sold, genre)
VALUES (963, 'fantasy');
INSERT INTO book (copies_sold, genre)
VALUES (734, 'romance');
INSERT INTO book (copies_sold, genre)
VALUES (246, 'fantasy');
INSERT INTO book (copies_sold, genre)
VALUES (163, 'romance');
INSERT INTO book (copies_sold, genre)
VALUES (78, 'fantasy');
INSERT INTO book (copies_sold, genre)
VALUES (95, 'romance');
INSERT INTO book (copies_sold, genre)
VALUES (43, 'fantasy');
INSERT INTO book (copies_sold, genre)
VALUES (75, 'romance');