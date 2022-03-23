/*
* 题目:
* 有一对兔子，从出生后第三个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假入兔子都不死，问第二十个月的兔子对数为多少?*/
package Java案例;

public class 不死神兔 {
    public static void main(String args[]){
        //定义一个数组并进行动态初始化,长度为20
        int[] arr=new int[20];

        //第一个月和第二个月兔子对数都是已知的,都为1
        arr[0]=arr[1]=1;

        //用循环实现计算每个月的兔子对数
        for(int i=2;i<arr.length;i++){
            arr[i]=arr[i-2]+arr[i-1];
        }

        //输出数组中最后一个元素的值(就是第二十个月的兔子对数)
        System.out.println("第二十个月的兔子对数是:"+arr[19]);
    }
}
