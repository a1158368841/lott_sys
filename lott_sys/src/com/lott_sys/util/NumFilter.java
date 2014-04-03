/**
 * 
 */
package com.lott_sys.util;

import java.util.ArrayList;
import java.util.List;

import com.lott_sys.dao.DictionaryDAO;
import com.lott_sys.vo.Lottery;

/**
 * �н��������
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

		   boolean flag = false; // �Ƿ������һ����ϵı�� 

		   // ���ɸ������顣���ȳ�ʼ����������ǰn��Ԫ����1����ʾ��һ�����Ϊǰn������ 
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
		    int pose = 0; // ��¼�ı��λ�� 
		    int sum = 0; // ��¼�ı�λ�� ��� 1 �ĸ��� 
		    // Ȼ�������ɨ������Ԫ��ֵ�ġ�10����ϣ��ҵ���һ����10����Ϻ����Ϊ��01�� 
		    for (int i = 0; i < (n - 1); i++) { 
		     if (tempNum[i] == 1 && tempNum[i + 1] == 0) { 
		      tempNum[i] = 0; 
		      tempNum[i + 1] = 1; 
		      pose = i; 
		      break; 
		     } 
		    } 
		   // print(tempNum);// ��ӡ�������� 
		    list.add(createResult(a, tempNum, m));// ��ӡ��һ��Ĭ����� 

		    // ͬʱ������ߵ����С�1��ȫ���ƶ������������ˡ� 

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

		    // �ж��Ƿ�Ϊ���һ����ϣ�����һ����1���ƶ��������m-n��λ�ã���n����1��ȫ���ƶ������Ҷ�ʱ���͵õ������һ����ϡ� 
		    flag = false; 
		    for (int i = n - m; i < n; i++) { 

		     if (tempNum[i] == 0) 
		      flag = true; 

		    } 
		   } while (flag); 

		   return list; 
		} 
	
	// ���ݸ��������ԭʼ�������� ������� 
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
