package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameBettingOutcomeTest {

  // Player Ties = get Bet back
  // Player BJ = Bet + Bet + 50% Bet

  @Test
  public void playerWith20Bets10WhenWinsBalanceIs30() throws Exception {
    Game game = createGameWithPlayerBalanceOf(20);
    game.getPlayer().playerBets(10);

    game.getPlayer().playerWins();

    assertThat(game.getPlayer().playerBalance())
        .isEqualTo(30);
  }

  @Test
  public void playerWith80Bets70WhenTiesBalanceIs80() throws Exception {
    Game game = createGameWithPlayerBalanceOf(80);
    game.getPlayer().playerBets(70);

    game.getPlayer().playerTies();

    assertThat(game.getPlayer().playerBalance())
        .isEqualTo(80);
  }

  @Test
  public void playerWith35Bets30WhenLosesBalanceIs5() throws Exception {
    Game game = createGameWithPlayerBalanceOf(35);

    game.getPlayer().playerBets(30);
    game.getPlayer().playerLoses();

    assertThat(game.getPlayer().playerBalance())
        .isEqualTo(5);
  }

  @Test
  public void playerWith40Bets15BalanceIs25() throws Exception {
    Game game = createGameWithPlayerBalanceOf(40);

    game.getPlayer().playerBets(15);

    assertThat(game.getPlayer().playerBalance())
        .isEqualTo(25);
  }

  @Test
  public void playerDeposits18DollarsBalanceIs18Dollars() throws Exception {
    Game game = createGameWithPlayerBalanceOf(18);

    assertThat(game.getPlayer().playerBalance())
        .isEqualTo(18);
  }

  @Test
  public void totalAmountBetsWhenPlayerBets0() throws Exception{
    Game game = createGameWithPlayerBalanceOf(10);
    game.getPlayer().playerBets(0);
    assertThat(game.getPlayer().totalAmountBets())
            .isEqualTo(0);
  }

  @Test
  public void totalAmountBetsWhenPlayerBets10() throws Exception{
    Game game = createGameWithPlayerBalanceOf(20);
    game.getPlayer().playerBets(10);
    assertThat(game.getPlayer().totalAmountBets())
            .isEqualTo(10);
  }

  @Test
  public void totalAmountBetsWhenPlayerBets10amd15() throws Exception{
    Game game = createGameWithPlayerBalanceOf(50);
    game.getPlayer().playerBets(10);
    game.getPlayer().playerBets(15);
    assertThat(game.getPlayer().totalAmountBets())
            .isEqualTo(25);
  }

  @Test
  public void totalAmountBetsGetsBonus10WhenPlayerBets100() throws Exception{
    Game game = createGameWithPlayerBalanceOf(200);
    game.getPlayer().playerBets(100);
    assertThat(game.getPlayer().totalAmountBets())
            .isEqualTo(110);
  }
  @Test
  public void totalAmountBetsGetsNoBonus10WhenPlayerBets99() throws Exception{
    Game game = createGameWithPlayerBalanceOf(200);
    game.getPlayer().playerBets(99);
    assertThat(game.getPlayer().totalAmountBets())
            .isEqualTo(99);
  }

  @Test
  public void totalAmountBetsGetsBonus10WhenPlayerBets100And200() throws Exception{
    Game game = createGameWithPlayerBalanceOf(500);
    game.getPlayer().playerBets(100);
    game.getPlayer().playerBets(200);
    assertThat(game.getPlayer().totalAmountBets())
            .isEqualTo(320);
  }

  private Game createGameWithPlayerBalanceOf(int amount) {
    Game game = new Game();
    game.getPlayer().playerDeposits(amount);
    return game;
  }



//  private Player createPlayerWithBalance(int amount){
//    Player player = new Player();
//    player.playerDeposits(amount);
//    return player;
//  }
}