package com.zuehlke.jso;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zuehlke.jso.resources.ReservationsResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class KickerboxReservationsServiceApplication extends Application<KickerboxReservationsServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new KickerboxReservationsServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "KickerboxReservationsService";
    }

    @Override
    public void initialize(final Bootstrap<KickerboxReservationsServiceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final KickerboxReservationsServiceConfiguration configuration,
                    final Environment environment) {
        environment.getObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        environment.jersey().register(new ReservationsResource());
    }

}
