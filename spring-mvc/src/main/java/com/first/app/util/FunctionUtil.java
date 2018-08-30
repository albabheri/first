/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.first.app.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author FathanHaykel
 */
public class FunctionUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object getGenderName(Integer genderId, CrudRepository clas) {
		return clas.findOne(genderId);
	}

	@SuppressWarnings("rawtypes")
	public static List getListMap(List list, Object... cols) {
		List<Map<String, Object>> listData = new ArrayList<>();
		for (Object o : list) {
			Object[] oo = (Object[]) o;
			Map<String, Object> data = new LinkedHashMap<>();

			for (int i = 0; i < cols.length; i++) {
				data.put(cols[i].toString(), oo[i]);
			}
			listData.add(data);
		}
		return listData;
	}

	@SuppressWarnings("rawtypes")
	public static List getListMapLOV(List list) {
		return getListMap(list, "KODE", "DESKRIPSI");
	}

	@SuppressWarnings("rawtypes")
	public static List getListMapKelurahan(List list) {
		return getListMap(list, "KODE", "DESKRIPSI", "KODEPOS");
	}

}
