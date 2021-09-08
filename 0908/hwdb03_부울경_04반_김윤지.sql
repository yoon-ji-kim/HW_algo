-- emp와 dept Table을 join 하여 이름, 급여, 부서명을 검색하세요.
select ename, sal, dname
from emp
join dept
using (deptno);
-- 이름이 'KING'인 사원의 부서명을 검색하세요
select dname
from dept
join emp
using (deptno)
where emp.ENAME = 'KING';

select *
from dept;
-- dept Table에 있는 모든 부서를 출력하고, emp table에 있는 data와 join하여 모든 사원의 이름, 부서번호, 부서명, 급여를 출력하라
select ename, deptno, dname, sal
from dept left outer join emp
using (deptno);
-- emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력되도록 쿼리를 작성하세요
-- 'SCOTT의 매니저는 JONES이다.'
select concat(emp.ename, '의 매니저는', e.ename,'이다.')
from emp
join emp e
on emp.mgr = e.empno
where emp.ename = 'SCOTT';
-- SCOTT의 직무와 같은 사람의 이름, 부서명, 급여, 직무를 검색하세요
select ename, dname, sal, job
from emp 
join dept
on emp.deptno = dept.deptno
where job = ( select job
				from emp
				where ename = 'SCOTT');

-- SCOTT이 속해 있는 부서의 모든 사람의 사원 번호, 이름, 입사일, 급여를 검색하세요
select empno, ename, hiredate, sal
from emp 
where deptno = ( select deptno
				from emp
                where ename = 'SCOTT');
-- 전체 사원의 평균 급여보다 급여가 많은 사원의 사원번호, 이름, 부서명, 입사일, 지역, 급여를 검색하세요
select empno, ename, dname, hiredate, loc, sal
from emp 
join dept
on emp.deptno = dept.deptno
where sal >= (select avg(sal)
				from emp);
                
select avg(sal) '평균'
from emp;
-- 10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서명, 입사일, 지역을 검색하세요
select empno, ename, dname, hiredate, loc
from emp
join dept
on emp.deptno = dept.deptno
where job not in (select distinct job
					from emp
					where deptno =30)
and emp.deptno = 10;

/*
select distinct job
from emp
where deptno =10;
*/
-- 'KING'이나 'JAMES'의 급여와 같은 사원의 사원번호, 이름, 급여를 검색하세요
select empno, ename, sal
from emp
where sal in (select sal
				from emp
				where ename = 'KING' or ename = "JAMES");
-- 급여가 30번의 부서의 최고 급여보다 높은 사원의 사원번호, 이름, 급여를 검색하세요
select empno, ename, sal
from emp
where sal > (select max(sal)
				from emp
				where deptno = 30);
/*
select max(sal)
from emp
where deptno =30;
*/

-- 이름 검색을 보다 빠르게 수행하기 위해 emp 테이블 ename에 인덱스를 생성하시오
create index idx_emp_ename on emp(ename);
-- 이름이 'ALLEN'인 사원의 입사연도가 같은 사원들의 이름과 급여를 출력하세요
select ename, sal
from emp
where YEAR(hiredate) = ( select YEAR(hiredate)
					from emp
                    where ename = 'ALLEN');

-- 부서별 급여의 합계를 출력하는 View를 작성하세요
create or replace view salBydept
as 
select deptno, sum(sal)
from emp
group by deptno;

-- select * from salBydept;
