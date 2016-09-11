package com.mongodb;

import spark.Spark;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Spark.get("/", (req, res) -> "Hello World from Spark");
    }

}
