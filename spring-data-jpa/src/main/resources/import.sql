insert into Address (id, city, street, street_number, postal_code) values (1, 'Wrocław', 'Rynek', '44', '55-555');
insert into Address (id, city, street, street_number, postal_code) values (2, 'Wrocław', 'Strzegomska', '42', '55-551');

insert into Library (id, name, address_id, version) values (1, 'Biblioteka Rynek', 1, 1);
insert into Library (id, name, address_id, version) values (2, 'Biblioteka Miejska', 2, 1);

insert into Book (id, title, library_id) values (1, 'Sample Book', 1);

insert into Person (id, first_name, last_name, age) values (1, 'Jan', 'Kowalski', 44);
insert into Author (author_id, publications) values (1, 15);

insert into book_author (BOOK_ID, AUTHOR_ID) values (1, 1);