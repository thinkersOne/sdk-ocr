package com.ocr.common.model;

/**
 * 行驶证 反面
 */
public class DrivingLicenseBackModel {
    /**
     * 配置字符串信息
     */
    private String config_str;
    /**
     * 核定载人数
     */
    private String appproved_passenger_capacity;
    /**
     * 核定载质量
     */
    private String approved_load;
    /**
     * 档案编号
     */
    private String file_no;
    /**
     * 总质量
     */
    private String gross_mass;
    /**
     * 检验记录
     */
    private String inspection_record;
    /**
     * 外廓尺寸
     */
    private String overall_dimension;
    /**
     * 准牵引总质量
     */
    private String traction_mass;
    /**
     * 整备质量
     */
    private String unladen_mass;
    /**
     * 号牌号码
     */
    private String plate_num;
    /**
     * 识别成功与否 true/false
     */
    private Boolean success;
    /**
     * 请求对应的唯一表示
     */
    private String request_id;


    /**
     * 请求示例：
     * {
     *     "config_str":"{\"side\": \"back\" }",  #配置字符串信息
     *     "appproved_passenger_capacity":"5人",    #核定载人数
     *     "approved_load":"",                      #核定载质量
     *     "file_no":"530100001466",                #档案编号
     *     "gross_mass":"2000kg",                   #总质量
     *     "inspection_record":"检验有效期至2014年09月云A(01)",  #检验记录
     *     "overall_dimension":"4945x1845x1480mm",   #外廓尺寸
     *     "traction_mass":"",                       #准牵引总质量
     *     "unladen_mass":"1505kg"                   #整备质量
     *     "plate_num":"云AD8V02",                   #号牌号码
     *     "success":true,              #识别成功与否 true/false
     *     "request_id":"20180131144149_c440540b20a4dc079a10680ff60b2d2a" #请求对应的唯一表示
     * }
     * @return
     */

    public String getConfig_str() {
        return config_str;
    }

    public void setConfig_str(String config_str) {
        this.config_str = config_str;
    }

    public String getAppproved_passenger_capacity() {
        return appproved_passenger_capacity;
    }

    public void setAppproved_passenger_capacity(String appproved_passenger_capacity) {
        this.appproved_passenger_capacity = appproved_passenger_capacity;
    }

    public String getApproved_load() {
        return approved_load;
    }

    public void setApproved_load(String approved_load) {
        this.approved_load = approved_load;
    }

    public String getFile_no() {
        return file_no;
    }

    public void setFile_no(String file_no) {
        this.file_no = file_no;
    }

    public String getGross_mass() {
        return gross_mass;
    }

    public void setGross_mass(String gross_mass) {
        this.gross_mass = gross_mass;
    }

    public String getInspection_record() {
        return inspection_record;
    }

    public void setInspection_record(String inspection_record) {
        this.inspection_record = inspection_record;
    }

    public String getOverall_dimension() {
        return overall_dimension;
    }

    public void setOverall_dimension(String overall_dimension) {
        this.overall_dimension = overall_dimension;
    }

    public String getTraction_mass() {
        return traction_mass;
    }

    public void setTraction_mass(String traction_mass) {
        this.traction_mass = traction_mass;
    }

    public String getUnladen_mass() {
        return unladen_mass;
    }

    public void setUnladen_mass(String unladen_mass) {
        this.unladen_mass = unladen_mass;
    }

    public String getPlate_num() {
        return plate_num;
    }

    public void setPlate_num(String plate_num) {
        this.plate_num = plate_num;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }
}
