package com.blbuyer.erp.util;

/**
 * 枚举类
 * 2016-10-14
 *
 */
public class MessageConstants {
	
		/**
		 * 会员/卡分类
		 */
		public static enum CardCode {
			
			BUYER_STORE(10, "买手店会员");

			CardCode(Integer code, String value) {
				this.code = code;
				this.value = value;
			}

			private Integer code;
			private String value;

			public Integer getCode() {
				return code;
			}

			public String getValue() {
				return value;
			}

		}
		
	public final static String smsUserName = "shblyy";
	
	public final static String smsPassword = "shblyy0920";
	
	public final static String smsSendUrl = "http://www.yescloudtree.cn:28001/";
	
	public final static String smsPointContent = "尊敬的会员您好：您{0}年剩余积分{1}将于{2}清空。";
}
