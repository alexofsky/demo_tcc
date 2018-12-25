package com.blbuyer.erp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.google.common.base.Strings;

/**

 * <p>Title: StringCommonUtil</p>
 
 * <p>Description: 字符串处理工具类</p>

 * @author  Xia Hao

 * @date    2018年1月22日
 */
public class StringCommonUtil {

	/**
	
	 * <p>Title: makeUpZero</p>
	 
	 * <p>Description: 字符串长度小于10时，再前面补0</p>
	
	 * @author  Xia Hao
	 * @param str
	 * @return
	 */
	public static String makeUpZero(String str){
		if(Strings.isNullOrEmpty(str) || str.length() >= 10){
			return str;
		}else {
			String val = str;
			for (int i = str.length(); i < 10; i++) {
				val = "0" + val;
			}
			return val;
		}
	}
	
	/**
	
	 * <p>Title: makeUpZeroList</p>
	 
	 * <p>Description: 将字符串集合中字符串长度小于10时，再前面补0</p>
	
	 * @author  Xia Hao
	 * @param strList
	 * @return
	 */
	public static List<String> makeUpZeroList(List<String> strList) {
		List<String> list = new ArrayList<String>();
		if(strList != null && !strList.isEmpty()){
			for (String str : strList) {
				list.add(makeUpZero(str));
			}
		}
		return list;
	}
	
	/**
	
	 * <p>Title: isChinaPhoneLegal</p>
	 
	 * <p>Description: 验证手机号是否合法</p>
	
	 * @author  Xia Hao
	 * @param str
	 * @return
	 * @throws PatternSyntaxException
	 */
	public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {  
        String regExp = "^1[\\d]{10}";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }
	
	/**
	
	 * <p>Title: isBankCard</p>
	 
	 * <p>Description: 验证银行卡号是否合法</p>
	
	 * @author  Xia Hao
	 * @param str
	 * @return
	 * @throws PatternSyntaxException
	 */
	public static boolean isBankCard(String str) throws PatternSyntaxException {  
        String regExp = "^[1-9]{1,}";
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }
	
	/**
	
	 * <p>Title: enCardQrCodeParam</p>
	 
	 * <p>Description: 生成卡券二维码参数</p>
	
	 * @author  Xia Hao
	 * @param str
	 * @return
	 */
	public static String enCardQrCodeParam(String str){
		return "{\"customerCode\":\""+ str +"\"}";
	}
}
