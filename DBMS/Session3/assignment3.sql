-- use database library
USE Library;

-- dispal total no of students, no of faculties and no of others in library
SELECT category,COUNT(*) AS total
FROM Members
GROUP BY category;

-- display those titles which have issued more than two times
SELECT b.accession_no, t.title_nm
FROM Book_issue b, Books b1, Titles t
WHERE b.accession_no = b1.accession_no AND t.title_id = b1.title_id
GROUP BY b.accession_no
HAVING COUNT(b.accession_no) >= 2;

-- display members which are issue any books but not belongs two F category
SELECT m.member_id, m.member_nm, b.accession_no, t.title_nm
FROM Book_issue b, Books b1, Members m, Titles t
WHERE b.accession_no = b1.accession_no AND t.title_id = b1.title_id AND b.member_id = m.member_id AND m.category != 'F';

-- display those authors that book has been purchased
SELECT DISTINCT author_nm
FROM Authors  a, Titles t, Books b, Title_author ta
WHERE a.author_id = ta.author_id AND ta.title_id = t.title_id AND t.title_id = b.title_id;