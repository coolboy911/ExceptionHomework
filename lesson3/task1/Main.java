package ExceptionHomework.lesson3.task1;

// Напишите программу-калькулятор, которая запрашивает у пользователя два числа и 
// выполняет все операции операции(+, -, '', /) и возведения первого числа в степень 
// второго числа. Если введены некорректные числа или происходит деление на ноль, 
// необходимо обработать соответствующие исключения и вывести информативное сообщение об ошибке.
// Важно! С использованием принципа одного уровня абстракции!
// *В этой задаче мы создаем класс PowerCalculator, который содержит метод 
// calculatePower(), выполняющий операцию возведения числа в степень. Если введено 
// некорректное основание (ноль) и отрицательная степень, выбрасывается исключение InvalidInputException.
public class Main {
    public static void main(String[] args) {
        // в этой цепочке try-catch представлены почти все собственные ошибки

        try { // сложение [sum results in Double MAX_VALUE overflow]
            System.out.println(PowerCalculator.add(Double.MAX_VALUE, Double.MAX_VALUE));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try { // вычитание [subtract results in Double MAX_VALUE overflow]
            System.out.println(PowerCalculator.subtract(-Double.MAX_VALUE, Double.MAX_VALUE));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try { // умножение [multiplying results in Double MAX_VALUE overflow]
            System.out.println(PowerCalculator.multiply(Double.MAX_VALUE, 2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try { // умножение [multiplying results in Double MIN_VALUE overflow]
            System.out.println(PowerCalculator.multiply(Double.MIN_VALUE, 0.001));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try { // деление [division by 0 not allowed]
            System.out.println(PowerCalculator.divide(10, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try { // деление [division results in Double MAX_VALUE overflow]
            System.out.println(PowerCalculator.divide(Double.MAX_VALUE, 0.01));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try { // деление [dividing results in Double MIN_VALUE overflow]
            System.out.println(PowerCalculator.divide(Double.MIN_VALUE, 2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try { // возведение в степень [0 ^ 0 not allowed]
            System.out.println(PowerCalculator.calculatePower(0, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try { // возведение в степень [power results in Double MAX_VALUE overflow]
            System.out.println(PowerCalculator.calculatePower(100000, 100000));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try { // возведение в степень [power results in Double MIN_VALUE overflow]
            System.out.println(PowerCalculator.calculatePower(0.00001, 100000));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class PowerCalculator {
    static double add(double a, double b) {
        double result = a + b;
        // если результат превышает MAX_VALUE то он станет infinity
        if (Double.isInfinite(result))
            throw new InvalideInputException("sum results in Double MAX_VALUE overflow");
        return result;
    }

    static double subtract(double a, double b) {
        double result = a - b;
        // то же самое условие применимо и для вычитания
        if (Double.isInfinite(result))
            throw new InvalideInputException("subtract results in Double MAX_VALUE overflow");
        return a - b;
    }

    static double multiply(double a, double b) {
        double result = a * b;
        if (Double.isInfinite(result))
            throw new InvalideInputException("multiplying results in Double MAX_VALUE overflow");
        // если число не ноль, но в результате умножения стало нулем,
        // то произошла перегрузка наименьшего положительного числа double
        if ((a != 0.0 || b != 0.0) && (Math.abs(result) < Double.MIN_VALUE))
            throw new InvalideInputException("multiplying results in Double MIN_VALUE overflow");
        return result;
    }

    static double divide(double a, double b) {
        if (b == 0)
            throw new InvalideInputException(
                    "division by 0 not allowed");
        double result = a / b;
        if (Double.isInfinite(result))
            throw new InvalideInputException("division results in Double MAX_VALUE overflow");
        if (a != 0.0 && Math.abs(result) < Double.MIN_VALUE)
            throw new InvalideInputException("dividing results in Double MIN_VALUE overflow");
        return result;
    }

    static double calculatePower(double a, double b) {
        if (a == 0 && b == 0)
            throw new InvalideInputException("0 ^ 0 not allowed");
        double result = Math.pow(a, b);
        if (Double.isInfinite(result))
            throw new InvalideInputException("power results in Double MAX_VALUE overflow");
        if (a != 0.0 && Math.abs(result) < Double.MIN_VALUE)
            throw new InvalideInputException("power results in Double MIN_VALUE overflow");
        return result;
    }

}

class InvalideInputException extends RuntimeException {
    public InvalideInputException(String msg) {
        super(msg);
    }
}
