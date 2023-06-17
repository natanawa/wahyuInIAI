package com.springbackend.wawa.dal;

import java.util.List;

import javax.persistence.Query;

import com.springbackend.wawa.model.Parkiran;
import org.springframework.stereotype.Repository;

@Repository("parkir_repo_hibernate")
public class ParkiranImpl extends BaseHibernate implements ParkiranDal {

	@Override
	public Parkiran valid(Parkiran parkir) throws Exception {
		Query q = em.createQuery(" from Parkiran where no_plat = :noParam and status_transaksi = 0").setParameter("noParam",
				parkir.getNoPlat().toLowerCase());
		q.setMaxResults(1);
		Parkiran result = new Parkiran();
		result = (Parkiran) q.getSingleResult();
		return result;
	}

	@Override
	public Parkiran getMaxTransaksi() {
		Parkiran parkir = new Parkiran();
		Query q = em.createNativeQuery("Select MAX(right(no_transaksi,5))as noTransaksi from Parkiran");
		List<Integer> Result = q.getResultList();
		if(Result.get(0) == null) {
			return null;
		}
		parkir.setNoTransaksi(String.valueOf(Result.get(0)));
		return parkir;
	}

	@Override
	public Parkiran insert(Parkiran parkir) throws Exception {
		em.persist(parkir);
		return parkir;
	}

	@Override
	public Parkiran update(Parkiran parkir) throws Exception {
		Query q = em.createQuery(" from Parkiran where id = :idParam");
		q.setParameter("idParam", parkir.getId());
		Parkiran updateDataparkir = new Parkiran();
		updateDataparkir = (Parkiran) q.getSingleResult();
		updateDataparkir.setTanggalKeluar(parkir.getTanggalKeluar());
		updateDataparkir.setStatusTransaksi(1);
		updateDataparkir.setTotalJam(parkir.getTotalJam());
		updateDataparkir.setTotalPembayaran(parkir.getTotalPembayaran());
		updateDataparkir.setTanggalKeluar(parkir.getTanggalKeluar());
		em.merge(updateDataparkir);
		return updateDataparkir;
	}
}
