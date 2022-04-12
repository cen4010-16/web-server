
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
    genre       varchar(30),
    author       varchar(100),
    title       varchar(100),
    cover_url varchar(350)
);

CREATE TABLE book_rating
(
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    book_id    BIGSERIAL             NOT NULL,
    profile_id BIGSERIAL             NOT NULL,
    rating     INTEGER CHECK (rating > 0 AND rating <= 5),
    created    TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    CONSTRAINT FK_Book_Rating FOREIGN KEY (book_id) REFERENCES book (id),
    CONSTRAINT FK_Profile_Rating FOREIGN KEY (profile_id) REFERENCES profile (id)
);


CREATE TABLE book_comment
(
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    book_id    BIGSERIAL             NOT NULL REFERENCES book (id),
    profile_id BIGSERIAL             NOT NULL REFERENCES profile (id),
    text       VARCHAR(280)          NOT NULL,
    created    TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
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

INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (15, 'fiction', 'J.K. Rowling/Mary GrandPré', 'Harry Potter and the Half-Blood Prince', 'https://www.image.com/213124');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (100, 'fiction', 'J.K. Rowling/Mary GrandPré', 'Harry Potter and the Order of the Phoenix','https://www.image.com/342523');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (55, 'fiction', 'J.K. Rowling', 'Harry Potter and the Chamber of Secrets', 'https://www.image.com/23124');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (67, 'fiction', 'J.K. Rowling/Mary GrandPré', 'Harry Potter and the Prisoner of Azkaban', 'https://www.image.com/66577');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (324, 'romance','Charles Willeford/Elmore Leonard', 'Miami Blues', 'https://www.image.com/86456');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (347, 'romance','Henry Miller', 'Nexus','https://www.image.com/546454');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (34, 'action', 'Marguerite Duras/Barbara Bray', 'The War', 'https://www.image.com/45367');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (75, 'romance', 'Kahlil Gibran/Suheil Bushrui/Salma H. Al-Kuzbari', 'Love Letters', 'https://www.image.com/57432');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (85, 'fantasy', 'Joan Didion/David Thomson', 'Play It As It Lays','https://www.image.com/125734');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (43, 'romance','Paul Auster/Art Spiegelman/Luc Sante', 'The New York Trilogy', 'https://www.image.com/734623');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (23, 'fantasy', 'Paul Auster', 'City of Glass', 'https://www.image.com/364523');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (2, 'romance', 'Peter Moon/Preston B. Nichols/Nina Helms', 'Pyramids of Montauk: Explorations in Consciousness','https://www.image.com/475334');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (954, 'fantasy', 'Stephen Leeb/Glen C. Strathy', 'The Coming Economic Collapse: How You Can Thrive When Oil Costs $200 a Barrel', 'https://www.image.com/324323');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (346, 'romance', 'Joseph A. Tainter', 'Collapse of Complex Societies', 'https://www.image.com/2352567');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (357, 'fantasy', 'Robert D. Putnam', 'Bowling Alone: The Collapse and Revival of American Community', 'https://www.image.com/32556');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (235, 'romance', 'Philip K. Howard', 'The Collapse of the Common Good: How America''s Lawsuit Culture Undermines Our Freedom', 'https://www.image.com/85687');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (963, 'fantasy', 'Nikola Tesla', 'My Inventions', 'https://www.image.com/4563643');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (734, 'romance', 'William Golding', 'Lord of the Flies', 'https://www.image.com/dsfgdsfs');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (246, 'fantasy', 'Ephraim Sevela/Antonina W. Bouis', 'We Were Not Like Other People', 'https://www.image.com/435gs');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (163, 'romance', 'Alice Sebold', 'The Lovely Bones', 'https://www.image.com/sdfs4323');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (78, 'fantasy', 'Kevin O''Malley/Carol Heyer/Scott Goto', 'Once Upon a Cool Motorcycle Dude', 'https://www.image.com/sdfsdf435');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (95, 'romance', 'Ayn Rand/Leonard Peikoff', 'We the Living', 'https://www.image.com/dsfs4355');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (43, 'fantasy', 'Lonely Planet/Sarah Johnstone/Tom Masters', 'Lonely Planet Londres', 'https://www.image.com/324dsfgd');
INSERT INTO book (copies_sold, genre, author, title, cover_url)
VALUES (75, 'romance', 'George S. Clason', 'The Richest Man in Babylon', 'https://www.image.com/22343sad4');

INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (1, 1, 201, 5);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (2, 2, 201, 4);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (3, 3, 201, 1);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (4, 4, 201, 3);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (5, 5, 201, 2);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (6, 6, 201, 5);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (7, 7, 201, 3);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (8, 8, 201, 2);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (9, 9, 201, 4);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (10, 10, 201, 5);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (11, 11, 201, 2);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (12, 12, 201, 1);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (13, 13, 201, 4);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (14, 14, 201, 3);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (15, 15, 201, 4);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (16, 16, 201, 5);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (17, 17, 201, 1);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (18, 18, 201, 1);

INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (19, 1, 202, 4);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (20, 2, 202, 5);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (21, 3, 202, 3);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (22, 4, 202, 2);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (23, 5, 202, 5);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (24, 6, 202, 4);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (25, 7, 202, 3);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (26, 8, 202, 2);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (27, 9, 202, 5);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (28, 10, 202, 4);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (29, 11, 202, 4);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (30, 12, 202, 2);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (31, 13, 202, 1);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (32, 14, 202, 1);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (33, 15, 202, 2);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (34, 16, 202, 3);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (35, 17, 202, 4);
INSERT INTO book_rating (id, book_id, profile_id, rating)
VALUES (36, 18, 202, 2);


INSERT INTO wishlist(id, name, profile_id)
VALUES (0, 'test 1', 201);
INSERT INTO wishlist_books(wishlist_id, book_id)
VALUES (0, 1);
INSERT INTO shopping_cart(id, profile_id)
VALUES (0, 201);
INSERT INTO shopping_cart_books(shopping_cart_id, book_id)
VALUES (0, 1);

INSERT INTO book_comment(book_id, profile_id, text)
VALUES (1, 201, 'Great book!');