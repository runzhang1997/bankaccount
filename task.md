# Coding Exercise / Bank Account

## Introduction

*FooBar Bank* aims to replace its main banking system which is old and buggy and maintenance costs a fortune each year. 

You have been asked to design and implement the new bank transaction system which takes care of transferring money between two bank accounts.

There's some common wisdom about money when it comes to bank transaction systems - *money should not vanish*, i.e. whenever money is transferred from account A to account B, the *sum* of the two account balances before and after the transaction is exactly the same.

Of course we don't want you to design and implement a production ready transaction system so we'll have to make some assumptions: 

- no persistence / no stable storage is required
- the program never crashes
- the program is the single point of truth
- customers have unlimited credit, i.e. please ignore credit checks
- customers have unique names, i.e. "Arthur Dent" exists at most 1 time
- FooBar Bank’s customers only transfer money among each other, not with customers of other banks

Despite the simplifications, please consider that like in the real world, bank transactions will be *concurrent*! 

## Exercise submission format

Please use the provided ZIP file as a basis for your work. The file contains a basic project structure (which you should extend) and the two Java classes *Account* and *TransactionSystem*. We expect that *TransactionSystem* will contain your program's main method. 

We expect an archive containing the full source code. The project should be compilable immediately.Please use a are minimum of external libraries. Please implement your solution in Java >= 8. Please provide test data if needed for running your program.

We'll conduct a thorough code review on your submission and we will verify its correctness.

## Bonus question / task

*ACID* is a paradigm which was defined by database researchers, however it applies to many domains and different layers of a software stack. Discuss how ACID applies to the banking transaction system and how your system copes with the different challenges of ACID.

## Clean Code Standards

We expect you to make a masterpiece out of your work. Please use the coding exercise not only to show that you can solve the task but also to show that you're a great software engineer.

Please think about what you consider to be good coding standards and how to achieve good software quality.