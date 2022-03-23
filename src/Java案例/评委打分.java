/*
* 题目:
* 在比赛中,有6个评委为参赛的选手打分，分数为0-100的整数分，选手的最后得分为:去掉一个最高分和最后一个最低分的四个评委打分的平均值(不考虑小数部分)
* 注意:输入分数为要输入一排6个，不能换行输入，否则就是五个*/
package Java案例;

import java.util.Scanner;

public class 评委打分 {
    public static void main(String args[]) {
        int[] arr=new int[5];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int avg=(getSum(arr)-getMax(arr)-getMin(arr))/(arr.length-2);
        System.out.println("最终评分为:"+avg);
    }
    public static int getMax(int[] arr){
            int x = arr[0];
            for (int a = 1; a < arr.length; a++) {
                if (x < arr[a]) {
                    x = arr[a];
                }
            }
            return x;
        }
    public static int getMin(int[] arr){
        int y=arr[0];
        for(int b=1;b<arr.length;b++){
            if(y>arr[b]){
                y=arr[b];
            }
        }
        return y;
    }
    public static int getSum(int[] arr){
        int sum=0;
        for(int c=0;c<arr.length;c++){
            sum+=arr[c];
        }
        return sum;
    }
}
