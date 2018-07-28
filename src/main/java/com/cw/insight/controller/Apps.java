package com.cw.insight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Apps {
    @RequestMapping("/apps")
    public String getApps(){
        return "{\n" +
                "    \"records\":[\n" +
                "        {\n" +
                "            \"id\":\"mock id\",\n" +
                "            \"title\":\"数字园区导航\",\n" +
                "            \"url\": \"mock url\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":\"mock id\",\n" +
                "            \"title\":\"生酮营养师\",\n" +
                "            \"url\": \"mock url\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":\"mock id\",\n" +
                "            \"title\":\"考勤打卡应用\",\n" +
                "            \"url\": \"mock url\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":\"mock id\",\n" +
                "            \"title\":\"快眼看书\",\n" +
                "            \"url\": \"mock url\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":\"mock id\",\n" +
                "            \"title\":\"工行云服务\",\n" +
                "            \"url\": \"mock url\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":\"mock id\",\n" +
                "            \"title\":\"无聊的应用\",\n" +
                "            \"url\": \"mock url\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":\"mock id\",\n" +
                "            \"title\":\"不存在的小游戏\",\n" +
                "            \"url\": \"mock url\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    @RequestMapping("/apps/ID/quotas")
    public String getAppQuotas(){
        return "{\n" +
                "    \"batch\":[\n" +
                "        {\n" +
                "            \"name\":\"CPU性能指标\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"应用服务器CPU使用率\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库服务器CPU使用率\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"应用服务器CPU功耗\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"online\":[\n" +
                "\n" +
                "    ],\n" +
                "    \"service\":[\n" +
                "        {\n" +
                "            \"name\":\"CPU性能指标\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"应用服务器CPU使用率\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库服务器CPU使用率\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"应用服务器CPU功耗\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"performance\":[\n" +
                "\n" +
                "    ],\n" +
                "    \"property\":[\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"语句解析性能\",\n" +
                "            \"items\":[\n" +
                "                {\n" +
                "                    \"name\":\"单次耗时过长语句\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\":\"数据库硬解析次数\",\n" +
                "                    \"id\": \"mock id\",\n" +
                "                    \"ifCollected\":true\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    @RequestMapping("/apps/ID")
    public String getAppInfo(){
        return "{\n" +
                "    \"data\": {\n" +
                "        \"title\": \"生酮营养师\",\n" +
                "        \"bio\": \"这是一款专为佛系青年打造的养生App。\"\n" +
                "    }\n" +
                "}";
    }
}
