package com.lott_sys.test;

import java.util.ArrayList;
import java.util.List;

public class Zuhe1 {

	/** 
	* @param a:������� 
	* @param k:������ϸ��� 
	* @return :���п��ܵ���������б� 
	*/ 
	private List<int[]> zuhe(int[] a, int m) { 
	   Zuhe1 zuhe = new Zuhe1(); 
	   List<int[]> list = new ArrayList(); 
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
	   // System.out.print(tempNum[i]); 
	   } 
	   //print(tempNum);// ��ӡ�������� 

	   list.add(zuhe.createResult(a, tempNum, m));// ��ӡ��һ��Ĭ����� 

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
	    list.add(zuhe.createResult(a, tempNum, m));// ��ӡ��һ��Ĭ����� 

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
	public int[] createResult(int[] a, int[] temp, int m) { 
	   int[] result = new int[m]; 

	   int j = 0; 
	   for (int i = 0; i < a.length; i++) { 

	    if (temp[i] == 1) { 
	     result[j] = a[i]; 
	   //  System.out.println("result[" + j + "]:" + result[j]); 
	     j++; 

	    } 
	   } 

	   return result; 
	} 

	// ��ӡ 
	public void print1(List list) { 

	   for (int i = 0; i < list.size(); i++) { 
	    System.out.println(); 
	    int[] temp = (int[]) list.get(i); 
	    for (int j = 0; j < temp.length; j++) { 
	//     System.out.print(temp[j] + " "); 
	    } 
	   } 
	} 

	// ��ӡ��������ķ��� 
	public void print(int[] a) { 
	   System.out.println("���ɵĸ�������Ϊ��"); 
	   for (int i = 0; i < a.length; i++) { 
	    System.out.print(a[i]); 
	   } 
	   System.out.println(); 
	} 

	public static void main(String[] args) { 
	   int[] a = { 1, 2, 3, 4, 5,6,7,8,9,10,11,12 }; // �������� 
	   int m = 5; // ��ȡ����ϵĸ��� 
	   Zuhe1 zuhe = new Zuhe1(); 
	   List<int[]> list = zuhe.zuhe(a, m); 
	   System.out.println(list.get(0)[1]);
	   //zuhe.print1(list); 
	   //System.out.println("total:"+list.size());
	} 
}