package com.threefiveninetong.mchh.core.base;

/**
 * 
 */


import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * @author xuyh
 * @date 2013-7-23下午03:26:54
 * @description 
 */
public class BaseService<P, V> {
	protected Class<P> clapp;
	protected Class<V> clavv;

	@SuppressWarnings("unchecked")
	public BaseService() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clapp = (Class) pt.getActualTypeArguments()[0];
		clavv = (Class) pt.getActualTypeArguments()[1];
	}

	public List<V> pl2vl(List<P> pl) {
		List<V> vl = new ArrayList<V>();
		for (P p : pl) {
			vl.add(po2vo(p));
		}
		return vl;
	}

	public V po2vo(P p) throws RuntimeException {
		V v;
		try {
			v = clavv.newInstance();
			BeanUtils.copyProperties(p, v);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return v;
	}

	public List<P> vl2pl(List<V> vl) {
		List<P> pl = new ArrayList<P>();
		for (V v : vl) {
			pl.add(vo2po(v));
		}
		return pl;
	}

	public P vo2po(V v) {
		P p;
		try {
			p = clapp.newInstance();
			BeanUtils.copyProperties(v, p);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return p;
	}

}
