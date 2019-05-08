package com.currency.config;

/**
 * 通用配置文件
 *
 * @author acai
 * @ClassName: CurrencyConfig
 * @Description: 通用配置文件(这里用一句话描述这个类的作用)
 * @date 2018年9月13日 下午1:08:50
 */
public interface CurrencyConfig {

    public static final String[] originProperties = {
            "http://www.inartspace.com", "http://cms.inartspace.com",
            "http://mobile.inartspace.com", "http://weixin.inartspace.com",
            "http://192.168.1.58",
            "http://192.168.12.176:9002", "http://192.168.1.136:9002", "http://192.168.1.58:9003"};
    public static final String Front_Url = "http://192.168.1.136:8889";
    public static final String Front_WX_Url = "http://192.168.1.58:9003";

//	public static final String[] originProperties = { "http://www.inartspace.com", "http://cms.inartspace.com",
//			"http://mobile.inartspace.com", "http://weixin.inartspace.com", "https://cms.yssp-china.com" };
//	public static final String Front_Url = "http://front.inartspace.com";// 前台微信公众号接口正式环境
//	public static final String Front_WX_Url = "http://weixin.inartspace.com";// 前台微信端访问URL
//	public static final String Front_Computer_Url = "http://www.inartspace.com";// 前台电脑端访问URL
//	public static final String Front_Mobile_Url = "http://mobile.inartspace.com";// 前台手机端访问URL


    // 图片服务器访问域名
    public static final String FTP_Visit_URL = "https://picture.sh-idol.com";
    // 图片服务器上传ip
    public static final String FTP_URL = "10.10.1.213";
    // 图片服务器端口
    public static Integer FTP_PORT = 21;

    // 图片服务器用户名 0下标为身份证
    public static String[] FTP_USER = {"userIdCard"};
    // 图片服务器上传密码 0下标为身份证
    public static String[] FTP_PASS = {"Idol#123"};
    // 图片服务器上传路径 0下标为身份证
    public static String[] FTP_REMOTE_FILE_PATH = {"/"};

}
