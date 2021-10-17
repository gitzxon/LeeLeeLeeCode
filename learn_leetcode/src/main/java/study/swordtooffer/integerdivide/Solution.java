package study.swordtooffer.integerdivide;

class Solution {
    public int divide(int a, int b) {

        if (b == 0) {
            return 0;
        }

        long newA = a;
        long newB = b;

        boolean negative;
        if (newA * newB < 0) {
            negative = true;
        } else {
            negative = false;
        }

        long remain = Math.abs(newA);
        long divider = Math.abs(newB);
        long result = 0;
        if (divider == 1) {
            result = remain;
        } else {

            while (remain >= divider) {
                long currentDivider = divider;
                int count = 1;
                while (currentDivider + currentDivider <= remain) {
                    currentDivider = currentDivider + currentDivider;
                    count += count;
                }
                remain -= currentDivider;
                result += count;
            }
        }

        if (negative) {
            result = -result;
        }
        if (result >= Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        if (result <= Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
