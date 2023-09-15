package org.rebel.UserManagementSystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanBags {

    @Bean
    public List<Users> allUsers(){
        return new ArrayList<>();
    }
}
