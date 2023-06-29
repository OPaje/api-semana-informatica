package me.pj.gameawards.service;

import java.util.List;

public interface CrudService <E>{

    List<E>findAll();

    E findById(Long id);

    void insertGame(E entity);

    void updateGame(Long id, E entity);

    void deleteGame(Long id);
}
