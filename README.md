# KickerboxReservationsService

This app is part of a backend cloud application that has been developed during the JSO team camp in 2018.
It utilizes the Google Cloud Platform and consists of various components.

Setup
---

The KickerboxReservationsService app is using Google Cloud Datastore for storing the reservations. For local development,
one needs to install the Datastore emulator, which can be installed like this:

`gcloud components install cloud-datastore-emulator`

Then you can start the local instance with the following command.

`gcloud beta emulators datastore start --no-store-on-disk`

Usually this will start the emulator at `localhost:8081`, which is the endpoint that is configured when the app runs locally.


How to start the KickerboxReservationsService application
---

1. Run `mvn clean install` to build the application
1. Start application with `java -jar target/kickerbox-reservations-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`


How to deploy the app
---------------------

1. Run `mvn clean install` to build the application
2. Run `gcloud app deploy` and go grab a coffee

