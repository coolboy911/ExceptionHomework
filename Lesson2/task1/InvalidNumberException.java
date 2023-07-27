package ExceptionHomework.Lesson2.task1;

public class InvalidNumberException extends Exception {
    public InvalidNumberException(String msg){
        super(msg);
    }
    public InvalidNumberException(){
        super("Некорректное число");
    }
}
