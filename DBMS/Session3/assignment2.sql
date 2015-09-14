-- use database library
USE Library;

-- dispalay subject name, subject id and number of books purched of that subject
SELECT subject_nm, s.subject_id, COUNT(accession_no) AS no_of_books
FROM Subjects s, Titles t, Books b
WHERE s.subject_id = t.subject_id AND t.title_id = b.title_id
GROUP BY subject_nm;

-- display information of that books which is issued for more than two months
SELECT member_nm AS Member_Name, b.member_id AS Member_Id, issue_dt AS Issue_Date, due_dt AS Due_Date
FROM Book_issue b, Members m
WHERE m.member_id = b.member_id AND DATEDIFF(due_dt,issue_dt) >= 60;

-- list of books which have price greater than minimum price
SELECT t.title_nm, b.price
FROM Books b, Titles t
WHERE b.title_id = t.title_id AND b.price > (SELECT MIN(b1.price)
                    FROM Books b1);
                    
                    
