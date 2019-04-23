--drop table if exists users;
create table user(
    ID INT PRIMARY KEY AUTO_INCREMENT not null,
    user_name varchar(40),
    user_count int
);
--insert into user(user_name, user_count) values ("Anele", 1);



