package com.springbackend.wawa.service;

import com.springbackend.wawa.model.Parkiran;

public interface ParkiranService {

	abstract Parkiran insert(Parkiran parkir) throws Exception;
	abstract Parkiran update(Parkiran parkir) throws Exception;
	abstract Parkiran getTotal(String no_plat) throws Exception;
	abstract Boolean valid(Parkiran parkir) throws Exception;
}
