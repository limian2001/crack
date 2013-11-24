import java.util.HashMap;
import java.util.*;

/*This is a Dropbox interview question, which gives a 7-digits number telephone number and a dictionary. 
 * The dictionary includes all words equal or bigger than 3 chars. Please find all meaningful words
 * combination for this number.
 * In this case, we use number "5678432" for an example, the dictionary is just random.
 * Because all the words length in dictionary are bigger than 3, we only need consider the combination of 
 * 3-4, 4-3, or 7. */
public class TelNumberDropboxInter {
	public static void main(String args[]){
		String[] dic={"lop","jmpu","thea","ifc","kostiea","lap","tap","guest","lmp","get","ruif","kmpugec","vida"};
		int phonenum=5678432;
		getWords(phonenum,dic);
	}
 /*We build 3 hashmaps for 3 chars, 4 chars and 7 chars. Key is number for words in keypad
  *  and value is words in dictionary. For example, "key" is "539". Traverse all dictionary and
  *  get all length 3,4 and 7 words, put them into hashmap with its key. Then, divide input
  *  telephone number as 3+4,4+3 and 7 three combinations. Search hashmap and get all combinations.  */
	public static void getWords(int num,String[] dic){
		HashMap<Integer,ArrayList<String>> map3=new HashMap<Integer,ArrayList<String>>();
		HashMap<Integer,ArrayList<String>> map4=new HashMap<Integer,ArrayList<String>>();
		HashMap<Integer,ArrayList<String>> map7=new HashMap<Integer,ArrayList<String>>();

		int newkey;
		for(int i=0;i<dic.length;i++){
			if(dic[i].length() == 3){
				newkey=Integer.parseInt((
						Integer.toString(getNum(dic[i].charAt(0)))+
						Integer.toString(getNum(dic[i].charAt(1)))+
						Integer.toString(getNum(dic[i].charAt(2)))));
				if(map3.containsKey(newkey)){
					ArrayList<String> value1=new ArrayList<String>();
					value1=map3.get(newkey);
					value1.add(dic[i]);
					map3.put(newkey,value1);
				}
				else{
					ArrayList<String> value2=new ArrayList<String>();
					value2.add(dic[i]);
					map3.put(newkey,value2);
				}
			}
			
						
			if(dic[i].length() == 4){
				newkey=Integer.parseInt((
						Integer.toString(getNum(dic[i].charAt(0)))+
						Integer.toString(getNum(dic[i].charAt(1)))+
						Integer.toString(getNum(dic[i].charAt(2)))+
						Integer.toString(getNum(dic[i].charAt(3)))));
				if(map4.containsKey(newkey)){
					ArrayList<String> value1=new ArrayList<String>();
					value1=map4.get(newkey);
					value1.add(dic[i]);
					map4.put(newkey,value1);
				}
				else{
					ArrayList<String> value2=new ArrayList<String>();
					value2.add(dic[i]);
					map4.put(newkey,value2);
				}
			}
			if(dic[i].length() == 7){
				newkey=Integer.parseInt((
						Integer.toString(getNum(dic[i].charAt(0)))+
						Integer.toString(getNum(dic[i].charAt(1)))+
						Integer.toString(getNum(dic[i].charAt(2)))+
						Integer.toString(getNum(dic[i].charAt(3)))+
						Integer.toString(getNum(dic[i].charAt(4)))+
						Integer.toString(getNum(dic[i].charAt(5)))+
						Integer.toString(getNum(dic[i].charAt(6)))));
				if(map7.containsKey(newkey)){
					ArrayList<String> value1=new ArrayList<String>();
					value1=map7.get(newkey);
					value1.add(dic[i]);
					map7.put(newkey,value1);
				}
				else{
					ArrayList<String> value2=new ArrayList<String>();
					value2.add(dic[i]);
					map7.put(newkey,value2);
				}
			}
			}
		String s=Integer.toString(num);
		int first3=Integer.parseInt(s.substring(0, 3));
		int first4=Integer.parseInt(s.substring(0, 4));
		int last3=Integer.parseInt(s.substring(4, 7));
		int last4=Integer.parseInt(s.substring(3, 7));
		int all7=Integer.parseInt(s.substring(0, 7));
		ArrayList<String> first3arr=map3.get(first3);
		ArrayList<String> last4arr=map4.get(last4);
		for(String s1:first3arr)
			for(String s2:last4arr)
				System.out.println(s1+s2);
		ArrayList<String> first4arr=map4.get(first4);
		ArrayList<String> last3arr=map3.get(last3);
		for(String s1:first4arr)
			for(String s2:last3arr)
				System.out.println(s1+s2);
		ArrayList<String> all7arr=map7.get(all7);
		for(String s1:all7arr)
			System.out.println(s1);
			
	}
	/*A function transfer a word in dictionary to number according to keypad*/
	public static int getNum(char c){
		char[] s={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int[] num={2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		HashMap<Character,Integer> map1=new HashMap<Character,Integer>();
		for(int i=0,j=0;i<s.length && j<num.length;i++,j++)
			map1.put(s[i],num[j]);
		return map1.get(c);
	}

}
