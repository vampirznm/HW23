create table author
(
    id     serial primary key,   -- id номера заказа
    author varchar(100) not null -- Покупатель
);

insert into author(author)
values ('Лев Толстой'),
       ('Габриэль Гарсия Маркес'),
       ('Джонатан Свифт');


create table book
(
    id        serial primary key,    -- id
    name_book varchar(150) not null, -- Название книги
    author_id integer      not null, -- id Автора
    quantity  integer      not null, -- Количество

    foreign key (author_id) references author (id)
);

insert into book(name_book, author_id, quantity)
values ('Война и мир', 10, 20),
       ('Сто лет одиночества', 30, 15),
       ('Путешествия Гулливера', 20, 13),
       ('О дивный новый мир', 80, 10);

create table orders
(
    id          serial primary key,    -- id номера заказа
    book        integer      not null, -- Книга
    quantity    integer      not null, -- Количество
    buyers_name varchar(100) not null, -- Покупатель
    date_order  date         not null, -- Дата

    foreign key (book) references book (id)
);
insert into orders(book, quantity, buyers_name, date_order)
values (1, 1, 'Алексей Иванов', '2021-04-01'),
       (1, 1, 'Юлия Соколова', '2021-04-10');