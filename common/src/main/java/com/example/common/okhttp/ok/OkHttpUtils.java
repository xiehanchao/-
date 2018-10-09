package com.example.common.okhttp.ok;

import android.util.Log;


import java.util.Iterator;
import java.util.Map;

import com.example.common.okhttp.StringUtils;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**********************************************************************
 *
 *
 * @类名 OkHttpUtils
 * @包名 com.hotwheels.ok
 * @author 谢晗超
 * @创建日期 2018/5/12
 ***********************************************************************/
public class OkHttpUtils {
    /**
     * TAG
     */
    public static final String TAG = OkHttpUtils.class.getSimpleName();
    /**
     * 用于提交JSON数据
     */
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    /**
     * OkHttpClient对象，通过构建类默认配置构建
     */
    private static OkHttpClient sOkHttpClient = new OkHttpBuilder().build();

    /**
     * 异步GET请求
     *
     * @param url 请求地址
     * @param params 请求参数
     * @param responseCallback 响应回调
     * @throws Exception 异常
     */
    public static void get(String url, Map<String, String> params, Callback responseCallback) throws Exception {
        OkHttpUtils.get(url, null, params, responseCallback);
    }

    /**
     * 异步GET请求
     *
     * @param url 请求地址
     * @param headers 请求头
     * @param params 请求参数
     * @param responseCallback 响应回调
     * @throws Exception 异常
     */
    public static void get(String url, Map<String, String> headers, Map<String, String> params, Callback responseCallback) throws Exception {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(OkHttpUtils.getUrlWithValueEncodeParas(url, params));
        if (headers != null) {
            requestBuilder.headers(Headers.of(headers));
        }
        Request request = requestBuilder.build();
        Log.v(TAG,"get request:" + request.toString());
        sOkHttpClient.newCall(request).enqueue(responseCallback);
    }

    /**
     * 同步GET请求
     *
     * @param url 请求地址
     * @param params 请求参数
     * @return 响应对象
     * @throws Exception 异常
     */
    public static Response get(String url, Map<String, String> params) throws Exception {
        return OkHttpUtils.get(url, null, params);
    }

    /**
     * 同步GET请求
     *
     * @param url 请求地址
     * @param headers 请求头
     * @param params 请求参数
     * @return 响应对象
     * @throws Exception 异常
     */
    public static Response get(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(OkHttpUtils.getUrlWithValueEncodeParas(url, params));
        if (headers != null) {
            requestBuilder.headers(Headers.of(headers));
        }
        Request request = requestBuilder.build();
        Log.v(TAG,"get request:" + request.toString());
        return sOkHttpClient.newCall(request).execute();
    }

    /**
     * 同步POST请求
     *
     * @param url 请求地址
     * @param params 请求参数
     * @return 响应对象
     * @throws Exception 异常
     */
    public static Response post(String url, Map<String, String> params) throws Exception {
        return OkHttpUtils.post(url, null, params);
    }

    /**
     * 同步POST请求
     *
     * @param url 请求地址
     * @param headers 请求头
     * @param params 请求参数
     * @return 响应对象
     * @throws Exception 异常
     */
    public static Response post(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(url);
        if (headers != null) {
            requestBuilder.headers(Headers.of(headers));
        }
        if (params != null) {
            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            for (Map.Entry<String, String> param : params.entrySet()) {
                formBodyBuilder.add(param.getKey(), param.getValue());
            }
            RequestBody requestBody = formBodyBuilder.build();
            requestBuilder.post(requestBody);
        }
        Request request = requestBuilder.build();
        Log.v(TAG,"post request:" + request.toString());
        return sOkHttpClient.newCall(request).execute();
    }

    /**
     * 异步POST请求
     *
     * @param url 请求地址
     * @param params 请求参数
     * @param responseCallback 响应回调
     * @throws Exception 异常
     */
    public static void post(String url, Map<String, String> params, Callback responseCallback) throws Exception {
        OkHttpUtils.post(url, null, params, responseCallback);
    }
    /**
     * 异步POST请求
     *
     * @param url 请求地址
     * @param headers 请求头
     * @param params 请求参数
     * @param responseCallback 响应回调
     * @throws Exception 异常
     */

    public static void post(String url, Map<String, String> headers, Map<String, String> params, Callback responseCallback) throws Exception {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(url);
        if (headers != null) {
            requestBuilder.headers(Headers.of(headers));
        }
        if (params != null) {
            FormBody.Builder requestBodyBuilder = new FormBody.Builder();
            for (Map.Entry<String, String> param : params.entrySet()) {
                requestBodyBuilder.add(param.getKey(), param.getValue());
            }
            RequestBody requestBody = requestBodyBuilder.build();
            requestBuilder.post(requestBody);
        }
        Request request = requestBuilder.build();
        Log.v(TAG,"post request:" + request.toString());
        sOkHttpClient.newCall(request).enqueue(responseCallback);
    }

    /**
     * 异步POST请求(用于传递JSON字符串)
     *
     * @param url 请求地址
     * @param requestContent 请求体
     * @param responseCallback 响应回调
     * @throws Exception 异常
     */
    public static void post(String url, String requestContent, Callback responseCallback) throws Exception {
        OkHttpUtils.post(url, null, requestContent, responseCallback);
    }
    /**
     * 异步POST请求(用于传递JSON字符串)
     *
     * @param url 请求地址
     * @param headers 请求头
     * @param requestContent 请求体
     * @param responseCallback 响应回调
     * @throws Exception 异常
     */
    public static void post(String url, Map<String, String> headers, String requestContent, Callback responseCallback) throws Exception {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(url);
        if (headers != null) {
            requestBuilder.headers(Headers.of(headers));
        }
        if (!StringUtils.isEmpty(requestContent)) {
            RequestBody requestBody = RequestBody.create(JSON, requestContent);
            requestBuilder.post(requestBody);
        }
        Request request = requestBuilder.build();
        Log.v(TAG,"post request:" + request.toString());
        sOkHttpClient.newCall(request).enqueue(responseCallback);
    }
    /**
     * 将请求地址和请求参数映像转换为URL完整地址
     *
     * @param url 请求地址
     * @param parasMap 请求参数映像
     * @return 完整地址
     */
    public static String getUrlWithValueEncodeParas(String url, Map<String, String> parasMap) {
        StringBuilder urlWithParas = new StringBuilder(StringUtils.isEmpty(url) ? "" : url);
        String paras = joinParasWithEncodedValue(parasMap);
        if (!StringUtils.isEmpty(paras)) {
            urlWithParas.append("?").append(paras);
        }
        return urlWithParas.toString();
    }

    /**
     * 将请求参数映像转换为URL地址中的参数子字符串
     *
     * @param parasMap 请求参数映像
     * @return URL地址中的参数子字符串
     */
    public static String joinParasWithEncodedValue(Map<String, String> parasMap) {
        StringBuilder paras = new StringBuilder("");
        if (parasMap != null && parasMap.size() > 0) {
            Iterator<Map.Entry<String, String>> ite = parasMap.entrySet().iterator();
            try {
                while (ite.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry<String, String>) ite.next();
                    paras.append(entry.getKey()).append("=").append(StringUtils.utf8Encode(entry.getValue()));
                    if (ite.hasNext()) {
                        paras.append("&");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return paras.toString();
    }




}
