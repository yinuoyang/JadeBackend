package Jade.shoppingCart.demo;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

@RestController
public class Alipayclient {
	AlipayClient alipayClient;
	AlipayTradePagePayRequest alipayRequest;
	
	public Alipayclient() {
		alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
       
	}
	
	
	

    //商户订单号，商户网站订单系统中唯一订单号，必填
   
    //付款金额，必填
    String total_amount = "999";
    //订单名称，必填
    String subject = "支付宝测试";
    //商品描述，可空
    String body = "商品描述";
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	@RequestMapping(method=RequestMethod.GET, headers= {},path="/api/getPaymentLink")
	public String getPaymentLink(@RequestParam(required = true, name="amount") String amount, @RequestParam(required = true, name="tradeno") String tradeno) {
		this.alipayRequest = new AlipayTradePagePayRequest();
		this.alipayRequest.setReturnUrl(AlipayConfig.return_url);
        this.alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		 //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = tradeno;
        //付款金额，必填
        System.out.println(tradeno);
        System.out.println(amount);
        String total_amount = amount;
        //订单名称，必填
        String subject = "支付宝测试";
        //商品描述，可空
        String body = "商品描述";
		String requestPage = "";
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
                + "\"total_amount\":\""+ total_amount +"\"," 
                + "\"subject\":\""+ subject +"\"," 
                + "\"body\":\""+ body +"\"," 
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
            requestPage = result;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
		
		return requestPage;
	
	}
	
}
