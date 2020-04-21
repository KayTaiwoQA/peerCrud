create database if not exists peerdb;

CREATE TABLE if not exists peerdb.users(
userID int auto_increment,
userName varchar(100) unique,
`password` varchar(30),
firstname varchar(30),
lastname varchar(30),
primary key(userID)
);

CREATE TABLE if not exists peerdb.products(
productID int auto_increment,
productName varchar(50),
price double,
stock int,
primary key(productID)
);

CREATE TABLE if not exists peerdb.orders(
orderID int auto_increment,
productID int,
userID int,
quantity int,
price double,
primary key(orderID),
foreign key(userID) references users(userID),
foreign key(productID) references products(productID)
);

select * from peerdb.users;
describe peerdb.users;