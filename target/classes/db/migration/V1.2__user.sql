--drop table if exists users;
create table user(
    id INT PRIMARY KEY AUTO_INCREMENT not null,
    user_name varchar(40) not null,
    user_count int not null
);




