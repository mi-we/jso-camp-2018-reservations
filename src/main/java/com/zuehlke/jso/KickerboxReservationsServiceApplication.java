package com.zuehlke.jso;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyFilter;
import com.googlecode.objectify.ObjectifyService;
import com.zuehlke.jso.db.ReservationEntity;
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

    }

    @Override
    public void run(final KickerboxReservationsServiceConfiguration configuration,
                    final Environment environment) {
        ObjectifyService.init(createFactory());
        ObjectifyService.register(ReservationEntity.class);
        environment.servlets()
                .addFilter("ObjectifyFilter", ObjectifyFilter.class)
                .addMappingForUrlPatterns(null, true, "/api/v1/*");
        environment.getObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        environment.jersey().setUrlPattern("/api/v1");
        environment.jersey().register(new ReservationsResource());
    }

    private ObjectifyFactory createFactory() {
        Datastore datastore = DatastoreOptions.getDefaultInstance().toBuilder().setHost("localhost:8081").build().getService();
        return new ObjectifyFactory(datastore);
    }

}
