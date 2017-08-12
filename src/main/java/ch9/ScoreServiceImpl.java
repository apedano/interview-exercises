package ch9;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Alex on 12/08/2017.
 */
public class ScoreServiceImpl implements ScoreService {

    public void refreshScores(List<Player> players) {
        players.forEach(p -> p.setScore(p.getScore() + getRandomScore()));
    }

    @Override
    public List<Player> getFirst(List<Player> players, int numPlayers) {
        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                Integer score1 = Integer.valueOf(o1.getScore());
                Integer score2 = Integer.valueOf(o2.getScore());
                return -score1.compareTo(score2);
            }
        });
        return players.subList(0, numPlayers);
    }

    private int getRandomScore(){
        return (int) ((Math.random()*10));
    }
}
