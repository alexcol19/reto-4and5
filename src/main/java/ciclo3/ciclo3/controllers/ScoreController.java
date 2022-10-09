package ciclo3.ciclo3.controllers;

import ciclo3.ciclo3.entities.Reservations;
import ciclo3.ciclo3.entities.Score;
import ciclo3.ciclo3.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll() { return scoreService.getScores();
    }
    @GetMapping("/{id}")
    public Optional<Score> getReservationsId(@PathVariable("id") int id){
        return scoreService.getScoreId(id);
    }
    @PostMapping("/save")
    public Score saveScore(@RequestBody Score score) { return scoreService.saveScore(score);
    }
}

