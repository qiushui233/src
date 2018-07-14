package lintCode;
/*
计算  n！ 末尾 0 的个数
 */
public class test002 {

    public static void main(String[] args){
        System.out.println(trailingZeros(1001171717));
    }

    public static long trailingZeros(long n) {
        /*long count = 0;
        long pwr = 25;
        for (long temp = 5; temp <= n; temp+=5) {
            // for循环内部的temp都是5的倍数，因此首先进行+1操作
            count++;
            pwr = 25;
            // 判断是不是25、125、625...的倍数，并根据每次pwr的变化进行+1操作
            while (temp % pwr == 0) {
                count++;
                pwr *= 5;
            }
        }
        return count;*/

        long count = 0;
        long temp=n/5;
        while (temp!=0) {
            count+=temp;
            temp/=5;
        }
        return count;

    }
}
