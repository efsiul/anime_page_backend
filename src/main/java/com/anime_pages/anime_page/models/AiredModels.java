package com.anime_pages.anime_page.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class AiredModels {

    @Column(name = "from_date")
    private LocalDate from;

    @Column(name = "to_date")
    private LocalDate to_date;

    @Column(name = "string")
    private String string;

    public AiredModels() {
    }

    public AiredModels(LocalDate from, LocalDate to_date, String string) {
        this.from = from;
        this.to_date = to_date;
        this.string = string;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo_date() {
        return to_date;
    }

    public void setTo_date(LocalDate to_date) {
        this.to_date = to_date;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    

}
