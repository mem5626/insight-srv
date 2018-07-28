package com.cw.insight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class System {
    @RequestMapping("/system")
    public String getSystem(){
        return "{\n" +
                "    \"data\": {\n" +
                "        \"appNum\":5,\n" +
                "        \"exceptionNum\":11,\n" +
                "        \"point\":88\n" +
                "    }\n" +
                "}";

    }
}
