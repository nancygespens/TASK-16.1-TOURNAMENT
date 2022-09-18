import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

  @Test
  public void testAddPlayer() {
    Player player1 = new Player(1, "Vasya", 100);
    Player player2 = new Player(2, "Kolya", 50);
    Player player3 = new Player(3, "Kostya", 75);
    Player player4 = new Player(4, "Olya", 50);
    Player player5 = new Player(5, "Vanya", 75);
    Player player6 = new Player(6, "Nastya", 25);

    Game game = new Game();

    game.register(player1);
    game.register(player2);
    game.register(player3);
    game.register(player4);
    game.register(player5);
    game.register(player6);

    List<Player> actual = game.getAllPlayers();
    List<Player> expected = new ArrayList<>();

    expected.add(player1);
    expected.add(player2);
    expected.add(player3);
    expected.add(player4);
    expected.add(player5);
    expected.add(player6);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void testThrowExceptionForPlayer2() {
    Player player1 = new Player(1, "Vasya", 100);
    Player player2 = new Player(2, "Kolya", 50);
    Player player3 = new Player(3, "Kostya", 75);
    Player player4 = new Player(4, "Olya", 50);
    Player player5 = new Player(5, "Vanya", 75);
    Player player6 = new Player(6, "Nastya", 25);

    Game game = new Game();

    game.register(player1);


    Assertions.assertThrows(NotRegisteredException.class, () -> {
      game.round("Vasya", "Olya");
    });
  }

  @Test
  public void testThrowExceptionForPlayer1() {
    Player player1 = new Player(1, "Vasya", 100);
    Player player2 = new Player(2, "Kolya", 50);
    Player player3 = new Player(3, "Kostya", 75);
    Player player4 = new Player(4, "Olya", 50);
    Player player5 = new Player(5, "Vanya", 75);
    Player player6 = new Player(6, "Nastya", 25);

    Game game = new Game();

    game.register(player4);

    Assertions.assertThrows(NotRegisteredException.class, () -> {
      game.round("Vasya", "Olya");
    });
  }

  @Test
  public void testGameRoundWinPlayer1() {
    Player player1 = new Player(1, "Vasya", 100);
    Player player2 = new Player(2, "Kolya", 50);
    Player player3 = new Player(3, "Kostya", 75);
    Player player4 = new Player(4, "Olya", 50);
    Player player5 = new Player(5, "Vanya", 75);
    Player player6 = new Player(6, "Nastya", 25);

    Game game = new Game();

    game.register(player1);
    game.register(player2);
    game.register(player3);
    game.register(player4);
    game.register(player5);
    game.register(player6);

    int expected = 1;

    Assertions.assertEquals(expected, game.round("Vasya", "Olya"));
  }

  @Test
  public void testGamesRoundWithDrawResult() {
    Player player1 = new Player(1, "Vasya", 100);
    Player player2 = new Player(2, "Kolya", 50);
    Player player3 = new Player(3, "Kostya", 75);
    Player player4 = new Player(4, "Olya", 50);
    Player player5 = new Player(5, "Vanya", 75);
    Player player6 = new Player(6, "Nastya", 25);

    Game game = new Game();

    game.register(player1);
    game.register(player2);
    game.register(player3);
    game.register(player4);
    game.register(player5);
    game.register(player6);

    int expected = 0;

    Assertions.assertEquals(expected, game.round("Kolya", "Olya"));
  }

  @Test
  public void testGameRoundWinPlayer2() {
    Player player1 = new Player(1, "Vasya", 100);
    Player player2 = new Player(2, "Kolya", 50);
    Player player3 = new Player(3, "Kostya", 75);
    Player player4 = new Player(4, "Olya", 50);
    Player player5 = new Player(5, "Vanya", 75);
    Player player6 = new Player(6, "Nastya", 25);

    Game game = new Game();

    game.register(player1);
    game.register(player2);
    game.register(player3);
    game.register(player4);
    game.register(player5);
    game.register(player6);

    int expected = 2;

    Assertions.assertEquals(expected, game.round("Olya", "Vasya"));
  }
}
