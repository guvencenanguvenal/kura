package gcg.mapper.kura.core.util;

import java.lang.reflect.Method;

/**
 * @author guvencenanguvenal
 */
public final class MethodUtil {

    public static <T> Method getAvailableMethod(Class clazz, String methodName, Class<T>... params) {
        try {
            return clazz.getMethod(methodName, params);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
}
