package me.pj.gameawards.controller.games;

import me.pj.gameawards.controller.BaseRestController;
import me.pj.gameawards.domain.model.Game;
import me.pj.gameawards.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class GameRestController extends BaseRestController {

    @Autowired
    private GameService businnesLayer;

    @GetMapping("games")
    public ResponseEntity<List<Game>> findAll(){
        return ResponseEntity.ok(businnesLayer.findAll());
    }

    @GetMapping("games/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id){
        return ResponseEntity.ok(businnesLayer.findById(id));
    }

    @PostMapping("games")
    public ResponseEntity<Game> insertGame(@RequestBody Game game){  // criar um dto para não passar a entidade direto
        businnesLayer.insertGame(game);
        return ResponseEntity.ok(game);  // usar o created
    }

    @PutMapping("games/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game game){
        businnesLayer.updateGame(id, game);
        return ResponseEntity.ok(game);
    }

    @DeleteMapping("games/{id}")
    public ResponseEntity<Game> deleteGame(@PathVariable Long id){
        businnesLayer.deleteGame(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("games/{id}/vote")
    public ResponseEntity<Game> updateVote(@PathVariable long id){
        businnesLayer.vote(id);
        return ResponseEntity.ok().build();
    }
}
