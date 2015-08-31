package com.mongodb.spark;

import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.*;

/**
 * Created by HARI on 6/7/2015.
 */
public class SparkStyle {
    public static void main(String[] args) {
        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {

                return "Hello world Spark";
            }
        });
    }
}
