package com.example.ipc;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PortletSessionsIPCReceiverAction
 */
public class PortletSessionsIPCReceiverPortlet extends MVCPortlet {
 
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		_log.info("--PortletSessionsIPCReceiverPortlet--");
		
		PortletSession portletSession = renderRequest.getPortletSession();
		
		String userEmailAddress = (String) portletSession.getAttribute("userEmailAddress", PortletSession.APPLICATION_SCOPE);
		_log.info("userEmailAddress: " + userEmailAddress);

		String categoryId = (String) portletSession.getAttribute("categoryId", PortletSession.APPLICATION_SCOPE);
		_log.info("categoryId: " + categoryId);

		String tag = (String) portletSession.getAttribute("tag", PortletSession.APPLICATION_SCOPE);
		_log.info("tag: " + tag);

		String tags = (String) portletSession.getAttribute("tags", PortletSession.APPLICATION_SCOPE);
		_log.info("tags: " + tags);

		super.render(renderRequest, renderResponse);
	}

	private static Log _log = LogFactoryUtil.getLog(PortletSessionsIPCReceiverPortlet.class);
}
