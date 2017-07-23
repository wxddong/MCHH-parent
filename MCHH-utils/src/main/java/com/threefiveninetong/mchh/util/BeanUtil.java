package com.threefiveninetong.mchh.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;

/***
 * bean 工具类*
 * 
 * @author Administrator
 *
 */
public final class BeanUtil {

    public static final Map<Class<?>, Integer> commonTypeMap = new HashMap<Class<?>, Integer>();

    static {
        commonTypeMap.put(int.class, 1);
        commonTypeMap.put(double.class, 2);
        commonTypeMap.put(boolean.class, 3);
        commonTypeMap.put(long.class, 4);
        commonTypeMap.put(short.class, 5);
        commonTypeMap.put(float.class, 6);
        commonTypeMap.put(char.class, 7);
        commonTypeMap.put(byte.class, 8);

        commonTypeMap.put(Integer.class, 1);
        commonTypeMap.put(Double.class, 2);
        commonTypeMap.put(Boolean.class, 3);
        commonTypeMap.put(Long.class, 4);
        commonTypeMap.put(Short.class, 5);
        commonTypeMap.put(Float.class, 6);
        commonTypeMap.put(Character.class, 7);
        commonTypeMap.put(Byte.class, 8);
        commonTypeMap.put(String.class, 9);
        commonTypeMap.put(Date.class, 10);
        commonTypeMap.put(BigInteger.class, 11);
        commonTypeMap.put(BigDecimal.class, 12);
        commonTypeMap.put(Collection.class, 13);
        commonTypeMap.put(List.class, 14);
        commonTypeMap.put(ArrayList.class, 14);
        commonTypeMap.put(Set.class, 15);
        commonTypeMap.put(HashSet.class, 15);
        commonTypeMap.put(Map.class, 16);
        commonTypeMap.put(HashMap.class, 16);
    }

    /**
     * 判断对象是否为空
     * 
     * @param bean
     *            对象
     * @return 对象为空值或集合、数据的长度为0则返回true
     */
    public static boolean isNull(Object bean) {
        if (bean == null) {
            return true;
        }
        if (bean instanceof String) {
            String str = bean.toString();
            return str == null || str.isEmpty();
        }
        if (bean.getClass().isArray()) {
            return Array.getLength(bean) == 0;
        }
        if (bean instanceof Collection<?>) {
            return ((Collection<?>) bean).isEmpty();
        }
        if (bean instanceof Map<?, ?>) {
            return ((Map<?, ?>) bean).isEmpty();
        }
        if (bean instanceof Iterator<?>) {
            return !((Iterator<?>) bean).hasNext();
        }
        return false;
    }

