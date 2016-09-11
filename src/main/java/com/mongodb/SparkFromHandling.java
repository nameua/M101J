package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Spark;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tslepkan on 9/12/16
 */
public class SparkFromHandling {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");
        StringWriter writer = new StringWriter();
        try {
            Template fruitTemplate = configuration.getTemplate("fruitPicker.ftl");
            Map<String, Object> fruitsMap = new HashMap<String, Object>();
            fruitsMap.put("fruits", Arrays.asList("apple","banana","orange","peach"));
            fruitTemplate.process(fruitsMap, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Spark.get("/test", (req, res) -> "This is a test page");
        Spark.post("/", (req, res) -> writer);
    }
}
