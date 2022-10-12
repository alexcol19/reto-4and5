package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.ScoreRepository;
import ciclo3.ciclo3.entities.Message;
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

    public Score update(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> e = scoreRepository.getScoreId(score.getIdScore());//ojo//
            if (!e.isEmpty()) {
                if (score.getMessageText() != null) {
                    e.get().setMessageText(score.getMessageText());
                }
                if (score.getScore() != null) {
                    e.get().setScore(score.getScore());
                }
                scoreRepository.saveScore(e.get());//ojo//
                return e.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }

    public boolean deleteScore(int id) {
        Boolean d = getScoreId(id).map(score -> {
            scoreRepository.deleteScore(score);
            return true;
        }).orElse(false);
        return d;
    }
}
