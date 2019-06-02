package cn.mcandroid.dao;
import cn.mcandroid.model.Stus;
import java.util.*;
import java.lang.Exception;
public interface StusDao 
{


	public List<Stus> getAllStus(Stus stus);
	
	public Stus getStusByStus(Stus stus);
	
	public int addStus(Stus stus)throws Exception ;
	
	public int updateStus(Stus stus)throws Exception ;
	
	public int delStus(Stus stus)throws Exception ;
	
	
}