package com.javag.agendador_horarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AgendadorHorariosApplication {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        SpringApplication.run(AgendadorHorariosApplication.class, args);
    }


}
