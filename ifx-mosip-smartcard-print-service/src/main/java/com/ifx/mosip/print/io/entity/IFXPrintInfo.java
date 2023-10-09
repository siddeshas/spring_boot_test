package com.ifx.mosip.print.io.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ifxprintinfo")
public class IFXPrintInfo {
  
    @Id
	private Long uin;
    @Column(name = "name")
    private String name;
    @Column(name = "dob")
    private String dob;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "photo")
    private String photo;
    @Column(name = "qrcode")
    private String qrcode;
    @Column(name = "printstatus")
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
