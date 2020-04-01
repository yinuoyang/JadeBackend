package Jade.shoppingCart.demo;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;



//Controller control the post method to Dingding backend
@RestController
public class DingdingTalkController {
	
	
	private final String AppId = "dingoawhfmkj85ekyly4qw";
	private final String AppSecret = "-RuPAAzUX_GhgvI3lksVhN_rd_osD0Fs2dpxiF_3aPqjblGYPuVUnN1cyHjn8ZiN";
	
	@RequestMapping(method=RequestMethod.POST, path="")
	public String postUserData() {
		return null;
	}
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	
	@CrossOrigin(origins = "http://localhost:8000")
	@RequestMapping(method=RequestMethod.GET, headers= {},path="/api/getToken")
	public String getToken(@RequestParam(required = true, name="tempCode") String tempCode) {
		String result = "";
		DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/sns/getuserinfo_bycode");
		OapiSnsGetuserinfoBycodeRequest ding_req = new OapiSnsGetuserinfoBycodeRequest();
		System.out.println("Welcome to jade get method: ");
		try {
			ding_req.setTmpAuthCode(tempCode);
			OapiSnsGetuserinfoBycodeResponse res = client.execute(ding_req, AppId, AppSecret);
		
			System.out.println(res.getUserInfo());
			result =  res.getBody();
			
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
		
	}
}
