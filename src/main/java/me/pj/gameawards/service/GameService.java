package me.pj.gameawards.service;

import me.pj.gameawards.domain.model.Game;

import java.util.List;

public interface GameService extends CrudService<Game> {

    void vote(long id);
}
