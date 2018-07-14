package lintCode;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/*
设计一个算法，找出只含素因子2，3，5 的第 n 小的数。

符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

样例
如果n = 9， 返回 10
 */
public class test004 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(9));
    }

    public static int min(int a ,int b ,int c){
        if (a > b) {
            if (b >c){
                return c;
            }else {
                return b;
            }
        }else {
            if (a > c){
                return c;
            }else {
                return a;
            }
        }

    }

    public static int nthUglyNumber(int n) {
        int[] num = new int[n];
        num[0] = 1;
        int n2 = 0;
        int n3 = 0;
        int n5 = 0;
        for (int i = 1; i < n; i++) {
            num[i] = min(num[n2]*2,num[n3]*3,num[n5]*5);
            if (num[i] / num[n2] == 2 ){
                n2++;
            }
            if (num[i] / num[n3] == 3 ){
                n3++;
            }
            if (num[i] / num[n5] == 5 ){
                n5++;
            }
        }
        return num[n-1];
    }
}
