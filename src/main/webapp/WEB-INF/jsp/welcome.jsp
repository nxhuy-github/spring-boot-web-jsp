<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	<script src="http://code.jquery.com/jquery-latest.min.js"
			type="text/javascript"></script>
</head>
<body>

	<header>
		<h1>RESTFull-AJAX-JSON</h1>
		<button id="btn">Fetch DATA</button>
	</header>
	<div id="data-info"></div>

	<br/>
	<br/>
	<div>
		<h1>LogIn</h1>
		<form>
			<input id="userName" name="userName" placeholder="User Name" type="text"/><br>
			<input id="userPassword" name="userPassword" placeholder="Password" type="password"/><br>
		</form>
		<button id="submit">Submit</button>
	</div>
	<div id="result"></div>
	<br/>
	<br/>
	<div>
		<h1>List Users</h1>
		<button id="listUser">Get List Users</button>
		<ul id="progress">*Progress</ul>
		<ul id="future">*Future</ul>
		<ul id="history">*History</ul>
	</div>

	<br/>
	<br/>
	<div>
		<h1>Send Data to Server</h1>
		<button id="send">Send</button>
	</div>

	<script type="text/javascript"
		src="/js/main.js"></script>

</body>

</html>
