package cn.mcandroid.dao.impl;
import java.sql.*;
import java.util.Date;
import cn.mcandroid.dao.impl.BaseDaoImpl;
import cn.mcandroid.dao.StusDao;
import cn.mcandroid.model.Stus;
import java.util.*;
import java.lang.Exception;
public class StusDaoimpl extends BaseDaoImpl implements StusDao 
{


	public List<Stus> getAllStus(Stus stus)
	{
	
		List paramList=new ArrayList();
		StringBuffer sql=new StringBuffer("select id,first_name,last_name,sex from stus where 1=1");
	
		if(stus!=null){
			if(stus.getId()>0){
				sql.append(" and id=?");
				paramList.add(stus.getId());
			}
			if(stus.getFirstName()!=null){
				sql.append(" and first_name=?");
				paramList.add(stus.getFirstName());
			}
			if(stus.getLastName()!=null){
				sql.append(" and last_name=?");
				paramList.add(stus.getLastName());
			}
			if(stus.getSex()!=null){
				sql.append(" and sex=?");
				paramList.add(stus.getSex());
			}
		
	
		}
		List<Stus> stList=new ArrayList<Stus>();
		Connection conn=getConn();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql.toString());
			for(int i=0;i<paramList.size();i++){
				Object obj=paramList.get(i);
				if(obj instanceof java.util.Date){
					Date utilDate=(Date) obj;
					java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
					obj=sqlDate;
				}
				pre.setObject(i+1, obj);
			}
			rs=pre.executeQuery();
			while(rs.next()){
				Stus stusModel=new Stus(rs.getLong("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("sex"));
				stList.add(stusModel);
			}
			return stList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(conn, pre, rs);
		}
	
		return null;
	}
	
	public Stus getStusByStus(Stus stus)
	{
	
		List paramList=new ArrayList();
		StringBuffer sql=new StringBuffer("select id,first_name,last_name,sex from stus where 1=1");
	
		if(stus!=null){
			if(stus.getId()>0){
				sql.append(" and id=?");
				paramList.add(stus.getId());
			}
			if(stus.getFirstName()!=null){
				sql.append(" and first_name=?");
				paramList.add(stus.getFirstName());
			}
			if(stus.getLastName()!=null){
				sql.append(" and last_name=?");
				paramList.add(stus.getLastName());
			}
			if(stus.getSex()!=null){
				sql.append(" and sex=?");
				paramList.add(stus.getSex());
			}
		
	
		}
		Connection conn=getConn();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql.toString());
			for(int i=0;i<paramList.size();i++){
				Object obj=paramList.get(i);
				if(obj instanceof java.util.Date){
					Date utilDate=(Date) obj;
					java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
					obj=sqlDate;
				}
				pre.setObject(i+1, obj);
			}
			rs=pre.executeQuery();
			if(rs.next()){
				Stus stusModel=new Stus(rs.getLong("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("sex"));
				return stusModel;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(conn, pre, rs);
		}
	
		return null;
	}
	
	public int addStus(Stus stus)throws Exception 
	{
	
		List paramList=new ArrayList();
		StringBuffer colBuf=new StringBuffer();
		if(stus.getId()>0){
			colBuf.append("id,");
			paramList.add(stus.getId());
		}
		if(stus.getFirstName()!=null){
			colBuf.append("first_name,");
			paramList.add(stus.getFirstName());
		}
		if(stus.getLastName()!=null){
			colBuf.append("last_name,");
			paramList.add(stus.getLastName());
		}
		if(stus.getSex()!=null){
			colBuf.append("sex,");
			paramList.add(stus.getSex());
		}
		StringBuffer sql=new StringBuffer("insert into stus("+colBuf.deleteCharAt(colBuf.length()-1)
			+") values(");
		StringBuffer valBuf=new StringBuffer();
		for(int i=0;i<paramList.size();i++){
			valBuf.append("?,");
		}
		sql.append(valBuf.deleteCharAt(valBuf.length()-1).toString()+")");
		Connection conn=getConn();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql.toString());
			for(int i=0;i<paramList.size();i++){
				Object obj=paramList.get(i);
				if(obj instanceof java.util.Date){
					Date utilDate=(Date) obj;
					java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
					obj=sqlDate;
				}
				pre.setObject(i+1, obj);
			}
			return pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			pre.close();
			pre=conn.prepareStatement("select LAST_INSERT_ID() from stus");
			rs=pre.executeQuery();
			if(rs.next()){
				stus.setId(rs.getLong("id"));
			}
			closeAll(conn, pre,rs);
		}
	
	
	}
	
	public int updateStus(Stus stus)throws Exception 
	{
	
		List paramList=new ArrayList();
		StringBuffer setBuf=new StringBuffer();
		StringBuffer sql=new StringBuffer();
		if(stus.getId_updateField()>0){
			setBuf.append("id=?,");
			paramList.add(stus.getId_updateField());
		}
		if(stus.getFirstName_updateField()!=null){
			setBuf.append("first_name=?,");
			paramList.add(stus.getFirstName_updateField());
		}
		if(stus.getLastName_updateField()!=null){
			setBuf.append("last_name=?,");
			paramList.add(stus.getLastName_updateField());
		}
		if(stus.getSex_updateField()!=null){
			setBuf.append("sex=?,");
			paramList.add(stus.getSex_updateField());
		}
	
		if(stus!=null){
			if(stus.getId()>0){
				sql.append(" and id=?");
				paramList.add(stus.getId());
			}
			if(stus.getFirstName()!=null){
				sql.append(" and first_name=?");
				paramList.add(stus.getFirstName());
			}
			if(stus.getLastName()!=null){
				sql.append(" and last_name=?");
				paramList.add(stus.getLastName());
			}
			if(stus.getSex()!=null){
				sql.append(" and sex=?");
				paramList.add(stus.getSex());
			}
		
	
		}
		sql.insert(0, "update stus set "+setBuf.deleteCharAt(setBuf.length()-1)
			+" where 1=1 ");
		Connection conn=getConn();
		PreparedStatement pre=null;
		try {
			pre=conn.prepareStatement(sql.toString());
			for(int i=0;i<paramList.size();i++){
				Object obj=paramList.get(i);
				if(obj instanceof java.util.Date){
					Date utilDate=(Date) obj;
					java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
					obj=sqlDate;
				}
				pre.setObject(i+1, obj);
			}
			return pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			closeAll(conn, pre,null);
		}
	
	
	}
	
	public int delStus(Stus stus)throws Exception 
	{
	
		List paramList=new ArrayList();
		StringBuffer sql=new StringBuffer("delete from stus where 1=1");
	
		if(stus!=null){
			if(stus.getId()>0){
				sql.append(" and id=?");
				paramList.add(stus.getId());
			}
			if(stus.getFirstName()!=null){
				sql.append(" and first_name=?");
				paramList.add(stus.getFirstName());
			}
			if(stus.getLastName()!=null){
				sql.append(" and last_name=?");
				paramList.add(stus.getLastName());
			}
			if(stus.getSex()!=null){
				sql.append(" and sex=?");
				paramList.add(stus.getSex());
			}
		
	
		}
		Connection conn=getConn();
		PreparedStatement pre=null;
		try {
			pre=conn.prepareStatement(sql.toString());
			for(int i=0;i<paramList.size();i++){
				Object obj=paramList.get(i);
				if(obj instanceof java.util.Date){
					Date utilDate=(Date) obj;
					java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
					obj=sqlDate;
				}
				pre.setObject(i+1, obj);
			}
			return pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			closeAll(conn, pre,null);
		}
	
	
	}
	
	
}