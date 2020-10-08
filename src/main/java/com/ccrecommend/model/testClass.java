package com.ccrecommend.model;

import java.util.List;
import java.util.Map;

public class testClass {
    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        List<Map<String, String>> serviceList = dao.readServices();
        System.out.println("done");
    }
}
