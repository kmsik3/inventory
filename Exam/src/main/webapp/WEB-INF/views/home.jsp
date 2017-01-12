<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>User Info</title>
<script type="text/javascript" src="/resources/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="/resources/common.js"></script>
<link rel="stylesheet" href="resources/style.css">
</head>
<body>

<div id="contentContainer">
  <div id="sideBar">
    <h1>Clients</h1>
    <select id='users'>
      <option value="create">Choose Clients</option>
    </select>
  </div>
  <div id="content">
    <h3>Detail</h3>
    <hr>
    <div id="profilePictureContainer">
      <img src="/resources/profilePic.jpg" id="profilePicture">
        <input type="file" id='profile' accept="image/*">
    </div>
    <div id="profileContent">
        <label>NDIS#</label>
        <input type="text" id="ndis" value="" placeholder="ID">
        <br>
        <label>Name</label>
        <input type="text" id="name" value="" align="right" placeholder="Name">
        <br>
        <label>Address</label>
        <textarea id="address" cols="20" rows="2" placeholder="Address"></textarea>
        <br>
        <label>Phone Number</label>
        <input type="number" id="phone" value="" placeholder="Phone Number">
        <br>
        <label>Next Of Kin</label>
        <input type="text" id="nok" value="" placeholder="Next Of Kin">
        <br>
        <label>Date of Birth</label>
        <input type="number" id="dob" value="" placeholder="Date of Birth">
        <br>
        <label>Registered Device</label>
        <select id="device">
          <option value="0">No Device</option>
          <option value="1">Device No.1</option>
          <option value="2">Device No.2</option>
          <option value="3">Device No.3</option>
        </select>
        <br>
        <label>Notes</label>
        <textarea id="notes" cols="20" rows="2" placeholder="Notes"></textarea>
        <br>
        <br>
        <button id="btn_save">Save</button>
    </div>
  </div>
</div>


</body>
</html>
