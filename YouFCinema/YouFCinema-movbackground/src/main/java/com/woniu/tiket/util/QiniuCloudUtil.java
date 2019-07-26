package com.woniu.tiket.util;

import java.io.IOException;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class QiniuCloudUtil {
	// 设置需要操作的账号的AK和SK
	private static final String ACCESS_KEY = "7DqJiRB0XA3u02LjIWTaZTHBfH0zaA8Sk3Mj1taD";
	private static final String SECRET_KEY = "kHh0_OyMbqxfHSzmOQmLxsFzKwMER8dBOCoQTU_J";

	// 要上传的空间
	private static final String bucketname = "movies";

	// 密钥
	private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

	private static final String DOMAIN = "pv3v1208f.bkt.clouddn.com";

	//private static final String style = "自定义的图片样式";

	public String getUpToken() {        
        return auth.uploadToken(bucketname, null, 3600, new StringMap().put("insertOnly", 1));
    }
	
	
	//base64方式上传
    public String put64image(byte[] base64, String key) throws Exception{
    	String file64 = Base64.encodeToString(base64, 0);
        Integer l = base64.length;
        String url = "http://upload.qiniu.com/putb64/" + l + "/key/"+ UrlSafeBase64.encodeToString(key);      
        //非华东空间需要根据注意事项 1 修改上传域名
        RequestBody rb = RequestBody.create(null, file64);
        Request request = new Request.Builder().
                url(url).
                addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + getUpToken())
                .post(rb).build();
        //System.out.println(request.headers());
        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = client.newCall(request).execute();
        //如果不需要添加图片样式，使用以下方式
        return DOMAIN + key;
        //return DOMAIN + key + "?" + style;
    }
    class Ret {
        public long fsize;
        public String key;
        public String hash;
        public int width;
        public int height;
    }
}
