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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class PublicRenderParametersIPCSenderPortlet extends MVCPortlet {

	@ProcessAction(name = "getPublicParams")
	public void getPublicParams(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, SystemException {
		_log.info("--PublicRenderParametersIPCSenderPortlet--");
		
		String userEmailAddress = ParamUtil.getString(actionRequest, "userEmailAddress", StringPool.BLANK);
		actionResponse.setRenderParameter("userEmailAddress", userEmailAddress);
		_log.info("userEmailAddress: " + userEmailAddress);

		String categoryId = ParamUtil.getString(actionRequest, "categoryId", StringPool.BLANK);
		actionResponse.setRenderParameter("categoryId", categoryId);
		_log.info("categoryId: " + categoryId);

		String tag = ParamUtil.getString(actionRequest, "tag", StringPool.BLANK);
		actionResponse.setRenderParameter("tag", tag);
		_log.info("tag: " + tag);

		String tags = ParamUtil.getString(actionRequest, "tags", StringPool.BLANK);
		actionResponse.setRenderParameter("tags", tags);
		_log.info("tags: " + tags);
	}

	private static Log _log = LogFactoryUtil.getLog(PublicRenderParametersIPCSenderPortlet.class);
}
