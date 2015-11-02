create database Employee_details;
use Employee_details;
create table employee(
id int auto_increment primary key ,
name varchar(30),
email varchar(100),
date_of_birth Date,
address varchar(200)
);

insert into Employee values(1, "Amit", "amit@gmail.com", '1993-12-26', "Jhotwara");
insert into Employee values(2, "Rohit", "rohit@gmail.com", '1994-03-28', "Vaishali");
insert into Employee values(3, "Babalu", "babalu@gmail.com", '1992-12-26', "VDN");
insert into Employee values(4, "Banwari", "banwari@gmail.com", '1991-12-26', "Banipark");

select * from employee;

desc employee;