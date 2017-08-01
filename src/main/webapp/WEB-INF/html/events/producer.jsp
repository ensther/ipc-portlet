<%@include file="../init.jsp" %>

<portlet:actionURL var="sendDataActionURL" windowState="normal" name="getEventData" />
	
<h1>IPC Events Producer Portlet</h1>
<span>
	Por defecto los parámetros públicos sólo se comparten entre portlets del mismo layout<br/>
	<b style="text-align: center;">portlet.public.render.parameter.distribution=layout</b>
</span>
<aui:form action="<%=sendDataActionURL%>" method="post" name="smsForm">
	<aui:input name="userEmailAddress" id="userEmailAddress" label="email">
		<aui:validator name="required" />
		<aui:validator name="email"></aui:validator>
	</aui:input>
	<aui:button type="submit" value="send"></aui:button>
</aui:form>