package com.springbackend.wawa.dal;

import com.springbackend.wawa.model.Parkiran;

public interface ParkiranDal {
	abstract Parkiran getMaxTransaksi() throws Exception;
	abstract Parkiran insert(Parkiran parkir) throws Exception;
	abstract Parkiran update(Parkiran parkir) throws Exception;
	abstract Parkiran valid(Parkiran parkir) throws Exception;
}
