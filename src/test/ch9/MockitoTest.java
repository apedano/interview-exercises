package ch9;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;

/**
 * Created by Alex on 12/08/2017.
 */
public class MockitoTest {

    private List<Player> playerList;

    @Before
    public void setUp(){
        playerList = new ArrayList<Player>(10);
        playerList.add(new Player("Michael Jordan"));
        playerList.add(new Player("LeBron James"));
        playerList.add(new Player("Kobe Bryant"));
        playerList.add(new Player("Magic Johnson"));
        playerList.add(new Player("Larry Bird"));
        playerList.add(new Player("Bill Russell"));
        playerList.add(new Player("Wilt Chamberlain"));
        playerList.add(new Player("Julius Erving"));
        playerList.add(new Player("Kareem Abdul-Jabbar"));
        playerList.add(new Player("Hakeem Olajuwon"));
    }

    @Test
    public void gameExecutionTestNoMock(){
        Game game = new Game(new ScoreServiceImpl(), playerList, 5);
        game.play(10);
    }

    @Test
    public void gameExecutionTestMock(){
        ScoreService scoreServiceMock = Mockito.mock(ScoreService.class);

        List<Player> player1R = new ArrayList<Player>(2);
        Player player1 = new Player("Michael Jordan");
        player1.setScore(3);
        player1R.add(player1);
        Player player2 = new Player("Kobe Bryant");
        player2.setScore(2);
        player1R.add(player2);

        List<Player> player2R = new ArrayList<Player>(2);
        player1 = new Player("Michael Jordan");
        player1.setScore(7);
        player2R.add(player1);
        player2 = new Player("Kobe Bryant");
        player2.setScore(5);
        player2R.add(player2);

        Mockito.when(scoreServiceMock.getFirst(Matchers.any(List.class), Matchers.anyInt()))
                .thenReturn(player1R)
                .thenReturn(player2R);
        Game game = new Game(scoreServiceMock, new ArrayList<Player>(), 2);
        game.play(2);
        Mockito.verify(scoreServiceMock, Mockito.times(2)).getFirst(Matchers.any(List.class), Matchers.anyInt());
    }
}
