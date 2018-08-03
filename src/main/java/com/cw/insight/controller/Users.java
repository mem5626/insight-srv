package com.cw.insight.controller;

import com.cw.insight.utils.DbTools;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;

@RestController
public class Users {
    /*
    获取用户的收藏信息列表。
     */
    @RequestMapping(path = "/users/{openid}/diagrams")
    public String getUserDiagrams(@PathVariable String openid) {
        String diagrams = "{}";
        try{
            ResultSet rs = DbTools.doQuery("select * from test_chart");
            String chartid = "";
            String chartdata = "";
            diagrams = "{\"records\":[";
            while(rs.next()){
                chartid =  rs.getString("chartid");
                chartdata =  rs.getString("chartdata");
                diagrams += "{\"name\":\""+chartid+"\",\"id\":\""+chartdata+"\"},";
            }
            diagrams += "]}";
        }catch (Exception e){
            e.printStackTrace();
            diagrams = "{}";
        }
        return diagrams;
//        return "{\n" +
//                "    \"records\": [{\n" +
//                "            \"name\":\"代理业务成功率统计\",\n" +
//                "            \"id\":\"mock id\"\n" +
//                "        }, {\n" +
//                "            \"name\":\"资产业务增长情况\",\n" +
//                "            \"id\":\"mock id\"\n" +
//                "        }, {\n" +
//                "            \"name\":\"交易并发量监控\",\n" +
//                "            \"id\":\"mock id\"\n" +
//                "        }, {\n" +
//                "            \"name\":\"日终批量运行情况\",\n" +
//                "            \"id\":\"mock id\"\n" +
//                "        }, {\n" +
//                "            \"name\":\"跨境汇款金额统计\",\n" +
//                "            \"id\":\"mock id\"\n" +
//                "        }]\n" +
//                "}";
    }

    /*
    向后端发送formid。
     */
    @RequestMapping(path = "/users/{openid}")
    public String patchUserFormId(@PathVariable String openid, HttpServletRequest request) {
        String formid = request.getParameter("formid");
        int count = DbTools.doUpdate("insert into insight_medium(openid,formid,new_time,is_used) values('" + openid + "','" + formid + "',date_format(now(),'%Y-%m-%d %H:%i:%S'),0)");
        if (count == 1) {
            return "{\n" + "    \"msg\": \"发送成功！\"\n" + "}";
        } else {
            return "{\n" + "    \"msg\": \"发送失败！\"\n" + "}";
        }
    }

    /*
    修改指定用户的图表收藏状态。
     */
    @RequestMapping("/users/{openid}/diagrams/{chartid}")
    public String toggleUserDiagram(@PathVariable String openid, @PathVariable String chartid, HttpServletRequest request) {
        try{
            ResultSet rs = DbTools.doQuery("select * from insight_collection where openid='" + openid + "' and chartid='" + chartid + "'");
            if(rs != null && rs.next()){
                //做删除操作？
            }else{
                //做新增操作？
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "{\n" +
                "    \"diagramId\": \"mock id\",\n" +
                "    \"userId\": \"mock id\",\n" +
                "    \"ifCollected\": true\n" +
                "}";
    }
}
