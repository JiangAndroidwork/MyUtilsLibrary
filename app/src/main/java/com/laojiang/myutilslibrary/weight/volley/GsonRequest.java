package com.laojiang.myutilslibrary.weight.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.laojiang.myutilslibrary.application.DemoApplication;
import com.laojiang.utilslibrary.volley.util.FileCopyUtils;
import com.laojiang.utilslibrary.volley.utils.ALog;
import com.laojiang.utilslibrary.volley.utils.MD5Utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;



/**
 * 自定义Request，通过GSON解析json格式的response。带缓存请求功能。
 * @param <T>
 */
public class GsonRequest<T> extends Request<T> {

    private final Gson gson = new Gson();
    private final Class<? extends T> clazz;
    private final Map<String, String> params;
    private final Response.Listener<T> listener;
    private boolean isCache;

    /**
     * 初始化
     *
     * @param method        请求方式
     * @param url           请求地址
     * @param params        请求参数，可以为null
     * @param clazz         Clazz类型，用于GSON解析json字符串封装数据
     * @param listener      处理响应的监听器
     * @param errorListener 处理错误信息的监听器
     */
    public GsonRequest(int method, String url, Map<String, String> params, Class<? extends T> clazz,
                       Response.Listener<T> listener, Response.ErrorListener errorListener, boolean isCache) {
        super(method, url, errorListener);
        this.clazz = clazz;
        this.params = params;
        this.listener = listener;
        this.isCache = isCache;
    }

    public Gson getGson() {
        return gson;
    }

    /**
     * 获取GsonRequest所要解析Class类型
     *
     * @return GSON解析的对象字节码
     */
    public Class<? extends T> getClazz() {
        return clazz;
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            ALog.d("我是volley返回的字符串----------====>>>>>>" + json);

            if (isCache) {
                //将json字符串缓存到本地
                FileCopyUtils.copy(response.data, new File(DemoApplication.getInstance().getCacheDir(), "" + MD5Utils.encode(getUrl())));
            }

            T result = null;
            try {
                result = gson.fromJson(json, clazz);//按正常响应解析
            } catch (JsonSyntaxException e) {
//                result = (T) gson.fromJson(json, ErrorResponse.class);//解析失败，按错误响应
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            return Response.success(
                    result,
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        } catch (IOException e) {
            return Response.error(new ParseError(e));
        }
    }
}