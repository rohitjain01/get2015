-- Use database Library
USE Library;

-- insert Keshav Sharma in Members Table
INSERT INTO Members(member_nm, addressline1, addressline2, category) VALUES('Keshav Sharma', 'EPIP Sitapura','Jaipur', 'F');

-- Write a SELECT command to display name of those members who belong to the category as to which member “Keshav Sharma” belongs
SELECT m.member_nm
FROM Members m
WHERE m.category = ( SELECT m1.category
                    FROM Members m1
                    WHERE m1.member_nm = "Keshav Sharma"
                    );
                    
-- Write a SELECT command to display information on the books that have not been returned till date.
SELECT bi.issue_dt, m.member_nm, bi.due_dt, t.title_nm, bi.accession_no, m.member_id
FROM Book_issue bi, Book_return br, Members m, Titles t, Books b
WHERE m.member_id = bi.member_id 
AND b.accession_no = bi.accession_no 
AND b.title_id = t.title_id 
AND(bi.member_id, bi.issue_dt, bi.accession_no) 
NOT IN (
        SELECT member_id,issue_dt,accession_no 
        FROM book_return br 
        GROUP BY br.member_id,br.accession_no,br.issue_dt)
GROUP BY bi.member_id,bi.accession_no,bi.issue_dt;
                                                                                                                                                
-- Write a SELECT command to display information on the books that have been returned after their due dates
SELECT bi.issue_dt, m.member_nm, bi.due_dt, t.title_nm, bi.accession_no, m.member_id
FROM Book_issue bi, Members m, Titles t, Books b
WHERE m.member_id = bi.member_id 
AND b.accession_no = bi.accession_no 
AND b.title_id = t.title_id 
AND bi.due_dt < (SELECT return_dt FROM Book_return br 
WHERE bi.member_id=br.member_id AND bi.accession_no=br.accession_no AND bi.issue_dt=br.issue_dt 
GROUP BY br.member_id,br.accession_no,br.issue_dt)
GROUP BY bi.member_id,bi.accession_no,bi.issue_dt;                                                                                                                                            

-- Write a SELECT command to display information of those books whose price is equal to the most expensive book purchase so far
SELECT t.title_nm,s.subject_nm,b.price
FROM Books b, Titles t, Subjects s
WHERE b.title_id = t.title_id AND t.subject_id = s.subject_id AND b.price = (SELECT MAX(b1.price)
                                                                                FROM Books b1);
                    
-- Write a SELECT command to display the second maximum price of a book
SELECT MAX(price) FROM Books WHERE price NOT IN(SELECT MAX(price) FROM Books);