SELECT ee.emp_no, ee.birth_date, ee.first_name, ee.last_name, ee.gender, ee.hire_date
from employees ee 
ORDER BY hire_date desc
LIMIT 1