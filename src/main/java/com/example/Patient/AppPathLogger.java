package com.example.Patient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppPathLogger {
	public AppPathLogger(@Value("${server.servlet.context-path}") String path) {
        System.out.println("Context Path is: " + path);
    }

}
