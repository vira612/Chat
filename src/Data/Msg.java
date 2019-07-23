package Data;


import java.util.List;

public class Msg {
	
	int mid;
	String msg;
	String key;

	
	public Msg(int mid,String msg,String key) 
	{
		this.msg=msg;
		this.key=key;
		this.mid=mid;
		
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	
	


	
	

}

