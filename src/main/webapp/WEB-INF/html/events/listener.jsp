<%@include file="../init.jsp"%>


<h1>Receive User Data from Events Producer in Listener Portlet</h1>

<%
	String message = null;
	String userEmailAddress = ParamUtil.getString(renderRequest, "userEmailAddress", null);
	User senderPortletUserOject = null;
	try {
		if (userEmailAddress != null) {
			senderPortletUserOject = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(),
					userEmailAddress);
		}
	} catch (NoSuchUserException e) {
		message = "No User exists with the given Email Address.";
	} catch (Exception e) {
		message = "There is problem in view the user details.";
	}
%>
<c:choose>
	<c:when test="<%=senderPortletUserOject != null%>">
		<table border="1">
			<tr>
				<td>User Id</td>
				<td><%=senderPortletUserOject.getUserId()%></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><%=senderPortletUserOject.getFirstName()%></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><%=senderPortletUserOject.getLastName()%></td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><%=senderPortletUserOject.getEmailAddress()%></td>
			</tr>
			<tr>
				<td>Screen Name</td>
				<td><%=senderPortletUserOject.getScreenName()%></td>
			</tr>
		</table>
	</c:when>
	<c:otherwise>
		<%=message%>
	</c:otherwise>
</c:choose>