    public static void setProperty(Object bean, String name, Object value) {
        Class<?> clazz = bean.getClass();
        try {
            Field field = clazz.getDeclaredField(name);
            field.setAccessible(true);
            try {
                field.set(bean, value);
            } catch (Exception e) {
                Class<?> fieldType = field.getType();
                if (value != null) {
                    Object newValue = convert(fieldType, value);
                    if (newValue != null) {
                        field.set(bean, newValue);
                        return;
                    }
                }
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将一个对象的所有属性值复制到另一具有相同属性的对象
     * 
     * @param source
     *            源对象
     * @param target
     *            目标对象
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public static void copyProperties(Object source, Object target) {
        copyProperties(source, target, null, null);
    }

    public static void copyProperties(Object source, Object target, String[] ignoreProperties) {
        copyProperties(source, target, ignoreProperties, null);
    }

    public static void copyProperties(Object source, Object target, Map<String, String> propertiesMap) {
        copyProperties(source, target, null, propertiesMap);
    }

    public static <T> T mapToBean(Map<String, Object> properties, Class<T> beanClass) {
        return mapToBean(properties, beanClass, BeanMapStyle.NULL);
    }
    
    public static Field[] getBeanFields(Class cls,Field[] fs){
        fs = (Field[]) ArrayUtils.addAll(fs, cls.getDeclaredFields());
        if(cls.getSuperclass()!=null){
            Class clsSup = cls.getSuperclass();
            fs = getBeanFields(clsSup,fs);
        }
        return fs;
    }

    @SuppressWarnings("unchecked")
    public static <T> T mapToBean(Map<String, Object> properties, Class<T> beanClass, BeanMapStyle style) {
        if (beanClass == null || properties == null) {
            return null;
        }
        Field[] beanFields = {};
        //获取类的以及其父类的字段集合
        beanFields = getBeanFields(beanClass,beanFields);
        T t = null;
        try {
            t = beanClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        switch (style) {
        case NULL:
            for (int i = 0, length = beanFields.length; i < length; i++) {
                Field beanField = beanFields[i];
                String fieldName = beanField.getName();
                beanField.setAccessible(true);
                Object value = properties.get(fieldName);
                if (value == null && beanField.getType().isPrimitive()) {
                    continue;
                }
                try {
                    beanField.set(t, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        case NESTED:
            for (int i = 0, length = beanFields.length; i < length; i++) {
                Field beanField = beanFields[i];
                String fieldName = beanField.getName();
                beanField.setAccessible(true);
                Object value = properties.get(fieldName);
                if (value == null && beanField.getType().isPrimitive()) {
                    continue;
                }
                if (value instanceof Map<?, ?>) {
                    Class<?> fieldType = beanField.getType();
                    if (ClassUtil.isCustom(fieldType)) {
                        value = mapToBean((Map) value, fieldType, style);
                    }
                }
                try {
                    beanField.set(t, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        case TOGETHER:
            for (int i = 0, length = beanFields.length; i < length; i++) {
                Field beanField = beanFields[i];
                String fieldName = beanField.getName();
                beanField.setAccessible(true);
                Class<?> fieldType = beanField.getType();
                Object value;
                if (ClassUtil.isCustom(fieldType)) {
                    value = mapToBean(properties, fieldType, fieldName);
                } else {
                    value = properties.get(fieldName);
                }
                if (value == null && beanField.getType().isPrimitive()) {
                    continue;
                }
                try {
                    beanField.set(t, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        }
        return t;
    }

    public static Map<String, Object> beanToMap(Object bean) {
        return beanToMap(bean, BeanMapStyle.NULL);
    }

    public static Map<String, Object> beanToMap(Object bean, BeanMapStyle style) {
        if (bean == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        Class<?> beanClass = bean.getClass();
        //获取类的以及其父类的字段集合
        Field[] beanFields = {};
        beanFields = getBeanFields(beanClass,beanFields);
        //Field[] beanFields = beanClass.getDeclaredFields();
        switch (style) {
        case NULL:
            for (int i = 0, length = beanFields.length; i < length; i++) {
                Field beanField = beanFields[i];
                String fieldName = beanField.getName();
                beanField.setAccessible(true);
                try {
                    Object beanValue = beanField.get(bean);
                    map.put(fieldName, beanValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        case NESTED:
            for (int i = 0, length = beanFields.length; i < length; i++) {
                Field beanField = beanFields[i];
                String fieldName = beanField.getName();
                beanField.setAccessible(true);
                try {
                    Object beanValue = beanField.get(bean);
                    if (ClassUtil.isCustom(beanValue.getClass())) {
                        beanValue = beanToMap(beanValue, style);
                    }
                    map.put(fieldName, beanValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        case TOGETHER:
            for (int i = 0, length = beanFields.length; i < length; i++) {
                Field beanField = beanFields[i];
                String fieldName = beanField.getName();
                beanField.setAccessible(true);
                try {
                    Object beanValue = beanField.get(bean);
                    if (ClassUtil.isCustom(beanValue.getClass())) {
                        Map<String, Object> childMap = beanToMap(beanValue, style);
                        Map<String, Object> childNewMap = new HashMap<String, Object>();
                        for (Entry<String, Object> entry : childMap.entrySet()) {
                            String key = fieldName + "." + entry.getKey();
                            childNewMap.put(key, entry.getValue());
                        }
                        map.putAll(childNewMap);
                    } else {
                        map.put(fieldName, beanValue);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        }
        return map;
    }

    public static String beanToString(Object bean) {
        return beanToString(bean, BeanStringStyle.DEFAULT);
    }

    public static String beanToString(Object bean, BeanStringStyle style) {
        if (bean == null) {
            return null;
        }
        Class<?> clazz = bean.getClass();
        if (!ClassUtil.isCustom(clazz)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        switch (style) {
        case DEFAULT:
            stringBuffer.append(clazz.getName() + "[");
            stringBuffer.append(BeanStringStyle.beanToString(bean));
            stringBuffer.append("]");
            break;
        case FORMAT:
            stringBuffer.append(clazz.getName() + "[\r\n");
            stringBuffer.append(BeanStringStyle.beanToString(bean, 0));
            stringBuffer.append("]");
            break;
        case FORM:
            stringBuffer.append(BeanStringStyle.beanToString(bean, null));
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            break;
        }
        return stringBuffer.toString();
    }

    private static void copyProperties(Object source, Object target, String[] ignoreProperties,
            Map<String, String> propertiesMap) {
        if (source == null || target == null) {
            return;
        }
        Class<?> sourceClass = source.getClass();
        Class<?> tarClass = target.getClass();
        Field[] tarFields = tarClass.getDeclaredFields();

        fieldFor: for (int i = 0, length = tarFields.length; i < length; i++) {
            Field tarField = tarFields[i];
            String fieldName = tarField.getName();
            if (ignoreProperties != null) {
                for (String ignoreProperty : ignoreProperties) {
                    if (fieldName.equals(ignoreProperty)) {
                        continue fieldFor;
                    }
                }
            } else if (propertiesMap != null) {
                String fieldMapName = propertiesMap.get(fieldName);
                if (fieldMapName != null) {
                    fieldName = fieldMapName;
                }
            }
            try {
                Field sourceField = sourceClass.getDeclaredField(fieldName);
                sourceField.setAccessible(true);
                tarField.setAccessible(true);
                Object sourceValue = sourceField.get(source);
                tarField.set(target, sourceValue);
            } catch (NoSuchFieldException e) {
                continue;
            } catch (Exception e) {
                throw new RuntimeException("Copy the property failed.", e);
            }
        }
    }

    private static Object convert(Class<?> paramClass, Object value) {
        if (paramClass == null || value == null) {
            return null;
        }
        Object newValue = null;
        String valueStr = value.toString();
        Integer index = commonTypeMap.get(paramClass);
        if (index != null) {
            switch (index) {
            case 1:
                newValue = NumberUtil.toInt(valueStr);
                break;
            case 2:
                newValue = NumberUtil.toDouble(valueStr);
                break;
            case 3:
                newValue = Boolean.parseBoolean(valueStr);
                break;
            case 4:
                newValue = NumberUtil.toLong(valueStr);
                break;
            case 5:
                newValue = NumberUtil.toShort(valueStr);
                break;
            case 6:
                newValue = NumberUtil.toFloat(valueStr);
                break;
            case 7:
                newValue = valueStr.charAt(0);
                break;
            case 8:
                newValue = Byte.parseByte(valueStr);
                break;
            case 9:
                newValue = valueStr;
                break;
            case 10:
                newValue = DateUtil.stringToDate(valueStr);
                break;
            case 11:
                newValue = NumberUtil.toBigInteger(valueStr);
                break;
            case 12:
                newValue = NumberUtil.toBigDecimal(valueStr);
                break;
            default:
                break;
            }
        }
        return newValue;
    }

    private static <T> T mapToBean(Map<String, Object> properties, Class<T> beanClass, String childBeanName) {
        Field[] beanFields = beanClass.getDeclaredFields();
        T t = null;
        try {
            t = beanClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (int i = 0, length = beanFields.length; i < length; i++) {
            Field beanField = beanFields[i];
            String fieldName = beanField.getName();
            beanField.setAccessible(true);
            Class<?> fieldType = beanField.getType();
            Object value;
            if (ClassUtil.isCustom(fieldType)) {
                value = mapToBean(properties, fieldType, childBeanName + "." + fieldName);
            } else {
                value = properties.get(childBeanName + "." + fieldName);
            }
            if (value == null && beanField.getType().isPrimitive()) {
                continue;
            }
            try {
                beanField.set(t, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    /**
     * 封装（拷贝）对象列表.
     * 
     * @param cls
     *            封装（拷贝）类
     * @param list
     *            被封装的对象列表
     * @param <T>
     *            T
     * @return List<T>
     */
    public static <T> List<T> wrapList(Class<T> cls, List<?> list) {
        List<T> newList = new ArrayList<T>(list.size());
        for (int i = 0; i < list.size(); i++) {

            T newObject;
            try {
                newObject = cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException("can't instance class[" + cls.getName() + "]", e);
            }
            try {
                org.apache.commons.beanutils.BeanUtils.copyProperties(newObject, list.get(i));
            } catch (Exception e) {
                throw new RuntimeException("can't copyProperties class[" + cls.getName() + "]", e);
            }
            newList.add(newObject);
        }
        return newList;
    }
    
    public static String generateOrderNo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date()) + StringUtil.valueOf((int)(Math.random()*89)+10);
	}
}
