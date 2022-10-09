package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.ScoreRepository;
import ciclo3.ciclo3.entities.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getScores(){ return scoreRepository.getScores(); }
    public Optional<Score> getScoreId(int id){
       return scoreRepository.getScoreId(id);
    }
    public Score saveScore(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.saveScore(score);
        }else{
            Optional<Score> paux= scoreRepository.getScoreId(score.getIdScore());
            if(paux.isEmpty()){
                return scoreRepository.saveScore(score);
            }else
                return score;
        }
    }
}
