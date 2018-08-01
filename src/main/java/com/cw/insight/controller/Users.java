package com.cw.insight.controller;

import com.cw.insight.utils.DbTools;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Users {
    @RequestMapping("/users/ID/diagrams")
    public String getUserDiagrams(){
        return "{\n" +
                "    \"records\": [{\n" +
                "            \"name\":\"XXXX图表\",\n" +
                "            \"id\":\"mock id\"\n" +
                "        }, {\n" +
                "            \"name\":\"XXXX图表\",\n" +
                "            \"id\":\"mock id\"\n" +
                "        }, {\n" +
                "            \"name\":\"XXXXXXXXXXXXXXXXXX图表\",\n" +
                "            \"id\":\"mock id\"\n" +
                "        }, {\n" +
                "            \"name\":\"X图表\",\n" +
                "            \"id\":\"mock id\"\n" +
                "        }, {\n" +
                "            \"name\":\"XXXX图表\",\n" +
                "            \"id\":\"mock id\"\n" +
                "        }, {\n" +
                "            \"name\":\"XXXXXXXXXXXXXX图表\",\n" +
                "            \"id\":\"mock id\"\n" +
                "        }, {\n" +
                "            \"name\":\"XXXXXXXXXXXXXX图表\",\n" +
                "            \"id\":\"mock id\"\n" +
                "        }]\n" +
                "}";

    }

//    @RequestMapping("/users/ID")
//    public String patchUserFormId(){
//        return "{\n" +
//                "    \"msg\": \"发送成功！\"\n" +
//                "}";
//    }
    @RequestMapping(path="/users/{openid}")
    public String patchUserFormId(@PathVariable String openid, HttpServletRequest request){
        String formid = request.getParameter("formid");
        int count = DbTools.doUpdate("insert into insight_medium(openid,formid,new_time,is_used) values('"+openid+"','"+formid+"',date_format(now(),'%Y-%m-%d %H:%i:%S'),0)");
        if(count == 1){
            return "{\n" +"    \"msg\": \"发送成功！\"\n" + "}";
        }else{
            return "{\n" +"    \"msg\": \"发送失败！\"\n" + "}";
        }

    }

    @RequestMapping("/users/ID/diagrams/ID")
    public String toggleUserDiagram(){
        return "{\n" +
                "    \"diagramId\": \"mock id\",\n" +
                "    \"userId\": \"mock id\",\n" +
                "    \"ifCollected\": true\n" +
                "}";
    }
}
