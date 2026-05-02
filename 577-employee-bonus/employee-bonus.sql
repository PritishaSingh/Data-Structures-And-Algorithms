# Write your MySQL query statement below
SELECT
p.name,
b.bonus
FROM Employee p
LEFT JOIN Bonus b 
ON p.empId=b.empId WHERE b.bonus<1000 OR b.bonus Is null;