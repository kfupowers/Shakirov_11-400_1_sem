package ru.kpfu.itis.shakirov.http;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpClientExample implements HttpClient{

    @Override
    public String get(String url, Map<String, String> headers, Map<String, String> params) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            for(Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);
            String str = readResponse(connection);
            System.out.println(connection.getResponseCode());
            connection.disconnect();
            return str;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String post(String url, Map<String, String> headers, Map<String, String> data) {
        try {
            HttpURLConnection postConnection = (HttpURLConnection) new URL(url).openConnection();
            postConnection.setRequestMethod("POST");
            for(Map.Entry<String, String> header : headers.entrySet()) {
                postConnection.setRequestProperty(header.getKey(), header.getValue());
            }
            postConnection.setConnectTimeout(1000);
            postConnection.setReadTimeout(1100);
            postConnection.setDoOutput(true);
            String jsonInput = new ObjectMapper().writeValueAsString(data);
            try (OutputStream outputStream = postConnection.getOutputStream()) {
                byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }
            System.out.println(postConnection.getResponseCode());
            String str = readResponse(postConnection);
            postConnection.disconnect();
            return str;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String put(String url, Map<String, String> headers, Map<String, String> data) {
        try {
            HttpURLConnection putConnection = (HttpURLConnection) new URL(url).openConnection();
            putConnection.setRequestMethod("PUT");
            for(Map.Entry<String, String> header : headers.entrySet()) {
                putConnection.setRequestProperty(header.getKey(), header.getValue());
            }
            putConnection.setConnectTimeout(1000);
            putConnection.setReadTimeout(1000);
            putConnection.setDoOutput(true);
            String jsonInput = new ObjectMapper().writeValueAsString(data);
            try (OutputStream outputStream = putConnection.getOutputStream()) {
                byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }
            System.out.println(putConnection.getResponseCode());
            String str = readResponse(putConnection);
            putConnection.disconnect();
            return str;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String delete(String url, Map<String, String> headers, Map<String, String> data) {
        try {
            HttpURLConnection deleteConnection = (HttpURLConnection) new URL(url).openConnection();
            deleteConnection.setRequestMethod("DELETE");
            for(Map.Entry<String, String> header : headers.entrySet()) {
                deleteConnection.setRequestProperty(header.getKey(), header.getValue());
            }
            deleteConnection.setConnectTimeout(1000);
            deleteConnection.setReadTimeout(1000);
            deleteConnection.setDoOutput(true);
            String jsonInput = new ObjectMapper().writeValueAsString(data);
            try (OutputStream outputStream = deleteConnection.getOutputStream()) {
                byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }
            System.out.println(deleteConnection.getResponseCode());
            String str = readResponse(deleteConnection);
            deleteConnection.disconnect();
            return str;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readResponse(HttpURLConnection connection) {
        if (connection == null) {
            return null;
        } else {
            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder content = new StringBuilder();
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                return content.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}