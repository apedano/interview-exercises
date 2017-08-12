package ch9;

import java.util.List;

/**
 * Created by Alex on 12/08/2017.
 */
public class Game {

    private ScoreService scoreService;
    private List<Player> players;
    private int roundCounter = 0;
    private final int firstPlayers;

    public Game(ScoreService scoreService, List<Player> starters, int firstPlayers){
        this.scoreService = scoreService;
        this.players = starters;
        this.firstPlayers = firstPlayers;
    }

    private String playRound(){
        StringBuilder scoreBuilder = new StringBuilder("Round ").append(++roundCounter).append(" played.\n");
        scoreBuilder.append("Standings:\n");
        scoreService.refreshScores(players);
        int position = 0;
        for(Player player : scoreService.getFirst(players, firstPlayers)){
            scoreBuilder.append(++position)
                    .append("^: ")
                    .append(player.getName())
                    .append(" score:")
                    .append(player.getScore())
                    .append("\n");
        }
        return scoreBuilder.toString();
    }

    public void play(int numRounds){
        for(int i = 1; i<=numRounds;i++){
            System.out.println(playRound());
        }
    }

}
