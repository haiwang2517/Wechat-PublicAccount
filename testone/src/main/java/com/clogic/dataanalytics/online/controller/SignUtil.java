/**   
 *
 * @author HYL   
 * @date 2018��3��20�� ����5:46:50
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.clogic.dataanalytics.online.controller;

import java.util.Arrays;

/**
 * ����: SignUtil </br>
 * ����: ����signature ������ </br>
 * ������Ա�� souvc </br>
 * ����ʱ�䣺 2015-9-29 </br>
 * �����汾��V1.0 </br>
 */
public class SignUtil {

	// ��ӿ�������Ϣ�е�TokenҪһ��
	private static String token = "hyl2517";

	/**
	 * ��������checkSignature</br> ��������֤ǩ��</br> ������Ա��souvc</br> ����ʱ�䣺2015-9-29
	 * </br> @param signature @param timestamp @param nonce @return @throws
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce) {
		// 1.��token��timestamp��nonce�������������ֵ�������
		String[] arr = new String[] { token, timestamp, nonce };
		Arrays.sort(arr);

		// 2. �����������ַ���ƴ�ӳ�һ���ַ�������sha1����
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}

		// ����sha1����
		String temp = SHA1.encode(content.toString());
		// ��΢���ṩ��signature����ƥ��
		return signature.equals(temp);

	}
}
