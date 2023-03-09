class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

class MyMethods {
    public void methodOne() throws MyException {
        throw new MyException("Exception in methodOne");
    }

    public void methodTwo() throws MyException {
        throw new MyException("Outch , we've got an exception in methodTwo");
    }

    public void methodThree() throws MyException {
        throw new MyException("methodThree thowed A really bad exception at your face !!");
    }
}

class ExceptionCaller {
    public void callMethods() {
        MyMethods methods = new MyMethods();
        try {
            methods.methodOne();
            methods.methodTwo();
            methods.methodThree();
        } catch (MyException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
    }
}

public class Lab4Q1 {
    public static void main(String[] args) {
        ExceptionCaller caller = new ExceptionCaller();
        caller.callMethods();
    }
}
