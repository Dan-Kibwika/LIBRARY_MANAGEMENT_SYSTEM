
CREATE DATABASE LIBRARY_MANAGEMENT_SYSTEM_V5;
USE LIBRARY_MANAGEMENT_SYSTEM_V5;




CREATE TABLE person(

        lastName CHAR(225) ,
        surname  CHAR(225),
        nationalID  VARCHAR(225) PRIMARY KEY ,
        gender  CHAR(225), 
        dateOfBith  CHAR(225)
        );
        
        
        
       CREATE TABLE user  (
        status  CHAR(225), 
        userKey  VARCHAR(225),
        nationalID  CHAR(225),
        FOREIGN KEY (nationalID) REFERENCES person (nationalID) 
        );
        
        
        
        CREATE TABLE  book (
        book_id VARCHAR(25) PRIMARY KEY AUTO_INCREMENT ,
        book_edition CHAR(225),
        authorm CHAR(225),
        category CHAR(225),
        number CHAR(225),
        bookName  CHAR(225)
        );
        
        
		 CREATE TABLE  book (
         
         book_id INT PRIMARY KEY  AUTO_INCREMENT,
         book_edition CHAR(225),
         author CHAR(225),
         category CHAR(225),
         number CHAR(225),
         bookName  CHAR(225)
         
         )
         
         
      SELECT* FROM person;
          SELECT* FROM user;
              SELECT* FROM book;
    
         