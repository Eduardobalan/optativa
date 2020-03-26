package br.com.albus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AlbusApp {
    public static void main(String[] args) { SpringApplication.run(AlbusApp.class, args); } //NOSONAR
}
