package cn.mcandoird.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bill {

	private int id;
	private Date date;
	private double money;
	private String pay_mode;
	private String type;
	private String msg;
	public Bill(int id, Date date, double money, String pay_mode, String type, String msg) {
		this.id = id;
		this.date = date;
		this.money = money;
		this.pay_mode = pay_mode;
		this.type = type;
		this.msg = msg;
	}
	public Bill() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getPay_mode() {
		return pay_mode;
	}
	public void setPay_mode(String pay_mode) {
		this.pay_mode = pay_mode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		SimpleDateFormat format=new SimpleDateFormat("yyyyƒÍMM‘¬dd»’");
		return "Bill [id=" + id + ", date=" + format.format(date) + ", money=" + money + ", pay_mode=" + pay_mode + ", type=" + type
				+ ", msg=" + msg + "]";
	}
	
	
	
	
	
}
