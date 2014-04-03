<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'filter.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><form method="post" action="lfilter" name="form1"><p>&nbsp;
  启用<input type="checkbox" value="1" name="dxqy">&nbsp;&nbsp;&nbsp;
  <input type="text" name="dx1" size="2"><=大数个数<=<input type="text" name="dx2" size="2">
  &nbsp;&nbsp;&nbsp;容错<input type="checkbox" value="1" name="dxrc">
  </p>
  <p>&nbsp;
  启用<input type="checkbox" value="1" name="joqy">&nbsp;&nbsp;&nbsp;
  <input type="text" name="jo1" size="2"><=偶数个数<=<input type="text" name="jo2" size="2">
  &nbsp;&nbsp;&nbsp;容错<input type="checkbox" value="1" name="jorc">
  </p>
   <p>&nbsp;
  启用<input type="checkbox" value="1" name="zhqy">&nbsp;&nbsp;&nbsp;
  <input type="text" name="zh1" size="2"><=合数个数<=<input type="text" name="zh2" size="2">
  &nbsp;&nbsp;&nbsp;容错<input type="checkbox" value="1" name="zhrc">
  </p>
  
  
  <p><input type="submit" value="过滤"></p>
  
  </form>
    
  </body>
</html>
