package com.example.ipc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ClientSideSenderPortlet extends MVCPortlet {

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		_log.info("====ClientSideSenderPortlet :: serveResource=======");
		
		String emailaddress = ParamUtil.getString(resourceRequest, "emailAddess");
		long companyId = ParamUtil.getLong(resourceRequest, "companyId");
		User user = null;
		
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailaddress);
		} catch (PortalException e) {
			user = null;
			System.out.println(e.getMessage());
		} catch (SystemException e) {
			user = null;
			System.out.println(e.getMessage());
		}
		
		PrintWriter pw = resourceResponse.getWriter();
		JSONObject juser = JSONFactoryUtil.createJSONObject();
		if (user != null) {
			juser.put("firstName", user.getFirstName());
			juser.put("lastName", user.getLastName());
			juser.put("userId", user.getUserId());
			juser.put("emailAddress", user.getEmailAddress());
			
			_log.info("User data : " + juser.toString());
			
		} else {
			System.out.println("===========error in get user by email===");
			juser.put("error", "No User found for given Email");
		}
		pw.println(juser.toString());		
	}

	private static Log _log = LogFactoryUtil.getLog(ClientSideSenderPortlet.class);
}
