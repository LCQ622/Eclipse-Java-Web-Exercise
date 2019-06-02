package cn.mcandoird.mapper;

import java.util.List;

import cn.mcandoird.pojo.Bill;

public interface BillMapper {
	/**
	 * 该方法用于获取所有的记录
	 * @return
	 */
	List<Bill> getAll();
	
}
