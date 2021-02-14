package com.tictactoe.tictactoe.entity;

import java.util.Objects;

import com.tictactoe.tictactoe.enums.Marker;

public class Player {
    private String name;
    private Marker marker;
    private int score;

    public Player() {
    }

    public Player(String name, Marker marker) {
        this.marker = marker;
        this.score = 0;
        this.name = name;
    }

    public Marker getMarker() {
        return this.marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player marker(Marker marker) {
        setMarker(marker);
        return this;
    }

    public Player score(int score) {
        setScore(score);
        return this;
    }

    public Player name(String name) {
        setName(name);
        return this;
    }

    public void scorePoint() {
        this.score = this.score + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Player)) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(marker, player.marker) && score == player.score && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marker, score, name);
    }
 

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", marker='" + getMarker() + "'" +
            ", score='" + getScore() + "'" +
            "}";
    }

}
