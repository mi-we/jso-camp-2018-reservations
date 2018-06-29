package com.zuehlke.jso.resources;

import com.zuehlke.jso.api.Reservation;
import com.zuehlke.jso.db.ReservationRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.function.Supplier;

import static javax.ws.rs.core.Response.Status.CREATED;

@Path("reservation")
@Produces(MediaType.APPLICATION_JSON)
public class ReservationsResource {

    private ReservationRepository reservationRepository = new ReservationRepository();

    @GET
    public Response getReservations() {
        return Response
                .ok(reservationRepository.getAll())
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createReservation(Reservation reservation) {
        Reservation createdReservation = reservationRepository.save(reservation);
        return Response
                .status(CREATED)
                .entity(createdReservation)
                .build();
    }

    @GET
    @Path("{reservationId}")
    public Response getReservation(@PathParam("reservationId") long reservationId) {
        Reservation reservation = reservationRepository.get(reservationId)
                .orElseThrow(notFoundException(reservationId));

        return Response
                .ok(reservation)
                .build();
    }

    @DELETE
    @Path("{reservationId}")
    public Response deleteReservation(@PathParam("reservationId") long reservationId) {
        reservationRepository.delete(reservationId);

        return Response.noContent().build();
    }

    private Supplier<NotFoundException> notFoundException(long reservationId) {
        return () -> new NotFoundException("Reservation with id " + reservationId + " not found");
    }

}
