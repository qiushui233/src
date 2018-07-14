package lintCode;
/*
3. 统计数字
计算数字k在0到n中的出现的次数，k可能是0~9的一个值

样例
例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)
 */
public class test003 {

    public static void main(String[] args){
        System.out.println(digitCounts(1,112));
    }

    public static int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for(int i = 0;i<=n;i++)
        {
            int number = i;
            while( number/10 != 0)
            {
                if(number % 10 == k)
                {
                    count++;
                }
                number = number/10;
            }
            if(number == k)
                count++;
        }
        return count;
    }
}
