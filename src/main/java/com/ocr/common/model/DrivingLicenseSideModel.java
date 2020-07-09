package com.ocr.common.model;

/**
 * 行驶证 正面
 */
public class DrivingLicenseSideModel {
    /**
     * 配置字符串信息
     */
    private String config_str;
    /**
     * 车牌号码
     */
    private String plate_num;
    /**
     * 车辆类型
     */
    private String vehicle_type;
    /**
     * 所有人名称
     */
    private String owner;
    /**
     * 使用性质
     */
    private String use_character;
    /**
     * 地址
     */
    private String addr;
    /**
     * 品牌型号
     */
    private String model;
    /**
     * 车辆识别代号
     */
    private String vin;
    /**
     * 发动机号码
     */
    private String engine_num;
    /**
     * 注册日期
     */
    private String register_date;
    /**
     * 发证日期
     */
    private String issue_date;
    /**
     * 请求对应的唯一表示
     */
    private String request_id;
    /**
     * 识别成功与否 true/false
     */
    private Boolean success;

    /**
     * 请求示例：
     * {
     *     "config_str": "null\n",         #配置字符串信息
     *     "plate_num": "沪A0M084",        #车牌号码
     *     "vehicle_type":"小型轿车",       #车辆类型
     *     "owner": "张三",                #所有人名称
     *     "use_character":"出租转非",      #使用性质
     *     "addr":"浙江省宁波市江东区丁街88弄", #地址
     *     "model":"桑塔纳牌SVW7180LE1",    #品牌型号
     *     "vin" : "LSVFF66R8C2116280",     #车辆识别代号
     *     "engine_num" : "416098",        #发动机号码
     *     "register_date":"20121127",       #注册日期
     *     "issue_date":"20130708",        #发证日期
     *     "request_id": "84701974fb983158_20160526100112",               #请求对应的唯一表示
     *     "success": true                 #识别成功与否 true/false
     * }
     * @return
     */

    public String getConfig_str() {
        return config_str;
    }

    public void setConfig_str(String config_str) {
        this.config_str = config_str;
    }

    public String getPlate_num() {
        return plate_num;
    }

    public void setPlate_num(String plate_num) {
        this.plate_num = plate_num;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUse_character() {
        return use_character;
    }

    public void setUse_character(String use_character) {
        this.use_character = use_character;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getEngine_num() {
        return engine_num;
    }

    public void setEngine_num(String engine_num) {
        this.engine_num = engine_num;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
