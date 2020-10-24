package com.bearingpoint.codingexercise.bank;

public class Account {

  private final String owner;
  private Money balance = Money.ZERO;

  public Account(String owner) {
    this.owner = owner;
  }

  public String getOwner() {
    return owner;
  }

  public Money getBalance() {
    return balance;
  }

  @Override
  public String toString() {
    return "Account{" +
        "owner='" + owner + '\'' +
        ", balance=" + balance.getValue() +
        '}';
  }

  public void withdraw(Money amount) {
    balance = balance.subtract(amount);
  }

  public void deposit(Money amount) {
    balance = balance.add(amount);
  }
}
