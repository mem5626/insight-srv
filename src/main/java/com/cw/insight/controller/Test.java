package com.cw.insight.controller;

import com.cw.insight.data.Params;
import com.cw.insight.utils.HttpTools;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @RequestMapping("/test")
    public String getApps(){
        return Params.getParamById("appid");
    }

    @RequestMapping("/template")
    public String setTemplate(){
        String appid = "wx1044da5d38d4d77d";
        String secret = "69c5ee2b5b8bb56aba2aff32e8935bfe";
        String template_id = "ST-eqvgOuAVHq-w4DYMuD4Uc0oITPJp9m3rQbl8ObM8";
        String openid = "oZwF75Z-BtareG5p1jDzzLenCV5g";
        String formid = "1533175450568";

        String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret+"";
        String jsonStr = "";
        try {
            jsonStr = HttpTools.httpRequest(access_token_url,"GET",null);
            java.lang.System.out.println("access_token_url="+jsonStr);
            String access_token = "";
            JSONObject jsonObject = (JSONObject) JSONValue.parseStrict(jsonStr);
            if(jsonObject != null){
                access_token = jsonObject.get("access_token") == null? "":jsonObject.get("access_token").toString();
            }
            java.lang.System.out.println("access_token="+access_token);
            String template_url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="+access_token;
            //template_url += "&touser="+openid+"&template_id="+template_id+"&form_id="+formid+"&data={}";

            String put = "{\n" +
                    "  \"touser\": \""+openid+"\",\n" +
                    "  \"template_id\": \""+template_id+"\",\n" +
                    "  \"form_id\": \""+formid+"\",\n" +
                    "  \"data\": {\n" +
                    "      \"keyword1\": {\n" +
                    "          \"value\": \"登录成功了喂\"\n" +
                    "      },\n" +
                    "      \"keyword2\": {\n" +
                    "          \"value\": \"就是这里了\"\n" +
                    "      }\n" +
                    "  }\n" +
                    "}";
            jsonStr = HttpTools.httpRequest(template_url,"POST",put);
            java.lang.System.out.println("template_url="+jsonStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
