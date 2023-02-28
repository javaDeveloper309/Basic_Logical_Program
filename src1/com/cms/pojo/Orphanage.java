package com.cms.pojo;

public class Orphanage {
	private int oId;
	private String oName;
	private String oAddress;
	private long oMobileNo;
	private String oemail;
	private String foodNeed;

	public Orphanage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orphanage(int oId, String oName, String oAddress, long oMobileNo, String oemail, String foodNeed) {
		super();
		this.oId = oId;
		this.oName = oName;
		this.oAddress = oAddress;
		this.oMobileNo = oMobileNo;
		this.oemail = oemail;
		this.foodNeed = foodNeed;
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getoAddress() {
		return oAddress;
	}

	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}

	public long getoMobileNo() {
		return oMobileNo;
	}

	public void setoMobileNo(long oMobileNo) {
		this.oMobileNo = oMobileNo;
	}

	public String getOemail() {
		return oemail;
	}

	public void setOemail(String oemail) {
		this.oemail = oemail;
	}

	public String getFoodNeed() {
		return foodNeed;
	}

	public void setFoodNeed(String foodNeed) {
		this.foodNeed = foodNeed;
	}

	@Override
	public String toString() {
		return "Orphanage [oId=" + oId + ", oName=" + oName + ", oAddress=" + oAddress + ", oMobileNo=" + oMobileNo
				+ ", oemail=" + oemail + ", foodNeed=" + foodNeed + "]";
	}

}
