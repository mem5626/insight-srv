package com.cw.insight.controller;

import org.springframework.web.bind.annotation.PathVariable;
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
                "        \"id\":\"e0001\",\n" +
                "        \"title\":\"代理业务对账异常\",\n" +
                "        \"app\":\"GCMC\"\n" +
                "    }, {\n" +
                "        \"id\":\"e0002\",\n" +
                "        \"title\":\"日终批量中断\",\n" +
                "        \"app\":\"CAPS\"\n" +
                "    }, {\n" +
                "        \"id\":\"e0003\",\n" +
                "        \"title\":\"指令处理成功率异常\",\n" +
                "        \"app\":\"CAPS\"\n" +
                "    }, {\n" +
                "        \"id\":\"e0004\",\n" +
                "        \"title\":\"收款重复处理报错\",\n" +
                "        \"app\":\"GCMC\"\n" +
                "    }, {\n" +
                "        \"id\":\"e0005\",\n" +
                "        \"title\":\"他行支付调用失败\",\n" +
                "        \"app\":\"MBPS\"\n" +
                "    }]\n" +
                "}";
    }

    /*
    获取未处理的异常详细。
     */
    @RequestMapping("/exception/{exid}")
    public String getExceptionById(@PathVariable String exid){
        return "{\n" +
                "    \"app\":{\n" +
                "        \"name\":\"CAPS\",\n" +
                "        \"id\":\"CAPS\"\n" +
                "    },\n" +
                "    \"description\":{\n" +
                "        \"title\":\"出大事啦\",\n" +
                "        \"content\":\"我也不知道怎么回事支付就出现异常了，昨天还好好的，(┬＿┬)\",\n" +
                "        \"time\":\"2017-10-12 18:01\"\n" +
                "    },\n" +
                "    \"solution\":{\n" +
                "        \"content\":\"我也不知道怎么回事支付就出现异常了，昨天还好好的，(┬＿┬)\",\n" +
                "        \"time\":\"2017-10-12 18:01\"\n" +
                "    }\n" +
                "}";
    }

    /*
    获取已处理的异常信息列表。
     */
    @RequestMapping("/handledexceptions")
    public String getHandledExceptions(){
        return "{\n" +
                "    \"page\": 0,\n" +
                "    \"records\":[\n" +
                "        {\n" +
                "            \"date\":\"2018-07-01\",\n" +
                "            \"exceptions\":[\n" +
                "                {\n" +
                "                    \"time\":\"19:02\",\n" +
                "                    \"title\":\"代理业务对账异常\",\n" +
                "                    \"app\":\"GCMC\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"time\":\"19:02\",\n" +
                "                    \"title\":\"代理业务对账异常\",\n" +
                "                    \"app\":\"GCMC\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"time\":\"19:02\",\n" +
                "                    \"title\":\"代理业务对账异常\",\n" +
                "                    \"app\":\"GCMC\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"date\":\"2017-08-21\",\n" +
                "            \"exceptions\":[\n" +
                "                {\n" +
                "                    \"time\":\"19:02\",\n" +
                "                    \"title\":\"代理业务对账异常\",\n" +
                "                    \"app\":\"GCMC\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"time\":\"19:02\",\n" +
                "                    \"title\":\"代理业务对账异常\",\n" +
                "                    \"app\":\"GCMC\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"time\":\"19:02\",\n" +
                "                    \"title\":\"代理业务对账异常\",\n" +
                "                    \"app\":\"GCMC\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }
}
