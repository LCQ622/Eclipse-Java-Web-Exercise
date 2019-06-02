package cn.mcandroid.jdbc;

import java.util.Iterator;
import java.util.List;

import cn.mcandroid.dao.impl.StusDaoimpl;
import cn.mcandroid.model.Stus;

public class Test02 {
	public static void main(String[] args) {
		Stus s1=new Stus();
		s1.setId(4);
		StusDaoimpl d=new StusDaoimpl();
		List<Stus> list=d.getAllStus(s1);
		for(Iterator<Stus> iterator=list.iterator();iterator.hasNext();) {
			Stus stus=iterator.next();
			System.out.println(stus.toString());
		}
	}
}
