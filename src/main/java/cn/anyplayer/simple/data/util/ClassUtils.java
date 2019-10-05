package cn.anyplayer.simple.data.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtils {

    /**
     * 实例化泛型对象
     *
     * @param target 泛型类
     * @param <T>
     * @return
     */
    public static <T> Object getInstance(Class<T> target) {
        try {
            T entity = target.newInstance();
            return entity;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("实例化对象失败");
    }

    /**
     * 根据className加载class
     *
     * @param className 类名
     * @return
     */
    public static Class forName(String className) {
        try {
            Class<?> cls = Class.forName(className);
            return cls;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 获取属性值
     *
     * @param target 目标对象
     * @param field  目标对象的属性
     * @return
     */
    public static Object getValue(Object target, Field field) {
        boolean accessible = field.isAccessible();
        if (!accessible) {
            field.setAccessible(true);
        }
        try {
            return field.get(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            field.setAccessible(accessible);
        }

        return null;
    }

    /**
     * 设置属性值
     *
     * @param target 目标对象
     * @param field  目标对象的属性
     * @param value  属性值
     * @return
     */
    public static boolean setValue(Object target, Field field, Object value) {
        boolean accessible = field.isAccessible();
        try {
            field.setAccessible(true);
            field.set(target, value);
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            field.setAccessible(accessible);
        }
        return false;
    }

    /**
     * 获得属性的get方法
     *
     * @param field 目标属性
     * @return
     */
    public static Method getGetMethod(Field field) {
        String fieldName = field.getName();
        char[] ch = fieldName.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        Class<?> declaringClass = field.getDeclaringClass();
        String methodName = "get" + new String(ch);
        try {
            Method method = declaringClass.getDeclaredMethod(methodName, null);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

}
