<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<<title>Charting</title>
	<link href="css/basic.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="http://filamentgroup.github.com/EnhanceJS/enhance.js"></script>	
	<script type="text/javascript">
		// Run capabilities test
		enhance({
			loadScripts: [
				{src: 'js/excanvas.js', iecondition: 'all'},
				'js/jquery.js',
				'js/visualize.jQuery.js',
				'js/example.js'
			],
			loadStyles: [
				'css/visualize.css',
				'css/visualize-dark.css'
			]	
		});   
    </script>
</head>
<body>

<table >
	<caption>No of questions per hour</caption>
	<thead>
		<tr>
			<td></td>
			<th scope="col">No of Questions</th>
			
		</tr>
	</thead>
	<tbody>
		<tr>
			<th scope="row">10 AM</th>
			<td>100</td>
			
		</tr>
		<tr>
			<th scope="row">11 AM</th>
			<td>3</td>
			
		</tr>
		<tr>
			<th scope="row">12 PM</th>
			
			<td>180</td>
			
		</tr>
		<tr>
			<th scope="row">1 PM</th>
			
			<td>25</td>
			
		</tr>		
	</tbody>
</table>	

</body>
</html>