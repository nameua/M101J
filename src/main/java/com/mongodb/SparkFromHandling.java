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
            Map<String, Object> fruitsMap = new HashMap<>();
            fruitsMap.put("fruits", Arrays.asList("apple", "banana", "orange", "peach"));
            fruitsMap.put("fruit", "apple");
            fruitTemplate.process(fruitsMap, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Spark.get("/", (req, res) -> writer);
        Spark.get("/test", (req, res) -> "This is a test page");

        Spark.post("/favorite_fruit", (req, res) -> {
            final String fruit = req.queryParams("fruit");
            if (fruit == null){
                return "Why do not you pick on?";
            } else {
                return "You favorite fruit is " + fruit;
            }
        });
    }
}
