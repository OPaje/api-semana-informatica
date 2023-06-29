package me.pj.gameawards.service.impl;

import me.pj.gameawards.domain.BaseEntity;
import me.pj.gameawards.domain.model.Game;
import me.pj.gameawards.service.CrudService;
import me.pj.gameawards.service.GameService;
import me.pj.gameawards.service.exception.BusinessException;
import me.pj.gameawards.service.exception.NoContentException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class BaseCrudService<E extends BaseEntity, T extends JpaRepository<E, Long>> implements CrudService<E> {

    protected T repository;

    public BaseCrudService(T repository) {
        this.repository = repository;
    }

    @Override
    public List<E> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "votes"));
    }

    @Override
    public E findById(Long id) {
        Optional<E> game = repository.findById(id);

        return game.orElseThrow(() -> new NoContentException());
    }

    @Transactional
    @Override
    public void insertGame(E entity) {
        if(Objects.nonNull(entity.getId())){
            throw new BusinessException("O id é diferente de nulo");
        }

        repository.save(entity);
    }

    @Override
    public void updateGame(Long id, E entity) {
        E entityDb = findById(id);

        if(entityDb.getId().equals(entity.getId())){
            repository.save(entity);
        }
    }

    @Transactional
    @Override
    public void deleteGame(Long id) {
        E entityDb = findById(id);
        repository.delete(entityDb);
    }

}
