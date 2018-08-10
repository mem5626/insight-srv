package com.cw.insight.controller;

import com.cw.insight.utils.DbTools;
import com.cw.insight.utils.HttpTools;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;

@RestController
public class System {
    /*
    获取小程序首页顶部的总览信息。
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

}
