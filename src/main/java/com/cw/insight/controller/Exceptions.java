package com.cw.insight.controller;

import com.cw.insight.data.Params;
import com.cw.insight.utils.DbTools;
import com.cw.insight.utils.HttpTools;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;

@RestController
public class Exceptions {
    /*
    未处理异常列表
     */
    @RequestMapping("/unhandledexceptions")
    public String getUnhandledExceptions() {
        String exceptions = "";
        try {
            ResultSet rs = DbTools.doQuery("select * from insight_app_exception where is_handled='0' order by des_time desc");
            exceptions = "{\"records\":[";
            while (rs.next()) {
                exceptions += "{\"id\":\"" + rs.getString("exid") + "\"," +
                        "\"title\":\"" + rs.getString("title") + "\"," +
                        "\"app\":\"" + rs.getString("appid") + "\"},";
            }
            if (",".equals(exceptions.substring(exceptions.length() - 1))) {
                exceptions = exceptions.substring(0, exceptions.length() - 1);
            }
            exceptions += "]}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exceptions;
    }

    /*
    历史异常列表
     */
    @RequestMapping("/handledexceptions")
    public String getHandledExceptions(HttpServletRequest request) {
        String page = request.getParameter("page");
        int pageSize = 10;//每次返回10条
        int offset = Integer.parseInt(page) * pageSize;
        String exceptions = "{\"page\":\"" + page + "\",";
        String dateTemp = "";
        try {
            ResultSet rs = DbTools.doQuery("select * from insight_app_exception where is_handled='1' order by des_time desc limit " + offset + ","+pageSize+"");
            exceptions += "\"records\":[";
            while (rs.next()) {
                String datePart = rs.getString("des_time").substring(0, 10);
                if (dateTemp.equals(datePart)) {//相同日期放在同一个节点
                    exceptions += "{\"id\":\"" + rs.getString("exid") + "\"," +
                            "\"time\":\"" + rs.getString("des_time").substring(11, 16) + "\"," +
                            "\"title\":\"" + rs.getString("title") + "\"," +
                            "\"app\":\"" + rs.getString("appid") + "\"},";
                } else {
                    if (!dateTemp.equals("")) {
                        if (",".equals(exceptions.substring(exceptions.length() - 1))) {
                            exceptions = exceptions.substring(0, exceptions.length() - 1);
                        }
                        exceptions += "]},";
                    }
                    exceptions += "{" +
                            "\"date\":\"" + datePart + "\"," +
                            "\"exceptions\":[" +
                            "{\"id\":\"" + rs.getString("exid") + "\"," +
                            "\"time\":\"" + rs.getString("des_time").substring(11, 16) + "\"," +
                            "\"title\":\"" + rs.getString("title") + "\"," +
                            "\"app\":\"" + rs.getString("appid") + "\"" +
                            "},";
                }
                dateTemp = datePart;
            }
            if (",".equals(exceptions.substring(exceptions.length() - 1))) {
                exceptions = exceptions.substring(0, exceptions.length() - 1);
            }
            exceptions += "]}]}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exceptions;
    }

    /*
    异常详细信息
     */
    @RequestMapping("/exceptions/{exid}")
    public String getExceptionById(@PathVariable String exid) {
        String exception = "{}";
        try {
            ResultSet rs = DbTools.doQuery("select * from insight_app_exception where exid='" + exid + "'");
            if (rs.next()) {
                String app = "\"app\":{\"name\":\"" + rs.getString("appid") + "\",\"id\":\"" + rs.getString("appid") + "\"}";
                String description = "\"description\":{\"title\":\"" + rs.getString("title") + "\",\"content\":\"" + rs.getString("description") + "\",\"time\":\"" + rs.getString("des_time") + "\"}";
                String solution_c = rs.getString("solution");
                String solution_t = rs.getString("sol_time");
                String solution = "\"solution\":{\"content\":\"" + rs.getString("solution") + "\",\"time\":\"" + rs.getString("sol_time") + "\"}";
                if ((solution_c == null && solution_t == null) || ("null".equals(solution_c) && "null".equals(solution_t)) || ("".equals(solution_c) && "".equals(solution_t))) {
                    exception = "{" + app + "," + description + "}";
                } else {
                    exception = "{" + app + "," + description + "," + solution + "}";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exception;
    }

    /*
    推送异常
     */
    @RequestMapping("/msg/warning")
    public boolean doWarning(HttpServletRequest request) {
        String appid = request.getParameter("appid");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String time = request.getParameter("time");
        String customid = request.getParameter("customid");
        String sql = "insert into insight_app_exception(exid,appid,title,description,des_time,solution,sol_time,is_handled,customid) " +
                "values(unix_timestamp(now()),'" + appid + "','" + title + "','" + content + "','" + time + "','','','0','" + customid + "')";
        try {
            DbTools.doUpdate(sql);
            String temp_switch = Params.getParamById("temp_switch");//消息推送开关
            if("1".equals(temp_switch)){
                HttpTools ht = new HttpTools();
                ht.cycleTemplate(appid, title, time);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
    结束异常
     */
    @RequestMapping("/msg/finished")
    public boolean doFinished(HttpServletRequest request) {
        String appid = request.getParameter("appid");
        String content = request.getParameter("content");
        String time = request.getParameter("time");
        String customid = request.getParameter("customid");
        String sql = "update insight_app_exception set solution='" + content + "',sol_time='" + time + "',is_handled='1' where appid='" + appid + "' and customid='" + customid + "'";
        try {
            DbTools.doUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
