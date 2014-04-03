/**
 * 
 */
package com.lott_sys.util;

import java.util.ArrayList;
import java.util.List;

import com.lott_sys.dao.DictionaryDAO;
import com.lott_sys.vo.Lottery;

/**
 * 中奖号码过滤
 * @author caozx10172
 *
 */
public class NumFilter {

	private static String[] strs = {"01","02","03","04","05","06","07","08","09","10","11","12"};
	private static int length = 5;
	private DictionaryDAO dictionarydao;
	
	public List<String> filter(int a,int dict_entry){
		List<String> list = new ArrayList();
		List<String[]> temp = zuhe(strs, length);
		for(int i = 0;i < temp.size();i++){
			int sum = getInfoSum(temp.get(i), dict_entry);
			if(sum == a){
				list.add(temp.get(i)[0]+","
						+temp.get(i)[1]+","
						+temp.get(i)[2]+","
						+temp.get(i)[3]+","
						+temp.get(i)[4]);
			}
		}
		return list;
	}
	
	public int getInfoSum(String[] s,int dict_entry){
		int sum=0;
		for(int i = 0 ; i < s.length ; i++){
			sum += dictionarydao.getDictcode(s[i], dict_entry);
		}
		return sum;
	}
	
	private List<String[]> zuhe(String[] a, int m) { 
		   List<String[]> list = new ArrayList(); 
		   int n = a.length; 

		   boolean flag = false; // 是否是最后一种组合的标记 

		   // 生成辅助数组。首先初始化，将数组前n个元素置1，表示第一个组合为前n个数。 
		   int[] tempNum = new int[n]; 
		   for (int i = 0; i < n; i++) { 
		    if (i < m) { 
		     tempNum[i] = 1; 

		    } else { 
		     tempNum[i] = 0; 
		    } 
		    //System.out.print(tempNum[i]); 
		   } 

		   do { 
		    int pose = 0; // 记录改变的位置 
		    int sum = 0; // 记录改变位置 左侧 1 的个数 
		    // 然后从左到右扫描数组元素值的“10”组合，找到第一个“10”组合后将其变为“01” 
		    for (int i = 0; i < (n - 1); i++) { 
		     if (tempNum[i] == 1 && tempNum[i + 1] == 0) { 
		      tempNum[i] = 0; 
		      tempNum[i + 1] = 1; 
		      pose = i; 
		      break; 
		     } 
		    } 
		   // print(tempNum);// 打印辅助数组 
		    list.add(createResult(a, tempNum, m));// 打印第一中默认组合 

		    // 同时将其左边的所有“1”全部移动到数组的最左端。 

		    for (int i = 0; i < pose; i++) { 
		     if (tempNum[i] == 1) 
		      sum++; 
		    } 

		    for (int i = 0; i < pose; i++) { 
		     if (i < sum) 
		      tempNum[i] = 1; 
		     else 
		      tempNum[i] = 0; 
		    } 

		    // 判断是否为最后一个组合：当第一个“1”移动到数组的m-n的位置，即n个“1”全部移动到最右端时，就得到了最后一个组合。 
		    flag = false; 
		    for (int i = n - m; i < n; i++) { 

		     if (tempNum[i] == 0) 
		      flag = true; 

		    } 
		   } while (flag); 

		   return list; 
		} 
	
	// 根据辅助数组和原始数组生成 结果数组 
		public String[] createResult(String[] a, int[] temp, int m) { 
		   String[] result = new String[m]; 

		   int j = 0; 
		   for (int i = 0; i < a.length; i++) { 

		    if (temp[i] == 1) { 
		     result[j] = a[i]; 
		    // System.out.println("result[" + j + "]:" + result[j]); 
		     j++; 

		    } 
		   } 

		   return result; 
		}

		public DictionaryDAO getDictionarydao() {
			return dictionarydao;
		}

		public void setDictionarydao(DictionaryDAO dictionarydao) {
			this.dictionarydao = dictionarydao;
		} 
}
