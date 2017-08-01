<%@include file="../init.jsp"%>

<portlet:resourceURL var="getUserData" />

<aui:script use="aui-node, aui-io-request, cookie">
	A.one('#<portlet:namespace/>fm .btn[type="submit"]').on('click', function(event){
		var emailAddessValue = A.one('#<portlet:namespace/>userEmailAddress').val();
		var request = A.io.request('<%=getUserData%>',{
			dataType: 'json',
			data: {
				emailAddess:emailAddessValue,
	      		companyId:'<%=themeDisplay.getCompanyId()%>'				
			},
			type : "get",
	        cache: 'true',
	        on: {
		      	success: function() {
		      		var data = this.get('responseData');
		     		
		     		var htmlString = "<table id='userData'>"
						+ "<tr><td>User Id</td><td>" + data.userId
						+ "</td></tr>" + "<tr><td>First Name</td><td>"
						+ data.firstName + "</td></tr>"
						+ "<tr><td>Last Name</td><td>" + data.lastName
						+ "</td></tr>" + "<tr><td>Email Address</td><td>"
						+ data.emailAddress + "</td></tr>" + "</table>";
		     		
					A.Cookie.set('userData', htmlString);

		     		Liferay.fire('getUserData',{
						userData : data
					});
				},
				error : function() {
					console.error('Connection problems');
				}
	    	}
		});
	});
</aui:script>

<aui:form action="<%=getUserData%>" method="post" name="fm" onclick="event.preventDefault();">
	<aui:input name="userEmailAddress" id="userEmailAddress" label="email">
		<aui:validator name="required" />
		<aui:validator name="email"></aui:validator>
	</aui:input>
	<aui:button type="submit" value="send"></aui:button>
</aui:form>
