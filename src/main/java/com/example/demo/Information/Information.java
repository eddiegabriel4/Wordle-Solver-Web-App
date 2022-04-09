package com.example.demo.Information;

import java.util.Locale;

public class Information {

    private String yellow;
    private String green;
    private String gray;

    public Information(String yellow, String green, String gray) {
        this.yellow = yellow;
        this.green = green;
        this.gray = gray;
    }

    public void uppercase() {
        this.yellow = this.yellow.toUpperCase(Locale.ROOT);
        this.green = this.green.toUpperCase(Locale.ROOT);
        this.gray = this.gray.toUpperCase(Locale.ROOT);
    }

    public String get_yellow() {
        return this.yellow;
    }

    public String get_green() {
        return this.green;
    }

    public String get_gray() {
        return this.gray;
    }


    @Override
    public String toString() {
        return "Information{" +
                "yellow='" + yellow + '\'' +
                ", green='" + green + '\'' +
                ", gray='" + gray + '\'' +
                '}';
    }
}

