create schema `wineShop`;
DROP DATABASE IF EXISTS wineShop;
CREATE DATABASE wineShop DEFAULT CHARACTER SET utf8;

USE wineShop;

GRANT ALL ON wineShop.* TO 'root'@'%' IDENTIFIED BY 'root';

FLUSH PRIVILEGES;