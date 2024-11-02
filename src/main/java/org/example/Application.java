package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
public class Application {
    private static final Communication communication = new Communication();

    public static void main(String[] args) {
        System.out.println("get: " + communication.getHeader());
        System.out.println("post: " + communication.saveUser());
        System.out.println("put: " + communication.editUser());
        System.out.println("delete: " + communication.deleUser());
    }
}
