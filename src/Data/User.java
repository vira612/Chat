package Data;


import java.util.List;

public class User {
	Integer id;
	String name;
	String email;
	String pwd;
	
	
	public User(Integer id,String name,String email,String pwd) 
	{
		this.id=id;
		//this.msg=msg;
		this.name=name;
		this.email=email;
		this.pwd=pwd;
	}
	
	
//	public List<Msg> getMsg() {
//		return msg;
//	}
//	public void setMsg(List<Msg> msg) {
//		this.msg = msg;
//	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}