package ExceptionHomework.Lesson2.task3;
// Напишите программу, которая запрашивает у пользователя три числа и выполняет следующие проверки:

import java.util.Scanner;

// Если первое число больше 100, выбросить исключение NumberOutOfRangeException с 
// сообщением "Первое число вне допустимого диапазона".
// Если второе число меньше 0, выбросить исключение NumberOutOfRangeException с 
// сообщением "Второе число вне допустимого диапазона".
// Если сумма первого и второго чисел меньше 10, выбросить исключение 
// NumberSumException с сообщением "Сумма первого и второго чисел слишком мала".
// Если третье число равно 0, выбросить исключение DivisionByZeroException с 
// сообщением "Деление на ноль недопустимо".
// В противном случае, программа должна выводить сообщение "Проверка пройдена успешно".
// - необходимо создать 3 класса собвстенных исключений
public class Main {
    public static void main(String[] args) throws NumberOutOfRangeException, NumberSumException, DivisionByZeroException {
        Scanner iscan = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int num1 = iscan.nextInt();
        System.out.print("Введите второе число: ");
        int num2 = iscan.nextInt();
        System.out.print("Введите третье число: ");
        int num3 = iscan.nextInt();
        iscan.close();

        if (num1 > 100) throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
        if (num2 < 0) throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
        if ((num1 + num2) < 10) throw new NumberSumException("Сумма первого и второго чисел слишком мала");
        if (num3 == 0) throw new DivisionByZeroException("Деление на ноль недопустимо");

        System.out.println("Проверка пройдена успешно");
    }
    
}
