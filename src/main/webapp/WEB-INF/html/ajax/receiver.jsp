<%@include file="../init.jsp"%>

<aui:script use="aui-node, cookie">
	Liferay.on('getUserData', function(event) {
		A.one('#userInformation').empty();
		A.one('#errorInformation').empty();
		if (event.userData.error != null) {
			A.one('#errorInformation').html(event.userData.error);
		} else {
			var htmlString = "<table id='userData'>"
					+ "<tr><td>User Id</td><td>" + event.userData.userId
					+ "</td></tr>" + "<tr><td>First Name</td><td>"
					+ event.userData.firstName + "</td></tr>"
					+ "<tr><td>Last Name</td><td>" + event.userData.lastName
					+ "</td></tr>" + "<tr><td>Email Address</td><td>"
					+ event.userData.emailAddress + "</td></tr>" + "</table>";
			A.one('#userInformation').html(htmlString);
			
			if(A.Cookie.exists('userData')){
				var htmlString = A.Cookie.get('userData');
				A.one('#userInformation').html(htmlString);
			}
		}
	});
</aui:script>

<div id="userInformation"></div>
<div id="errorInformation" style="color: red; font-weight: bold;"></div>