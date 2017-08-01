package com.example.ipc;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class PublicRenderParametersIPCReceiverPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		_log.info("--PublicRenderParametersIPCReceiverPortlet--");
		String userEmailAddress = ParamUtil.getString(renderRequest, "userEmailAddress");
		_log.info("userEmailAddress: " + userEmailAddress);

		String categoryId = ParamUtil.getString(renderRequest, "categoryId");
		_log.info("categoryId: " + categoryId);

		String tag = ParamUtil.getString(renderRequest, "tag");
		_log.info("tag: " + tag);

		String tags = ParamUtil.getString(renderRequest, "tags");
		_log.info("tags: " + tags);

		super.render(renderRequest, renderResponse);
	}

	private static Log _log = LogFactoryUtil.getLog(PublicRenderParametersIPCReceiverPortlet.class);
}
