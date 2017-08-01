package com.example.ipc;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class IPCEventProducerPortlet extends MVCPortlet {

	@ProcessAction(name = "getEventData")
	public void getEventData(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, SystemException {
		_log.info("--IPCEventProducerPortlet--");
		
		String userEmailAddress = ParamUtil.getString(actionRequest, "userEmailAddress");
		javax.xml.namespace.QName qNameEmail = new javax.xml.namespace.QName("http://www.liferayipc.com",
				"userEmailAddress", "event");
		actionResponse.setEvent(qNameEmail, userEmailAddress);
		_log.info("userEmailAddress: " + userEmailAddress);
	}

	private static Log _log = LogFactoryUtil.getLog(IPCEventProducerPortlet.class);
}
