package com.springboot_basic.SpringbootApplication.JPA;

import jakarta.persistence.*;

import java.util.Date;

@Entity
// @Table(name = "JPA_Player") - We do need this (This is required if table name is different than Bean Name)
@NamedQuery(
        name = "getAllPlayers",
        query="select p from Player p"
)
public  class Player {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    // @Column(name="nationality") We do need this (This is required if column name is different than field Name)
    private String nationality;

    private Date birthDate;
    private int titles;
    public Player(){

    }

    public Player(String name, String nationality, Date birthDate, int titles){
        super();
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;

    }

    public Player(int id, String name, String nationality, Date birthDate, int titles) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;

    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate=" + birthDate +
                ", titles=" + titles +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }

}
