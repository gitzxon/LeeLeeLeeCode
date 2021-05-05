package test.java.sync;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 1 ");
//                Solution solution = new Solution();
                solution.syncMethod();
                System.out.println("thread 1 end");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 2 ");
//                Solution solution = new Solution();
                solution.syncMethod();
                System.out.println("thread 2 end");
            }
        }).start();
    }

    synchronized void syncMethod() {
        System.out.println("currentThread : " + Thread.currentThread());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep finish : " + Thread.currentThread());
    }

}
