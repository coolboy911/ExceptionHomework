package ExceptionHomework.Lesson2.task4;

import ExceptionHomework.Lesson2.task4.Bank.Bank;

// Создание многопоточной программы для обработки банковских транзакций с использованием 
// пользовательских классов исключений.
// __
// Описание задачи:
// Вы разрабатываете многопоточную программу для обработки банковских транзакций. 
// Вам необходимо реализовать класс "BankAccount", который представляет счет в банке 
// и содержит баланс пользователя. Класс "BankAccount" должен поддерживать две операции: 
// пополнение счета и снятие денег. Однако, у каждого счета есть ограничение по 
// максимальному балансу, и попытка пополнения или снятия средств, превышающих это 
// ограничение, должна вызывать соответствующее исключение.
// __
// Вам также необходимо реализовать класс "Bank" для управления счетами и 
// обработки транзакций. Класс "Bank" должен содержать методы для создания 
// новых счетов, пополнения и снятия денег с счетов.
// __
// Для обработки ошибок исключений, вы должны создать два пользовательских класса исключений:
// __
// "InsufficientFundsException" - выбрасывается при попытке снятия средств, превышающих 
// доступный баланс на счете.
// "MaxBalanceExceededException" - выбрасывается при попытке пополнения счета, превышающего 
// максимальное допустимое значение баланса.
// Класс "Bank" должен использовать многопоточность, чтобы обрабатывать транзакции с 
// разных счетов параллельно.
public class Main {
    public static void main(String[] args) {
        Bank bank1 = new Bank();
        bank1.createAccount(0, 0);
        bank1.createAccount(1, 5000);
        bank1.createAccount(0, 5000); // Такой номер счета уже существует
        bank1.deposit(0, 5000);
        bank1.deposit(0, 5001);  // [ERROR] Превышение баланса
        bank1.withdraw(0, 5001);  // [ERROR] Нельзя снять больше чем есть на счету!
        bank1.withdraw(0, -5);  // [ERROR] Отрицательное значение недопустимо!
        System.out.println(bank1);
    }
}
