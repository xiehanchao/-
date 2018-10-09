package com.example.common.okhttp;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**********************************************************************
 *
 *
 * @类名 StringUtils
 * @包名 com.hotwheels
 * @author 谢晗超
 * @创建日期 2018/5/12
 ***********************************************************************/
public class StringUtils {
    private StringUtils() {
        throw new AssertionError();
    }

    /**
     * 判断字符串是否为空或是空字符串或是空格组成字符串
     *
     * <pre>
     * isBlank(null) = true;
     * isBlank(&quot;&quot;) = true;
     * isBlank(&quot;  &quot;) = true;
     * isBlank(&quot;a&quot;) = false;
     * isBlank(&quot;a &quot;) = false;
     * isBlank(&quot; a&quot;) = false;
     * isBlank(&quot;a b&quot;) = false;
     * </pre>
     *
     * @param str 传入字符串
     * @return 判断结果
     */
    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }

    /**
     * 判断字符串是否为空或是空字符串
     *
     * <pre>
     * isEmpty(null) = true;
     * isEmpty(&quot;&quot;) = true;
     * isEmpty(&quot;  &quot;) = false;
     * </pre>
     *
     * @param str 传入字符串
     * @return 判断结果
     */
    public static boolean isEmpty(CharSequence str) {
        return (str == null || str.length() == 0);
    }

    /**
     * 比较字符串是否相等
     *
     * @param actual 现有的字符串
     * @param expected 预期的字符串
     * @return 比较结果
     */
    public static boolean isEquals(String actual, String expected) {
        return actual == expected || (actual == null ? expected == null : actual.equals(expected));
    }

    /**
     * 取得CharSequence长度
     *
     * <pre>
     * length(null) = 0;
     * length(\"\") = 0;
     * length(\"abc\") = 3;
     * </pre>
     *
     * @param str 传入CharSequence
     * @return CharSequence长度
     */
    public static int length(CharSequence str) {
        return str == null ? 0 : str.length();
    }

    /**
     * 对象转字符串，如为空对象则转换为空字符串
     *
     * <pre>
     * nullStrToEmpty(null) = &quot;&quot;;
     * nullStrToEmpty(&quot;&quot;) = &quot;&quot;;
     * nullStrToEmpty(&quot;aa&quot;) = &quot;aa&quot;;
     * </pre>
     *
     * @param str 转换对象
     * @return 转换字符串
     */
    public static String nullStrToEmpty(Object str) {
        return (str == null ? "" : (str instanceof String ? (String)str : str.toString()));
    }

    /**
     * 将字符串进行UTF-8编码
     *
     * <pre>
     * utf8Encode(null)        =   null
     * utf8Encode("")          =   "";
     * utf8Encode("aa")        =   "aa";
     * utf8Encode("啊啊啊啊")   = "%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A";
     * </pre>
     *
     * @param str 现有字符串
     * @return UTF-8编码后字符串
     * @throws UnsupportedEncodingException 编码异常
     */
    public static String utf8Encode(String str) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
            }
        }
        return str;
    }

    /**
     * 将字符串进行UTF-8编码，如有异常则返回默认字符串
     *
     * @param str 现有字符串
     * @param defultReturn 默认字符串
     * @return UTF-8编码后字符串
     */
    public static String utf8Encode(String str, String defultReturn) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return defultReturn;
            }
        }
        return str;
    }
}
