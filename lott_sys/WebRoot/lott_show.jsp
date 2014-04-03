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
    		<td>ÆÚºÅ</td>
    		
    		<td>ºÅÂë1</td>
    		<td>ºÅÂë2</td>
    		<td>ºÅÂë3</td>
    		<td>ºÅÂë4</td>
    		<td>ºÅÂë5</td>
    		<td>ºÅÂë1ÐÅÏ¢</td>
    		<td>ºÅÂë2ÐÅÏ¢</td>
    		<td>ºÅÂë3ÐÅÏ¢</td>
    		<td>ºÅÂë4ÐÅÏ¢</td>
    		<td>ºÅÂë5ÐÅÏ¢</td>
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
    		<td>ÆÚºÅ</td>
    		
    		<td>ºÅÂë1</td>
    		<td>ºÅÂë2</td>
    		<td>ºÅÂë3</td>
    		<td>ºÅÂë4</td>
    		<td>ºÅÂë5</td>
    		
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
