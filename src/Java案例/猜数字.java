/*
* 题目
* 程序自动生成一个1-100之间的数字，使用程序实现猜出这个数字是多少？
* 当猜错时给出的提示：
* 猜的数字比真实数字大，提示猜的数据大了
* 猜的数字比真实数字小，提示猜的数据小了
* 猜的数字等于真实数字，提示恭喜猜中了*/
package Java案例;

import java.util.Random;
import java.util.Scanner;

public class 猜数字 {
   public static void main(String args[]){
       //使用随机数生成该数字，范围0-100
       //需要导包import java.util.*;
       Random r=new Random();
       int num=r.nextInt(100)+1;
        //使用循环反复进行猜数字过程
       while(true){
           //使用键盘实现输入的猜测数字
           Scanner sc=new Scanner(System.in);
           System.out.println("请输入你猜的数字:");
           int s=sc.nextInt();

            //比较猜测的数字与生成的数字
           if(s>num){
               System.out.println("猜的数字大了!");
           }
           else if(s<num){
               System.out.println("猜的数字小了!");
           }
           else{
               System.out.println("恭喜你猜对了!");
                //猜中后跳出循环
               break;
           }
       }
   }
}
