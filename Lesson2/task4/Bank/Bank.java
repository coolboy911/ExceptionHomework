package ExceptionHomework.Lesson2.task4.Bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Bank {
    private Map<Long, BankAccount> accounts = new HashMap<>();

    // операции банка
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("bank [accounts =\n");
        for (Entry<Long, BankAccount> entry : accounts.entrySet()) {
            sb.append("    ").append(entry.getValue()).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Создает новый банк аккаунт и добовляет его в банк
     * @param accountID
     * @param maxBalance
     */
    public void createAccount(long accountID, double maxBalance){
        if (accounts.containsKey(accountID)) System.out.println("Такой номер счета уже существует");
        else {
            accounts.put(accountID, new BankAccount(accountID, maxBalance));
        }
    }
    
    // операции клиентов
    public void deposit(long accountID, int amount){
        accounts.get(accountID).deposit(amount);
    }
    public void withdraw(long accountID, int amount){
        accounts.get(accountID).withdraw(amount);
    }
    public void getBalance(long accountID, int amount) {
        accounts.get(accountID).getBalance();
    }
    public void getMaxBalance(long accountID, int amount) {
        accounts.get(accountID).getMaxBalance();
    }
    
    
}
