/**
 * 
 */
package com.lott_sys.util;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		return sum;
	}
	
	
	public LotteryDAO getLotterydao() {
		return lotterydao;
	}
	public void setLotterydao(LotteryDAO lotterydao) {
		this.lotterydao = lotterydao;
	}
}
