package com.cw.insight.controller;

import com.cw.insight.data.Params;
import com.cw.insight.utils.DbTools;
import com.cw.insight.utils.HttpTools;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;

@RestController
public class Apps {
    /*
    获取所有应用列表。
     */
    @RequestMapping("/apps")
    public String getApps(){
        return "{\n" +
                "    \"records\":[\n" +
                "        {\n" +
                "            \"id\":\"CAPS\",\n" +
                "            \"title\":\"对公账户体系与产品服务\",\n" +
                "            \"url\": \"https://images.unsplash.com/photo-1487544532015-24f380bb9113?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=eddc41ce01e818b8fbb0d2da81061a75&auto=format&fit=crop&w=500&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":\"GCMC\",\n" +
                "            \"title\":\"全球现金管理\",\n" +
                "            \"url\": \"https://images.unsplash.com/photo-1526978051370-7f21511778aa?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=129fce2b05ac2d9769fee3493dcf21d6&auto=format&fit=crop&w=500&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":\"MBPS\",\n" +
                "            \"title\":\"多银行支付\",\n" +
                "            \"url\": \"https://images.unsplash.com/photo-1519389950473-47ba0277781c?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=47d2b1f32cc05c976af4a39256e01cba&auto=format&fit=crop&w=500&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":\"DEMO1\",\n" +
                "            \"title\":\"用例应用系统1\",\n" +
                "            \"url\": \"https://images.unsplash.com/photo-1533021465698-203cf8b7936f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=226635089169a49de62c0c1f0bc27d5f&auto=format&fit=crop&w=500&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":\"DEMO2\",\n" +
                "            \"title\":\"用例应用系统2\",\n" +
                "            \"url\": \"https://images.unsplash.com/photo-1435163570436-d7c1dee361c4?ixlib=rb-0.3.5&s=8c74898a1d66979a9fbbe49366c76904&auto=format&fit=crop&w=500&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":\"DEMO3\",\n" +
                "            \"title\":\"用例应用系统3\",\n" +
                "            \"url\": \"https://images.unsplash.com/photo-1435163570436-d7c1dee361c4?ixlib=rb-0.3.5&s=8c74898a1d66979a9fbbe49366c76904&auto=format&fit=crop&w=500&q=60\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    /*
    获取指定应用的所有层级指标的列表。
     */
    @RequestMapping("/apps/{appid}/quotas")
    public String getAppQuotas(@PathVariable String appid,HttpServletRequest request){
        String x001 = "false";
        String l001 = "false";
        String y001 = "false";
        String y002 = "false";
        String y003 = "false";
        try {
            String openid = request.getParameter("openid");
            ResultSet rs = DbTools.doQuery("select \n" +
                    "(select 'true' from insight_collection where chartid='x001') as x001,\n" +
                    "(select 'true' from insight_collection where chartid='l001') as l001,\n" +
                    "(select 'true' from insight_collection where chartid='y001') as y001,\n" +
                    "(select 'true' from insight_collection where chartid='y002') as y002,\n" +
                    "(select 'true' from insight_collection where chartid='y003') as y003");
            if (rs.next()) {
                x001 = "true".equals(rs.getString("x001"))?"true":"false";
                l001 = "true".equals(rs.getString("x001"))?"true":"false";
                y001 = "true".equals(rs.getString("x001"))?"true":"false";
                y002 = "true".equals(rs.getString("x001"))?"true":"false";
                y003 = "true".equals(rs.getString("x001"))?"true":"false";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\n" +
                "    \"xingneng\":[\n" +
                "        {\n" +
                "            \"name\":\"应用服务器CPU使用率\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"主站点CPU使用率\",\n" +
                "                    \"id\":\"x001\",\n" +
                "                    \"ifCollected\":"+x001+"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"数据库服务器CPU使用率\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"单次耗时过长语句\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"执行次数过多语句\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"数据库硬解析次数过多\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"数据库统计信息丢失\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"存在失效的对象\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"ziyuan\":[\n" +
                "        {\n" +
                "            \"name\":\"应用服务器磁盘使用率\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"数据库服务器磁盘使用率\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"表空间使用率\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"序列使用率\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"记录数增长\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"piliang\":[\n" +
                "        {\n" +
                "            \"name\":\"批量开始时间\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"批量结束时间\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"批量运行时长\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"批量中断\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"批量处理记录数\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"批量处理成功率\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"批量重复处理监控\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"批量数据清理情况\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"lianji\":[\n" +
                "        {\n" +
                "            \"name\":\"技术类错误\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"交易成功率\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"代理业务成功率\",\n" +
                "                    \"id\":\"l001\",\n" +
                "                    \"ifCollected\":"+l001+"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"交易响应时间\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"交易并发数\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"应用间一致性监控\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"差错对账\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"定时任务执行情况\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"报文指令量/成功率\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"发送消息量/成功率\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"yewu\":[\n" +
                "        {\n" +
                "            \"name\":\"业务量（笔）\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"资产池业务增长情况\",\n" +
                "                    \"id\":\"y001\",\n" +
                "                    \"ifCollected\":"+y001+"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"付款渠道交易量\",\n" +
                "                    \"id\":\"y002\",\n" +
                "                    \"ifCollected\":"+y002+"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"交易率（笔/秒）\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"业务成功率\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"交易金额\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"业务增长数/率\",\n" +
                "            \"items\":[\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"业务统计\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"对公收费交易分布\",\n" +
                "                    \"id\":\"y003\",\n" +
                "                    \"ifCollected\":"+y003+"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    /*
    获取指定应用的详细信息。
     */
    @RequestMapping("/apps/{appid}")
    public String getAppInfo(@PathVariable String appid, HttpServletRequest request){
        if ("CAPS".equals(appid)){
            return "{\n" +
                    "    \"data\": {\n" +
                    "        \"title\": \"对公账户体系与产品服务\",\n" +
                    "        \"bio\": \"提供平台结算账户的结算及相关配套的管理功能。包括账户管理、凭证管理、收支结算、协议维护、风险管控、资金管理、批量处理、账户计息及核算等功能。\"\n" +
                    "    },\n" +
                    "    \"charts\": {\n" +
                    "        \"line\":[10, 1, 2, 8, 0, 0, 1, 3, 0, 7, 1, 4],\n" +
                    "        \"pie\": [\n" +
                    "            {\"name\": \"批量\", \"value\": 5},\n" +
                    "            {\"name\": \"联机\", \"value\": 9},\n" +
                    "            {\"name\": \"业务\", \"value\": 13},\n" +
                    "            {\"name\": \"性能\", \"value\": 11},\n" +
                    "            {\"name\": \"资源\", \"value\": 16}\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}";
        }else if ("MBPS".equals(appid)){
            return "{\n" +
                    "    \"data\": {\n" +
                    "        \"title\": \"多银行支付\",\n" +
                    "        \"bio\": \"提供非本行账户（卡）跨行支付功能，主要包括以下四部分内容：1.介入模块；2.支付路由；3.第三方支付渠道管理；4.内部管理。\"\n" +
                    "    },\n" +
                    "    \"charts\": {\n" +
                    "        \"line\":[10, 1, 2, 8, 0, 0, 1, 3, 0, 7, 1, 4],\n" +
                    "        \"pie\": [\n" +
                    "            {\"name\": \"批量\", \"value\": 5},\n" +
                    "            {\"name\": \"联机\", \"value\": 9},\n" +
                    "            {\"name\": \"业务\", \"value\": 13},\n" +
                    "            {\"name\": \"性能\", \"value\": 11},\n" +
                    "            {\"name\": \"资源\", \"value\": 16}\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}";
        }else{
            return "{\n" +
                    "    \"data\": {\n" +
                    "        \"title\": \"全球现金管理\",\n" +
                    "        \"bio\": \"为我行现金管理企业客户提供流动性管理、收付款、信息服务、投融资等一系列现金管理产品组合服务。\"\n" +
                    "    },\n" +
                    "    \"charts\": {\n" +
                    "        \"line\":[10, 1, 2, 8, 0, 0, 1, 3, 0, 7, 1, 4],\n" +
                    "        \"pie\": [\n" +
                    "            {\"name\": \"批量\", \"value\": 5},\n" +
                    "            {\"name\": \"联机\", \"value\": 9},\n" +
                    "            {\"name\": \"业务\", \"value\": 13},\n" +
                    "            {\"name\": \"性能\", \"value\": 11},\n" +
                    "            {\"name\": \"资源\", \"value\": 16}\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}";
        }

    }

    /*
    用户登录时，获取该用户的唯一标识openid。
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
    获取某指标的图表数据。
     */
    @RequestMapping("/diagrams/{chartid}")
    public String getDiagram(@PathVariable String chartid){
        String chartdata = "{}";
        try{
            ResultSet rs = DbTools.doQuery("select * from test_chart where chartid='" + chartid + "'");
            if(rs != null && rs.next()){
                chartdata =  rs.getString("chartdata");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return chartdata;
    }
}
