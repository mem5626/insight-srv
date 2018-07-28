package com.cw.insight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exceptions {

    @RequestMapping("/unhandledexceptions")
    public String getUnhandledExceptions(){
        return "{\n" +
                "    \"records\": [{\n" +
                "        \"id\":\"fake id\",\n" +
                "        \"name\":\"性能异常\",\n" +
                "        \"source\":\"生酮营养师\"\n" +
                "    }, {\n" +
                "        \"id\":\"fake id\",\n" +
                "        \"name\":\"支付异常\",\n" +
                "        \"source\":\"生酮营养师\"\n" +
                "    }, {\n" +
                "        \"id\":\"fake id\",\n" +
                "        \"name\":\"GPS定位异常\",\n" +
                "        \"source\":\"数字园区导航\"\n" +
                "    }, {\n" +
                "        \"id\":\"fake id\",\n" +
                "        \"name\":\"路线导航异常\",\n" +
                "        \"source\":\"数字园区导航\"\n" +
                "    }]\n" +
                "}";
    }

    @RequestMapping("/handledexceptions")
    public String getHandledExceptions(){
        return "{\n" +
                "    \"page\": 0,\n" +
                "    \"size\": 10,\n" +
                "    \"records\":[\n" +
                "        {\n" +
                "            \"date\":\"2018-07-01\",\n" +
                "            \"exceptions\":[\n" +
                "                {\n" +
                "                    \"time\":\"19:30\",\n" +
                "                    \"name\":\"性能异常\",\n" +
                "                    \"source\":\"生酮营养师\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"time\":\"10:30\",\n" +
                "                    \"name\":\"性能异常\",\n" +
                "                    \"source\":\"数字园区导航\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"time\":\"07:30\",\n" +
                "                    \"name\":\"性能异常\",\n" +
                "                    \"source\":\"生酮营养师\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"date\":\"2017-08-21\",\n" +
                "            \"exceptions\":[\n" +
                "                {\n" +
                "                    \"time\":\"11:30\",\n" +
                "                    \"name\":\"性能异常\",\n" +
                "                    \"source\":\"生酮营养师\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"time\":\"00:30\",\n" +
                "                    \"name\":\"性能异常\",\n" +
                "                    \"source\":\"汕大课程表\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"time\":\"00:29\",\n" +
                "                    \"name\":\"发布异常\",\n" +
                "                    \"source\":\"生酮营养师\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }
}
