package Java案例;
/*
*水仙花是一个三位数
* 水仙花的个位，十位，百位的数字立方和等于原数
* 原数(primitive number)求一个数的补数时，把这个数称为原数或本数。
若两数之和是10、100、1000、……10n的乘方数（n是正整数），这两个数就互为补数.
比如4的原数是6，91的原数是9等等。 */
public class 水仙花 {
    public static void main (String args[]){
        //使用循环遍历所有的三位数（100开始到999结束）
        for(int i=100;i<1000;i++){
            //计算之前获得的三位数每个位上的值
            int ge=i%10;
            int shi=i/10%10;
            int bai=i/100%10;

            //将三位数中的每个数的值取出来，计算立方和并与原数比较
            if(ge*ge*ge+shi*shi*shi+bai*bai*bai ==i){
                //输出水仙花
                System.out.println(i+" ");
            }
        }
    }
}
