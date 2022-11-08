package gcg.mapper.kura.factory;

import gcg.mapper.kura.proxy.Proxy;

/**
 * @author guvencenanguvenal
 */
public final class ProxyFactory {

    public static <T> Proxy<T> getProxy(T obj) {
        return new Proxy<>(obj);
    }
}
