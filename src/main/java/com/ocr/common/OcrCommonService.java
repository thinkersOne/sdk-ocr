package com.ocr.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.api.gateway.demo.Client;
import com.aliyun.api.gateway.demo.Request;
import com.aliyun.api.gateway.demo.Response;
import com.aliyun.api.gateway.demo.constant.Constants;
import com.aliyun.api.gateway.demo.constant.ContentType;
import com.aliyun.api.gateway.demo.constant.HttpHeader;
import com.aliyun.api.gateway.demo.enums.EnumOcrRes;
import com.aliyun.api.gateway.demo.enums.Method;
import com.aliyun.api.gateway.demo.util.MessageDigestUtil;
import com.ocr.common.req.OcrRequest;
import com.ocr.common.res.OcrResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OcrCommonService {
    private String appKey="203774242";
    private String appSecret = "66yw26f36zjmqiffpnvojrnr2t2a9iec";
    //自定义参与签名Header前缀（可选,默认只有"X-Ca-"开头的参与到Header签名）
    private final static List<String> CUSTOM_HEADERS_TO_SIGN_PREFIX = new ArrayList<String>();

    /**
     * ocr扫描
     * @param ocrRequest
     * @return
     */
    public OcrResponse getOcrResponse(OcrRequest ocrRequest){
        OcrResponse ocrResponse = new OcrResponse().code(1);
        String imgFile = ocrRequest.getImgFile();
        //Body内容
        String body = getRequestBody(getImgBase64(imgFile),ocrRequest.getSide());
        if(StringUtil.isBlank(body)){
            return new OcrResponse(EnumOcrRes.Identify_Error.getCode(),EnumOcrRes.Identify_Error.getDescription());
        }
        Map<String, String> headers = new HashMap<String, String>();
        //（必填）根据期望的Response内容类型设置
        headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "application/json");
        //（可选）Body MD5,服务端会校验Body内容是否被篡改,建议Body非Form表单时添加此Header
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_MD5, MessageDigestUtil.base64AndMD5(body));
        //（POST/PUT请求必选）请求Body内容格式
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_TEXT);
        Request request = new Request(Method.POST_STRING, ocrRequest.getHost(), ocrRequest.getPath(),
                appKey, appSecret, Constants.DEFAULT_TIMEOUT);
        request.setHeaders(headers);
        request.setSignHeaderPrefixList(CUSTOM_HEADERS_TO_SIGN_PREFIX);
        request.setStringBody(body);
        //调用服务端
        Response response = null;
        try {
            response = Client.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new OcrResponse(EnumOcrRes.Identify_Error.getCode(),EnumOcrRes.Identify_Error.getDescription());
        }
        OcrResponse res = getOcrResponse(response);
        if(res.getCode() != 1){
            return res;
        }
        JSONObject res_obj = JSON.parseObject(response.getBody());
        System.out.println(res_obj.toJSONString());
        ocrResponse.setData(res_obj);
        return ocrResponse;
    }

    /**
     * 获取 错误信息
     * @param response
     * @return
     */
    public OcrResponse getOcrResponse(Response response){
        if(response == null){
            return new OcrResponse(EnumOcrRes.Identify_Error.getCode(),EnumOcrRes.Identify_Error.getDescription());
        }
        if(response.getStatusCode() == 200){
            return new OcrResponse(EnumOcrRes.Identify_Success.getCode(),EnumOcrRes.Identify_Success.getDescription());
        }
        for (EnumOcrRes enumOcrRes : EnumOcrRes.values()){
            if(response.getStatusCode() == enumOcrRes.getCode().intValue()
                    && response.getBody().equals(enumOcrRes.getMsg())){
                return new OcrResponse(enumOcrRes.getCode(),enumOcrRes.getDescription());
            }
        }
        return new OcrResponse(EnumOcrRes.Identify_Error.getCode(),EnumOcrRes.Identify_Error.getDescription());
    }

    /**
     * 获取 base64
     * @param imgFile
     * @return
     */
    public String getImgBase64(String imgFile){
        if(StringUtil.isBlank(imgFile)){
            return null;
        }
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
            return null;
        }
        return imgBase64;
    }

    public String getRequestBody(String imgBase64,String side){
        if(StringUtils.isBlank(imgBase64) || StringUtils.isBlank(side)){
            return null;
        }
        JSONObject configObj = new JSONObject();
        configObj.put("side", side);
        String config_str = configObj.toString();
        // 拼装请求body的json字符串
        JSONObject requestObj = new JSONObject();
        try {
            requestObj.put("image", imgBase64);
            if(config_str.length() > 0) {
                requestObj.put("configure", config_str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        //Body内容
        return requestObj.toString();
    }

    public static void main(String[] args) {
        OcrCommonService ocrCommonService = new OcrCommonService();
        OcrRequest ocrRequest = new OcrRequest("http://dm-53.data.aliyun.com", "/rest/160601/ocr/ocr_vehicle.json",
                "C:\\projects\\functions\\OCR_EXAMPLE-master\\OCR_EXAMPLE-master\\java\\src\\main\\java\\com\\image\\行驶证1.jpg"
                ,"face");
        OcrResponse ocrResponse = ocrCommonService.getOcrResponse(ocrRequest);
        System.out.println(JSON.toJSONString(ocrResponse));
    }


}
