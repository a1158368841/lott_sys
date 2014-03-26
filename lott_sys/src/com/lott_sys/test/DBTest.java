package com.lott_sys.test;

import com.lott_sys.dao.PlaymethodsDAO;
import com.lott_sys.vo.Playmethods;

public class DBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playmethods p = null;
		PlaymethodsDAO dao = new PlaymethodsDAO();
		p=(Playmethods)dao.findById((short)1);
		System.out.println(p.getMethodName());
	}

}
