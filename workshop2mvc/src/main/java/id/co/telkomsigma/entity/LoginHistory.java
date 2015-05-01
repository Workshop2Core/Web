package id.co.telkomsigma.entity;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the LOGIN_HISTORY database table.
 * 
 */
public class LoginHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	private long idlogin;
	private Timestamp logintime;
	private String user;

	public LoginHistory() {
	}

	public long getIdlogin() {
		return this.idlogin;
	}

	public void setIdlogin(long idlogin) {
		this.idlogin = idlogin;
	}

	public Timestamp getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}