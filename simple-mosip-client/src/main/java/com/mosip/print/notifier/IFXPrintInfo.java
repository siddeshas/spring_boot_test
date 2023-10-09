package com.mosip.print.notifier;





public class IFXPrintInfo {
  
	private Long uin;
    private String name;
    private String dob;
    private String gender;
    private String address;
    private String photo;
    private String qrcode;
    private int printStatus;

    
    public IFXPrintInfo(Long uin, String name, String dob, String gender, String address, String photo, String qrcode,
            int printStatus) {
        this.uin = uin;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.photo = photo;
        this.qrcode = qrcode;
        this.printStatus = printStatus;
    }


    public IFXPrintInfo() {
    }
    public Long getUin() {
        return uin;
    }
    public String getName() {
        return name;
    }
    public String getDob() {
        return dob;
    }
    public String getGender() {
        return gender;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoto() {
        return photo;
    }
    public String getQrcode() {
        return qrcode;
    }
    public int getPrintStatus() {
        return printStatus;
    }


	public void setUin(Long uin) {
		this.uin = uin;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}


	public void setPrintStatus(int printStatus) {
		this.printStatus = printStatus;
	}


	@Override
	public String toString() {
		return "IFXPrintInfo [uin=" + uin + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", address="
				+ address + ", photo=" + photo + ", qrcode=" + qrcode + ", printStatus=" + printStatus + "]";
	}
}
