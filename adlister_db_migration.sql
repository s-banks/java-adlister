USE adlister_db;

DROP TABLE IF EXIST users;
CREATE TABLE IF NOT EXIST users;
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(16) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (username, email)
)

DROP TABLE IF EXIST ads;
CREATE TABLE IF NOT EXIST ads;
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT,
    title VARCHAR(100) NOT NULL,
    description VARChAR(250) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    UNIQUE (title)
)
