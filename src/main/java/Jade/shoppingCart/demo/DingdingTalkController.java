package Jade.shoppingCart.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;



//Controller control the post method to Dingding backend
@RestController
public class DingdingTalkController {
	
	DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/sns/getuserinfo_bycode");
	OapiSnsGetuserinfoBycodeRequest ding_req = new OapiSnsGetuserinfoBycodeRequest();
	private final String AppId = "dingoawhfmkj85ekyly4qw";
	private final String AppSecret = "-RuPAAzUX_GhgvI3lksVhN_rd_osD0Fs2dpxiF_3aPqjblGYPuVUnN1cyHjn8ZiN";
	
	@RequestMapping(method=RequestMethod.POST, path="")
	public String postUserData() {
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/api/getToken")
	public String getToken(@RequestParam(required = true) String tempCode) {
		ding_req.setTmpAuthCode(tempCode);
		System.out.println("Welcome to jade get method");
		try {
			OapiSnsGetuserinfoBycodeResponse res = client.execute(ding_req, AppId, AppSecret);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
