package com.clogic.dataanalytics.online.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

/**
 * 类名: CoreServlet </br>
 * 描述: 来接收微信服务器传来信息 </br>
 * 开发人员： souvc</br>
 * 创建时间：2015-9-29 </br>
 * 发布版本：V1.0 </br>
 */
@Controller
public class CoreServlet {

	static String TOKEN = "";

	/**
	 * 验证微信公众号
	 * 
	 * @param request
	 * @param response
	 * @author HYL
	 * @date 2018年3月20日 下午10:12:06
	 */
	@GetMapping("/testOne")
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				out.write(echostr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}

	/**
	 * 定制自动发送请求获取 access_token
	 * 
	 * @author HYL
	 * @date 2018年3月20日 下午10:13:20
	 */
	@GetMapping("/refreshToken")
	@ResponseBody
	public String refreshAccessToken() {

		String AppID = "wxde8eb0fd85608ee2";

		String AppSecret = "2535d8c6b23e929dcc60d979e7861f6f";

		String TokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + AppID
				+ "&secret=" + AppSecret;

		HttpClient client = HttpClients.createDefault();

		HttpUriRequest request = new HttpGet(TokenUrl);
		HttpResponse response = null;
		JSONObject ret = null;
		try {
			response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
				System.out.println("[获取到的JSON]:[" + strResult + "]");
				ret = (JSONObject) JSONObject.parse(strResult);
				String errcode = ret.getString("errcode");
				String errmsg = ret.getString("errmsg");
				if (null != errcode && errcode.length() > 0) {
					System.out.println(errmsg);
					return errmsg;
				}
				TOKEN = ret.getString("access_token");
				System.out.println("access_token:[" + TOKEN + "]");
				System.out.println("expires_in:[" + ret.getLong("expires_in") + "]");
				return "获取成功";
			} else {
				return "请求超时";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "请求异常";
		}

	}

	/**
	 * 个人帐号不能通过系统自定义菜单,必须升级企业版
	 * @return
	 * @throws UnsupportedEncodingException
	 * @author HYL   
	 * @date 2018年3月20日 下午11:40:09
	 */
	@Deprecated
	@GetMapping("/initMenu")
	public String createMenu() throws UnsupportedEncodingException {
		String menuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + TOKEN;

		String initMenu = "{\n" + "    \"button\": [\n" + "        {\n" + "            \"name\": \"个人中心\",\n"
				+ "            \"sub_button\": [\n" + "                {\n"
				+ "                    \"type\": \"location_select\",\n" + "                    \"name\": \"位置\",\n"
				+ "                    \"key\": \"rselfmenu_2_0\"\n" + "                },\n" + "                {\n"
				+ "                    \"type\": \"view\",\n" + "                    \"name\": \"绑定帐号\",\n"
				+ "                    \"url\":\"http://www.9ku.com/\"\n" + "                }\n" + "            ]\n"
				+ "        },\n" + "        {\n" + "            \"name\": \"百度\",\n"
				+ "            \"type\": \"view\",\n" + "             \"url\":\"http://www.baidu.com/\"\n"
				+ "        }\n" + "\n" + "    ]\n" + "}";
		return httpRequestPost(menuUrl, initMenu);
	}

	private String httpRequestPost(String url, String paramert) throws UnsupportedEncodingException {

		HttpClient client = HttpClients.createDefault();

		HttpPost request = new HttpPost(url);
		StringEntity entity = new StringEntity(paramert);
		request.setEntity(entity);
		HttpResponse response = null;
		JSONObject ret = null;
		try {
			response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
				System.out.println("[获取到的JSON]:[" + strResult + "]");
				ret = (JSONObject) JSONObject.parse(strResult);
				String errcode = ret.getString("errcode");
				String errmsg = ret.getString("errmsg");
				if (null != errcode && errcode.length() > 0) {
					System.out.println(errmsg);
					return errmsg;
				}
				return "获取成功";
			} else {
				return "请求超时";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "请求异常";
		}

	}
}
