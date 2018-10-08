package okhttp.ok;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**********************************************************************
 *
 * 该类用于存放API和请求API相对应的方法
 *
 * @类名 ApiWrapperUtils
 * @包名 com.hotwheels.ok
 * @author 谢晗超
 * @创建日期 2018/5/12
 ***********************************************************************/
public final class ApiWrapperUtils {
    /**
     * 接口基地址
     */
    private final String BASE = "http://oxysrnjd2.bkt.clouddn.com";

    /**
     * 个人信息请求接口
     */
    private final String PERSONINFO = BASE + "/q.txt";

    /**
     * 单例模式内部类
     */
    private static class ApiWrapperUtilsInner{
        private final static ApiWrapperUtils mApiWrapperUtils = new ApiWrapperUtils();
    }

    /**
     * 获取单例模式
     * @return API实例
     */
    public static ApiWrapperUtils  getmApiWrapperUtils() {
        return ApiWrapperUtilsInner.mApiWrapperUtils;
    }

    /**
     * 私有构造方法
     */
    private ApiWrapperUtils(){}

    public Response getUserInfo() throws Exception {
        HashMap<String, String> headers = new HashMap<>();
        OkHttpUtils.post(PERSONINFO, null, new HashMap<String, String>(), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("成功");
            }
        });
        return null;
    }


}
