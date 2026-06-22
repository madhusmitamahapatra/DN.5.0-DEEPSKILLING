public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First log entry");
        logger2.log("Second log entry");

        System.out.println("logger1 hash: " + System.identityHashCode(logger1));
        System.out.println("logger2 hash: " + System.identityHashCode(logger2));
        System.out.println("Same instance? " + (logger1 == logger2));
    }
}
