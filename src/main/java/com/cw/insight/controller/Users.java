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
        try {
            ResultSet rs = DbTools.doQuery("select chartid,(select t.title from test_chart t where t.chartid=c.chartid) as title from insight_collection c where openid='" + openid + "'");
            String chartid = "";
            String title = "";
            diagrams = "{\"records\":[";
            while (rs.next()) {
                chartid = rs.getString("chartid");
                title = rs.getString("title");
                diagrams += "{\"name\":\"" + title + "\",\"id\":\"" + chartid + "\"},";
            }
            if (",".equals(diagrams.substring(diagrams.length() - 1))) {
                diagrams = diagrams.substring(0,diagrams.length()-1);
            }
            diagrams += "]}";
        } catch (Exception e) {
            e.printStackTrace();
            diagrams = "{}";
        }
        return diagrams;
    }

    /*
    修改指定用户的图表收藏状态。
     */
    @RequestMapping("/users/{openid}/diagrams/{chartid}")
    public String toggleUserDiagram(@PathVariable String openid, @PathVariable String chartid, HttpServletRequest request) {
        String operflag = request.getParameter("operflag");
        try {
            ResultSet rs = DbTools.doQuery("select * from insight_collection where openid='" + openid + "' and chartid='" + chartid + "'");
            if (rs != null && rs.next()) {
                if("true".equals(operflag)){//收藏操作，但已经收藏过了
                    return "{\n" +
                            "    \"ifCollected\":true\n" +
                            "}";
                }
                //删除
                DbTools.doUpdate("delete from insight_collection where openid='" + openid + "' and chartid='" + chartid + "'");
            } else {
                if("false".equals(operflag)){//取消收藏操作，但原先就没有收藏过。
                    return "{\n" +
                            "    \"ifCollected\":false\n" +
                            "}";
                }
                //新增
                DbTools.doUpdate("insert into insight_collection(openid,chartid) values('" + openid + "','" + chartid + "')");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "{\n" +
                "    \"ifCollected\":true\n" +
                "}";
    }

    /*
    向后端发送formid。
     */
    @RequestMapping(path = "/users/{openid}")
    public String patchUserFormId(@PathVariable String openid, HttpServletRequest request) {
        String formid = request.getParameter("formid");
        if ("the formId is a mock one".equals(formid)) {
            return "{\n" + "    \"msg\": \"发送成功！\"\n" + "}";
        }
        int count = DbTools.doUpdate("insert into insight_medium(openid,formid,new_time,is_used) values('" + openid + "','" + formid + "',date_format(now(),'%Y-%m-%d %H:%i:%S'),0)");
        if (count == 1) {
            return "{\n" + "    \"msg\": \"发送成功！\"\n" + "}";
        } else {
            return "{\n" + "    \"msg\": \"发送失败！\"\n" + "}";
        }
    }
}
