package com.bearingpoint.codingexercise.bank;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionSystem {

  private List<Account> accounts;

  public TransactionSystem(List<Account> accounts) {
    this.accounts = accounts;
  }

  public static void main(String[] args) {
    // In our tests, we'll create TransactionSystem
    // with different accounts.
    Account a1 = new Account("Bob");
    Account a2 = new Account("Joe");
    List<Account> accounts = Arrays.asList(a1, a2);
    a1.deposit(new Money(3000));
    // before transfer
    System.out.println(a1.toString());
    System.out.println(a2.toString());
    TransactionSystem transactionSystem = new TransactionSystem(accounts);
    transactionSystem.transferMoney("Bob", "Joe", new Money(1000));
    // after transfer
    System.out.println(a1.toString());
    System.out.println(a2.toString());
  }

  /**
   * Transfers money from sender to receiver. Amount is strictly positive.
   */
  public int accountExists(String owner) {
    for (int i = 0; i < accounts.size(); i++){
      if (accounts.get(i).getOwner()==owner){
        // return the index of the account if exists
        return i;
      }
    }
    // return -1 if not exists
    return -1;
  } 

  public void transferMoney(String sender, String receiver, Money amount) {
    
    if (sender == "" || receiver == ""|| sender == receiver){
      System.out.println("Invalid sender or receiver account!");
      return;
    }

    int senderID = accountExists(sender);
    int receiverID = accountExists(receiver);

    if (senderID == -1) {
      System.out.println("Account " + sender + " doesn't exist!");
      return;
    }
    if (receiverID == -1){
      System.out.println("Account " + receiver + " doesn't exist!");
      return;
    }
    
    Lock lock = new ReentrantLock(); 
    lock.lock();
    // put the balance operation in a critical section

    if (amount.getValue() < 0){
      System.out.println("To transfer "+ amount.getValue() + "is illegal!");
      return;
    }

    if (accounts.get(senderID).getBalance().getValue() < amount.getValue()){
      System.out.println("Insufficient account balance "+ accounts.get(senderID).getBalance().getValue());
      return;
    }
    
    accounts.get(senderID).withdraw(amount);
    accounts.get(receiverID).deposit(amount);
    System.out.println("Transfering " + amount.getValue() +" from "+ sender+ " to " + receiver + " is successful!");
    
    lock.unlock();
  }
}
