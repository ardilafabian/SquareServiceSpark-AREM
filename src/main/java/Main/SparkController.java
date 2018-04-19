package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import spark.Request;
import spark.Response;
import spark.Spark;
import static spark.Spark.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fabian Ardila
 */
public class SparkController {
    
    public static void main (String[] args) {
        Spark.staticFiles.location("/public");
        get("/square", (Request req, Response res) -> {
            return getResponse(Integer.parseInt(req.queryParams("num")));
        });
    } 
    
    public static String getResponse (int numero) throws MalformedURLException, IOException {
        String URL_API_GATEWAY = "https://czq3zklhub.execute-api.us-west-2.amazonaws.com/prod/square?num=" + String.valueOf(numero);
        URL num = new URL(URL_API_GATEWAY);
        String response = "";
        try (BufferedReader reader 
                = new BufferedReader(new InputStreamReader(num.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                response+= inputLine;
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return response;
    }
}
