package gcg.mapper.kura.core.util;

import java.lang.reflect.Method;

/**
 * @author guvencenanguvenal
 */
public final class MethodUtil {

    public static <T> Method getAvailableMethod(Class clazz, String methodName, Class<T>... params) throws NoSuchMethodException {
        return clazz.getMethod(methodName, params);
    }
}
