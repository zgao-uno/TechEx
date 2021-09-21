<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="util.DButil,datamodel.Things,service.Service"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To Do List</title>
</head>
<body>
	<table border-color="white" >
		<tr>
			<td>
				<div style="width:500px;height:500px;margin:100px 0 0 100px;
								border: solid;align="center">
					<h1 align="center">To do list</h1>
						<ol>
							<%
								Service se = new Service();
								List<Things> list = se.showAll();
								for (Things th : list) {
							%>
							<li><%=th.getThing() %></li><br>
							<%}%>
						</ol>
				</div>
			</td>
			<td>
				<div style="width:500px;height:500px;margin:100px 0 0 100px;align="center">
					<br><br><br>
					<form action="AddToList" method="post">
						<h3 align="center">Add to To Do List</h1>
						<input type="text" name="add" 
						style="width:300px;height:50px;margin:0 0 0 110px;" />
						<input type="submit" value="insert" style="width:50px; height:35px;"/>
					</form>	
					<br><br><br>
					<form action="DeleteFromList" method="post">
						<h3 align="center">Remove from To Do List</h1>
						<input type="text" name="delete" 
						style="width:300px;height:50px;margin:0 0 0 110px;" />
						<input type="submit" value="delete" 
						style="width:50px; height:35px;"/>
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>