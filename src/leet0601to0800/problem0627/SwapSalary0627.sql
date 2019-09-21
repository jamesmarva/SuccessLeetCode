# Write your MySQL query statement below
update salary set sex = (case sex
                           when 'm' then 'f'
                           when 'f' then 'm'
                           else 'exception'
  end)



                  # Write your MySQL query statement below
update salary
set sex= case sex when 'f' then 'm' else 'f' end;


UPDATE salary SET sex =IF(Sex = 'm', 'f', 'm');