package com.cw.insight.utils;

import com.cw.insight.data.Params;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTools {

    //处理http请求  requestUrl为请求地址  requestMethod请求方式，值为"GET"或"POST"
    public static String httpRequest(String requestUrl,String requestMethod,String outputStr){
        StringBuffer buffer=null;
        try{
            URL url=new URL(requestUrl);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod(requestMethod);
            conn.connect();
            //往服务器端写内容 也就是发起http请求需要带的参数
            if(null!=outputStr){
                OutputStream os=conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }

            //读取服务器端返回的内容
            InputStream is=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public String sendTemplate(){
        String appid = Params.getParamById("appid");
        String secret = Params.getParamById("secret");
        String template_id = Params.getParamById("template_id");
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

    public static void main(String[] args){
        //String s=httpRequest("https://www.hi5399.xyz/apps","GET",null);
        String a = "https://api.weixin.qq.com/sns/jscode2session?appid=wx1044da5d38d4d77d&secret=69c5ee2b5b8bb56aba2aff32e8935bfe&js_code=1234&grant_type=authorization_code";
        String s=httpRequest(a,"POST",null);
        System.out.println(s);
    }
}
