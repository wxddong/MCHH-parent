package com.threefiveninetong.mchh.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

public enum BeanStringStyle {

    DEFAULT, FORMAT, FORM;

    static StringBuffer beanToString(Object bean) {
        return beanToString(bean, -1);
    }

    static StringBuffer beanToString(Object bean, int level) {
        if (level != -1) {
            level++;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Class<?> beanClass = bean.getClass();
        Field[] beanFields = beanClass.getDeclaredFields();
        for (int i = 0, length = beanFields.length; i < length; i++) {
            boolean isLast = i == length - 1;
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
                fieldToString(stringBuffer, fieldName, fieldValue, level, isLast);
            }
        }
        return stringBuffer;
    }

    static StringBuffer beanToString(Object bean, String childBeanName) {
        StringBuffer stringBuffer = new StringBuffer();
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
                fieldToString(stringBuffer, fieldName, fieldValue);
            }
        }
        return stringBuffer;
    }

    private static void fieldToString(StringBuffer stringBuffer, String fieldName, Object fieldValue, int level,
            boolean isLast) {
        if (fieldValue == null) {
            return;
        }
        Class<?> fieldType = fieldValue.getClass();
        Integer index = BeanUtil.commonTypeMap.get(fieldType);
        if (index != null) {
            switch (index) {
            case 10:
                writeLine(stringBuffer, level,
                        fieldName + "=" + DateUtil.dateToString((Date) fieldValue, DateStyle.YYYY_MM_DD_HH_MM_SS),
                        isLast);
                break;
            case 13:
            case 14:
            case 15:
                arrayFieldToString(stringBuffer, fieldName, ((Collection<?>) fieldValue).toArray(), level, isLast);
                break;
            case 16:
                Map<?, ?> map = (Map<?, ?>) fieldValue;
                writeLine(stringBuffer, level, fieldName + "={", true);
                for (Entry<?, ?> entry : map.entrySet()) {
                    fieldToString(stringBuffer, entry.getKey().toString(), entry.getValue(),
                            level != -1 ? level + 1 : level, isLast);
                }
                writeLine(stringBuffer, level, "}", isLast);
                break;
            default:
                if (fieldName != null) {
                    writeLine(stringBuffer, level, fieldName + "=" + fieldValue, isLast);
                } else {
                    writeLine(stringBuffer, level, fieldValue, isLast);
                }
                break;
            }
        } else if (ClassUtil.isCustom(fieldType)) {
            if (fieldName != null) {
                writeLine(stringBuffer, level, fieldName + "={", true);
            } else {
                writeLine(stringBuffer, level, "{", true);
            }
            stringBuffer.append(beanToString(fieldValue, level));
            writeLine(stringBuffer, level, "}", isLast);
        } else if (fieldType.isArray()) {
            arrayFieldToString(stringBuffer, fieldName, fieldValue, level, isLast);
        } else {
            writeLine(stringBuffer, level, fieldName + "=" + fieldValue, isLast);
        }
    }

    private static void fieldToString(StringBuffer stringBuffer, String fieldName, Object fieldValue) {
        if (fieldValue == null) {
            return;
        }
        Class<?> fieldType = fieldValue.getClass();
        Integer index = BeanUtil.commonTypeMap.get(fieldType);
        if (index != null) {
            switch (index) {
            case 10:
                stringBuffer.append(fieldName).append("=")
                        .append(DateUtil.dateToString((Date) fieldValue, DateStyle.YYYY_MM_DD_HH_MM_SS)).append("&");
                break;
            case 13:
            case 14:
            case 15:
                arrayFieldToString(stringBuffer, fieldName, ((Collection<?>) fieldValue).toArray());
                break;
            case 16:
                Map<?, ?> map = (Map<?, ?>) fieldValue;
                for (Entry<?, ?> entry : map.entrySet()) {
                    fieldToString(stringBuffer, fieldName + "['" + entry.getKey().toString() + "']", entry.getValue());
                }
                break;
            default:
                stringBuffer.append(fieldName).append("=").append(fieldValue).append("&");
                break;
            }
        } else if (ClassUtil.isCustom(fieldType)) {
            stringBuffer.append(beanToString(fieldValue, fieldName + "."));
        } else if (fieldType.isArray()) {
            arrayFieldToString(stringBuffer, fieldName, fieldValue);
        } else {
            stringBuffer.append(fieldName).append("=").append(fieldValue).append("&");
        }
    }

    private static void arrayFieldToString(StringBuffer stringBuffer, String fieldName, Object fieldValue, int level,
            boolean isLast) {
        if (fieldName != null) {
            writeLine(stringBuffer, level, fieldName + "={", true);
        } else {
            writeLine(stringBuffer, level, "{", true);
        }
        for (int i = 0, length = Array.getLength(fieldValue); i < length; i++) {
            Object obj = Array.get(fieldValue, i);
            fieldToString(stringBuffer, null, obj, level != -1 ? level + 1 : level, i == length - 1);
        }
        writeLine(stringBuffer, level, "}", isLast);
    }

    private static void arrayFieldToString(StringBuffer stringBuffer, String fieldName, Object fieldValue) {
        for (int i = 0, length = Array.getLength(fieldValue); i < length; i++) {
            Object obj = Array.get(fieldValue, i);
            fieldToString(stringBuffer, fieldName + "[" + i + "]", obj);
        }
    }

    private static void writeLine(StringBuffer stringBuffer, int level, Object value, boolean isLast) {
        for (int i = 0; i < level; i++) {
            stringBuffer.append("\t");
        }
        stringBuffer.append(value);
        if (isLast) {
            if (level != -1) {
                stringBuffer.append("\r\n");
            }
        } else {
            if (level != -1) {
                stringBuffer.append(",\r\n");
            } else {
                stringBuffer.append(",");
            }
        }
    }
}
