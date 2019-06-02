package cn.mcandoird.stu;


public class Stu {
	private int  id;
	private String name;
	private String sex;
	public Stu(int id, String name, String sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	public Stu() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Stu [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}
	

}
