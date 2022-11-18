package gcg.mapper.kura.proxy;

import gcg.mapper.kura.core.enums.MethodNameEnum;
import gcg.mapper.kura.core.util.MethodUtil;
import gcg.mapper.kura.exception.NoZeroArgConstructorException;
import gcg.mapper.kura.exception.NotFoundGetterMethodException;
import gcg.mapper.kura.exception.NotFoundSetterMethodException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public Constructor<T> getConstructor() throws NoZeroArgConstructorException {
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

    public void setFieldValue(Field field, Object value) throws NotFoundSetterMethodException {
        Method method;
        try {
            method = MethodUtil.getAvailableMethod(this.clazz,
                    MethodNameEnum.SET.getFieldMethodName(field.getName()),
                    field.getType());
        } catch (NoSuchMethodException e) {
            throw new NotFoundSetterMethodException();
        }
        this.runMethod(method, value);
    }

    public Object getFieldValue(Field field) throws NotFoundGetterMethodException {
        Method method;
        try {
            method = MethodUtil.getAvailableMethod(this.clazz,
                    MethodNameEnum.GET.getFieldMethodName(field.getName()));
        } catch (NoSuchMethodException e) {
            throw new NotFoundGetterMethodException();
        }
        return this.runMethod(method);
    }

    public Object runMethod(Method method, Object... args) {
        try {
            return method.invoke(this.instance, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }
}
