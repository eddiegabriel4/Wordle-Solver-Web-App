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

    public void removeGray(String letter) {
        this.gray = this.gray.replace(letter, "");
    }

    public void filter() {
        for (int i = 0 ; i < this.get_yellow().length(); i++) {
            if (this.get_gray().contains(Character.toString(this.get_yellow().charAt(i)))) {
                this.removeGray(Character.toString(this.get_yellow().charAt(i)));
            }
        }

        for (int i = 0 ; i < this.get_green().length(); i++) {
            if (this.get_gray().contains(Character.toString(this.get_green().charAt(i)))) {
                this.removeGray(Character.toString(this.get_green().charAt(i)));
            }
        }
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

