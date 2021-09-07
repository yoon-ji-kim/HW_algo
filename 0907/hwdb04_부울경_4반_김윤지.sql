-- select *
-- from emp;
-- 부서위치가 CHICAGO인 모든 사원에 대해 이름, 업무, 급여 출력
select ename, job, sal
from emp, dept
where emp.deptno = dept.deptno
and loc = 'CHICAGO';
-- 부하 직원이 없는 사원의 사원번호, 이름, 업무, 부서번호 출력 re 
select empno, ename, job, deptno
from emp
where empno not in(select mgr
					from emp
					where mgr is not null
                    );
-- BLAKE와 같은 상사를 가진 사원의 이름, 업무, 상사번호 출력
select ename, job, mgr
from emp
where mgr = ( select mgr
				from emp
                where ename ='BLAKE'
                );
				
-- 입사일이 가장 오래된 사람 5명을 검색
select ename
from emp
order by HIREDATE limit 5;
-- JONES의 부하 직원의 이름, 업무, 부서명을 검색
select ename, job, dname
from emp, dept
where mgr = ( select empno
				from emp
				where ename = 'JONES'
                );