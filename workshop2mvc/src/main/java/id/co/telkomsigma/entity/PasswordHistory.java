package id.co.telkomsigma.entity;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the PASSWORD_HISTORY database table.
 * 
 */

public class PasswordHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	private long idpassword;
	private String oldpwd;
	private Timestamp timechange;
	private String user;

	public PasswordHistory() {
	}

	public long getIdpassword() {
		return this.idpassword;
	}

	public void setIdpassword(long idpassword) {
		this.idpassword = idpassword;
	}

	public String getOldpwd() {
		return this.oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public Timestamp getTimechange() {
		return this.timechange;
	}

	public void setTimechange(Timestamp timechange) {
		this.timechange = timechange;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}