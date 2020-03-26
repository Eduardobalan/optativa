package br.com.albus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("br.com.albus")
@EntityScan(basePackages = {"br.com.albus"})
public class AlbusAppTest {//NOSONAR
    public static void main(String[] args) {
        SpringApplication.run(AlbusAppTest.class, args);//NOSONAR
    }
}