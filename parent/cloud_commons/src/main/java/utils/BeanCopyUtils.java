package utils;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;

/**
 * @className BeanCopyUtils
 * @package utils
 * @describe Bean拷贝工具类
 * @author hua.yang
 * @date 2020/10/27 13:44:00
 */
public class BeanCopyUtils {

    private static final Map<String , BeanCopier> BEAN_COPY_CACHE = new ConcurrentHashMap<>();
    private static final Map<String , ConstructorAccess> CONSTRUCTOR_ACCESSOR_CACHE = new ConcurrentHashMap<>();


    /**
     * 获取复制bean
     * @methodName getBeanCopy
     * @param source
     * @param targetClass
     * @return T
     * @author hua.yang
     * @date 2020/10/27 14:40:00
     */
    public static <T> T getBeanCopy(Object source, Class<T> targetClass) {
        T t = null;
        try {
            t = targetClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(format("Create new instance of %s failed: %s", targetClass, e.getMessage()));
        }
        getBeanCopy(source, t);
        return t;
    }

    private static void getBeanCopy(Object source , Object target){
        BeanCopier copier = copyProperties(source.getClass() , target.getClass());
        copier.copy(source , target , null);
    }


    private static BeanCopier copyProperties(Class sourceClass, Class targetClass) {
        String beanKey = generateKey(sourceClass, targetClass);
        BeanCopier copier = null;
        if (!BEAN_COPY_CACHE.containsKey(beanKey)) {
            copier = BeanCopier.create(sourceClass, targetClass, false);
            BEAN_COPY_CACHE.put(beanKey, copier);
        } else {
            copier = BEAN_COPY_CACHE.get(beanKey);
        }
        return copier;
    }

    /**
     *
     * @methodName generateKey
     * @param sourceClass
     * @return targetClass
     * @author hua.yang
     * @date 2020/10/27 14:34:00
     */
    private static String generateKey(Class sourceClass, Class targetClass) {
        return sourceClass.getName() + targetClass.getName();
    }



    public static <T> List<T> copyPropertiesOfList(List<?> sourceList, Class<T> targetClass) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return Collections.emptyList();
        }
        ConstructorAccess<T> constructorAccess = getConstructorAccess(targetClass);
        List<T> resultList = new ArrayList<>(sourceList.size());
        for (Object o : sourceList) {
            T t = null;
            try {
                t = constructorAccess.newInstance();
                getBeanCopy(o, t);
                resultList.add(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return resultList;
    }

    /**
     *
     * @methodName
     * @param
     * @return
     * @author hua.yang
     * @date 2020/10/27 14:35:00
     */
    private static <T> ConstructorAccess<T> getConstructorAccess(Class<T> targetClass) {
        //从缓存中获取值
        ConstructorAccess<T> constructorAccess = (ConstructorAccess<T>) CONSTRUCTOR_ACCESSOR_CACHE.get(targetClass.toString());
        // 判断缓存是否存在对象
        if(constructorAccess != null) {
            return constructorAccess;
        }
        try {
            constructorAccess = ConstructorAccess.get(targetClass);
            constructorAccess.newInstance();
            //存入缓存
            CONSTRUCTOR_ACCESSOR_CACHE.put(targetClass.toString(),  constructorAccess);
        } catch (Exception e) {
            throw new RuntimeException(format("Create new instance of %s failed: %s", targetClass, e.getMessage()));
        }
        return constructorAccess;
    }
}
