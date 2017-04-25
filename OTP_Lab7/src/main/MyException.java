package main;

/**
 * Created by Makarenko on 25.04.2017.
 */
public class MyException extends Exception {
    public MyException(String message){
        super(message);
    }
    public void showMessage() {
        System.out.println(this.getMessage());
    }
}
