package com.threefiveninetong.mchh.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class ArrayUtil {

	public static boolean isArray(Object object) {
		if (object == null) {
			return false;
		}
		return object.getClass().isArray();
	}

	public static boolean isNullOrEmpty(Object array) {
		return array == null || Array.getLength(array) == 0;
	}

	public static int getLength(Object array) {
		if (array == null) {
			return 0;
		}
		return Array.getLength(array);
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> toList(Object array) {
		if (array == null) {
			return null;
		}
		if (array instanceof Object[]) {
			Object[] objs = (Object[]) array;
			List<T> list = new ArrayList<T>();
			list.addAll((Collection<T>) Arrays.asList(objs));
			return list;
		} else {
			List<T> list = new ArrayList<T>();
			for (int i = 0, size = Array.getLength(array); i < size; i++) {
				list.add((T) Array.get(array, i));
			}
			return list;
		}
	}

	public static Object get(Object array, int index) {
		if (array == null) {
			return null;
		}
		return Array.get(array, index);
	}

	public static Object add(Object array, Object element) {
		if (array == null) {
			return null;
		} else if (element == null) {
			return array;
		}
		int arrayLength = Array.getLength(array);
		Object newArray = Array.newInstance(array.getClass().getComponentType(), arrayLength + 1);
		System.arraycopy(array, 0, newArray, 0, arrayLength);
		Array.set(newArray, arrayLength, element);
		return newArray;
	}

	public static Object addAll(Object array, Object arrayOther) {
		if (array == null) {
			return null;
		} else if (arrayOther == null) {
			return array;
		} else if (!arrayOther.getClass().isArray()) {
			return add(array, arrayOther);
		}
		int arrayLength = Array.getLength(array);
		int arrayOtherLength = Array.getLength(arrayOther);
		Object newArray = Array.newInstance(array.getClass().getComponentType(), arrayLength + arrayOtherLength);
		System.arraycopy(array, 0, newArray, 0, arrayLength);
		System.arraycopy(arrayOther, 0, newArray, arrayLength, arrayOtherLength);
		return newArray;
	}

	public static Object removeElement(Object array, Object element) {
		int index = indexOf(array, element);
		if (index == -1) {
			return array;
		}
		return remove(array, index);
	}

	public static Object remove(Object array, int index) {
		if (array == null) {
			return null;
		}
		int length = getLength(array);
		if ((index < 0) || (index >= length)) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
		}
		Object result = Array.newInstance(array.getClass().getComponentType(), length - 1);
		System.arraycopy(array, 0, result, 0, index);
		if (index < length - 1) {
			System.arraycopy(array, index + 1, result, index, length - index - 1);
		}
		return result;
	}

	public static int indexOf(Object array, Object element) {
		return indexOf(array, element, 0);
	}

	public static int indexOf(Object array, Object element, int startIndex) {
		if (array == null) {
			return -1;
		}
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (array instanceof Object[]) {
			Object[] objs = (Object[]) array;
			if (element == null) {
				for (int i = startIndex, length = objs.length; i < length; i++) {
					if (objs[i] == null) {
						return i;
					}
				}
			} else if (array.getClass().getComponentType().isInstance(element)) {
				for (int i = startIndex, length = objs.length; i < length; i++) {
					if (element.equals(objs[i])) {
						return i;
					}
				}
			}
		} else {
			if (array.getClass().isArray() && element != null) {
				String arrayTypeName = array.getClass().getComponentType().getName();
				String elementTypeName = element.getClass().getSimpleName().toLowerCase();
				if (elementTypeName.startsWith(arrayTypeName)) {
					for (int i = startIndex, length = Array.getLength(array); i < length; i++) {
						if (element.equals(Array.get(array, i))) {
							return i;
						}
					}
				}
			}
		}
		return -1;
	}

	public static int lastIndexOf(Object array, Object element) {
		return lastIndexOf(array, element, Integer.MAX_VALUE);
	}

	public static int lastIndexOf(Object array, Object element, int startIndex) {
		if (array == null) {
			return -1;
		}
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (array instanceof Object[]) {
			Object[] objs = (Object[]) array;
			int length = objs.length;
			if (startIndex >= length) {
				startIndex = length - 1;
			}
			if (element == null) {
				for (int i = startIndex; i >= 0; i--) {
					if (objs[i] == null) {
						return i;
					}
				}
			} else if (array.getClass().getComponentType().isInstance(element)) {
				for (int i = startIndex; i >= 0; i--) {
					if (element.equals(objs[i])) {
						return i;
					}
				}
			}
		} else {
			if (array.getClass().isArray() && element != null) {
				int length = Array.getLength(array);
				if (startIndex >= length) {
					startIndex = length - 1;
				}
				String arrayTypeName = array.getClass().getComponentType().getName();
				String elementTypeName = element.getClass().getSimpleName().toLowerCase();
				if (elementTypeName.startsWith(arrayTypeName)) {
					for (int i = startIndex; i >= 0; i--) {
						if (element.equals(Array.get(array, i))) {
							return i;
						}
					}
				}
			}
		}
		return -1;
	}

	public static boolean contains(Object array, Object element) {
		return indexOf(array, element) != -1;
	}

	public static boolean equals(Object array, Object arrayOther) {
		if (array == arrayOther) {
			return true;
		}
		if (array == null || arrayOther == null) {
			return false;
		}
		if (!array.getClass().getName().equals(arrayOther.getClass().getName())) {
			return false;
		}
		int length = Array.getLength(array);
		if (length != Array.getLength(arrayOther)) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			Object element = Array.get(array, i);
			Object elementOther = Array.get(arrayOther, i);
			if ((element == null || elementOther == null) && element != elementOther) {
				return false;
			}
			if (element != null && !element.equals(elementOther)) {
				return false;
			}
		}
		return true;
	}

	public static Object subarray(Object array, int startIndex) {
		if (array == null) {
			return null;
		}
		int length;
		if (startIndex < 0 || startIndex > (length = Array.getLength(array))) {
			throw new IndexOutOfBoundsException("Array index out of range: " + startIndex);
		} else if (startIndex == 0) {
			return array;
		}
		int newLength = length - startIndex;
		Object newArray = Array.newInstance(array.getClass().getComponentType(), newLength);
		System.arraycopy(array, startIndex, newArray, 0, newLength);
		return newArray;
	}

	public static Object subarray(Object array, int startIndex, int endIndex) {
		if (array == null) {
			return null;
		}
		int length;
		if (startIndex < 0) {
			throw new IndexOutOfBoundsException("Array index out of range: " + startIndex);
		} else if (startIndex > endIndex) {
			throw new IndexOutOfBoundsException("Array index out of range: " + (endIndex - startIndex));
		} else if (endIndex > (length = Array.getLength(array))) {
			throw new IndexOutOfBoundsException("Array index out of range: " + endIndex);
		} else if (startIndex == 0 && endIndex == length) {
			return array;
		}
		int newLength = endIndex - startIndex;
		Object newArray = Array.newInstance(array.getClass().getComponentType(), newLength);
		System.arraycopy(array, startIndex, newArray, 0, newLength);
		return newArray;
	}

	public static Object wrapperToPrimitive(Object[] array) {
		if (array == null) {
			return null;
		}
		int length = array.length;
		Object primitiveArray = createPrimitiveArray(array);
		if (primitiveArray == null) {
			return null;
		}
		for (int i = 0; i < length; i++) {
			Object element = array[i];
			if (element == null) {
				throw new NullPointerException();
			}
			Array.set(primitiveArray, i, element);
		}
		return primitiveArray;
	}

	public static Object wrapperToPrimitive(Object[] array, Object valueForNull) {
		if (array == null) {
			return null;
		}
		int length = array.length;
		Object primitiveArray = createPrimitiveArray(array);
		if (primitiveArray == null) {
			return null;
		}
		for (int i = 0; i < length; i++) {
			Object element = array[i];
			Array.set(primitiveArray, i, element == null ? valueForNull : element);
		}
		return primitiveArray;
	}

	public static Object primitiveToWrapper(Object array) {
		if (array == null) {
			return null;
		}
		int length = Array.getLength(array);
		Class<?> clazz = array.getClass().getComponentType();
		Object targetObject;
		// TODO: 此处可用switch改进
		if (Integer.TYPE.equals(clazz)) {
			targetObject = Array.newInstance(Integer.class, length);
		} else if (Double.TYPE.equals(clazz)) {
			targetObject = Array.newInstance(Double.class, length);
		} else if (Long.TYPE.equals(clazz)) {
			targetObject = Array.newInstance(Long.class, length);
		} else if (Short.TYPE.equals(clazz)) {
			targetObject = Array.newInstance(Short.class, length);
		} else if (Float.TYPE.equals(clazz)) {
			targetObject = Array.newInstance(Float.class, length);
		} else if (Boolean.TYPE.equals(clazz)) {
			targetObject = Array.newInstance(Boolean.class, length);
		} else if (Character.TYPE.equals(clazz)) {
			targetObject = Array.newInstance(Character.class, length);
		} else if (Byte.TYPE.equals(clazz)) {
			targetObject = Array.newInstance(Byte.class, length);
		} else {
			return null;
		}
		for (int i = 0; i < length; i++) {
			Array.set(targetObject, i, Array.get(array, i));
		}
		return targetObject;
	}

	private static Object createPrimitiveArray(Object[] array) {
		Object primitiveArray;
		// TODO: 此处可用switch改进
		if (array instanceof Integer[]) {
			primitiveArray = Array.newInstance(Integer.TYPE, array.length);
		} else if (array instanceof Double[]) {
			primitiveArray = Array.newInstance(Double.TYPE, array.length);
		} else if (array instanceof Long[]) {
			primitiveArray = Array.newInstance(Long.TYPE, array.length);
		} else if (array instanceof Short[]) {
			primitiveArray = Array.newInstance(Short.TYPE, array.length);
		} else if (array instanceof Float[]) {
			primitiveArray = Array.newInstance(Float.TYPE, array.length);
		} else if (array instanceof Boolean[]) {
			primitiveArray = Array.newInstance(Boolean.TYPE, array.length);
		} else if (array instanceof Character[]) {
			primitiveArray = Array.newInstance(Character.TYPE, array.length);
		} else if (array instanceof Byte[]) {
			primitiveArray = Array.newInstance(Byte.TYPE, array.length);
		} else {
			primitiveArray = null;
		}
		return primitiveArray;
	}
}
