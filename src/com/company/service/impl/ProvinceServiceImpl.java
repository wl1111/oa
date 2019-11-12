package com.company.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bean.Province;
import com.company.dao.IProvinceDao;
import com.company.service.IProvinceService;

/**
 * @author  wl
 * @category 省业务逻辑实现类
 */
@Service
public class ProvinceServiceImpl implements IProvinceService {
	@Autowired
	private IProvinceDao provinceDao;
	
	@Test
	public void test(){
		List<Province> list=provinceDao.findAll();
		 for (Province province : list) {
			System.out.println(province.getProvince());
		}
	}
	
	public List<Province> findAll() {
		return provinceDao.findAll();
	}

	public Province findObject(String provinceId) {
		return null;
	}

}
