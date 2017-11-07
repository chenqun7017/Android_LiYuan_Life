package com.lifecircle.utils;

/**
 * 常用方法工具
 *
 * Created by chenqun on 2017/8/1.
 */


public class EditViewUtil {



	/**
	 * 判断 一个字段的值否为空
	 *
	 * @param
	 * @return
	 */
	public static boolean isNull(String s) {
		if (null == s || s.equals("") || s.equalsIgnoreCase("null")) {
			return true;
		}

		return false;
	}




	/**
	 * 验证呢称
	 *
	 * @param nickname
	 * @return
	 */
	public static boolean validateNickname(String nickname) {
		if (isNull(nickname))
			return false;
		String pattern = "[\u4e00-\u9fa5\\w]+";
		return nickname.matches(pattern);
	}

	/**
	 * 验证手机号码
	 *
	 * @param phone
	 * @return
	 */
	public static boolean validatePhone(String phone) {
		if (isNull(phone))
			return false;
		String pattern = "^(1(([35][0-9])|(47)|[8][0-9]|[7][0-9]))\\d{8}$";
		return phone.matches(pattern);
	}

	/**
	 * 验证密码
	 *
	 * @param password
	 * @return
	 */
	public static boolean validatePwd(String password) {
		if (isNull(password))
			return false;
		String pattern = "^[a-zA-Z0-9]{6,16}$";
		return password.matches(pattern);
	}

	/**
	 * 描述：是否是邮箱.
	 *
	 * @param str 指定的字符串
	 * @return 是否是邮箱:是为true，否则false
	 */
	public static Boolean isEmail(String str) {
		Boolean isEmail = false;
		String expr = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		if (str.matches(expr)) {
			isEmail = true;
		}
		return isEmail;
	}

}