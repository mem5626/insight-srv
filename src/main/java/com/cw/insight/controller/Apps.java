package com.cw.insight.controller;

import com.cw.insight.utils.HttpTools;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/loginstate")
    public String getLoginState(HttpServletRequest request){
        String appid = "wx1044da5d38d4d77d";
        String secret = "69c5ee2b5b8bb56aba2aff32e8935bfe";
        String js_code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="
                +appid+"&secret="+secret+"&js_code="+js_code+"&grant_type=authorization_code";
        String jsonStr = HttpTools.httpRequest(url,"POST",null);

        String openid = "";
        try {
            JSONObject jsonObject = (JSONObject) JSONValue.parseStrict(jsonStr);
            openid = jsonObject.get("openid").toString();
        } catch (ParseException e) {
            //e.printStackTrace();
            openid = "";
        }
        return openid;
    }
}
