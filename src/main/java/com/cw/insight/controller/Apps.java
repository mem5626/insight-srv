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
    应用列表
     */
    @RequestMapping("/apps")
    public String getApps() {
        String apps = "{}";
        try {
            ResultSet rs = DbTools.doQuery("select * from insight_app");
            String appid = "";
            String appname = "";
            String pic_url = "";
            apps = "{\"records\":[";
            while (rs.next()) {
                appid = rs.getString("appid");
                appname = rs.getString("appname");
                pic_url = rs.getString("pic_url");
                apps += "{\"id\":\"" + appid + "\",\"app\":\"" + appid + "\",\"title\":\"" + appname + "\",\"url\":\"" + pic_url + "\"},";
            }
            if (",".equals(apps.substring(apps.length() - 1))) {
                apps = apps.substring(0, apps.length() - 1);
            }
            apps += "]}";
        } catch (Exception e) {
            e.printStackTrace();
            apps = "{}";
        }
        return apps;
    }

    /*
    指标列表
     */
    @RequestMapping("/apps/{appid}/quotas")
    public String getAppQuotas(@PathVariable String appid, HttpServletRequest request) {
        String kpiData = "{";
        try {
            String openid = request.getParameter("openid");
            String sql = "SELECT " +
                    " (CASE WHEN k.kpitype = '1' THEN 'xingneng' WHEN k.kpitype = '2' THEN 'ziyuan' WHEN k.kpitype = '3' THEN 'piliang' WHEN k.kpitype = '4' THEN 'lianji' WHEN k.kpitype = '5' THEN 'yewu' ELSE k.kpitype END) kpitype," +
                    " k.kpiid,k.kpiname, " +
                    " t.title,t.chartid, " +
                    "IFNULL((SELECT 'true' FROM insight_collection c WHERE c.openid='"+openid+"' AND c.chartid=t.chartid LIMIT 1),'false') ifCollected " +
                    "FROM insight_kpi k " +
                    "left join test_chart t on k.kpiid=t.kpiid " +
                    "ORDER BY k.kpitype,k.kpiid";
            java.lang.System.out.println("sql=" + sql);
            ResultSet rs = DbTools.doQuery(sql);
            String kpitype = "";
            String kpiname = "";
            String title = "";
            String chartid = "";
            String ifCollected = "";
            String typeTemp = "";
            String nameTemp = "";

            while (rs.next()) {
                kpitype = rs.getString("kpitype");
                kpiname = rs.getString("kpiname");
                title = rs.getString("title");
                chartid = rs.getString("chartid");
                ifCollected = rs.getString("ifCollected");

                if (typeTemp.equals(kpitype)) {
                    if (nameTemp.equals(kpiname)) {
                        if (chartid != null && !"".equals(chartid) && !"null".equals(chartid)) {
                            kpiData += "                {\n" +
                                    "                    \"name\":\"" + title + "\",\n" +
                                    "                    \"id\":\"" + chartid + "\",\n" +
                                    "                    \"ifCollected\":" + ifCollected + "\n" +
                                    "                },";
                        }
                        //nameTemp = kpiname;
                    } else {

                        if (",".equals(kpiData.substring(kpiData.length() - 1))) {
                            kpiData = kpiData.substring(0, kpiData.length() - 1);
                        }

                        kpiData += "\n            ]\n" +
                                "        },";

                        kpiData += "\n       {\n" +
                                "            \"name\":\"" + kpiname + "\",\n" +
                                "            \"items\":[\n";

                        if (chartid != null && !"".equals(chartid) && !"null".equals(chartid)) {
                            kpiData += "                {\n" +
                                    "                    \"name\":\"" + title + "\",\n" +
                                    "                    \"id\":\"" + chartid + "\",\n" +
                                    "                    \"ifCollected\":" + ifCollected + "\n" +
                                    "                },";
                        }
                        nameTemp = kpiname;
                    }

                } else {

                    if (!"".equals(typeTemp)) {
                        if (",".equals(kpiData.substring(kpiData.length() - 1))) {
                            kpiData = kpiData.substring(0, kpiData.length() - 1);
                        }
                        kpiData += "\n]\n";
                        kpiData += "\n            }\n" +
                                "        ],";
                    }
                    kpiData += "\n\"" + kpitype + "\":[";
                    kpiData += "\n       {\n" +
                            "            \"name\":\"" + kpiname + "\",\n" +
                            "            \"items\":[\n";
                    if (chartid != null && !"".equals(chartid) && !"null".equals(chartid)) {
                        kpiData += "                {\n" +
                                "                    \"name\":\"" + title + "\",\n" +
                                "                    \"id\":\"" + chartid + "\",\n" +
                                "                    \"ifCollected\":" + ifCollected + "\n" +
                                "                },";
                    }
                    nameTemp = kpiname;
                }
                typeTemp = kpitype;
            }

            if (",".equals(kpiData.substring(kpiData.length() - 1))) {
                kpiData = kpiData.substring(0, kpiData.length() - 1);
            }
            kpiData += "\n]\n" +
                    "}";
            kpiData += "\n]\n" +
                    "}";
        } catch (Exception e) {
            e.printStackTrace();
            kpiData = "{}";
        }
        //java.lang.System.out.println("kpiData=" + kpiData);
        return kpiData;


//        String x001 = "false";
//        String l001 = "false";
//        String y001 = "false";
//        String y002 = "false";
//        String y003 = "false";
//        try {
//            String openid = request.getParameter("openid");
//            ResultSet rs = DbTools.doQuery("select " +
//                    "(select 'true' from insight_collection where openid='"+openid+"' and chartid='x001') as x001," +
//                    "(select 'true' from insight_collection where openid='"+openid+"' and chartid='l001') as l001," +
//                    "(select 'true' from insight_collection where openid='"+openid+"' and chartid='y001') as y001," +
//                    "(select 'true' from insight_collection where openid='"+openid+"' and chartid='y002') as y002," +
//                    "(select 'true' from insight_collection where openid='"+openid+"' and chartid='y003') as y003");
//            if (rs.next()) {
//                x001 = "true".equals(rs.getString("x001"))?"true":"false";
//                l001 = "true".equals(rs.getString("l001"))?"true":"false";
//                y001 = "true".equals(rs.getString("y001"))?"true":"false";
//                y002 = "true".equals(rs.getString("y002"))?"true":"false";
//                y003 = "true".equals(rs.getString("y003"))?"true":"false";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "{\n" +
//                "    \"xingneng\":[\n" +
//                "        {\n" +
//                "            \"name\":\"应用服务器CPU使用率\",\n" +
//                "            \"items\":[\n" +
//                "                {\n" +
//                "                    \"name\":\"主站点CPU使用率\",\n" +
//                "                    \"id\":\"x001\",\n" +
//                "                    \"ifCollected\":"+x001+"\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"数据库服务器CPU使用率\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"单次耗时过长语句\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"执行次数过多语句\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"数据库硬解析次数过多\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"数据库统计信息丢失\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"存在失效的对象\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"ziyuan\":[\n" +
//                "        {\n" +
//                "            \"name\":\"应用服务器磁盘使用率\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"数据库服务器磁盘使用率\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"表空间使用率\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"序列使用率\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"记录数增长\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"piliang\":[\n" +
//                "        {\n" +
//                "            \"name\":\"批量开始时间\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"批量结束时间\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"批量运行时长\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"批量中断\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"批量处理记录数\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"批量处理成功率\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"批量重复处理监控\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"批量数据清理情况\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"lianji\":[\n" +
//                "        {\n" +
//                "            \"name\":\"技术类错误\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"交易成功率\",\n" +
//                "            \"items\":[\n" +
//                "                {\n" +
//                "                    \"name\":\"代理业务成功率\",\n" +
//                "                    \"id\":\"l001\",\n" +
//                "                    \"ifCollected\":"+l001+"\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"交易响应时间\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"交易并发数\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"应用间一致性监控\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"差错对账\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"定时任务执行情况\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"报文指令量/成功率\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"发送消息量/成功率\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"yewu\":[\n" +
//                "        {\n" +
//                "            \"name\":\"业务量（笔）\",\n" +
//                "            \"items\":[\n" +
//                "                {\n" +
//                "                    \"name\":\"资产池业务增长情况\",\n" +
//                "                    \"id\":\"y001\",\n" +
//                "                    \"ifCollected\":"+y001+"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"name\":\"付款渠道交易量\",\n" +
//                "                    \"id\":\"y002\",\n" +
//                "                    \"ifCollected\":"+y002+"\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"交易率（笔/秒）\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"业务成功率\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"交易金额\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"业务增长数/率\",\n" +
//                "            \"items\":[\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"name\":\"业务统计\",\n" +
//                "            \"items\":[\n" +
//                "                {\n" +
//                "                    \"name\":\"对公收费交易分布\",\n" +
//                "                    \"id\":\"y003\",\n" +
//                "                    \"ifCollected\":"+y003+"\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
    }

    /*
    应用详细信息
     */
    @RequestMapping("/apps/{appid}")
    public String getAppInfo(@PathVariable String appid) {
        String appinfo = "{}";
        try {
            ResultSet rs = DbTools.doQuery("select * from insight_app where appid = '" + appid + "'");
            if (rs.next()) {
                String appname = rs.getString("appname");
                String appdesc = rs.getString("appdesc");
                appinfo = "{\n" +
                        "    \"data\":{\n" +
                        "        \"app\":\"" + appid + "\",\n" +
                        "        \"title\":\"" + appname + "\",\n" +
                        "        \"bio\":\"" + appdesc + "\"\n" +
                        "    },";
                String kpisql = "select " +
                        "(select count(*) from test_chart where kpiid like 'yw%') as yewu," +
                        "(select count(*) from test_chart where kpiid like 'lj%') as lianji," +
                        "(select count(*) from test_chart where kpiid like 'pl%') as piliang," +
                        "(select count(*) from test_chart where kpiid like 'xn%') as xingneng," +
                        "(select count(*) from test_chart where kpiid like 'zy%') as ziyuan";
                ResultSet kpirs = DbTools.doQuery(kpisql);

                if(kpirs.next()){
                    appinfo += "\"charts\": {\n" +
                            "        \"line\":[10, 1, 2, 8, 0, 0, 1, 3, 0, 7, 1, 4],\n" +
                            "        \"pie\": [\n" +
                            "            {\"name\": \"批量\", \"value\": "+kpirs.getString("piliang")+"},\n" +
                            "            {\"name\": \"联机\", \"value\": "+kpirs.getString("lianji")+"},\n" +
                            "            {\"name\": \"业务\", \"value\": "+kpirs.getString("yewu")+"},\n" +
                            "            {\"name\": \"性能\", \"value\": "+kpirs.getString("xingneng")+"},\n" +
                            "            {\"name\": \"资源\", \"value\": "+kpirs.getString("ziyuan")+"}\n" +
                            "        ]\n" +
                            "    }\n" +
                            "}";
                }else{
                    appinfo += Params.getParamById("appview");
                    appinfo += "}";
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appinfo;
    }

    /*
    原子图表
     */
    @RequestMapping("/diagrams/{chartid}")
    public String getDiagram(@PathVariable String chartid) {
        String chartdata = "{}";
        try {
            ResultSet rs = DbTools.doQuery("select * from test_chart where chartid='" + chartid + "'");
            if (rs != null && rs.next()) {
                chartdata = rs.getString("chartdata");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chartdata;
    }
}
