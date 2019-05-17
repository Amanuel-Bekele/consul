package com.example.demoConsul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AutoRegistration {

    private final ConsulAutoServiceRegistration registration;

    private boolean isRegistered = false;

    @Value("${spring.cloud.consul.enabled}")
    private boolean isConsulEnabled;

    @Autowired
    public AutoRegistration(ConsulAutoServiceRegistration registration) {
        this.registration = registration;
    }

    @PostConstruct
    public void registerServiceInstance(){
        if (isConsulEnabled){
            registration.start();
            isRegistered = true;
        }
    }

    public boolean getRegistered(){
        return isRegistered;
    }
}
