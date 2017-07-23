package com.threefiveninetong.mchh.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ClassUtil {

    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap<Class<?>, Class<?>>(8);

    private static final Map<Class<?>, Class<?>> primitiveWrapperMap = new HashMap<Class<?>, Class<?>>(8);

    static {
        wrapperPrimitiveMap.put(Boolean.class, Boolean.TYPE);
        wrapperPrimitiveMap.put(Byte.class, Byte.TYPE);
        wrapperPrimitiveMap.put(Character.class, Character.TYPE);
        wrapperPrimitiveMap.put(Double.class, Double.TYPE);
        wrapperPrimitiveMap.put(Float.class, Float.TYPE);
        wrapperPrimitiveMap.put(Integer.class, Integer.TYPE);
        wrapperPrimitiveMap.put(Short.class, Short.TYPE);

        for (Map.Entry<Class<?>, Class<?>> entry : wrapperPrimitiveMap.entrySet()) {
            primitiveWrapperMap.put(entry.getValue(), entry.getKey());
        }
    }

    public static boolean isWrapper(Class<?> clazz) {
        return wrapperPrimitiveMap.containsKey(clazz);
    }

    public static boolean isPrimitiveOrWrapper(Class<?> clazz) {
        if (clazz == null) {
            return false;
        }
        return clazz.isPrimitive() || isWrapper(clazz);
    }

    public static boolean isPrimitiveArray(Class<?> clazz) {
        if (clazz == null) {
            return false;
        }
        return clazz.isArray() && clazz.getComponentType().isPrimitive();
    }

    public static boolean isWrapperArray(Class<?> clazz) {
        if (clazz == null) {
            return false;
        }
        return clazz.isArray() && isWrapper(clazz.getComponentType());
    }

    public static boolean isCustom(Class<?> clazz) {
        return clazz != null && clazz.getClassLoader() != null;
    }

    public static boolean isAssignable(Class<?> clazz, Class<?> toClass) {
        if (toClass == null) {
            return false;
        }
        if (clazz == null) {
            return (!(toClass.isPrimitive()));
        }

        if ((clazz.isPrimitive()) && (!(toClass.isPrimitive()))) {
            clazz = primitiveToWrapper(clazz);
            if (clazz == null) {
                return false;
            }
        }
        if ((toClass.isPrimitive()) && (!(clazz.isPrimitive()))) {
            clazz = wrapperToPrimitive(clazz);
            if (clazz == null) {
                return false;
            }
        }
        if (clazz.equals(toClass)) {
            return true;
        }
        if (clazz.isPrimitive()) {
            if (!(toClass.isPrimitive())) {
                return false;
            }
            if (Integer.TYPE.equals(clazz)) {
                return ((Long.TYPE.equals(toClass)) || (Float.TYPE.equals(toClass)) || (Double.TYPE.equals(toClass)));
            }
            if (Long.TYPE.equals(clazz)) {
                return ((Float.TYPE.equals(toClass)) || (Double.TYPE.equals(toClass)));
            }
            if (Boolean.TYPE.equals(clazz)) {
                return false;
            }
            if (Double.TYPE.equals(clazz)) {
                return false;
            }
            if (Float.TYPE.equals(clazz)) {
                return Double.TYPE.equals(toClass);
            }
            if (Character.TYPE.equals(clazz)) {
                return ((Integer.TYPE.equals(toClass)) || (Long.TYPE.equals(toClass)) || (Float.TYPE.equals(toClass))
                        || (Double.TYPE.equals(toClass)));
            }
            if (Short.TYPE.equals(clazz)) {
                return ((Integer.TYPE.equals(toClass)) || (Long.TYPE.equals(toClass)) || (Float.TYPE.equals(toClass))
                        || (Double.TYPE.equals(toClass)));
            }
            if (Byte.TYPE.equals(clazz)) {
                return ((Short.TYPE.equals(toClass)) || (Integer.TYPE.equals(toClass)) || (Long.TYPE.equals(toClass))
                        || (Float.TYPE.equals(toClass)) || (Double.TYPE.equals(toClass)));
            }
            return false;
        }
        return toClass.isAssignableFrom(clazz);
    }

    public static Class<?> primitiveToWrapper(Class<?> clazz) {
        Class<?> convertedClass = clazz;
        if (clazz != null && clazz.isPrimitive()) {
            convertedClass = primitiveWrapperMap.get(clazz);
        }
        return convertedClass;
    }

    public static Class<?> wrapperToPrimitive(Class<?> clazz) {
        Class<?> convertedClass = wrapperPrimitiveMap.get(clazz);
        if (convertedClass == null) {
            convertedClass = clazz;
        }
        return convertedClass;
    }

    public static String getShortClassName(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        String className;
        {
            StringBuilder result = new StringBuilder();
            while (clazz.isArray()) {
                clazz = clazz.getComponentType();
                result.append("[]");
            }
            result.insert(0, clazz.getName());
            if (result.length() > 0) {
                className = result.toString();
            } else {
                className = clazz.getName();
            }
        }
        int lastDotIndex = className.lastIndexOf(46);
        int nameEndIndex = className.indexOf("$$");
        if (nameEndIndex == -1) {
            nameEndIndex = className.length();
        }
        String shortName = className.substring(lastDotIndex + 1, nameEndIndex);
        shortName = shortName.replace('$', '.');
        return shortName;
    }

    public static String getPackageName(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        String className = clazz.getName();
        while (className.charAt(0) == '[') {
            className = className.substring(1);
        }
        if ((className.charAt(0) == 'L') && (className.charAt(className.length() - 1) == ';')) {
            className = className.substring(1);
        }
        int i = className.lastIndexOf(46);
        return i != -1 ? className.substring(0, i) : "";
    }

    public static List<Class<?>> getAllInterfaces(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        Set<Class<?>> interfacesFound = new LinkedHashSet<Class<?>>();
        getAllInterfaces(clazz, interfacesFound);
        return new ArrayList<Class<?>>(interfacesFound);
    }

    private static void getAllInterfaces(Class<?> clazz, Set<Class<?>> interfacesFound) {
        while (clazz != null) {
            Class<?>[] interfaces = clazz.getInterfaces();
            for (Class<?> interfaceTmp : interfaces) {
                if (interfacesFound.add(interfaceTmp)) {
                    getAllInterfaces(interfaceTmp, interfacesFound);
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    public static List<Class<?>> getAllSuperclasses(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        List<Class<?>> superClasses = new ArrayList<Class<?>>();
        Class<?> superclass = clazz.getSuperclass();
        while (superclass != null) {
            superClasses.add(superclass);
            superclass = superclass.getSuperclass();
        }
        return superClasses;
    }

    /**
     * 通过反射,获得指定类的父类的泛型参数的实际类型. 如BuyerServiceBean extends DaoSupport<Buyer>
     * 
     * @param clazz
     *            clazz 需要反射的类,该类必须继承范型父类
     * @param index
     *            泛型参数所在索引,从0开始.
     * @return 范型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回
     *         <code>Object.class</code>
     */
    public static Class<?> getSuperClassGenricType(Class<?> clazz, int index) {
        Type genType = clazz.getGenericSuperclass();// 得到泛型父类
        // 如果没有实现ParameterizedType接口，即不支持泛型，直接返回Object.class
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        // 返回表示此类型实际类型参数的Type对象的数组,数组里放的都是对应类型的Class, 如BuyerServiceBean extends
        // DaoSupport<Buyer,Contact>就返回Buyer和Contact类型
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            throw new RuntimeException("你输入的索引" + (index < 0 ? "不能小于0" : "超出了参数的总数"));
        }
        if (!(params[index] instanceof Class<?>)) {
            return Object.class;
        }
        return (Class<?>) params[index];
    }

    /**
     * 通过反射,获得指定类的父类的第一个泛型参数的实际类型. 如BuyerServiceBean extends DaoSupport<Buyer>
     * 
     * @param clazz
     *            clazz 需要反射的类,该类必须继承泛型父类
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回
     *         <code>Object.class</code>
     */
    public static Class<?> getSuperClassGenricType(Class<?> clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    /**
     * 通过反射,获得方法返回值泛型参数的实际类型. 如: public Map<String, Buyer> getNames(){}
     * 
     * @param Method
     *            method 方法
     * @param int
     *            index 泛型参数所在索引,从0开始.
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回
     *         <code>Object.class</code>
     */
    public static Class<?> getMethodGenericReturnType(Method method, int index) {
        Type returnType = method.getGenericReturnType();
        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            if (index >= typeArguments.length || index < 0) {
                throw new RuntimeException("你输入的索引" + (index < 0 ? "不能小于0" : "超出了参数的总数"));
            }
            return (Class<?>) typeArguments[index];
        }
        return Object.class;
    }

    /**
     * 通过反射,获得方法返回值第一个泛型参数的实际类型. 如: public Map<String, Buyer> getNames(){}
     * 
     * @param Method
     *            method 方法
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回
     *         <code>Object.class</code>
     */
    public static Class<?> getMethodGenericReturnType(Method method) {
        return getMethodGenericReturnType(method, 0);
    }

    /**
     * 通过反射,获得方法输入参数第index个输入参数的所有泛型参数的实际类型. 如: public void add(Map<String,
     * Buyer> maps, List<String> names){}
     * 
     * @param Method
     *            method 方法
     * @param int
     *            index 第几个输入参数
     * @return 输入参数的泛型参数的实际类型集合, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回空集合
     */
    public static List<Class<?>> getMethodGenericParameterTypes(Method method, int index) {
        List<Class<?>> results = new ArrayList<Class<?>>();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        if (index >= genericParameterTypes.length || index < 0) {
            throw new RuntimeException("你输入的索引" + (index < 0 ? "不能小于0" : "超出了参数的总数"));
        }
        Type genericParameterType = genericParameterTypes[index];
        if (genericParameterType instanceof ParameterizedType) {
            ParameterizedType aType = (ParameterizedType) genericParameterType;
            Type[] parameterArgTypes = aType.getActualTypeArguments();
            for (Type parameterArgType : parameterArgTypes) {
                Class<?> parameterArgClass = (Class<?>) parameterArgType;
                results.add(parameterArgClass);
            }
            return results;
        }
        return results;
    }

    /**
     * 通过反射,获得方法输入参数第一个输入参数的所有泛型参数的实际类型. 如: public void add(Map<String, Buyer>
     * maps, List<String> names){}
     * 
     * @param Method
     *            method 方法
     * @return 输入参数的泛型参数的实际类型集合, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回空集合
     */
    public static List<Class<?>> getMethodGenericParameterTypes(Method method) {
        return getMethodGenericParameterTypes(method, 0);
    }

    /**
     * 通过反射,获得Field泛型参数的实际类型. 如: public Map<String, Buyer> names;
     * 
     * @param Field
     *            field 字段
     * @param int
     *            index 泛型参数所在索引,从0开始.
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回
     *         <code>Object.class</code>
     */
    public static Class<?> getFieldGenericType(Field field, int index) {
        Type genericFieldType = field.getGenericType();

        if (genericFieldType instanceof ParameterizedType) {
            ParameterizedType aType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            if (index >= fieldArgTypes.length || index < 0) {
                throw new RuntimeException("你输入的索引" + (index < 0 ? "不能小于0" : "超出了参数的总数"));
            }
            return (Class<?>) fieldArgTypes[index];
        }
        return Object.class;
    }

    /**
     * 通过反射,获得Field泛型参数的实际类型. 如: public Map<String, Buyer> names;
     * 
     * @param Field
     *            field 字段
     * @param int
     *            index 泛型参数所在索引,从0开始.
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回
     *         <code>Object.class</code>
     */
    public static Class<?> getFieldGenericType(Field field) {
        return getFieldGenericType(field, 0);
    }

    public static boolean hasGetSetMethod(Class<?> beanClass, String fieldName, Class<?> fieldType) {
        String firstLetter = fieldName.substring(0, 1).toUpperCase();
        String otherLetter = fieldName.substring(1);

        StringBuffer getMethodName = new StringBuffer();
        getMethodName.append("get").append(firstLetter).append(otherLetter);

        StringBuffer setMethodName = new StringBuffer();
        setMethodName.append("set").append(firstLetter).append(otherLetter);

        try {
            Method method = beanClass.getDeclaredMethod(getMethodName.toString());
            if (method == null) {
                return false;
            }
            method = beanClass.getDeclaredMethod(setMethodName.toString(), fieldType);
            if (method == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
