package com.aliyun.api.gateway.demo.enums;

import com.aliyun.api.gateway.demo.Response;
import com.ocr.common.res.OcrResponse;

public enum EnumOcrRes {
    /**
     * 从阿里云 错误码 同步部分关键 错误信息
     * 地址：https://help.aliyun.com/document_detail/95605.html?spm=a2c4g.11186623.6.564.6d1c28c27qVCwH
     */
    Identify_Success(1,"Identify Success","上传成功!"),
    Identify_Error(1001,"Identify Error","识别失败，请重新上传!"),

    Invalid_URL(400,"Invalid URL","URL错误"),
    Forbidden(403,"Forbidden","没有购买，或者购买次数用尽，或者URL错误"),
    Request_Timeout(408,"Request Timeout","超时"),
    Payload_Too_Large(413,"Payload Too Large","request body太大"),
    Reject_Error(450,"","后端服务队列满，请求被拒绝，重试即可"),
    Invalid_Input_failed_to_parse_json(460,"Invalid Input - failed to parse json","上传的body不符合json格式要求，是非法json"),
    Invalid_Input_json_format_error_missing_key_image(461,"Invalid Input - json format error - missing key: image","新格式：输入Json中缺少image键\n" +
            "旧格式：输入Json的inputs值中缺少image键"),
    Invalid_Input_json_format_error_image_format_error(461,"Invalid Input - json format error - image format error","新格式：输入Json中的image值不是字符串\n" +
            "旧格式：输入Json中的image值不是包含DataValue和DataType的Json串"),
    Invalid_Input_json_format_error_key_inputs_missing(461,"Invalid Input - json format error - key inputs missing","旧格式：输入Json中缺少inputs键"),
    Invalid_Input_json_format_error_value_of_inputs_must_be_a_array(461,"Invalid Input - json format error - value of inputs must be a array","旧格式：输入Json中的inputs值不是一个array"),
    Invalid_Input_json_format_error_image_DataValue_format_error(461,"Invalid Input - json format error - image DataValue format error","旧格式：输入Json的image键中的DataValue值不是字符串"),
    Invalid_Input_json_format_error_configure_format_error(461,"Invalid Input - json format error - configure format error","旧格式：输入Json中的configure值不是包含DataValue和DataType的Json"),
    Invalid_Input_json_format_error_failed_to_parse_config_str_xxx(461,"Invalid Input - json format error - failed to parse config str: xxx","输入的configure不是合法的Json"),
    Invalid_Input_json_format_error_json_parse_runtime_exception(461,"Invalid Input - json format error - json parse runtime exception","输入的Json格式不符合要求"),
    Invalid_Input_image_data_error_download_image_from_url_error(461,"Invalid Input - image data error - download image from url error","从URL下载图像失败"),
    Invalid_Input_wrong_category(463,"Invalid Input - wrong category","输入图像不是对应服务的图像，如行驶证服务请求的不是行驶证"),
    Invalid_Result_algorithm_run_failed(464,"Invalid Result - algorithm run failed","OCR识别失败"),
    Invalid_Result_algorithm_runtime_exception(464,"Invalid Result - algorithm runtime exception","OCR识别异常"),
    Invalid_Result_xxx(464,"Invalid Result - xxx","OCR识别失败"),
    Bad_Gateway(502,"Bad Gateway","识别程序超时并断开连接"),
    Service_Unavailable(503,"Service Unavailable","API网关等待超时断开连接"),

    ;

    private Integer code;
    private String msg;
    private String description;

    EnumOcrRes(Integer code, String msg, String description) {
        this.code = code;
        this.msg = msg;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
