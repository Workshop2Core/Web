package id.co.telkomsigma.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ORDER_HISTORY database table.
 * 
 */
public class OrderHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	private long idorder;
	private Date dateorder;
	private BigDecimal idcounterpart;
	private String jenistransaksi;
	private BigDecimal lot;
	private BigDecimal price;
	private String status;
	private Saham saham;
	private User user;

	public OrderHistory() {
	}

	public long getIdorder() {
		return this.idorder;
	}

	public void setIdorder(long idorder) {
		this.idorder = idorder;
	}

	public Date getDateorder() {
		return this.dateorder;
	}

	public void setDateorder(Date dateorder) {
		this.dateorder = dateorder;
	}

	public BigDecimal getIdcounterpart() {
		return this.idcounterpart;
	}

	public void setIdcounterpart(BigDecimal idcounterpart) {
		this.idcounterpart = idcounterpart;
	}

	public String getJenistransaksi() {
		return this.jenistransaksi;
	}

	public void setJenistransaksi(String jenistransaksi) {
		this.jenistransaksi = jenistransaksi;
	}

	public BigDecimal getLot() {
		return this.lot;
	}

	public void setLot(BigDecimal lot) {
		this.lot = lot;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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