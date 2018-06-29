package com.zuehlke.jso;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class KickerboxReservationsServiceConfiguration extends Configuration {

    @NotNull
    private String environment;

    @JsonProperty
    public String getEnvironment() {
        return environment;
    }

    public boolean isLocalEnvironment() {
        return "local".equals(environment);
    }
}
