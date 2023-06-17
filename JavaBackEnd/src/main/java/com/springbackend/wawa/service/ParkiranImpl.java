package com.springbackend.wawa.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.transaction.Transactional;

import com.springbackend.wawa.dal.ParkiranDal;
import com.springbackend.wawa.model.Parkiran;
import com.springbackend.wawa.component.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ParkiranImpl implements ParkiranService {

	@Autowired
	@Qualifier("parkir_repo_hibernate")
	private ParkiranDal parkirDal;

	@Override
	public Parkiran getTotal(String no_plat) throws Exception {
		Parkiran par = null;
		try {
			Parkiran parameter = new Parkiran();
			parameter.setNoPlat(no_plat);
			Parkiran result = (Parkiran) parkirDal.valid(parameter);
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
			Date now = calendar.getTime();

			long difference_In_Time = now.getTime() - result.getTanggalMasuk().getTime();
			long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;
			long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;
			if(difference_In_Minutes > 0){
				difference_In_Hours += 1;
			}
			int totalJam = (int) difference_In_Hours;
			int totalBayar = totalJam * Constants.CHARGES;

			par = new Parkiran();
			par.setId(result.getId());
			par.setNoTransaksi(result.getNoTransaksi());
			par.setTanggalMasuk(result.getTanggalMasuk());
			par.setNoPlat(result.getNoPlat());
			par.setJenisKendaraan(result.getJenisKendaraan());
			par.setTanggalKeluar(now);
			par.setTotalJam(totalJam);
			par.setTotalPembayaran(totalBayar);
		} catch (Exception e) {
		}
		return par;
	}

	@Override
	public Parkiran insert(Parkiran parkir) throws Exception {
		String noPlat = parkir.getNoPlat().replaceAll("\\s+", "").toLowerCase();
		if (noPlat.length() < 8 && noPlat.length() > 4) {
			if (valid(parkir) == false) {
				throw new Exception("Plat No " + parkir.getNoPlat() + " sudah dalam transaksi...");
			} else {
				Date now = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(now);
				calendar.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));
				now = calendar.getTime();
				parkir.setNoTransaksi(generateDocument());
				parkir.setNoPlat(parkir.getNoPlat().toLowerCase());
				parkir.setStatusTransaksi(0);
				parkir.setTanggalMasuk(now);
				parkir.setTanggalKeluar(null);
				return parkirDal.insert(parkir);
			}
		}else {
			throw new Exception("Plat No " + parkir.getNoPlat() + " tidak valid silahkan periksa kembali...");
		}
	}

	@Override
	public Parkiran update(Parkiran parkir) throws Exception {
		if (valid(parkir) == true) {
			throw new Exception("Plat No " + parkir.getNoPlat() + " belum ada dalam transaksi...");
		} else {
			return parkirDal.update(parkir);
		}
	}

	private String generateDocument() {
		Parkiran par;
		try {
			par = parkirDal.getMaxTransaksi();
			Date sk = new Date();
			SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyy");
			String time =format1.format(sk);
			if (par != null) {
				int auto_no = Integer.valueOf(par.getNoTransaksi()) +1;
				String no = String.valueOf(auto_no);
				int noLong = no.length();
				for(int a=0;a<6-noLong;a++){
					no="0" +no;
				}
				return "Trans-"+time+"-"+ no;
			} else {
				return "Trans-"+time+"-"+"000001";
			}
		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public Boolean valid(Parkiran parkir) throws Exception {
		Parkiran par = null;
		try {
			par = (Parkiran) parkirDal.valid(parkir);
		} catch (Exception e) {
		}

		if (par != null) {
				return false;
		} else {
			return true;
		}
	}
}
