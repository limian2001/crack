/*Best Time to Buy and Sell Stock Total Accepted: 6345 Total Submissions: 20393 My Submissions 





Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

//��������Ȱ�ÿ��ļ۸�ĳ�һ��n-1����array�����һ���ǰһ��Ĳ�ֵ��Ȼ��ת��Ϊ������������������
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
        //�㷨��������divide&conquer��������һ��mid���ֳ������������left,right�ʹ�Խmid�������
        //������ֱ�ӱ���һ�����У������ӣ�������������ʱ�򣬰�ǰ����ӽ�����������͵�ǰmax�Ƚϣ�����������С��0��ʱ��ֱ�ӷ���ǰ�����С�
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
        //�ⲽ�жϲ����٣���Ϊ������������ѭ��ʱ���һ���Ǹ�sum��û�ù�
        if(sum>max)
            max=sum;
            
        return max;
    }
	

}
