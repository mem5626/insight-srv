package com.cw.insight.controller;

import com.cw.insight.data.Params;
import com.cw.insight.utils.DbTools;
import com.cw.insight.utils.HttpTools;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;

@RestController
public class System {
    /*
    登记用户openid
     */
    @RequestMapping("/loginstate")
    public String getLoginState(HttpServletRequest request){
        String appid = Params.getParamById("appid");//小程序appid
        String secret = Params.getParamById("secret");//小程序secret
        String js_code = request.getParameter("code");//wx.login() 获取的code
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="
                +appid+"&secret="+secret+"&js_code="+js_code+"&grant_type=authorization_code";
        String jsonStr = HttpTools.httpRequest(url,"POST",null);

        String openid = "";
        String session_key = "";
        try {
            JSONObject jsonObject = (JSONObject) JSONValue.parseStrict(jsonStr);
            if(jsonObject != null){
                openid = jsonObject.get("openid") == null? "":jsonObject.get("openid").toString();
                session_key = jsonObject.get("session_key") == null? "":jsonObject.get("session_key").toString();
            }
        } catch (ParseException e) {
            //e.printStackTrace();
            openid = "";
        }
        if(!"".equals(openid)){
            if(!DbTools.checkIfExist("select count(1) from insight_user where openid='"+openid+"'")){
                DbTools.doUpdate("insert into insight_user(openid,last_time) values('"+openid+"',date_format(now(),'%Y-%m-%d %H:%i:%S'))");
            }
        }
        return "{\n" +
                "  \t\"openid\": \""+openid+"\",\n" +
                "  \t\"token\": \""+session_key+"\"\n" +
                "}\n";
    }

    /*
    首页顶部信息
     */
    @RequestMapping("/system")
    public String getSystem(){
        String appNum = "6";
        String exceptionNum = "0";
        int point = 0;
        try {
            ResultSet rs = DbTools.doQuery("select count(*) num from insight_app_exception where is_handled = '0'");
            if (rs.next()) {
                exceptionNum = rs.getString("num");
            }

        } catch (Exception e) {
            //e.printStackTrace();
            exceptionNum = "0";
        }
        point = 100 - Integer.parseInt(exceptionNum);
        return "{\n" +
                "    \"data\": {\n" +
                "        \"appNum\":"+appNum+",\n" +
                "        \"exceptionNum\":"+exceptionNum+",\n" +
                "        \"point\":"+point+"\n" +
                "    }\n" +
                "}";
    }

    /*
    官方公告
     */
    @RequestMapping("/system/announcements")
    public String getAnnouncements(){
        return Params.getParamById("announcements");
//        return "{\n" +
//                "    \"data\":[\n" +
//                "        {\n" +
//                "            \"date\":\"2018-08-12\",\n" +
//                "            \"details\":[\n" +
//                "                \"修复 小程序使用分包后，云测试提示代码包上限有误的问题 \",\n" +
//                "                \"修复 素材管理文件列表内容重叠的问题\",\n" +
//                "                \"修复 模拟器工具栏消失的问题 \"\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"date\":\"2018-07-20\",\n" +
//                "            \"details\":[\n" +
//                "                \"修复 1.0 带来的编译不生效的问题\",\n" +
//                "                \"修复 界面调试样式覆盖规则计算错误的问题 \",\n" +
//                "                \"修复 分包根目录名字后缀相同时报错的问题 \"\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
    }

}
