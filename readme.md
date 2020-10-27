# bankaccount java exercise

## environment
- IntelliJ IDEA 
- Junit 5
- Gradle

## realization
- The money transfer function is included in `TransactionSystem.java`.
- Two test cases are included in `TransactionSystemTest.java`.

## ACID property

- Atomicity

    Atomicity property guarantee that either all the actions in a transaction happen, or none happen.

    Because there is no operations inbetween the `withdraw` and `deposit` in the transfer function, if a thread goes into the critical section, it will execute every line of code inside the critical section, it is impossible to jump out of the critical section. So atomicity is satisfied. 

- Consistency

    Consistency guarantee that database moves from one consistent state at the beginning of the transaction to another other consistent state at the end of the transaction.

    Because we will go through some checking before we change the account information, we can make sure that we move from a legal state to another legal state. For example, we will check if the sender and receiver exists in our bank system and we will check if there is enough balance before we transfer some money to another account.

- Isolation

    Isolation property gives an illusion that one transaction has full control over the database and it is the only transaction running at the moment even though multiple transactions are running concurrently.

    Because we put the `read` and `write` operation in a critical section `synchronized`, only one thread can access this critical section, so the isolation property is satisfies in the bank transfer system.

- Durability

    This property guarantees that once a transaction completes successfully, all the changes made by the transaction persist even in the case of a system failure after the transaction completes execution. 

    Assuming the bank transfer system never crashes, the account information in the memory will live all the time, All the changes to those account info also persist forever. 
