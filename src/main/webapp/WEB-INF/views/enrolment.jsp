<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"  %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<title>Insert title here</title>
</head>
<body>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/createsubject"
		modelAttribute="subject">
		<table class="formtable2">
			<tr>
				<td class="label">Year</td>
				<td><sf:input class="control" type="text" path="year" value="2019" readonly="readonly" /> <br />
				<sf:errors class="error" path="year" /></td>
			</tr>
			<tr>
				<td class="label">Semester:</td>
				<td><sf:input class="control" type="text" path="semester" value="1" readonly="readonly" /> <br />
				<sf:errors class="error" path="semester" /></td>
			</tr>
			<tr>
				<td class="label">Subject Code:</td>
				<td><sf:input class="control" type="text" path="subjectCode" /> <br />
				<sf:errors class="error" path="subjectCode" /></td>
			</tr>
			<tr>
				<td class="label">Subject Name:</td>
				<td><label><sf:radiobutton class="control" path="subjectName" value="Security" />정보보안</label>
				<label><sf:radiobutton class="control" path="subjectName" value="AI" />인공지능</label><br/>
				<label><sf:radiobutton class="control" path="subjectName" value="Capston1" />캡스톤1</label>
				<label><sf:radiobutton class="control" path="subjectName" value="Capston12" />캡스톤2</label><br/>
				<label><sf:radiobutton class="control" path="subjectName" value="Compiler" />컴파일러</label>
				<label><sf:radiobutton class="control" path="subjectName" value="BigData" />빅데이터3</label><br />
				<sf:errors class="error" path="subjectName" /></td>
			</tr>
			<tr>
				<td class="label">Subject Type:</td>
				<td><sf:input class="control" type="text" path="type" /> <br />
				<sf:errors class="error" path="type" /></td>
			</tr>
			<tr>
				<td class="label">Grade:</td>
				<td><sf:input class="control" type="text" value="3" path="grade" /> <br />
				<sf:errors class="error" path="grade" /></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="createsubject" /></td>
			</tr>
		</table>
	</sf:form>
	<!-- name에 binding 되어 offer 객체에 들어감 -->
</body>
</html>