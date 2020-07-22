import java.util.LinkedList;

public class Main {

    public static class HostManager {
        LinkedList<Integer> object;

        HostManager() {
            object = new LinkedList<>();
        }
    }

    private static volatile HostManager hostManager;
    public static HostManager hostManager() {
        if (hostManager == null) {
            synchronized (Main.class) {
                if (hostManager == null) {
                    hostManager = new HostManager();
                }
            }
        }
        return hostManager;
    }
    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hostManager().object = " + hostManager().object);
                }
            }).start();
        }


//        System.out.println("start main");
//
//        System.out.println("value is : " + 0xFFFFFFBF);
//
//        int value = ((Integer.MIN_VALUE + Integer.MIN_VALUE) >>> 2);
//        int value2 = Integer.MIN_VALUE + (Integer.MIN_VALUE - Integer.MIN_VALUE) / 2;
//        System.out.println("min + min = " + value);
//        System.out.println("value2 = " + value2);
//
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(1);
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(0);
//        list1.add(1);
//        System.out.println("list == list1 = " + (list == list1));
//        System.out.println("list.equals(list1) = " + list.equals(list1));
    }
}
