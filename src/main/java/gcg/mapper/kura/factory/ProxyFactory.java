package gcg.mapper.kura.factory;

import gcg.mapper.kura.exception.NoZeroArgConstructorException;
import gcg.mapper.kura.proxy.Proxy;

import java.lang.reflect.InvocationTargetException;

/**
 * @author guvencenanguvenal
 */
public final class ProxyFactory {

    public static <T> Proxy<T> getProxy(T obj) {
        return new Proxy<>(obj);
    }

    public static <T> Proxy<T> getProxy(Class<T> clazz) throws NoZeroArgConstructorException {
        T obj = null;
        try {
            obj = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new NoZeroArgConstructorException();
        }
        return new Proxy<>(obj);
    }
}
