# Write your MySQL query statement below

select s.id, s.student
from  (
        select  id - 1 as id, student from seat where mod(id, 2) = 0
        union
        select id + 1 as id, student from seat where mod(id, 2) = 1 && id != (select count(*) from seat)
        union
        select id, student from seat where mod(id,2)=1 && id=(select count(*) from seat)
      ) s
order by s.id asc
