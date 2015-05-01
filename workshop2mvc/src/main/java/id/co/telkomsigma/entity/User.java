package id.co.telkomsigma.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private long iduser;
	private String password;
	private BigDecimal saldo;
	private String username;
	private List<LoginHistory> loginHistories;
	private List<OrderHistory> orderHistories;
	private List<PasswordHistory> passwordHistories;
	private List<TransaksiSaham> transaksiSahams;

	public User() {
	}

	public long getIduser() {
		return this.iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<LoginHistory> getLoginHistories() {
		return this.loginHistories;
	}

	public void setLoginHistories(List<LoginHistory> loginHistories) {
		this.loginHistories = loginHistories;
	}

	public LoginHistory removeLoginHistory(LoginHistory loginHistory) {
		getLoginHistories().remove(loginHistory);
		loginHistory.setUser(null);

		return loginHistory;
	}

	public List<OrderHistory> getOrderHistories() {
		return this.orderHistories;
	}

	public void setOrderHistories(List<OrderHistory> orderHistories) {
		this.orderHistories = orderHistories;
	}

	public OrderHistory addOrderHistory(OrderHistory orderHistory) {
		getOrderHistories().add(orderHistory);
		orderHistory.setUser(this);

		return orderHistory;
	}

	public OrderHistory removeOrderHistory(OrderHistory orderHistory) {
		getOrderHistories().remove(orderHistory);
		orderHistory.setUser(null);

		return orderHistory;
	}

	public List<PasswordHistory> getPasswordHistories() {
		return this.passwordHistories;
	}

	public void setPasswordHistories(List<PasswordHistory> passwordHistories) {
		this.passwordHistories = passwordHistories;
	}

	public PasswordHistory removePasswordHistory(PasswordHistory passwordHistory) {
		getPasswordHistories().remove(passwordHistory);
		passwordHistory.setUser(null);

		return passwordHistory;
	}

	public List<TransaksiSaham> getTransaksiSahams() {
		return this.transaksiSahams;
	}

	public void setTransaksiSahams(List<TransaksiSaham> transaksiSahams) {
		this.transaksiSahams = transaksiSahams;
	}

	public TransaksiSaham addTransaksiSaham(TransaksiSaham transaksiSaham) {
		getTransaksiSahams().add(transaksiSaham);
		transaksiSaham.setUser(this);

		return transaksiSaham;
	}

	public TransaksiSaham removeTransaksiSaham(TransaksiSaham transaksiSaham) {
		getTransaksiSahams().remove(transaksiSaham);
		transaksiSaham.setUser(null);

		return transaksiSaham;
	}

}