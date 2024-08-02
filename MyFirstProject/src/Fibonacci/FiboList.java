package Fibonacci;

public class FiboList {
    public int length;
    public int[] fibolist;

    public FiboList(int n) {
        this.length = n;
        this.fibolist = generateFiboList(this.length);
    }

    public String fiboListToString() {
        String result = "";
        for (int i = 0; i < this.length; i++) {
            result += this.fibolist[i] + ", ";
        }
        result = result.substring(0, result.length() - 2);
        return result;
    }

    private int[] generateFiboList(int n) {
        int[] fibolist = new int[n];
        for (int i = 0; i < n; i++) {
            fibolist[i] = fibo(i);
        }
        return fibolist;
    }

    public static int fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
