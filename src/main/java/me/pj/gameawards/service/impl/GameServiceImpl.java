package me.pj.gameawards.service.impl;

import me.pj.gameawards.domain.model.Game;
import me.pj.gameawards.domain.model.GameRepository;
import me.pj.gameawards.service.GameService;
import me.pj.gameawards.service.exception.BusinessException;
import me.pj.gameawards.service.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GameServiceImpl extends BaseCrudService<Game, GameRepository> implements GameService {

    @Autowired
    public GameServiceImpl(GameRepository repository) {
        super(repository);
    }

    @Override
    public List<Game> findAll() {
        return super.repository.findAll(Sort.by(Sort.Direction.DESC, "votes"));
    }

    @Override
    public void vote(long id) {
        Game gameDb = findById(id);
        gameDb.setVotes(gameDb.getVotes() + 1);

        updateGame(id, gameDb);
    }
}
