package com.springbackend.wawa.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "parkiran")
public class Parkiran {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String noTransaksi;
	private int statusTransaksi;
	private String noPlat;
	private String jenisKendaraan;
	private Date tanggalMasuk;
	private Date tanggalKeluar;
	private int totalJam;
	private int totalPembayaran;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNoTransaksi() {
		return noTransaksi;
	}
	public void setNoTransaksi(String noTransaksi) {
		this.noTransaksi = noTransaksi;
	}

	public int getStatusTransaksi() {
		return statusTransaksi;
	}
	public void setStatusTransaksi(int statusTransaksi) {
		this.statusTransaksi = statusTransaksi;
	}

	public String getNoPlat() {
		return noPlat;
	}
	public void setNoPlat(String noPlat) {
		this.noPlat = noPlat;
	}

	public String getJenisKendaraan() {
		return jenisKendaraan;
	}
	public void setJenisKendaraan(String jenisKendaraan) {
		this.jenisKendaraan = jenisKendaraan;
	}

	public Date getTanggalMasuk() {
		return tanggalMasuk;
	}
	public void setTanggalMasuk(Date tanggalMasuk) {
		this.tanggalMasuk = tanggalMasuk;
	}

	public Date getTanggalKeluar() {
		return tanggalKeluar;
	}
	public void setTanggalKeluar(Date tanggalKeluar) {
		this.tanggalKeluar = tanggalKeluar;
	}

	public int getTotalJam() {
		return totalJam;
	}
	public void setTotalJam(int totalJam) {
		this.totalJam = totalJam;
	}

	public int getTotalPembayaran() {
		return totalPembayaran;
	}
	public void setTotalPembayaran(int totalPembayaran) {
		this.totalPembayaran = totalPembayaran;
	}
}
