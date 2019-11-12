package com.company.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bean.City;
import com.company.dao.ICityDao;
import com.company.service.ICityService;

/**
 * @author  wl
 * @category 市业务逻辑实现类
 */
@Service
public class CityServiceImpl implements ICityService {
	@Autowired
	private ICityDao cityDao; 
	@Test
	public void test(){
		List<City> list=cityDao.findCitiesByPid("610000");
		  for (City city : list) {
			System.out.println(city.getCity());
		}
	}
	public List<City> findCitiesByPid(String provinceId) {
		List<City> list = null;
		if(provinceId!=null){
			list = cityDao.findCitiesByPid(provinceId);
		}
		return list;
	}

	public City findObject(String cityId) {
		return null;
	}

}
