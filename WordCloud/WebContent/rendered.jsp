<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>output</title>
<style>
	#text_area{
		
		position:absolute;
		margin:auto;
		text-align:center;
		left:0;
		right:0;
		top:0;
		bottom:0;
		width:30%;
		height:70%;
		
	}

</style>

</head>
<body>
<div id="text_area">
	<%@ page import="java.util.*"%> 
	<% 
		HashMap<String,Double> word_count = (HashMap<String,Double>)request.getAttribute("word_count");

		
		int count=0;
		
		
		Integer num=(Integer)request.getAttribute("num");
		
		for(String word: word_count.keySet()){
			
			if(count>=num){
				count=1;
				%>
				<br>
				<% 	
			}
			else{
				out.print(" ");
				count++;
				
			}
			
			%>
			
			
			<font face ="Helvetica" size="<% out.println(word_count.get(word)+3); %>" 
			style = "color:<%
				int r = (int)(Math.random()*255);
				int g = (int)(Math.random()*255);
				int b = (int)(Math.random()*255);
				
				String color="rgb("+r+","+g+","+b+" )";
				out.print(color);
			%>" ><% out.println(word); %></font><% 
		}
	%>
	</div>
</body>
</html>