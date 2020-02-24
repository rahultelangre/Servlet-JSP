<%@ page  import="com.nt.service.*,com.nt.dto.StudentBean"%>
<!-- create or locate java bean class object -->

<jsp:useBean id="dto" class="com.nt.dto.StudentBean" scope="request"/>
<!-- set from data properties -->
<h1 style="color:red;text-align:center;">Employee Salary Slip</h1>
<jsp:setProperty property="*" name="dto"/>
<!-- use service -->
<% 
  SalaryService service=new SalaryServiceImpl();
  service.paySlip(dto);
%>

<!-- read and display the result -->
name:<jsp:getProperty property="ename" name="dto"/><br>
desg:<jsp:getProperty property="desg" name="dto"/><br>
basic Salary<jsp:getProperty property="basicSalary" name="dto"/><br>
Gross Salary<jsp:getProperty property="grosSalary" name="dto"/><br>
Net Salary<jsp:getProperty property="netSalary" name="dto"/>