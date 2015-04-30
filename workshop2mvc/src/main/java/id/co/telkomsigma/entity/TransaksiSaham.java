package id.co.telkomsigma.entity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the TRANSAKSI_SAHAM database table.
 * 
 */
public class TransaksiSaham implements Serializable {
	private static final long serialVersionUID = 1L;
	private long idtransaksi;
	private BigDecimal lot;
	private Saham saham;
	private User user;

	public TransaksiSaham() {
	}

	public long getIdtransaksi() {
		return this.idtransaksi;
	}

	public void setIdtransaksi(long idtransaksi) {
		this.idtransaksi = idtransaksi;
	}

	public BigDecimal getLot() {
		return this.lot;
	}

	public void setLot(BigDecimal lot) {
		this.lot = lot;
	}

	public Saham getSaham() {
		return this.saham;
	}

	public void setSaham(Saham saham) {
		this.saham = saham;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}