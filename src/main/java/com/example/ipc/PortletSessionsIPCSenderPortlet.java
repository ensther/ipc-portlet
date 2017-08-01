package com.example.ipc;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class PortletSessionsIPCSenderPortlet extends MVCPortlet {

	@ProcessAction(name = "getPublicSessionParams")
	public void getPublicSessionParams(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, SystemException {
		_log.info("--PortletSessionsIPCSenderPortlet--");
		

		PortletSession portletSession = actionRequest.getPortletSession();
		
		String userEmailAddress = ParamUtil.getString(actionRequest, "userEmailAddress");
		portletSession.setAttribute("userEmailAddress", userEmailAddress, PortletSession.APPLICATION_SCOPE);
		_log.info("userEmailAddress: " + userEmailAddress);

		String categoryId = ParamUtil.getString(actionRequest, "categoryId", StringPool.BLANK);
		portletSession.setAttribute("categoryId", categoryId, PortletSession.APPLICATION_SCOPE);
		_log.info("categoryId: " + categoryId);

		String tag = ParamUtil.getString(actionRequest, "tag", StringPool.BLANK);
		portletSession.setAttribute("tag", tag, PortletSession.APPLICATION_SCOPE);
		_log.info("tag: " + tag);

		String tags = ParamUtil.getString(actionRequest, "tags", StringPool.BLANK);
		portletSession.setAttribute("tags", tags, PortletSession.APPLICATION_SCOPE);
		_log.info("tags: " + tags);

	}

	private static Log _log = LogFactoryUtil.getLog(PortletSessionsIPCSenderPortlet.class);
}
