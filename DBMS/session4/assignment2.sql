-- use database Library
USE Library;

-- Create a View which can be used to display member name and all issue details of the member using a simple SELECT command
CREATE VIEW BookIssueInfo
AS
SELECT m.member_id, m.member_nm, bi.issue_dt, bi.due_dt, bi.accession_no
FROM Members m, Book_issue bi
WHERE m.member_id = bi.member_id ;

-- Display BookIssueInfo
SELECT * FROM BookIssueInfo;

/* Create a View which contains three columns, member name, member id and full description of category, i.e., Faculty, Students 
and Others instead of F,S and O */
CREATE VIEW memberInfo
AS
SELECT member_id, member_nm, IF(category='F','Faculty',IF(category='S','Student','Others'))AS category
FROM Members ;

-- Display memberInfo
SELECT * from memberInfo;

/*Create a View which contains the information – subject name, title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be displayed instead of return date*/
CREATE VIEW information
AS 
SELECT s.subject_nm, t.title_nm, m.member_nm, m.category, bi.issue_dt, bi.due_dt, br.return_dt
FROM Members m, Titles t, Subjects s, Books b, Book_issue bi
LEFT JOIN Book_return br ON bi.issue_dt=br.issue_dt AND bi.accession_no=br.accession_no AND bi.member_id=br.member_id
WHERE bi.member_id = m.member_id
AND bi.accession_no = b.accession_no
AND b.title_id = t.title_id
AND t.subject_id = s.subject_id;

-- Display information
SELECT * FROM information;