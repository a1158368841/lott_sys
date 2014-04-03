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
		
		//表示最新一期是今天的
		if(front.equals(datestring)){
			//期号加1
			behind = String.format("%03d", Integer.valueOf(behind)+1);	
		}else{
			//这是今天的第一期
			behind = "001";
			front = datestring.substring(0,6);
		}
		
		lastid = Integer.valueOf(front+behind);
		return lastid;
	}
	
	//获取中奖号码大小信息 指标号 1001
	public LotteryInfo getBig_Small(Lottery l){
		LotteryInfo li = new LotteryInfo(l);
		this.setInfo(li, 1001);
		return li;
	}
	
	//获取中奖号码奇偶信息 指标号 1002
	public LotteryInfo getOdd_Even(Lottery l){
		LotteryInfo li = new LotteryInfo(l);
		this.setInfo(li, 1002);
		return li;
	}
	
	
	//获取中奖号码质合信息 指标号 1003
	public LotteryInfo getPrime_Composite(Lottery l){
		LotteryInfo li = new LotteryInfo(l);
		this.setInfo(li, 1003);
		return li;
	}
	
	//获取中奖号码012路信息 指标号1004
	public LotteryInfo get012(Lottery l){
		LotteryInfo li = new LotteryInfo(l);
		this.setInfo(li, 1004);
		return li;
	}
	
	//获取中奖号码和尾012路信息 指标号1005
	public LotteryInfo getTiles012(Lottery l){
		LotteryInfo li = new LotteryInfo(l);
		String sum = String.valueOf(this.getSum(l));
		String tiles = sum.substring(sum.length()-1); //取 和尾
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
	
	//获取每个号码对应字典项的和
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
	//根据字典项的和判断号码的组合情况（以大小为例，小:0,大：1）:若1小4大,则和为4
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
	
	//根据字典项的和判断号码的组合情况（以012路为例，0路:0,1路：1,2路：10）:若分别为 1,3,1 则和为13
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
