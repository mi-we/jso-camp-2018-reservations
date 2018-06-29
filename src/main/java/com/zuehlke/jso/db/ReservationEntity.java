package com.zuehlke.jso.db;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity(name = "Reservation")
public class ReservationEntity {

    @Id
    private Long id;
    private String dateOfReservation;
    private long visitorTeamId;
    private long homeTeamId;
    private long kickerBoxId;

    public ReservationEntity() {
    }

    public ReservationEntity(Long id, String dateOfReservation, long visitorTeamId, long homeTeamId, long kickerBoxId) {
        this.id = id;
        this.dateOfReservation = dateOfReservation;
        this.visitorTeamId = visitorTeamId;
        this.homeTeamId = homeTeamId;
        this.kickerBoxId = kickerBoxId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(String dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public long getVisitorTeamId() {
        return visitorTeamId;
    }

    public void setVisitorTeamId(long visitorTeamId) {
        this.visitorTeamId = visitorTeamId;
    }

    public long getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public long getKickerBoxId() {
        return kickerBoxId;
    }

    public void setKickerBoxId(long kickerBoxId) {
        this.kickerBoxId = kickerBoxId;
    }
}
