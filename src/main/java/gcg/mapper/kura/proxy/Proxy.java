package gcg.mapper.kura.proxy;

import gcg.mapper.kura.core.enums.MethodNameEnum;
import gcg.mapper.kura.core.util.MethodUtil;
import gcg.mapper.kura.exception.NoZeroArgConstructorException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author guvencenanguvenal
 */
public class Proxy<T> {

    private final T instance;
    private final Class<T> clazz;

    public Proxy(T instance) {
        this.instance = instance;
        this.clazz = (Class<T>) instance.getClass();
    }

    public Constructor getConstructor() throws NoZeroArgConstructorException {
        try {
            return this.clazz.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw new NoZeroArgConstructorException();
        }
    }

    public T getInstance() {
        return this.instance;
    }

    public Class<T> getClazz() {
        return this.clazz;
    }

    public void setFieldValue(Field field, Object value) {
        Method method = MethodUtil.getAvailableMethod(this.clazz,
                MethodNameEnum.SET.getFieldMethodName(field.getName()));
        if (Objects.nonNull(method)) {
            this.runMethod(method, value);
        }
    }

    public Object getFieldValue(Field field) {
        Method method = MethodUtil.getAvailableMethod(this.clazz,
                MethodNameEnum.GET.getFieldMethodName(field.getName()));
        if (Objects.nonNull(method)) {
            return this.runMethod(method);
        }
        return null;
    }

    public Object runMethod(Method method, Object... args) {
        try {
            return method.invoke(this.instance, args);
        } catch (IllegalAccessException e) {
            return null;
        } catch (InvocationTargetException e) {
            return null;
        }
    }
}
