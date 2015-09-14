USE Library;

-- Query to find the columns of table members
SELECT * FROM Members;

-- Query to find the member id,member name,category of table members
SELECT member_nm, member_id, category FROM Members;

-- Query to find the member id,member name,category of table members whose category = "f"
SELECT member_nm, member_id, category FROM Members WHERE category = 'F';

-- Query to find distinct category of table members
SELECT DISTINCT category FROM Members;

-- Query to find the member id,member name of table members order by desc
SELECT member_nm, category FROM Members ORDER BY member_nm DESC;

-- Query to find the title name,publisher name, subject id of table
SELECT title_nm, subject_nm, publisher_nm 
FROM Titles T, Subjects S, Publishers P 
WHERE T.subject_id = S.subject_id AND T.publisher_id = P.publisher_id;

-- Query to find the count of members of category
SELECT category, COUNT(*)
FROM Members
GROUP BY category;

-- Query to Insert a record in Members Table
INSERT INTO Members(member_nm, addressline1, addressline2, category) VALUES('Keshav Sharma', 'EPIP Sitapura','Jaipur', 'M');

-- Query to find name of members to which Keshav Sharma belongs
SELECT M1.member_nm, M1.category
FROM Members M1
JOIN Members M
ON M.category = M1.category AND M.member_nm = "Keshav Sharma";

-- Query to find the status of return book and if returned  then place blank
SELECT e.issue_dt, e.accession_no, e.member_id, 
    IF( status = 1, return_dt, NULL) AS return_date
FROM Book_return e, Books b
WHERE e.accession_no = b.accession_no;
