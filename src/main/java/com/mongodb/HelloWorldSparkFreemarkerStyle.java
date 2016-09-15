package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;

/**
 * Created by tslepkan on 9/11/16
 */
public class HelloWorldSparkFreemarkerStyle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");
        StringWriter writer = new StringWriter();
        Map<String, Object> helloMap = new HashMap<>();
        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            helloMap.put("name", "Freemarket");
            helloTemplate.process(helloMap, writer);
        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
        }
        Spark.get("/", (req, res) -> writer);

        Spark.get("/test", (req, res) -> "This is a test page");
    }
}
