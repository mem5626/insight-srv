package com.cw.insight.controller;

import com.cw.insight.utils.HttpTools;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class System {
    /*
    获取小程序首页顶部的总览信息。
     */
    @RequestMapping("/system")
    public String getSystem(){
        return "{\n" +
                "    \"data\": {\n" +
                "        \"appNum\":3,\n" +
                "        \"exceptionNum\":5,\n" +
                "        \"point\":88\n" +
                "    }\n" +
                "}";
    }

}
