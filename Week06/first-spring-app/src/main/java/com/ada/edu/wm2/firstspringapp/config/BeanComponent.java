package com.ada.edu.wm2.firstspringapp.config;

import com.ada.edu.wm2.firstspringapp.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//configuration can also be fine
public class BeanComponent {
    @Primary
    @Bean
//    @Scope("prototype")
    public Person defaultPerson(){

        return new Person(0, "Default", "Person");
    }

    @Bean
    public Person anotherPerson(){
        return new Person(0, "Another", "Person");
    }
}
