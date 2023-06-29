package me.pj.gameawards.domain.model;

import jakarta.persistence.*;
import me.pj.gameawards.domain.BaseEntity;

@Entity(name = "games")
public class Game extends BaseEntity {

    @Column(nullable = false, unique = true, length = 130)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    private String cover;
    private long votes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }
}
