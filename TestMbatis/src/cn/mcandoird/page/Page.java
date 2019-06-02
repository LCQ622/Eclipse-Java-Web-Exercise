package cn.mcandoird.page;

import java.util.List;

public class Page {
	private int pageSize;//ÿҳ��ʾ����
	private int pageNum;//��ǰҳ��
	private int total ;//��ҳ��
	private List<?>list;//��ǰҳ��ʾ������
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public Page(int pageSize, int pageNum, int total, List<?> list) {
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.total = total;
		this.list = list;
	}
	public Page() {
	}
	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", pageNum=" + pageNum + ", total=" + total + ", list=" + list + "]";
	}
	
	
	
	
	

}
