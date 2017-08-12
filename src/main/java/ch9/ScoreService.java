package ch9;

import java.util.List;

/**
 * Created by Alex on 12/08/2017.
 */
public interface ScoreService {

    public void refreshScores(List<Player> players);

    public List<Player> getFirst(List<Player> players, int numPlayers);
}
