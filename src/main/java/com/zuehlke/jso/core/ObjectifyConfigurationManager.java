package com.zuehlke.jso.core;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.zuehlke.jso.KickerboxReservationsServiceConfiguration;
import com.zuehlke.jso.db.ReservationEntity;
import io.dropwizard.lifecycle.Managed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectifyConfigurationManager implements Managed {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectifyConfigurationManager.class);

    private KickerboxReservationsServiceConfiguration configuration;

    public ObjectifyConfigurationManager(KickerboxReservationsServiceConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void start() throws Exception {
        if (configuration.isLocalEnvironment()) {
            LOGGER.info("Using local configuration for connecting to Cloud Datastore");
            ObjectifyService.init(localConfiguration());
        } else {
            ObjectifyService.init();
        }

        ObjectifyService.register(ReservationEntity.class);
    }

    @Override
    public void stop() throws Exception {

    }

    private ObjectifyFactory localConfiguration() {
        Datastore datastore = DatastoreOptions.getDefaultInstance().toBuilder().setHost("localhost:8081").build().getService();
        return new ObjectifyFactory(datastore);
    }

}
