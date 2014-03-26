<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      
    <title>My JSP 'lott_add.jsp' starting page</title>
 
  </head>
  
  <body>
    彩票开奖记录添加<br>
    <form action="lott_add" method="post">
    	<input type="text" name="lottery.lottId"/>
    	<input type="text" name="lottery.num1"/>
    	<input type="text" name="lottery.num2"/>
       	<input type="text" name="lottery.num3"/>
    	<input type="text" name="lottery.num4"/>
       	<input type="text" name="lottery.num5"/>
       	<input type="submit" value="添加"/>
    </form>
  </body>
</html>
