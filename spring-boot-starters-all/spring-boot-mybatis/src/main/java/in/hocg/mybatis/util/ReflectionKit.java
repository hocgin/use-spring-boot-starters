package in.hocg.mybatis.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by hocgin on 2019/7/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@RequiredArgsConstructor
public class ReflectionKit {
    private static Map<Class, ReflectionKit> CACHED = Maps.newHashMap();
    private final Class<?> clazz;
    
    public static ReflectionKit from(Class<?> clazz) {
        return CACHED.computeIfAbsent(clazz, ReflectionKit::new);
    }
    
    /**
     * 获取所有函数
     * @return
     */
    public Method[] getAllMethod() {
        return clazz.getDeclaredMethods();
    }
    
    /**
     * 获取所有字段
     *
     * @return
     */
    public List<Field> getAllField() {
        ArrayList<Field> result = Lists.newArrayList();
        result.addAll(Arrays.asList(clazz.getDeclaredFields()));
    
        Class<?> superclass = clazz.getSuperclass();
        if (Object.class.equals(superclass)) {
            return result;
        }
        result.addAll(ReflectionKit.from(superclass).getAllField());
        return result;
    }
    
    /**
     * 获取所有字段，排除 @Transient
     *
     * @return
     */
    public List<Field> getAllFieldExcludeTransient() {
        return getAllField().stream()
                .filter(field -> !Modifier.isTransient(field.getModifiers()))
                .collect(Collectors.toList());
    }
    
    /**
     * 查找字段
     * @param fieldName
     * @return
     */
    public Field getField(String fieldName) {
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class<?> superclass = clazz.getSuperclass();
            if (!Object.class.equals(superclass)) {
                return ReflectionKit.from(superclass).getField(fieldName);
            }
        }
        if (Objects.isNull(field)) {
            throw new IllegalArgumentException(String.format("在 %s 中未找到 %s 字段", clazz.getSimpleName(), fieldName));
        }
        return field;
    }
    
}
