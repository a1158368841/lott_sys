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
    		<td>�ں�</td>
    		
    		<td>����1</td>
    		<td>����2</td>
    		<td>����3</td>
    		<td>����4</td>
    		<td>����5</td>
    		<td>����1��Ϣ</td>
    		<td>����2��Ϣ</td>
    		<td>����3��Ϣ</td>
    		<td>����4��Ϣ</td>
    		<td>����5��Ϣ</td>
    	</tr>
    	<s:iterator value="#request.lottinfolist" var="lott">
    		<tr>
    		
    		<td><s:property value="#lott.num1"/></td>
    		<td><s:property value="#lott.num2"/></td>
    		<td><s:property value="#lott.num3"/></td>
    		<td><s:property value="#lott.num4"/></td>
    		<td><s:property value="#lott.num5"/></td>
    		
    		<td><s:property value="#lott.lottId"/></td>
    		<td><s:property value="#lott.num1info"/></td>
    		<td><s:property value="#lott.num2info"/></td>
    		<td><s:property value="#lott.num3info"/></td>
    		<td><s:property value="#lott.num4info"/></td>
    		<td><s:property value="#lott.num5info"/></td>
    		</tr>
    	</s:iterator>
    </table>
    
    
    <table>
    	<tr>
    		<td>�ں�</td>
    		
    		<td>����1</td>
    		<td>����2</td>
    		<td>����3</td>
    		<td>����4</td>
    		<td>����5</td>
    		
    	</tr>
    	<s:iterator value="#request.lottlist" var="lott">
    		<tr>
    		
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
