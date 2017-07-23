package com.threefiveninetong.mchh.util;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public final class CollectionUtil {

	public static boolean isNullOrEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}

	public static boolean containsAny(Collection<?> collection, Collection<?> otherCollection) {
		return false;
	}

	public static boolean isSubCollection(Collection<?> collection, Collection<?> otherCollection) {
		return false;
	}

	public static void addAll(Collection<?> collection, Object[] array) {

	}

	public static void addAll(Collection<?> collection, Iterator<?> iterator) {

	}

	public static void addAll(Collection<?> collection, Enumeration<?> enumeration) {

	}
}
