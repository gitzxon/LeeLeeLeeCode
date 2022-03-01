package study.singleton.doublecheck;

public class Solution {
    private static volatile Solution sInstance = null;
    private Solution() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("new instance created");

    }

    public static Solution getInstance() {
        if (sInstance == null) {
            synchronized (Solution.class) {
                if (sInstance == null) {
                    sInstance = new Solution();
                }
            }
        }
        return sInstance;
    }
}
