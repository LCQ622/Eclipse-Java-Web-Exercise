package cn.mcandroid.manage;
import cn.mcandroid.model.Stus;
import java.util.*;
import java.lang.Exception;
public interface StusManage 
{


	public List<Stus> getAllStus(Stus stus);
	
	public Stus getStusByStus(Stus stus);
	
	public boolean addStus(Stus stus)throws Exception ;
	
	public boolean updateStus(Stus stus)throws Exception ;
	
	public boolean delStus(Stus stus)throws Exception ;
	
	
}