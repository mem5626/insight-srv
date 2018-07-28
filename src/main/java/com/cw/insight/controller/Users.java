package com.cw.insight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/users/ID")
    public String patchUserFormId(){
        return "{\n" +
                "    \"msg\": \"发送成功！\"\n" +
                "}";
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
