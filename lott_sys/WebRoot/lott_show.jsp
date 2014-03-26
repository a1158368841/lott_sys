<%@ page language="java" import="java.util.*,com.lott_sys.vo.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'lott_show.jsp' starting page</title>

  </head>
  
  <body>
    <table>
    	<tr>
    		<td>ฦฺบล</td>
    		<td>ึะฝฑบลย๋</td>
    		<td>บลย๋1</td>
    		<td>บลย๋2</td>
    		<td>บลย๋3</td>
    		<td>บลย๋4</td>
    		<td>บลย๋5</td>
    	</tr>
    	<s:iterator value="#request.lottlist" id="lott">
    		<tr>
    		<td><s:property value="#lott.lottId"/></td>
    		<td><s:property value="#lott.lottNums"/></td>
    		<td><s:property value="#lott.num1"/></td>
    		<td><s:property value="#lott.num2"/></td>
    		<td><s:property value="#lott.num3"/></td>
    		<td><s:property value="#lott.num4"/></td>
    		<td><s:property value="#lott.num5"/></td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</html>
