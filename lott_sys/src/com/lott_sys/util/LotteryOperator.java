/**
 * 
 */
package com.lott_sys.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lott_sys.dao.DictionaryDAO;
import com.lott_sys.dao.LotteryDAO;
import com.lott_sys.vo.Lottery;
import com.lott_sys.vo.LotteryInfo;

/**
 * @author caozx10172
 *
 */
public class LotteryOperator {

	private LotteryDAO lotterydao;
	private DictionaryDAO dictionarydao;
	
	public int getLottId(){
		String front,behind;
		int lastid = 0;
		//int old = lotterydao.getLastlottid();
		int old=0;
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
		return lastid;
	}
	
	//��ȡ�н������С��Ϣ ָ��� 1001
	public LotteryInfo getBig_Small(Lottery l){
		LotteryInfo li = new LotteryInfo(l);
		this.setInfo(li, 1001);
		return li;
	}
	
	//��ȡ�н�������ż��Ϣ ָ��� 1002
	public LotteryInfo getOdd_Even(Lottery l){
		LotteryInfo li = new LotteryInfo(l);
		this.setInfo(li, 1002);
		return li;
	}
	
	
	//��ȡ�н������ʺ���Ϣ ָ��� 1003
	public LotteryInfo getPrime_Composite(Lottery l){
		LotteryInfo li = new LotteryInfo(l);
		this.setInfo(li, 1003);
		return li;
	}
	
	//��ȡ�н�����012·��Ϣ ָ���1004
	public LotteryInfo get012(Lottery l){
		LotteryInfo li = new LotteryInfo(l);
		this.setInfo(li, 1004);
		return li;
	}
	
	//��ȡ�н������β012·��Ϣ ָ���1005
	public LotteryInfo getTiles012(Lottery l){
		LotteryInfo li = new LotteryInfo(l);
		String sum = String.valueOf(this.getSum(l));
		String tiles = sum.substring(sum.length()-1); //ȡ ��β
		li.setSuminfo(dictionarydao.getDictcode(tiles, 1005));
		return li;
	}
	
	public LotteryInfo setInfo(LotteryInfo li,int dict_entry){
		li.setNum1info(dictionarydao.getDictcode(li.getNum1(), dict_entry));
		li.setNum2info(dictionarydao.getDictcode(li.getNum2(), dict_entry));
		li.setNum3info(dictionarydao.getDictcode(li.getNum3(), dict_entry));
		li.setNum4info(dictionarydao.getDictcode(li.getNum4(), dict_entry));
		li.setNum5info(dictionarydao.getDictcode(li.getNum5(), dict_entry));
		return li;
	}
	
	public int getSum(Lottery l){
		int sum=0;
		sum+= Integer.valueOf(l.getNum1());
		sum+= Integer.valueOf(l.getNum2());
		sum+= Integer.valueOf(l.getNum3());
		sum+= Integer.valueOf(l.getNum4());
		sum+= Integer.valueOf(l.getNum5());
		return sum;
	}
	
	//��ȡÿ�������Ӧ�ֵ���ĺ�
	public int getInfoSum(Lottery l,int dict_entry){
		int sum=0;
		sum = dictionarydao.getDictcode(l.getNum1(), dict_entry)
			+ dictionarydao.getDictcode(l.getNum2(), dict_entry)
			+ dictionarydao.getDictcode(l.getNum3(), dict_entry)
			+ dictionarydao.getDictcode(l.getNum4(), dict_entry)
			+ dictionarydao.getDictcode(l.getNum5(), dict_entry);
		return sum;
	}
/*	
	//�����ֵ���ĺ��жϺ�������������Դ�СΪ����С:0,��1��:��1С4��,���Ϊ4
	public List<Lottery> query(int a,int b,int dict_entry,int begin,int end){
		List<Lottery> lotterys = new ArrayList<Lottery>();
		List<Lottery> list = lotterydao.query(begin, end);
		for(Lottery l:list){
			int sum = this.getInfoSum(l, dict_entry);
			if(b == sum){
				lotterys.add(l);
			}
		}
		return lotterys;
	}*/
	
	//�����ֵ���ĺ��жϺ��������������012·Ϊ����0·:0,1·��1,2·��10��:���ֱ�Ϊ 1,3,1 ���Ϊ13
	public List<Lottery> query(int a,int b,int c,int dict_entry,int begin,int end){
		List<Lottery> lotterys = new ArrayList<Lottery>();
		List<Lottery> list = lotterydao.query(end);
		for(Lottery l:list){
			int sum = this.getInfoSum(l, dict_entry);
			if((b+10*c) == sum){
				lotterys.add(l);
			}
		}
		return lotterys;
	}
	
	public List<Lottery> query(int dx,int jo,int zh,int l012,int nums){
		List<Lottery> lotterys = new ArrayList<Lottery>();
		List<Lottery> list = lotterydao.query(nums);

		for(Lottery l:list){
			if((dx == -1 || this.getInfoSum(l, 1001) == dx) 
			   && (jo == -1 || this.getInfoSum(l, 1002) == jo)
			   && (zh == -1 || this.getInfoSum(l, 1003) == zh)
			   && (l012 == -1 || this.getInfoSum(l, 1004) == l012)){
				lotterys.add(l);
			}
		}
		return lotterys;
	}
	 
	
	public List<Lottery> query(String str,int dict_entry,int begin,int end){
		List<Lottery> lotterys = new ArrayList<Lottery>();
		return lotterys;
	}
	
	public LotteryDAO getLotterydao() {
		return lotterydao;
	}
	public void setLotterydao(LotteryDAO lotterydao) {
		this.lotterydao = lotterydao;
	}

	public DictionaryDAO getDictionarydao() {
		return dictionarydao;
	}

	public void setDictionarydao(DictionaryDAO dictionarydao) {
		this.dictionarydao = dictionarydao;
	}
}
