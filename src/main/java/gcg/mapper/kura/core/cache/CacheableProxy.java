package gcg.mapper.kura.core.cache;

import gcg.mapper.kura.exception.NoZeroArgConstructorException;
import gcg.mapper.kura.proxy.Proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * @author guvencenanguvenal
 */
public class CacheableProxy<T> extends Proxy<T> {

    private final Map<String, Object> fieldNameValueCache;

    private Constructor constructor;

    public CacheableProxy(T instance) {
        super(instance);
        fieldNameValueCache = new HashMap<>();
    }

    @Override
    public Constructor getConstructor() throws NoZeroArgConstructorException {
        if (isNull(constructor)) {
            constructor = super.getConstructor();
        }
        return constructor;
    }

    @Override
    public Object getFieldValue(Field field) {
        if (fieldNameValueCache.isEmpty()) {
            fieldNameValueCache.put(field.getName(), super.getFieldValue(field));
        }
        return fieldNameValueCache.get(field.getName());
    }
}
