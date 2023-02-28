package com.cms.pojo;

public class Restaurant {
	private int rId;
	private String rName;
	private String rAddress;
	private long rMobileNo;
	private String email;
	private String foodAvalability;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int rId, String rName, String rAddress, long rMobileNo, String email, String foodAvalability) {
		super();
		this.rId = rId;
		this.rName = rName;
		this.rAddress = rAddress;
		this.rMobileNo = rMobileNo;
		this.email = email;
		this.foodAvalability = foodAvalability;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getrAddress() {
		return rAddress;
	}

	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}

	public long getrMobileNo() {
		return rMobileNo;
	}

	public void setrMobileNo(long rMobileNo) {
		this.rMobileNo = rMobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoodAvalability() {
		return foodAvalability;
	}

	public void setFoodAvalability(String foodAvalability) {
		this.foodAvalability = foodAvalability;
	}

	@Override
	public String toString() {
		return "Restaurant [rId=" + rId + ", rName=" + rName + ", rAddress=" + rAddress + ", rMobileNo=" + rMobileNo
				+ ", email=" + email + ", foodAvalability=" + foodAvalability + "]";
	}

}
