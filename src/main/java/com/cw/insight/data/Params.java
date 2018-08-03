package com.cw.insight.data;

import com.cw.insight.utils.DbTools;

import java.sql.ResultSet;

public class Params {
    public static String getParamById(String paramid) {
        String paramVal = "";
        try {
            ResultSet rs = DbTools.doQuery("select * from insight_params where paramid = '" + paramid + "'");
            if (rs != null && rs.next()) {
                paramVal = rs.getString("param");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paramVal;
    }
}
