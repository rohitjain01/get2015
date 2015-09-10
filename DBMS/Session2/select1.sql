-- Assignment 2
-- Query to  display results in ascending order of issue date and within issue date in ascending order of members name.

SELECT e.issue_dt, e.accession_no, e.member_id, member_nm,
    IF( status = 1, return_dt, NULL) AS return_date
FROM Book_return e, Books b, Members
WHERE e.accession_no = b.accession_no AND Members.member_id = e.member_id
ORDER BY return_dt ASC, member_nm ASC; 