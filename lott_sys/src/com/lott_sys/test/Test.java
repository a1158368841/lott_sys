package com.lott_sys.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<int[]> list1 = new ArrayList<int[]>(); 
		List<int[]> list2 = new ArrayList<int[]>(); 
		List<List<String>> list3 = new ArrayList<List<String>>();
		String[] strs = {"01","02"};
		list1.add(new int[] {1,2});
		list1.add(new int[] {1,3});
		list1.add(new int[] {1,4});
		
		list2.add(new int[] {1,3});
		list2.add(new int[] {1,2});
		list2.add(new int[] {2,4});
		
		System.out.println(list1.get(0)[0]);
		
/*		list1.retainAll(list2);
		for(int[] str:list1){
			System.out.println(str[0]+"  "+str[1]);
		}
		List<String> ls1 = new ArrayList<String>();
		ls1.add("a");

		List<String> ls2 = new ArrayList<String>();
		ls1.add("a");
		list3.add(ls1);
		System.out.println(list3.contains(ls2));*/
	}



}
