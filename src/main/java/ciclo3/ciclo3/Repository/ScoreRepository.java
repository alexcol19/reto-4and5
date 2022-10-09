package ciclo3.ciclo3.Repository;

import ciclo3.ciclo3.Repository.CrudRepository.ScoreCrudRepository;
import ciclo3.ciclo3.entities.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getScores(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScoreId(int id){ return scoreCrudRepository.findById(id);}
    public Score saveScore(Score score){ return scoreCrudRepository.save(score); }
    public void deleteScore(Score score){
        scoreCrudRepository.delete(score);
    }
}
