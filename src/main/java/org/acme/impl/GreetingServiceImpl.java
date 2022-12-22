package org.acme.impl;

import org.acme.GreetingService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greeting(String name) {
        return String.format("Hello %s", name.toUpperCase());
    }
}
