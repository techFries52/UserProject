package com.fries.userproject.utility;

import org.springframework.core.env.Environment;

public final class EnvironmentAccess {

    private final Environment env;

    private EnvironmentAccess (Environment environment) {
        this.env = environment;
    }

    public static String getApiVersion(Environment env) {
        return env.getProperty("API_VERSION");
    }
}
