/**   
 * Copyright © 2016 本代码版权归周林波所有，严禁未经许可使用。
 * 
 * @Title: RegexUtil.java 
 * @Prject: springweb
 * @Package: com.mckay.util 
 * @Description:
 * @author:
 * @date: 2016年12月30日 下午10:27:46 
 * @version: V1.0   
 */
package com.mckay.util;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/** 
 * @ClassName: RegexUtil 
 * @Description: TODO
 * @author: 周林波
 * @date: 2016年12月30日 下午10:27:46  
 */
public class RegexUtil {
	
    public final static boolean isNull(Object[] objs){
        if(objs==null||objs.length==0) return true;
        return false;
    }
    
    public final static boolean isNull(Integer integer){
        if(integer==null||integer==0) return true;
        return false;
    }
    
    @SuppressWarnings("rawtypes")
	public final static boolean isNull(Collection collection){
        if(collection==null||collection.size()==0) return true;
        return false;
    }
    
    @SuppressWarnings("rawtypes")
	public final static boolean isNull(Map map){
        if(map==null||map.size()==0) return true;
        return false;
    }
    
    public final static boolean isNull(String str){
        return str == null || "".equals(str.trim()) || "null".equals(str.toLowerCase());
    }
    
    
    public final static boolean isNull(Long longs){
        if(longs==null||longs==0) return true;
        return false;
    }
    
    public final static boolean isNotNull(Long longs){
        return !isNull(longs);
    }
    
    public final static boolean isNotNull(String str){
        return !isNull(str);
    }
    
    @SuppressWarnings("rawtypes")
	public final static boolean isNotNull(Collection collection){
        return !isNull(collection);
    }
    
    @SuppressWarnings("rawtypes")
    public final static boolean isNotNull(Map map){
        return !isNull(map);
    }
    
    public final static boolean isNotNull(Integer integer){
        return !isNull(integer);
    }
    
    public final static boolean isNotNull(Object[] objs){
        return !isNull(objs);
    }
    
    /**
     * 匹配URL地址
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean isUrl(String str) {
        return match(str, "^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$");
    }
    
    /**
     * 匹配密码，以字母开头，长度在6-12之间，只能包含字符、数字和下划线。
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean isPwd(String str) {
        return match(str, "^[a-zA-Z]\\w{6,12}$");
    }
    
    /**
     * 验证字符，只能包含中文、英文、数字、下划线等字符。
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean stringCheck(String str) {
        return match(str, "^[a-zA-Z0-9\u4e00-\u9fa5-_]+$");
    }
    
    /**
     * 匹配Email地址
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean isEmail(String str) {
        return match(str, "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }
    
    /**
     * 匹配非负整数（正整数+0）
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean isInteger(String str) {
        return match(str, "^[+]?\\d+$");
    }
    
    /**
     * 判断数值类型，包括整数和浮点数
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean isNumeric(String str) { 
        if(isFloat(str) || isInteger(str)) return true;
        return false;
    }
    
    /**
     * 只能输入数字
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean isDigits(String str) {
        return match(str, "^[0-9]*$");
    }
    
    /**
     * 匹配正浮点数
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean isFloat(String str) {
        return match(str, "^[-\\+]?\\d+(\\.\\d+)?$");
    }
    
    /**
     * 联系电话(手机/电话皆可)验证   
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isTel(String text){
        if(isMobile(text)||isPhone(text)) return true;
        return false;
    }
    
    /**
     * 电话号码验证  
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isPhone(String text){
        return match(text, "^(\\d{3,4}-?)?\\d{7,9}$");
    }
    
    /**
     * 手机号码验证   
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isMobile(String text){
        if(text.length()!=11) return false;
        return match(text, "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
    }
    
    /**
     * 身份证号码验证 
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isIdCardNo(String text){
        return match(text, "^(\\d{6})()?(\\d{4})(\\d{2})(\\d{2})(\\d{3})(\\w)$");
    }
    
    /**
     * 邮政编码验证 
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isZipCode(String text){
        return match(text, "^[0-9]{6}$");
    }
    
    /**
     * 判断整数num是否等于0
     * 
     * @param num
     * @return
     * @author jiqinlin
     */
    public final static boolean isIntEqZero(int num){ 
         return num==0;
    }
    
    /**
     * 判断整数num是否大于0
     * 
     * @param num
     * @return
     * @author jiqinlin
     */
    public final static boolean isIntGtZero(int num){ 
         return num>0;
    }
    
    /**
     * 判断整数num是否大于或等于0
     * 
     * @param num
     * @return
     * @author jiqinlin
     */
    public final static boolean isIntGteZero(int num){ 
        return num>=0;
    }
    
    /**
     * 判断浮点数num是否等于0
     * 
     * @param num 浮点数
     * @return
     * @author jiqinlin
     */
    public final static boolean isFloatEqZero(float num){ 
         return num==0f;
    }
    
    /**
     * 判断浮点数num是否大于0
     * 
     * @param num 浮点数
     * @return
     * @author jiqinlin
     */
    public final static boolean isFloatGtZero(float num){ 
         return num>0f;
    }
    
    /**
     * 判断浮点数num是否大于或等于0
     * 
     * @param num 浮点数
     * @return
     * @author jiqinlin
     */
    public final static boolean isFloatGteZero(float num){ 
        return num>=0f;
    }
    
    /**
     * 判断是否为合法字符(a-zA-Z0-9-_)
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isRightfulString(String text){
        return match(text, "^[A-Za-z0-9_-]+$"); 
    }
    
    /**
     * 判断英文字符(a-zA-Z)
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isEnglish(String text){
        return match(text, "^[A-Za-z]+$"); 
    }
    
    /**
     * 判断中文字符(包括汉字和符号)
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isChineseChar(String text){
        return match(text, "^[\u0391-\uFFE5]+$");
    }
    
    /**
     * 匹配汉字
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isChinese(String text){
        return match(text, "^[\u4e00-\u9fa5]+$");
    }
    
    /**
     * 是否包含中英文特殊字符，除英文"-_"字符外
     * 
     * @param str
     * @return
     */
    public static boolean isContainsSpecialChar(String text) {
        if(StringUtils.isBlank(text)) return false;
        String[] chars={"[","`","~","!","@","#","$","%","^","&","*","(",")","+","=","|","{","}","'",
                ":",";","'",",","[","]",".","<",">","/","?","~","！","@","#","￥","%","…","&","*","（","）",
                "—","+","|","{","}","【","】","‘","；","：","”","“","’","。","，","、","？","]"};
        for(String ch : chars){
            if(text.contains(ch)) return true;
        }
        return false;
    }
    
    /**
     * 过滤中英文特殊字符，除英文"-_"字符外
     * 
     * @param text
     * @return
     */
    public static String stringFilter(String text) {
        String regExpr="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";  
        Pattern p = Pattern.compile(regExpr);
        Matcher m = p.matcher(text);
        return m.replaceAll("").trim();     
    }
    
    
    /**
     * 正则表达式匹配
     * 
     * @param text 待匹配的文本
     * @param reg 正则表达式
     * @return
     * @author jiqinlin
     */
    private final static boolean match(String text, String reg) {
        if (StringUtils.isBlank(text) || StringUtils.isBlank(reg))
            return false;
        return Pattern.compile(reg).matcher(text).matches();
    }
}
