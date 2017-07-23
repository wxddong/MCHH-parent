package com.threefiveninetong.mchh.core.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public enum BeanMapStyle {

    NULL, NESTED, TOGETHER;

    static Map<String, Object> beanToMap(Object bean) {
        Map<String, Object> map = new HashMap<String, Object>();
        Class<?> beanClass = bean.getClass();
        Field[] beanFields = beanClass.getDeclaredFields();

        for (int i = 0, length = beanFields.length; i < length; i++) {
            Field beanField = beanFields[i];
            beanField.setAccessible(true);
            String fieldName = beanField.getName();

            if (!ClassUtil.hasGetSetMethod(beanClass, fieldName, beanField.getType())) {
                continue;
            }
            Object fieldValue;
            try {
                fieldValue = beanField.get(bean);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (fieldValue != null) {
                map.put(fieldName, fieldValue);
            }
        }
        return map;
    }

    static Map<String, Object> beanToMapByNested(Object bean) {
        Map<String, Object> map = new HashMap<String, Object>();
        Class<?> beanClass = bean.getClass();
        Field[] beanFields = beanClass.getDeclaredFields();

        for (int i = 0, length = beanFields.length; i < length; i++) {
            Field beanField = beanFields[i];
            beanField.setAccessible(true);
            String fieldName = beanField.getName();

            if (!ClassUtil.hasGetSetMethod(beanClass, fieldName, beanField.getType())) {
                continue;
            }
            Object fieldValue;
            try {
                fieldValue = beanField.get(bean);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (fieldValue != null) {
                fieldToMapByNested(map, fieldName, fieldValue);
            }
        }
        return map;
    }

    static Map<String, Object> beanToMapByTogether(Object bean, String childBeanName) {
        Map<String, Object> map = new HashMap<String, Object>();
        Class<?> beanClass = bean.getClass();
        Field[] beanFields = beanClass.getDeclaredFields();
        for (int i = 0, length = beanFields.length; i < length; i++) {
            Field beanField = beanFields[i];
            beanField.setAccessible(true);
            String fieldName = beanField.getName();

            if (!ClassUtil.hasGetSetMethod(beanClass, fieldName, beanField.getType())) {
                continue;
            }
            if (childBeanName != null) {
                fieldName = childBeanName + fieldName;
            }
            Object fieldValue;
            try {
                fieldValue = beanField.get(bean);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (fieldValue != null) {
                fieldToMapByTogether(map, fieldName, fieldValue);
            }
        }
        return map;
    }

    @SuppressWarnings("unchecked")
    private static void fieldToMapByNested(Map<String, Object> map, String fieldName, Object fieldValue) {
        if (fieldValue == null) {
            return;
        }
        Class<?> fieldType = fieldValue.getClass();
        Integer index = BeanUtil.commonTypeMap.get(fieldType);
        if (index != null) {
            switch (index) {
            case 13:
            case 14:
            case 15:
                Collection<?> collection = (Collection<?>) fieldValue;
                Collection<Object> newCollection = null;
                try {
                    newCollection = (Collection<Object>) fieldType.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
                for (Object obj : collection) {
                    if (ClassUtil.isCustom(obj.getClass())) {
                        newCollection.add(beanToMapByNested(obj));
                    } else {
                        newCollection.add(obj);
                    }
                }
                fieldValue = newCollection;
                break;
            case 16:
                Map<?, Object> fieldMap = (Map<?, Object>) fieldValue;
                for (Entry<?, Object> entry : fieldMap.entrySet()) {
                    Object fieldEntryValue = entry.getValue();
                    if (fieldEntryValue != null && ClassUtil.isCustom(fieldEntryValue.getClass())) {
                        fieldEntryValue = beanToMapByNested(fieldEntryValue);
                        entry.setValue(fieldEntryValue);
                    }
                }
                break;
            }
        } else if (ClassUtil.isCustom(fieldType)) {
            fieldValue = beanToMapByNested(fieldValue);
        } else if (fieldType.isArray()) {
            for (int i = 0, length = Array.getLength(fieldValue); i < length; i++) {
                Object obj = Array.get(fieldValue, i);
                if (obj != null && ClassUtil.isCustom(obj.getClass())) {
                    obj = beanToMapByNested(obj);
                }
            }
        }
        map.put(fieldName, fieldValue);
    }

    @SuppressWarnings("unchecked")
    private static void fieldToMapByTogether(Map<String, Object> map, String fieldName, Object fieldValue) {
        if (fieldValue == null) {
            return;
        }
        Class<?> fieldType = fieldValue.getClass();
        Integer index = BeanUtil.commonTypeMap.get(fieldType);
        if (index != null) {
            switch (index) {
            case 13:
            case 14:
            case 15:
                arrayFieldToMap(map, fieldName, ((Collection<?>) fieldValue).toArray());
                break;
            case 16:
                Map<?, Object> fieldMap = (Map<?, Object>) fieldValue;
                for (Entry<?, Object> entry : fieldMap.entrySet()) {
                    fieldToMapByTogether(map, fieldName + "['" + entry.getKey().toString() + "']", entry.getValue());
                }
                break;
            default:
                map.put(fieldName, fieldValue);
                break;
            }
        } else if (ClassUtil.isCustom(fieldType)) {
            map.putAll(beanToMapByTogether(fieldValue, fieldName + "."));
        } else if (fieldType.isArray()) {
            arrayFieldToMap(map, fieldName, ((Collection<?>) fieldValue).toArray());
        } else {
            map.put(fieldName, fieldValue);
        }
    }

    private static void arrayFieldToMap(Map<String, Object> map, String fieldName, Object fieldValue) {
        for (int i = 0, length = Array.getLength(fieldValue); i < length; i++) {
            Object obj = Array.get(fieldValue, i);
            fieldToMapByTogether(map, fieldName + "[" + i + "]", obj);
        }
    }
}
