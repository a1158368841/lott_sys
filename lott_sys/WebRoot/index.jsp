<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'index.jsp' starting page</title>

  </head>
  
  <body>
  
    <form action="lott_show" method="post">&nbsp; 
    <input type="text" value="1002" name="method">
    	<input type="submit" value="显示彩票记录"/>
    </form>
    <br>
    <br>
    <br>
    <form action="lott_query" method="post">
    	a:<input type="text" name="a"><br>
    	b:<input type="text" name="b"><br>
    	c:<input type="text" name="c"><br>
    	<select name="dict_entry">
    		<option value="1001">大小</option>
    		<option value="1002">奇偶</option>
    		<option value="1003">质合</option>
    		<option value="1004">012路</option>
    	</select>
    	<input type="submit" value="搜索"/>
    </form>
      <br>
    <br>
    <br>
      <br>
    <br>
    <br>
    
    <form action="lott_query" method="post">
    	大小：&nbsp; 小<input type="text" size="6" name="a1001"> &nbsp; &nbsp; 大<input type="text" size="6" name="b1001">
<br>
奇偶：&nbsp; 奇<input type="text" size="6" name="a1002"> &nbsp; &nbsp; 偶<input type="text" size="6" name="b10012">
<br>012路： 0路<input type="text" size="6" name="a1004">&nbsp; 1路<input type="text" size="6" name="b1004">&nbsp; 2路<input type="text"  size="6" name="c1004">
<input type="submit" value="搜索"/>


</form>

 <br>
    <br>
    <br>
      <br>
    <br>
    <br>
    <form action="lott_query" method="post">
    <select name='dx' id='dx'>
    	<option value='-1'>大  小</option>
    	<option value='0'>0  5</option>
    	<option value='1'>1  4</option>
    	<option value='2'>2  3</option>
    	<option value='3'>3  2</option>
    	<option value='4'>4  1</option>
    	<option value='5'>5  0</option>
    </select>
    <select name='jo' id='jo'>
    	<option value='-1'>奇 偶</option>
    	<option value='5'>0  5</option>
    	<option value='4'>1  4</option>
    	<option value='3'>2  3</option>
    	<option value='2'>3  2</option>
    	<option value='1'>4  1</option>
    	<option value='0'>5  0</option>
    </select>
    <select name='zh' id='zh'>
    	<option value='-1'>质  合</option>
    	<option value='5'>0  5</option>
    	<option value='4'>1  4</option>
    	<option value='3'>2  3</option>
    	<option value='2'>3  2</option>
    	<option value='1'>4  1</option>
    	<option value='0'>5  0</option>
    </select>
    <select name='l012' id='l012'>
    	<option value='-1'>012路</option>
    	<option value='2'>3 2 0</option>
    	<option value='11'>3 1 1</option>
    	<option value='20'>3 0 2</option>
    	<option value='3'>2 3 0</option>
    	<option value='12'>2 2 1</option>
    	<option value='21'>2 1 2</option>
    	<option value='30'>2 0 3</option>
    	<option value='13'>1 3 1</option>
    	<option value='22'>1 2 2</option>
    	<option value='31'>1 1 3</option>
    	<option value='23'>0 3 2</option>
    	<option value='32'>0 2 3</option>    	    	
    </select>
    
    <input type="submit" value="搜索">
    </form>
    
  </body>
</html>
