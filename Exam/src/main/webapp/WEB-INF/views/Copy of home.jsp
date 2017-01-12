<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>User Info</title>
<script type="text/javascript" src="/resources/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="/resources/common.js"></script>
</head>
<body>
	<input type="text" id="ndis" value="" placeholder="ID" />
	<input type="text" id="name" value="" placeholder="Name" />
	<input type="text" id="address" value="" placeholder="Address" />
	<input type="text" id="phone" value="" placeholder="Phone Number" />
	<input type="text" id="nok" value="" placeholder="Next Of Kin" />
	<input type="text" id="dob" value="" placeholder="Date of Birth" />
	<input type="text" id="notes" value="" placeholder="Notes" />
	<button id='btn_save'>save</button>
</body>
</html>
