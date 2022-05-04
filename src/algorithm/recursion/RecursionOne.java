//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package algorithm.recursion;

public class RecursionOne {
    public RecursionOne() {
    }

    public static void main(String[] args) {
        System.out.println(gcd(5, 85));
    }

    static int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }
}
