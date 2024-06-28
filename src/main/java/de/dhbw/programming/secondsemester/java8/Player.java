package de.dhbw.programming.secondsemester.java8;

import java.util.Objects;

public class Player {
    private int number;
    private String name;
    private String position;
    private String birthday;
    private String club;
    private int games;
    private int goals;

    public Player(int number, String name, String position, String birthday, String club, int games, int goals) {
        this.number = number;
        this.name = name;
        this.position = position;
        this.birthday = birthday;
        this.club = club;
        this.games = games;
        this.goals = goals;
    }

    // <editor-fold desc="Getter, Setter, toString, equals, hashCode">

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return number == player.number && games == player.games && goals == player.goals && Objects.equals(name, player.name) && Objects.equals(position, player.position) && Objects.equals(birthday, player.birthday) && Objects.equals(club, player.club);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, position, birthday, club, games, goals);
    }

    @Override
    public String toString() {
        return "Player{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", birthday='" + birthday + '\'' +
                ", club='" + club + '\'' +
                ", games=" + games +
                ", goals=" + goals +
                '}';
    }

    // </editor-fold>
}
