package study.PointToOffer.DivideTwoIntegers;

class Solution {
    public int divide(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (a == b) {
            return 1;
        }
        long newA = Math.abs((long) a);
        long newB = Math.abs((long) b);
        boolean positive = a > 0 && b > 0 || a < 0 && b < 0;
        long result = 0;
        if (newB == 1) {
            result = newA;
        } else {
            while (newA >= newB) {
                newA -= newB;
                result += 1;
            }
        }

        if (!positive) {
            result = -result;
        }

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }
}
