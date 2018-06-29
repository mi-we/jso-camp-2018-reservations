package com.zuehlke.jso.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public class Reservation {

    private final long id;

    private final OffsetDateTime dateOfReservation;

    private final long visitorTeamId;
    private final long homeTeamId;
    private final long kickerBoxId;

    @JsonCreator
    public Reservation(
            @JsonProperty("id") long id,
            @JsonProperty("dateOfReservation") OffsetDateTime dateOfReservation,
            @JsonProperty("visitorTeamId") long visitorTeamId,
            @JsonProperty("homeTeamId") long homeTeamId,
            @JsonProperty("kickerBoxId") long kickerBoxId) {
        this.id = id;
        this.dateOfReservation = dateOfReservation;
        this.visitorTeamId = visitorTeamId;
        this.homeTeamId = homeTeamId;
        this.kickerBoxId = kickerBoxId;
    }

    public long getId() {
        return id;
    }

    public OffsetDateTime getDateOfReservation() {
        return dateOfReservation;
    }

    public long getVisitorTeamId() {
        return visitorTeamId;
    }

    public long getHomeTeamId() {
        return homeTeamId;
    }

    public long getKickerBoxId() {
        return kickerBoxId;
    }
}
