package ru.kpfu.itis.shakirov;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        HttpClientExample httpClientExample = new HttpClientExample();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("Authorization", "Bearer 85f758a2395b44406fac60e22dcd5755e31222567ae3d7c91025d137173a1933");
        Map<String, String> data = new HashMap<>();
        data.put("name", "Ivan Ivanov");
        data.put("gender", "male");
        data.put("email", "ivan@gmail.com");
        data.put("status", "active");

        String str = httpClientExample.post("https://gorest.co.in/public/v2/users", headers, data);
        User user = new ObjectMapper().readValue(str, User.class);
        System.out.println(str);
        System.out.println(httpClientExample.get("https://gorest.co.in/public/v2/users/" + user.getId(), headers, null));

        Map<String, String> data1 = new HashMap<>();
        data1.put("name", "Dmitriy Ivanov");
        data1.put("gender", "male");
        data1.put("email", "dima@gmail.com");
        data1.put("status", "active");

        System.out.println(httpClientExample.put("https://gorest.co.in/public/v2/users/" + user.getId(), headers, data1));
        System.out.println(httpClientExample.get("https://gorest.co.in/public/v2/users/" + user.getId(), headers, null));
        System.out.println(httpClientExample.delete("https://gorest.co.in/public/v2/users/" + user.getId(), headers, null));
    }
}
