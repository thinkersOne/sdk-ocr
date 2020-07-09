package com.alibaba.ocr.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.api.gateway.demo.Client;
import com.aliyun.api.gateway.demo.Request;
import com.aliyun.api.gateway.demo.Response;
import com.aliyun.api.gateway.demo.constant.Constants;
import com.aliyun.api.gateway.demo.constant.ContentType;
import com.aliyun.api.gateway.demo.constant.HttpHeader;
import com.aliyun.api.gateway.demo.enums.Method;
import com.aliyun.api.gateway.demo.util.MessageDigestUtil;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 调用api网关，通过app_key进行身份认证
 */
public class APPKeyDemo {

    //自定义参与签名Header前缀（可选,默认只有"X-Ca-"开头的参与到Header签名）
    private final static List<String> CUSTOM_HEADERS_TO_SIGN_PREFIX = new ArrayList<String>();

    /*
     * 获取参数的json对象
     */
    public static JSONObject getParam(int type, String dataValue) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("dataType", type);
            obj.put("dataValue", dataValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        //请求path  身份证
//        String host = "http://dm-51.data.aliyun.com";
//        String path = "/rest/160601/ocr/ocr_idcard.json";
//        String APP_KEY = "203774242";
//        String APP_SECRET = "66yw26f36zjmqiffpnvojrnr2t2a9iec";
//        String imgFile = "C:\\projects\\functions\\OCR_EXAMPLE-master\\OCR_EXAMPLE-master\\java\\src\\main\\java\\com\\image\\正面照.jpg";

        // 行驶证
        String host = "http://dm-53.data.aliyun.com";
        String path = "/rest/160601/ocr/ocr_vehicle.json";
        String APP_KEY = "203774242";
        String APP_SECRET = "66yw26f36zjmqiffpnvojrnr2t2a9iec";
        String imgFile = "C:\\projects\\functions\\OCR_EXAMPLE-master\\OCR_EXAMPLE-master\\java\\src\\main\\java\\com\\image\\正面照.jpg";

        //请根据线上文档修改configure字段
        JSONObject configObj = new JSONObject();
        configObj.put("side", "face");
        String config_str = configObj.toString();
        // 对图像进行base64编码
        String imgBase64 = "";
        try {
            if(imgFile.startsWith("http")){
                imgBase64 = imgFile;
            }else {
                File file = new File(imgFile);
                byte[] content = new byte[(int) file.length()];
                FileInputStream finputstream = new FileInputStream(file);
                finputstream.read(content);
                finputstream.close();
                imgBase64 = new String(Base64.encodeBase64(content));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        // 拼装请求body的json字符串
        JSONObject requestObj = new JSONObject();
        try {
            requestObj.put("image", imgBase64);
            if(config_str.length() > 0) {
                requestObj.put("configure", config_str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Body内容
        String body = requestObj.toString();
        Map<String, String> headers = new HashMap<String, String>();
        //（必填）根据期望的Response内容类型设置
        headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "application/json");
        //（可选）Body MD5,服务端会校验Body内容是否被篡改,建议Body非Form表单时添加此Header
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_MD5, MessageDigestUtil.base64AndMD5(body));
        //（POST/PUT请求必选）请求Body内容格式
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_TEXT);
        Request request = new Request(Method.POST_STRING, host, path, APP_KEY, APP_SECRET, Constants.DEFAULT_TIMEOUT);
        request.setHeaders(headers);
        request.setSignHeaderPrefixList(CUSTOM_HEADERS_TO_SIGN_PREFIX);
        request.setStringBody(body);
        //调用服务端
        Response response = Client.execute(request);
        if(response.getStatusCode() != 200){
            System.out.println("Http code: " + response.getStatusCode());
            System.out.println("Http header error: " + response.getHeader("X-Ca-Error-Message"));
            System.out.println("Http body error msg: " + response.getBody());
            System.out.println("Http error Msg:"+ response.getErrorMessage());
            System.out.println(JSON.toJSONString(response));
            return;
        }
        String res = response.getBody();
        JSONObject res_obj = JSON.parseObject(res);
        System.out.println(res_obj.toJSONString());
    }
}
