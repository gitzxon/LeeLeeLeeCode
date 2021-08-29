package study.singleton.innerclass;

public class Singleton {

    private Singleton() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("new instance created");
    }

    public static Singleton getInstance() {
        return SingletonHolder.sSingletonHolder;
    }

    private static class SingletonHolder {
        private final static Singleton sSingletonHolder = new Singleton();
    }
}
