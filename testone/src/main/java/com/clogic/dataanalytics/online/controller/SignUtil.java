/**   
 *
 * @author HYL   
 * @date 2018年3月20日 下午5:46:50
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.clogic.dataanalytics.online.controller;

import java.util.Arrays;

/**
 * 类名: SignUtil </br>
 * 描述: 检验signature 工具类 </br>
 * 开发人员： souvc </br>
 * 创建时间： 2015-9-29 </br>
 * 发布版本：V1.0 </br>
 */
public class SignUtil {

	// 与接口配置信息中的Token要一致
	private static String token = "hyl2517";

	/**
	 * 方法名：checkSignature</br> 详述：验证签名</br> 开发人员：souvc</br> 创建时间：2015-9-29
	 * </br> @param signature @param timestamp @param nonce @return @throws
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce) {
		// 1.将token、timestamp、nonce三个参数进行字典序排序
		String[] arr = new String[] { token, timestamp, nonce };
		Arrays.sort(arr);

		// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}

		// 进行sha1加密
		String temp = SHA1.encode(content.toString());
		// 与微信提供的signature进行匹对
		return signature.equals(temp);

	}
}
