package com.cw.insight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exceptions {

    /*
    获取未处理的异常信息列表。
     */
    @RequestMapping("/unhandledexceptions")
    public String getUnhandledExceptions(){
        return "{\n" +
                "    \"records\": [{\n" +
                "        \"app\":\"GCMC\",\n" +
                "        \"title\":\"代理业务对账异常\",\n" +
                "        \"description\":\"代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账。\",\n" +
                "        \"occur_time\":\"2018-04-09\"\n" +
                "    }, {\n" +
                "        \"app\":\"CAPS\",\n" +
                "        \"title\":\"日终批量中断\",\n" +
                "        \"description\":\"日终批量中断日终批量中断日终批量中断日终批量中断。\",\n" +
                "        \"occur_time\":\"2018-04-09\"\n" +
                "    }, {\n" +
                "        \"app\":\"CAPS\",\n" +
                "        \"title\":\"指令处理成功率异常\",\n" +
                "        \"description\":\"指令处理成功率异常指令处理成功率异常指令处理成功率异常。\",\n" +
                "        \"occur_time\":\"2018-04-09\"\n" +
                "    }, {\n" +
                "        \"app\":\"GCMC\",\n" +
                "        \"title\":\"收款重复处理报错\",\n" +
                "        \"description\":\"收款重复处理报错收款重复处理报错收款重复处理报错收款重复处理报错。\",\n" +
                "        \"occur_time\":\"2018-04-10\"\n" +
                "    }, {\n" +
                "        \"app\":\"MBPS\",\n" +
                "        \"title\":\"他行支付调用失败\",\n" +
                "        \"description\":\"他行支付调用失败他行支付。\",\n" +
                "        \"occur_time\":\"2018-04-10\"\n" +
                "    }]\n" +
                "}";
//        return "{\n" +
//                "    \"records\": [{\n" +
//                "        \"id\":\"fake id\",\n" +
//                "        \"name\":\"性能异常\",\n" +
//                "        \"source\":\"生酮营养师\"\n" +
//                "    }, {\n" +
//                "        \"id\":\"fake id\",\n" +
//                "        \"name\":\"支付异常\",\n" +
//                "        \"source\":\"生酮营养师\"\n" +
//                "    }, {\n" +
//                "        \"id\":\"fake id\",\n" +
//                "        \"name\":\"GPS定位异常\",\n" +
//                "        \"source\":\"数字园区导航\"\n" +
//                "    }, {\n" +
//                "        \"id\":\"fake id\",\n" +
//                "        \"name\":\"路线导航异常\",\n" +
//                "        \"source\":\"数字园区导航\"\n" +
//                "    }]\n" +
//                "}";
    }

    /*
    获取已处理的异常信息列表。
     */
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
                "                    \"app\":\"GCMC\",\n" +
                "                    \"title\":\"代理业务对账异常\",\n" +
                "                    \"description\":\"代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账。\",\n" +
                "                    \"occur_time\":\"2018-04-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"app\":\"GCMC\",\n" +
                "                    \"title\":\"代理业务对账异常\",\n" +
                "                    \"description\":\"代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账。\",\n" +
                "                    \"occur_time\":\"2018-04-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"app\":\"GCMC\",\n" +
                "                    \"title\":\"代理业务对账异常\",\n" +
                "                    \"description\":\"代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账。\",\n" +
                "                    \"occur_time\":\"2018-04-09\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"date\":\"2017-08-21\",\n" +
                "            \"exceptions\":[\n" +
                "                {\n" +
                "                    \"app\":\"GCMC\",\n" +
                "                    \"title\":\"代理业务对账异常\",\n" +
                "                    \"description\":\"代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账。\",\n" +
                "                    \"occur_time\":\"2018-04-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"app\":\"GCMC\",\n" +
                "                    \"title\":\"代理业务对账异常\",\n" +
                "                    \"description\":\"代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账。\",\n" +
                "                    \"occur_time\":\"2018-04-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"app\":\"GCMC\",\n" +
                "                    \"title\":\"代理业务对账异常\",\n" +
                "                    \"description\":\"代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账异常代理业务对账。\",\n" +
                "                    \"occur_time\":\"2018-04-09\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
//        return "{\n" +
//                "    \"page\": 0,\n" +
//                "    \"size\": 10,\n" +
//                "    \"records\":[\n" +
//                "        {\n" +
//                "            \"date\":\"2018-07-01\",\n" +
//                "            \"exceptions\":[\n" +
//                "                {\n" +
//                "                    \"time\":\"19:30\",\n" +
//                "                    \"name\":\"性能异常\",\n" +
//                "                    \"source\":\"生酮营养师\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"time\":\"10:30\",\n" +
//                "                    \"name\":\"性能异常\",\n" +
//                "                    \"source\":\"数字园区导航\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"time\":\"07:30\",\n" +
//                "                    \"name\":\"性能异常\",\n" +
//                "                    \"source\":\"生酮营养师\"\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"date\":\"2017-08-21\",\n" +
//                "            \"exceptions\":[\n" +
//                "                {\n" +
//                "                    \"time\":\"11:30\",\n" +
//                "                    \"name\":\"性能异常\",\n" +
//                "                    \"source\":\"生酮营养师\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"time\":\"00:30\",\n" +
//                "                    \"name\":\"性能异常\",\n" +
//                "                    \"source\":\"汕大课程表\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"time\":\"00:29\",\n" +
//                "                    \"name\":\"发布异常\",\n" +
//                "                    \"source\":\"生酮营养师\"\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
    }
}
