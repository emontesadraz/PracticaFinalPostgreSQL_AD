package org.example.tarea5postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Esta anotación se utiliza para habilitar el cliente Feign
public class Tarea5PostgresApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tarea5PostgresApplication.class, args);
    }

}
