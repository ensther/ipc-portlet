package com.example.ipc;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class IPCEventListenerPortlet extends MVCPortlet {
	
	@javax.portlet.ProcessEvent(qname = "{http://www.liferayipc.com}userEmailAddress")
	public void handleProcesseuserEmailAddressEvent(javax.portlet.EventRequest request,
			javax.portlet.EventResponse response) throws javax.portlet.PortletException, java.io.IOException {
		_log.info("--IPCEventListenerPortlet--");
		
		javax.portlet.Event event = request.getEvent();
		String userEmailAddress = (String) event.getValue();
		response.setRenderParameter("userEmailAddress", userEmailAddress);
		_log.info("userEmailAddress" + userEmailAddress);
	}

	private static Log _log = LogFactoryUtil.getLog(IPCEventProducerPortlet.class);
}