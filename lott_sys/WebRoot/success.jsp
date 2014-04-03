<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'success.jsp' starting page</title>
    

  </head>
  
  <body>
    success
    <s:iterator value="#request.list">
    	<s:property/>
    	<br>
    </s:iterator>
  </body>
</html>
