CREATE TABLE book (
	book_id numeric PRIMARY KEY,
	author_id numeric,
	name VARCHAR(255),
	isbn VARCHAR(255),
	constraint fk_author foreign key(author_id) references author(author_id)
);

CREATE TABLE author (
	author_id numeric primary key,
	name     VARCHAR(255),
	mobile   CHAR(10)
);

INSERT INTO author(author_id, name, mobile) VALUES (100,'John Green','30303');
INSERT INTO author(author_id, name, mobile) VALUES(101,'Maureen Johnson','4343');
INSERT INTO author(author_id, name, mobile) VALUES(102,'Lauren Myracle','76665');
INSERT INTO author(author_id, name, mobile) VALUES(103,'Greg Mortenson','6434');
INSERT INTO author(author_id, name, mobile) VALUES(104,'David Oliver Relin','72322');

INSERT INTO book VALUES (1, 100, 'Let is Snow', 'ISBN3030303');
INSERT INTO book VALUES (2, 101, 'Three Cups of Tea','ISBN638242');
INSERT INTO book VALUES (3, 102, 'Hamlet','ISBN638365');
INSERT INTO book VALUES (4, 102, 'The Odyssey','ISBN638365');
INSERT INTO book VALUES (5, 103, 'Moby Dick','ISBN638365');
INSERT INTO book VALUES (6, 103, 'The Great Gatsby','ISBN638365');
INSERT INTO book VALUES (7, 104, 'In Search of Lost Time','ISBN638365');
INSERT INTO book VALUES (8, 104, 'Don Quixote','ISBN638365');
INSERT INTO book VALUES (9, 104, 'Madame Bovary','ISBN638365');
INSERT INTO book VALUES (10, 101, 'War and Peace','ISBN638365');