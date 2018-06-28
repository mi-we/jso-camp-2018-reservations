package com.zuehlke.jso.resources;

import com.zuehlke.jso.api.Reservation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Path("reservation")
@Produces(MediaType.APPLICATION_JSON)
public class ReservationsResource {

    @GET
    public Response getReservations() {
        Reservation dummyReservation = new Reservation(1, OffsetDateTime.now(ZoneId.of("Z")), 1, 2, 1);
        return Response
                .ok(dummyReservation)
                .build();
    }
}
