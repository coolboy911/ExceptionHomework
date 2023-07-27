package ExceptionHomework.Lesson2.task1;

import java.util.Scanner;

// Напишите программу, которая запрашивает у пользователя число и проверяет, 
// является ли оно положительным. Если число отрицательное или равно нулю, 
// программа должна выбрасывать исключение InvalidNumberException с сообщением 
// "Некорректное число". В противном случае, программа должна выводить 
// сообщение "Число корректно".
public class Main {
    public static void main(String[] args) {
        Scanner iscan = new Scanner(System.in);
        System.out.print("Введите число: ");
        double num = iscan.nextDouble();
        iscan.close();

        try {
            if (num <= 0) throw new InvalidNumberException("Некорректное число");
            // если ошибки не было, появится это сообщение
            System.out.println("Число корректно");
        } catch (Exception e) {
            // если ошибка была, появится сообщение ошибки
            System.out.println(e.getMessage());
        }
    }
}
