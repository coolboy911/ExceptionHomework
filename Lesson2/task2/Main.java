package ExceptionHomework.Lesson2.task2;
// Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление. 
// Если второе число равно нулю, программа должна выбрасывать исключение 
// DivisionByZeroException с сообщением "Деление на ноль недопустимо". 
// В противном случае, программа должна выводить результат деления.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws DivisionByZeroException {
        Scanner iscan = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double num1 = iscan.nextDouble();
        System.out.print("Введите второе число: ");
        double num2 = iscan.nextDouble();
        iscan.close();

        System.out.println(divide(num1, num2));
    }
    public static double divide(double num1, double num2) throws DivisionByZeroException{
        if (num2 == 0) throw new DivisionByZeroException("Деление на ноль недопустимо");
        return num1/num2;
    }
}
