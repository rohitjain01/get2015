-- USE Database Library
USE Library;

-- display details of that books which is not returned ithin two months
SELECT member_nm AS Member_Name, b.member_id AS Member_Id, r.issue_dt AS Issue_Date, b.due_dt AS Due_Date, r.accession_no,
PERIOD_DIFF(DATE_FORMAT(IF(return_dt != '0000-00-00', return_dt, NOW()), '%Y%m'), DATE_FORMAT(r.issue_dt,'%Y%m')) AS Issue_Months
FROM Book_issue b, Members m, Book_return r
WHERE m.member_id = b.member_id AND DATEDIFF(IF(return_dt != '0000-00-00', return_dt, NOW()), r.issue_dt) >= 60
        AND b.accession_no = r.accession_no AND b.member_id = r.member_id AND b.issue_dt = r.issue_dt;

-- dispay members informations which have maximum length in member name
SELECT member_nm AS Member_Name, LENGTH(member_nm) AS Length_Name
FROM Members m
WHERE LENGTH(m.member_nm) = ( SELECT MAX(LENGTH(m1.member_nm))
                                FROM Members m1);

-- count number of books issued
SELECT COUNT(*) AS Total_Books_Issue
FROM Book_issue;