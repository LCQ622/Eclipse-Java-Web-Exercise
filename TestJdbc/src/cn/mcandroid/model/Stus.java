package cn.mcandroid.model;
import java.lang.String;


public class Stus 
{

	private long id;
	private long id_updateField;
	private String firstName;
	private String firstName_updateField;
	private String lastName;
	private String lastName_updateField;
	private String sex;
	private String sex_updateField;

	public long getId()
	{
	
		return this.id;
	}
	
	public Stus setId(long id)
	{
	
		this.id=id;
		return this;
	}
	
	public long getId_updateField()
	{
	
		return this.id_updateField;
	}
	
	public Stus setId_updateField(long id_updateField)
	{
	
		this.id_updateField=id_updateField;
		return this;
	}
	
	public String getFirstName()
	{
	
		return this.firstName;
	}
	
	public Stus setFirstName(String firstName)
	{
	
		this.firstName=firstName;
		return this;
	}
	
	public String getFirstName_updateField()
	{
	
		return this.firstName_updateField;
	}
	
	public Stus setFirstName_updateField(String firstName_updateField)
	{
	
		this.firstName_updateField=firstName_updateField;
		return this;
	}
	
	public String getLastName()
	{
	
		return this.lastName;
	}
	
	public Stus setLastName(String lastName)
	{
	
		this.lastName=lastName;
		return this;
	}
	
	public String getLastName_updateField()
	{
	
		return this.lastName_updateField;
	}
	
	public Stus setLastName_updateField(String lastName_updateField)
	{
	
		this.lastName_updateField=lastName_updateField;
		return this;
	}
	
	public String getSex()
	{
	
		return this.sex;
	}
	
	public Stus setSex(String sex)
	{
	
		this.sex=sex;
		return this;
	}
	
	public String getSex_updateField()
	{
	
		return this.sex_updateField;
	}
	
	public Stus setSex_updateField(String sex_updateField)
	{
	
		this.sex_updateField=sex_updateField;
		return this;
	}
	
	public Stus(long id,String firstName,String lastName,String sex)
	{
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.sex=sex;
	
	}
	public Stus()
	{
	}

	@Override
	public String toString() {
		return "id:"+this.id+",firstName:"+this.firstName+",lastName:"+this.lastName+",sex:"+this.sex;
	}

}