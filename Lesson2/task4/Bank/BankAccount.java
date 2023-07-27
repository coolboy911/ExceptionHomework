package ExceptionHomework.Lesson2.task4.Bank;

import ExceptionHomework.Lesson2.task4.Exceptions.InsufficientFundsException;
import ExceptionHomework.Lesson2.task4.Exceptions.MaxBalanceExceededException;

public class BankAccount {
    private double balance;
    private long accountID;
    private double maxBalance;

    public BankAccount(long accountID, double maxBalance) {
        this.accountID = accountID;
        this.maxBalance = maxBalance;
        this.balance = 0;
    }

    public long getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxBalance() {
        return maxBalance;
    }
    
    @Override
    public String toString() {
        return "BankAccount [balance=" + balance + ", accountID=" + accountID + ", maxBalance=" + maxBalance + "]";
    }

    /**
     * положить денег на счет
     * @param amount - сколько денег положить
     */
    public void deposit(double amount) {
        try {
            System.out.println("ID:" + getAccountID() + " пополнение на:" + amount);

            if (amount < 0) throw new IllegalArgumentException(
                    "[ERROR] Отрицательное значение недопустимо!");
            if (this.balance + amount > this.maxBalance) throw new MaxBalanceExceededException(
                    "[ERROR] Превышение баланса");

            this.balance += amount;  // положили денег на счет
            System.out.println("ID:" + getAccountID() + " текущий баланс: " + getBalance());

        } catch (IllegalArgumentException | MaxBalanceExceededException e) {
            System.out.println(e.getMessage());
            System.out.println("Операция была прервана");
        }
    }

    /**
     * снять со счета
     * @param amount - сколько денег снять
     */
    public void withdraw(double amount) {
        try {
            System.out.println("ID:" + getAccountID() + " Снятие средств на:" + amount);

            if (amount < 0) throw new IllegalArgumentException(
                    "[ERROR] Отрицательное значение недопустимо!");
            if (this.balance < amount) throw new InsufficientFundsException(
                    "[ERROR] Нельзя снять больше чем есть на счету!");

            this.balance -= amount;  // сняли денег
            System.out.println("ID:" + getAccountID() + " текущий баланс: " + getBalance());

        } catch (IllegalArgumentException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Операция была прервана");
        }
    }
}
