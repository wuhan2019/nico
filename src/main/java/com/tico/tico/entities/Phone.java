package com.tico.tico.entities;

import java.util.Arrays;
import java.util.List;

public class Phone {
    private String phone_name;
    private String phone_brand;
    private String phone_price;
    private String phone_release_time;
    //手机类型，用于筛选搜索，比如 4G手机：八核手机：拍照手机 不同修辞词用“：”分开
    private String phone_type;
    //手机系统，比如android9.0
    private String phone_systemInfo;
    private String phone_screenInfo;
    private String phone_screenSize;
    //屏幕分辨率
    private String phone_resolution;
    private String phone_cpuInfo;
    //手机内存
    private String phone_ramInfo;
    //手机硬盘
    private String phone_disk;
    //手机扩展性
    private String phone_extend;
    //手机电池
    private String phone_battery;
    private String phone_batterySize;
    //手机传感器
    private String phone_sensor;
    //前置摄像头
    private String phone_fcamera;
    //后置摄像头
    private String phone_bcamera;
    //拍摄功能描述
    private String phone_shotDisc;
    private String phone_network;
    private String phone_wlan;
    private String phone_gps;
    private String phone_apprearance;
    private String phone_keyboard;
    private String phone_size;
    private String phone_weight;
    private String phone_voice;
    private String phone_video;
    //京东购买链接
    private String phone_buylink;
    //图片地址，多个图片路径用“##”分开解析
    private String phone_pic;

    public List<String> getPhone_pics() {
        return phone_pics;
    }

    public void setPhone_pics(List<String> phone_pics) {
        this.phone_pics = phone_pics;
    }

    private List<String> phone_pics;

    public void getPics(){
        phone_pics = Arrays.asList(phone_pic.split("##"));
    }

    public String getPhone_name() {
        return phone_name;
    }

    public void setPhone_name(String phone_name) {
        this.phone_name = phone_name;
    }

    public String getPhone_brand() {
        return phone_brand;
    }

    public void setPhone_brand(String phone_brand) {
        this.phone_brand = phone_brand;
    }

    public String getPhone_price() {
        return phone_price;
    }

    public void setPhone_price(String phone_price) {
        this.phone_price = phone_price;
    }

    public String getPhone_release_time() {
        return phone_release_time;
    }

    public void setPhone_release_time(String phone_release_time) {
        this.phone_release_time = phone_release_time;
    }

    public String getPhone_type() {
        return phone_type;
    }

    public void setPhone_type(String phone_type) {
        this.phone_type = phone_type;
    }

    public String getPhone_systemInfo() {
        return phone_systemInfo;
    }

    public void setPhone_systemInfo(String phone_systemInfo) {
        this.phone_systemInfo = phone_systemInfo;
    }

    public String getPhone_screenInfo() {
        return phone_screenInfo;
    }

    public void setPhone_screenInfo(String phone_screenInfo) {
        this.phone_screenInfo = phone_screenInfo;
    }

    public String getPhone_screenSize() {
        return phone_screenSize;
    }

    public void setPhone_screenSize(String phone_screenSize) {
        this.phone_screenSize = phone_screenSize;
    }

    public String getPhone_resolution() {
        return phone_resolution;
    }

    public void setPhone_resolution(String phone_resolution) {
        this.phone_resolution = phone_resolution;
    }

    public String getPhone_cpuInfo() {
        return phone_cpuInfo;
    }

    public void setPhone_cpuInfo(String phone_cpuInfo) {
        this.phone_cpuInfo = phone_cpuInfo;
    }

    public String getPhone_ramInfo() {
        return phone_ramInfo;
    }

    public void setPhone_ramInfo(String phone_ramInfo) {
        this.phone_ramInfo = phone_ramInfo;
    }

    public String getPhone_disk() {
        return phone_disk;
    }

    public void setPhone_disk(String phone_disk) {
        this.phone_disk = phone_disk;
    }

    public String getPhone_extend() {
        return phone_extend;
    }

    public void setPhone_extend(String phone_extend) {
        this.phone_extend = phone_extend;
    }

    public String getPhone_battery() {
        return phone_battery;
    }

    public void setPhone_battery(String phone_battery) {
        this.phone_battery = phone_battery;
    }

    public String getPhone_batterySize() {
        return phone_batterySize;
    }

    public void setPhone_batterySize(String phone_batterySize) {
        this.phone_batterySize = phone_batterySize;
    }

    public String getPhone_sensor() {
        return phone_sensor;
    }

    public void setPhone_sensor(String phone_sensor) {
        this.phone_sensor = phone_sensor;
    }

    public String getPhone_fcamera() {
        return phone_fcamera;
    }

    public void setPhone_fcamera(String phone_fcamera) {
        this.phone_fcamera = phone_fcamera;
    }

    public String getPhone_bcamera() {
        return phone_bcamera;
    }

    public void setPhone_bcamera(String phone_bcamera) {
        this.phone_bcamera = phone_bcamera;
    }

    public String getPhone_shotDisc() {
        return phone_shotDisc;
    }

    public void setPhone_shotDisc(String phone_shotDisc) {
        this.phone_shotDisc = phone_shotDisc;
    }

    public String getPhone_network() {
        return phone_network;
    }

    public void setPhone_network(String phone_network) {
        this.phone_network = phone_network;
    }

    public String getPhone_wlan() {
        return phone_wlan;
    }

    public void setPhone_wlan(String phone_wlan) {
        this.phone_wlan = phone_wlan;
    }

    public String getPhone_gps() {
        return phone_gps;
    }

    public void setPhone_gps(String phone_gps) {
        this.phone_gps = phone_gps;
    }

    public String getPhone_apprearance() {
        return phone_apprearance;
    }

    public void setPhone_apprearance(String phone_apprearance) {
        this.phone_apprearance = phone_apprearance;
    }

    public String getPhone_keyboard() {
        return phone_keyboard;
    }

    public void setPhone_keyboard(String phone_keyboard) {
        this.phone_keyboard = phone_keyboard;
    }

    public String getPhone_size() {
        return phone_size;
    }

    public void setPhone_size(String phone_size) {
        this.phone_size = phone_size;
    }

    public String getPhone_weight() {
        return phone_weight;
    }

    public void setPhone_weight(String phone_weight) {
        this.phone_weight = phone_weight;
    }

    public String getPhone_voice() {
        return phone_voice;
    }

    public void setPhone_voice(String phone_voice) {
        this.phone_voice = phone_voice;
    }

    public String getPhone_video() {
        return phone_video;
    }

    public void setPhone_video(String phone_video) {
        this.phone_video = phone_video;
    }

    public String getPhone_buylink() {
        return phone_buylink;
    }

    public void setPhone_buylink(String phone_buylink) {
        this.phone_buylink = phone_buylink;
    }

    public String getPhone_pic() {
        return phone_pic;
    }

    public void setPhone_pic(String phone_pic) {
        this.phone_pic = phone_pic;
    }
}
