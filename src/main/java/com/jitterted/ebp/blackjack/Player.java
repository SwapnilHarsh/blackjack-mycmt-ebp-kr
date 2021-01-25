package com.jitterted.ebp.blackjack;

public class Player {
    int balance;
    int bet;
    int totalBet;
    public Player(){
        this.balance = 0;
        this.bet = 0;
        this.totalBet = 0;
    }
    public void playerDeposits(int amount) {
        this.balance += amount;
    }

    public void playerBets(int betAmount) {
        this.bet = betAmount;
        this.balance -= betAmount;
        this.totalBet += betAmount;

    }

    public int playerBalance() {
        return this.balance;
    }

    public void playerWins() {
        this.balance += this.bet * 2;
    }

    public void playerLoses() {
        this.balance += this.bet * 0;
    }

    public void playerTies() {
        this.balance += this.bet * 1;
    }

    public int totalAmountBets() {
        return this.totalBet;
    }


}
