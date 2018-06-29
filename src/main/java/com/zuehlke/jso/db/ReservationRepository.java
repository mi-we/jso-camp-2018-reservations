package com.zuehlke.jso.db;

import com.googlecode.objectify.Key;
import com.zuehlke.jso.api.Reservation;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class ReservationRepository {

    public List<Reservation> getAll() {
        return ofy().load()
                .type(ReservationEntity.class)
                .list()
                .stream()
                .map(this::toReservation)
                .collect(Collectors.toList());
    }

    public Optional<Reservation> get(long id) {
        ReservationEntity reservationEntity = ofy().load()
                .key(Key.create(ReservationEntity.class, id))
                .now();

        return Optional.ofNullable(reservationEntity).map(this::toReservation);
    }

    public Reservation save(Reservation reservation) {
        Key<ReservationEntity> key = ofy()
                .save()
                .entity(toEntity(reservation))
                .now();
        ReservationEntity createdEntity = ofy()
                .load()
                .key(key)
                .now();
        return toReservation(createdEntity);
    }

    public void delete(long id) {
        ofy()
                .delete()
                .key(Key.create(ReservationEntity.class, id))
                .now();
    }

    private Reservation toReservation(ReservationEntity entity) {
        return new Reservation(
                entity.getId(),
                OffsetDateTime.parse(entity.getDateOfReservation(), DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                entity.getVisitorTeamId(),
                entity.getHomeTeamId(),
                entity.getKickerBoxId());
    }

    private ReservationEntity toEntity(Reservation reservation) {
        return new ReservationEntity(
                reservation.getId() == 0 ? null : reservation.getId(),
                reservation.getDateOfReservation().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                reservation.getVisitorTeamId(),
                reservation.getHomeTeamId(),
                reservation.getKickerBoxId()
        );
    }

}
