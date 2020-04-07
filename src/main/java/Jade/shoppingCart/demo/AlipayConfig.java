package Jade.shoppingCart.demo;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

	public static String app_id = "2016102300746938";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCxMn1e+0PafaSilhC/N3arUzyvZkF+Vgkf7OzzNGsbOycJGyJYjhINVIsjd07DOfeLaYVXeygpI4196eDsbuHHIG2tk5h+TD6Yal6uuh9qHfGaqxOc+eytBxiF1k8L2T2wQKAR1F+/b9alOa3o/oQ1nJj3Ysn6QJefEgDTh+jCmzSv/CydfgeddUT+Fd/O85/BAzOnDGNOMywbSjpd0LAGl5yruMEFjAtHjkfpewYx+7v0zT8UZXJQ8AvpfbGLgVc0UpLtbPsQQ6TNHRhktM7LnTsLzyJuWT9v2atdsz/rnPsDFbcsDWsmUN4o5vOvOjuwXiH/TTm2aFDIb7acPZQNAgMBAAECggEAA9NqP42/Rk1mK5h/3hENf995NPRJP7gN1GGiMBIWqezaB+lNEYpnu1/y7R4bVj2/KYRqu5vOHy1EVc6h65jtSQZbN98y8K8mvtW1G6KrIPhqigNdlgsTYB0CG4moBUJ4gYCztA7YzmJUyRZ4ucodAqdR6i143O1eGLIj0G1jyifUhRcqOA7rMO+vro2IoUb1/NEWI6xPxE/ACk+EUq4Sv/JpbZcMStCqJHeyKRj+DH54wIxLnms75BMcJeoUefNoNRP8ShUChSJdz2TN0WRhbI7s0ovoSZdSHyzAMMzZjiuLc83Gi5FXEkr+F7tKpyxGQ64joga26CIKvvZFK8pQxQKBgQDar4e5yQmzi0XpHFN/vfaXO7x1RDUyVToqkOuMLdutuGlO9cTpxAmgSu3Nrq3U/Cmb2zEPPS4wvXuYsJgZYhqF6vzUVo0Ob5k22ZdFfVloeoyZDZzVm2JXxK4otS+Y8KG0SUmyfoPVHrG9L4zSj3JEQKlNtePWLbsDEtt46CY5fwKBgQDPbrEAFkiujn+TMyI6poBVFucLrpBfWx42LUbdjWudKw2rm3PFjPXaDAjBAZqCLH/xmbEkrOhRzYeWUOrzhSYFH1OwGoeG7NpiDdNmUSiYQuPggWlUVR2sayXV9k1P9HNLL4inQv8/nfQXQRt2QLiwtJA6HTRkSQC6nyRowE5AcwKBgQCqGEOqlxtLorWS9qxfvMLzqMwSLiZuauoeN7BuzTCEc969Qt6RsSCHpCBJjme5NRWsG5aSMtUdphRflGQJwku9BCT5iASZSOZUSnSl4TTM1h1L4tGtN/oLKHkKQrut6uTr1OFUy6EBAKng6/5NvLN1MRI+1o5LhjBi2KUK6w7oQwKBgQC/8tk9kGFfjiOFrkqdZVfZ5WCWEcotQx8Y2Rr7h5MulBmJVEd0ZjVWuc4b9ATrMoyOoD8pBgvRLtSqB2TzRaHiGZQSoOoKtAB9vfeCddWP2E4QgRBb5ouX8mrHrKzsMPPDflABH2EdmGe4YRotekSt19iivkWuC1PuXbeOa229+wKBgHy1qiYAGnZdrZItSnRxKkFfBdX/JQWTolXBHZar8mrzYgXu3cWevQW2FkNHELlHDnMWAgbSPuV7Yh9ljF2RBnOMcJkHgYZpUmxrlwWIDIncPjARCV84Si+29Hc+46XR0QcU46q206AkEN9TBsFhlC16ofbuwq6NzLTy2ALf1UA9";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm/Wy008xUySKXJzrJV5SFQ2cL0XVIFUX/8JBk/j6VgjxEypGen9bJaPDM+7iOFddC1TteehDEpuOy31QG+P3iJ5OHqngUtwow6hgGGMhV66Rt/GS+CaeJvkstkey59EbWrzRO1pYwAkb7f5fqiFmwvD2K1n5SLRZjkyp8sMHcczaMrfF3foxe1NQ8Gx86u3nYh3fSlxdIACZ1B/x+960rwVuUa7LSxEN9oR005EWQ+4qTON+NeNOLo4xzqX9ZKdajm7qXhuC0OsFCc0GzuNOo9bfJp0nuRPJe/kPZgYnzJzU9y1bz2jd/wlmtkh8So4kTLbJAr1Tqws2ssRz9FOg6wIDAQAB";
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8000/paymentSuccess";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8000/cart";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "/Users/yinuoyang/Desktop/java/Jade/Log";


    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

