package ExceptionHomework.Lesson2.task4.Exceptions;

/**
 * превышение максимального баланса
 */
public class MaxBalanceExceededException extends Exception{
    public MaxBalanceExceededException(String msg){
        super(msg);
    }
}
