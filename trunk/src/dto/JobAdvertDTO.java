package dto;



public class JobAdvertDTO implements PropDTO{
	
	private int Id=0;
	private String adDesc;
	private String cmpnyDesc;

	public String getAdDesc() {
		return adDesc;
	}
	public void setAdDesc(String adDesc) {
		this.adDesc = adDesc;
	}
	public String getCmpnyDesc() {
		return cmpnyDesc;
	}
	public void setCmpnyDesc(String cmpnyDesc) {
		this.cmpnyDesc = cmpnyDesc;
	}
	@Override
	public int getId() {
		return Id;
	}

	@Override
	public void setId(int id) {
		this.Id = id;
	}

	public String toString(){
		return "\n#id:"+Id+"|desc:"+adDesc+"|cmpnyDesc:"+cmpnyDesc;
	}

}
