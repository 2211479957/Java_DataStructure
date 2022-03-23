package Java案例;

import java.util.Scanner;

public class 减肥计划 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入星期数:");
        int week=sc.nextInt();

        //使用switch语句进行判断
        switch(week){
            case 1:
                System.out.println("今天的计划是:跑步!");
                break;
            case 2:
                System.out.println("今天的计划是:爬山!");
                break;
            case 3:
                System.out.println("今天的计划是:游泳!");
                break;
            case 4:
                System.out.println("今天的计划是:骑自行车!");
                break;
            case 5:
                System.out.println("今天的计划是:拳击!");
                break;
            case 6:
                System.out.println("今天的计划是:健美操!");
                break;
            case 7:
                System.out.println("今天的计划是:休息!");
                break;
            default:
                System.out.println("输入的星期有误!");
                break;
        }
    }
}
