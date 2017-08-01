<%@include file="../init.jsp" %>

<portlet:actionURL var="sendDataActionURL" windowState="normal"	name="getPublicParams" />

<h1>Public Render Parameters IPC Sender Portlet</h1>
<span>
	Por defecto los par�metros p�blicos s�lo se comparten entre portlets del mismo layout<br/>
	<b style="text-align: center;">portlet.public.render.parameter.distribution=layout</b>
</span>
<aui:form action="<%=sendDataActionURL%>" method="post" name="smsForm">
	<aui:input name="userEmailAddress" id="userEmailAddress" label="email">
		<aui:validator name="required" />
		<aui:validator name="email"/>
	</aui:input>
	<aui:button type="submit" value="send"></aui:button>
</aui:form>