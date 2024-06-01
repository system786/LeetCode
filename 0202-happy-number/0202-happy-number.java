class Solution {
    public boolean isHappy(int n) {
        int[] d = getDigits(n);
        if(n==1 || n==7){
            return true;
        }
        if (n<10) {
            return false;
        }
        int sum =0;
        int i=0;
        while (d.length != 1) {
            sum = 0;
            for (int digit : d) {
                sum += (int) Math.pow(digit, 2);
            }
            d = getDigits(sum);
        }
        return sum ==1 || sum ==7;

    }

    int[] getDigits(int number) {
        int temp = number;
        int count = 0;
        while (temp != 0) {
            temp /= 10;
            count++;
        }
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }
}