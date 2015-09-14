INSERT INTO Authors(author_id, author_nm) VALUES(101, "John");
INSERT INTO Authors(author_nm) VALUES("Steve");
INSERT INTO Authors(author_nm) VALUES("Smith");
INSERT INTO Authors(author_nm) VALUES("Bannet");
INSERT INTO Authors(author_nm) VALUES("Marsh");
INSERT INTO Authors(author_nm) VALUES("Carson");

SELECT * FROM Authors;

INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(1001,"BPB Publication");
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(1002,"Rajasthan Books Publication");
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(1003,"Jain Publication");
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(1004,"Shreenath Publication");
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(1005,"Rajasthan Books Publication");
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(1006,"Indian Books House");

SELECT * FROM Publishers;

INSERT INTO Subjects(subject_id, subject_nm) VALUES(501,"History");
INSERT INTO Subjects(subject_nm) VALUES("Science");
INSERT INTO Subjects(subject_nm) VALUES("Geography");
INSERT INTO Subjects(subject_nm) VALUES("Mathematics");
INSERT INTO Subjects(subject_nm) VALUES("English & Communication Skills");
INSERT INTO Subjects(subject_nm) VALUES("Computer");

SELECT * FROM Subjects;

INSERT INTO Members(member_id, member_nm, addressline1, addressline2, category) VALUES(10001,"Rohit","Durgapura","Jaipur",'M');
INSERT INTO Members(member_nm, addressline1, addressline2, category) VALUES("Avinash","Sitapura","Udaipur",'M');
INSERT INTO Members(member_nm, addressline1, addressline2, category) VALUES("Amit","Jhotwara","Alwar",'M');
INSERT INTO Members(member_nm, addressline1, addressline2, category) VALUES("Arushi","Kumbhamarg","Jaipur",'F');
INSERT INTO Members(member_nm, addressline1, addressline2, category) VALUES("Deepali","Pratapnagar","Jaipur",'F');
INSERT INTO Members(member_nm, addressline1, addressline2, category) VALUES("Akshat","Mansarovar","Dausa",'M');

SELECT * FROM Members;

INSERT INTO Titles(title_id, title_nm, subject_id, publisher_id) VALUES(5001,"History of Rajasthan",501,1004);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Geographical Structure of Earth",503,1002);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Reactions of Molecules",502,1006);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Basics of Computer",506,1001);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("English Grammer",504,1003);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Algebra & Coordinate Geomatery",505,1005);

SELECT * FROM Titles;

INSERT INTO Title_author(title_id, author_id) VALUES(5001,104);
INSERT INTO Title_author(title_id, author_id) VALUES(5002,102);
INSERT INTO Title_author(title_id, author_id) VALUES(5003,103);
INSERT INTO Title_author(title_id, author_id) VALUES(5004,106);
INSERT INTO Title_author(title_id, author_id) VALUES(5005,101);
INSERT INTO Title_author(title_id, author_id) VALUES(5006,105);

SELECT * FROM Title_author;

INSERT INTO Books(accession_no, title_id, purchase_dt, price, status) VALUES(201,5001,'2008-04-01', 500.64, 1);
INSERT INTO Books(title_id, purchase_dt, price, status) VALUES(5002,'2010-12-25', 250.54, 1);
INSERT INTO Books(title_id, purchase_dt, price, status) VALUES(5003,'2011-06-22', 275.54, 1);
INSERT INTO Books(title_id, purchase_dt, price, status) VALUES(5004,'2013-03-12', 450.54, 1);
INSERT INTO Books(title_id, purchase_dt, price, status) VALUES(5005,'2014-08-13', 650.54, 1);
INSERT INTO Books(title_id, purchase_dt, price, status) VALUES(5006,'2014-10-18', 350.54, 1);

SELECT * FROM Books;

INSERT INTO Book_issue(accession_no, member_id) VALUES(201,10003);
INSERT INTO Book_issue(accession_no, member_id) VALUES(202,10002);
INSERT INTO Book_issue(accession_no, member_id) VALUES(205,10004);
INSERT INTO Book_issue(accession_no, member_id) VALUES(206,10006);
INSERT INTO Book_issue(accession_no, member_id) VALUES(204,10005);
INSERT INTO Book_issue(accession_no, member_id) VALUES(203,10001);

SELECT * FROM Book_issue;

INSERT INTO Book_return(return_dt, accession_no, member_id, issue_dt) VALUES('2015-09-23',201,10003,'2015-09-08');
INSERT INTO Book_return(return_dt, accession_no, member_id, issue_dt) VALUES('2015-09-23',202,10002,'2015-09-08');
INSERT INTO Book_return(return_dt, accession_no, member_id, issue_dt) VALUES('2015-09-23',205,10004,'2015-09-08');
INSERT INTO Book_return(return_dt, accession_no, member_id, issue_dt) VALUES('2015-09-23',206,10006,'2015-09-08');
INSERT INTO Book_return(return_dt, accession_no, member_id, issue_dt) VALUES('2015-09-23',204,10005,'2015-09-08');
INSERT INTO Book_return(return_dt, accession_no, member_id, issue_dt) VALUES('2015-09-23',203,10001,'2015-09-08');

SELECT * FROM Book_return;

UPDATE Members SET addressline2 = "Jaipur";

SELECT * FROM Members;

UPDATE Members SET addressline1 = "EPIP Sitapura" WHERE category = 'F';

SELECT * FROM Members;

DELETE FROM Publishers;

SELECT * FROM Publishers;


set @Publication1 := "BPB Publications";
set @setid := 1;
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(@setid,@Publication1);

set @Publication1 := "Rajasthan Books Publication";
set @setid := 2;
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(@setid,@Publication1);

set @Publication1 := "Jain Publication";
set @setid := 3;
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(@setid,@Publication1);

set @Publication1 := "Shreenath Publication";
set @setid := 4;
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(@setid,@Publication1);

set @Publication1 := "Rajasthan Books Publication";
set @setid := 5;
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(@setid,@Publication1);

set @Publication1 := "Indian Books House";
set @setid := 6;
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(@setid,@Publication1);

SELECT * FROM Publishers;

INSERT INTO Titles(title_id, title_nm, subject_id, publisher_id) VALUES(5001,"History of Rajasthan",501,4);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("History of India",501,1);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Geographical Structure of Earth",503,2);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Reactions of Molecules",502,6);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Dimensions",502,2);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Basics of Computer",506,1);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Computer Graphics",506,1);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("English Grammer",504,3);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Algebra & Coordinate Geomatery",505,5);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Diffrentiation & Integretation",505,1);

SELECT * FROM Titles;

DELETE FROM Titles WHERE publisher_id = 1;

SELECT * FROM Titles;