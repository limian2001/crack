/*Best Time to Buy and Sell Stock Total Accepted: 6345 Total Submissions: 20393 My Submissions 





Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

//这道题首先把每天的价格改成一个n-1长的array，存后一天和前一天的差值，然后转化为计算最大的子数列问题
//
public class BestTimetoSellBuyStock {
	
	public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int[] dif=new int[prices.length-1];
        for(int i=0;i<prices.length-1;i++)
            dif[i]=prices[i+1]-prices[i];
        int max=0;
        int sum=0;
        //算法导论上用divide&conquer来做，找一个mid，分成最大子数列在left,right和穿越mid三种情况
        //我这里直接遍历一遍数列，逐个相加，当遇到负数的时候，把前面相加结果存下来（和当前max比较），当加起来小于0的时候，直接放弃前面所有。
        for(int j=0;j<dif.length;j++){
            if(sum<0){
                sum=0;
                sum+=dif[j];
            }
            else{
                if(dif[j]<0 && sum>max){
                    max=sum;
                    sum+=dif[j];
                }
                else
                    sum+=dif[j];
            }
        }
        //这步判断不能少，因为遍历结束跳出循环时最后一次那个sum还没用过
        if(sum>max)
            max=sum;
            
        return max;
    }
	

}
