/*Tables Creation*/

CREATE TABLE profile
(
    id               BIGSERIAL PRIMARY KEY NOT NULL,
    username         varchar(40)           NOT NULL,
    password         varchar(40)           NOT NULL,
    first_name       varchar(40)           NOT NULL,
    last_name        varchar(40)           NOT NULL,
    street_address   varchar(40)           NOT NULL,
    street_address_2 varchar(40)                   ,
    city             varchar(20)           NOT NULL,
    state            varchar(25)           NOT NULL,
    zip_code         varchar(10)           NOT NULL
);

CREATE TABLE credit_card
(
    id              BIGSERIAL PRIMARY KEY NOT NULL,
    number          varchar(24)           NOT NULL,
    expiration_date varchar(10)           NOT NULL,
    cvv             varchar(5)            NOT NULL,
    username        varchar(24)           NOT NULL
);

CREATE TABLE author
(
    id BIGSERIAL PRIMARY KEY NOT NULL
);

CREATE TABLE book
(
    id          BIGSERIAL PRIMARY KEY NOT NULL,
    copies_sold integer DEFAULT 0,
    genre       varchar(30)
);

CREATE TABLE book_rating
(
    book_id    BIGSERIAL NOT NULL,
    profile_id BIGSERIAL NOT NULL,
    rating     integer,
    CONSTRAINT FK_Book_Rating FOREIGN KEY (book_id) REFERENCES book (id),
    CONSTRAINT FK_Profile_Rating FOREIGN KEY (profile_id) REFERENCES profile (id)
);
CREATE TABLE book_comment
(
    id          BIGSERIAL PRIMARY KEY NOT NULL,
    profile_id  BIGSERIAL             NOT NULL,
    book_id     BIGSERIAL             NOT NULL,
    date        date                  NOT NULL,
    description varchar(300)          NOT NULL,
    CONSTRAINT FK_Profile_Comment FOREIGN KEY (profile_id) REFERENCES profile (id)
);

CREATE TABLE shopping_cart
(
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    profile_id BIGSERIAL             NOT NULL,
    CONSTRAINT profile_shopping_cart FOREIGN KEY (profile_id) REFERENCES profile (id)
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
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    profile_id BIGSERIAL             NOT NULL,
    name       varchar(30) UNIQUE    NOT NULL,
    CONSTRAINT profile_wish_list FOREIGN KEY (profile_id) REFERENCES profile (id)
);
CREATE TABLE wishlist_books
(
    wishlist_id BIGSERIAL NOT NULL,
    book_id     BIGSERIAL NOT NULL,
    CONSTRAINT FK_Wishlist FOREIGN KEY (wishlist_id) REFERENCES wishlist (id),
    CONSTRAINT FK_Wishlist_Book FOREIGN KEY (book_id) REFERENCES book (id)
);

/*Data Insertions*/

/*Test users to be tested*/

INSERT INTO profile
(id, username, password, first_name, last_name, street_address, street_address_2, city, state,
 zip_code)
VALUES (201, '9hasui@gmail.com', 'ThedarkRock', 'Carlos', 'Shawn', '19808 Cade Park Dr ', NULL,
        'Los Suenos', 'FL', 331908),
       (202, 'uajhsy@yahoo.com', 'losTinparadise', 'Mathew', 'James', '2178 Ola St', NULL,
        'Pink Sky City', 'GA', 333890),
       (203, 'ausjje@yahoo.com', 'thinkinGthehardway', 'Daniel', 'Brown', '3589 West Holss St',
        NULL,  'Doortown', 'CA', 332897);

INSERT INTO credit_card
    (id, number, expiration_date, cvv, username)
VALUES (101, '8798567562768277', '05/31/2027', '453', '9hasui@gmail.com'),
       (103, '4812120923228329', '02/06/2021', '127', 'uajhsy@yahoo.com');


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
INSERT INTO wishlist(id, name, profile_id)
VALUES (0, 'test 1', 201);
INSERT INTO wishlist_books(wishlist_id, book_id)
VALUES (0, 1);
