package gcg.mapper.kura.core.util;

import java.lang.reflect.Method;

/**
 * @author guvencenanguvenal
 */
public final class MethodUtil {

    public static Method getAvailableMethod(Class clazz, String methodName) {
        try {
            return clazz.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
}
