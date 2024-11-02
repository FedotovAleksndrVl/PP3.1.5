package org.example;

import org.example.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Communication {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://94.198.50.185:7081/api/users";
    private final HttpHeaders httpHeaders = new HttpHeaders();
    private String result = "";

    public String getHeader () {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String cookieHeader = response.getHeaders().get("Set-Cookie").get(0);
        httpHeaders.set("Cookie", cookieHeader);
        return cookieHeader;
    }

    public String saveUser () {
        User user = new User(3L,"James","Brown", (byte) 25);
        HttpEntity<User> entityUser = new HttpEntity<>(user, httpHeaders);
        String request = restTemplate.postForEntity(url, entityUser, String.class).getBody();
        result += request;
        return request;
    }

    public String editUser () {
        User user = new User(3L,"Thomas","Shelby", (byte) 25);
        HttpEntity<User> entityUser = new HttpEntity<>(user, httpHeaders);
        String request = restTemplate.exchange(url, HttpMethod.PUT, entityUser, String.class).getBody();
        result += request;
        return request;
    }

    public String deleUser () {
        HttpEntity<User> entityUser = new HttpEntity<>(httpHeaders);
        String request = restTemplate.exchange(url+"/"+3, HttpMethod.DELETE, entityUser, String.class).getBody();
        result += request;
        System.out.println("result: " + result);
        return request;
    }
}
