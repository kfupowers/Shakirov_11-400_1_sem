package ru.kpfu.itis.shakirov.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class MainHelloServlet {
    public static void main(String[] args) throws JsonProcessingException {
        HttpClientExample httpClientExample = new HttpClientExample();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        Map<String, String> data = new HashMap<>();
        data.put("name", "Ivan Ivanov");
        data.put("gender", "male");
        data.put("email", "ivan@gmail.com");
        data.put("status", "active");

        String str = httpClientExample.post("http://localhost:8080/hello", headers, data);
        System.out.println(str);
        System.out.println(httpClientExample.get("http://localhost:8080/hello", headers, null));

        Map<String, String> data1 = new HashMap<>();
        data1.put("name", "Dmitriy Ivanov");
        data1.put("gender", "male");
        data1.put("email", "dima@gmail.com");
        data1.put("status", "active");

        System.out.println(httpClientExample.put("http://localhost:8080/hello", headers, data1));
        System.out.println(httpClientExample.get("http://localhost:8080/hello", headers, null));
        System.out.println(httpClientExample.delete("http://localhost:8080/hello", headers, data1));
    }
}