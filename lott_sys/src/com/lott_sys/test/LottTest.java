package com.lott_sys.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LottTest {

	public static void main(String[] args) {
		String front,behind;
		int lastid = 0;
		int old = 140320002;
		front = String.valueOf(old).substring(0,6);
		behind = String.valueOf(old).substring(6,9);
		Date curr = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		String datestring = sdf.format(curr);
		
		//��ʾ����һ���ǽ����
		if(front.equals(datestring)){
			//�ںż�1
			behind = String.format("%03d", Integer.valueOf(behind)+1);	
		}else{
			//���ǽ���ĵ�һ��
			behind = "001";
			front = datestring.substring(0,6);
		}
		
		lastid = Integer.valueOf(front+behind);
		System.out.println(lastid);
		
	}
}
