<%@include file="../init.jsp" %>

<portlet:actionURL var="sendDataActionURL" windowState="normal"	name="getPublicSessionParams"/>

<h1>Portlet Sessions IPC Sender Portlet</h1>

<aui:form action="<%=sendDataActionURL%>" method="post" name="smsForm">
	<aui:input name="userEmailAddress" id="userEmailAddress" label="email">
		<aui:validator name="required" />
		<aui:validator name="email"></aui:validator>
	</aui:input>
	<aui:button type="submit" value="send"></aui:button>
</aui:form>