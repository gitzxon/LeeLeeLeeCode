package interview.bytedance;

public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");

        new ProducerThread().start();
        new ConsumerThread().start();
    }

    public static volatile int count = 0;
    public static final Object object = new Object();

    public static class ProducerThread extends Thread {
        @Override
        public void run() {
            produce();
        }

        public void produce() throws IllegalMonitorStateException {

            System.out.println("enter produce !");
            while (true) {
                synchronized (object) {
                    if (count == 0) {
                        count = 1;
                        System.out.println("produce one, change count from 0 to 1");
                        object.notify();

                    } else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static class ConsumerThread extends Thread {
        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void consume() throws InterruptedException {

            System.out.println("enter consume !");

            while (true) {
                synchronized (object) {
                    if (count == 1) {
                        count = 0;
                        System.out.println("consume one, change count from 1 to 0");
                        object.notify();
                    } else {
                        object.wait();
                    }
                }
            }
        }
    }
}