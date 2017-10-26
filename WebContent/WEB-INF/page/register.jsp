<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="param/register.do" method="get">
		<input type="text" name="id" placeholder="id">
		<input type="text" name="name" placeholder="用户名">
		<input type="text" name="sex" placeholder="性别">
		<input type="date" name="birthday" placeholder="生日">
		<input type="submit" value="提交">
	</form>
</body>
</html>