package gcg.mapper.kura.core.mapper;

import gcg.mapper.kura.core.Mapper;
import gcg.mapper.kura.exception.NoZeroArgConstructorException;
import gcg.mapper.kura.exception.NotFoundGetterMethodException;
import gcg.mapper.kura.exception.NotFoundSetterMethodException;
import gcg.mapper.kura.factory.ProxyFactory;
import gcg.mapper.kura.proxy.Proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public final class BasicMapper implements Mapper {

    @Override
    public <S, D> D map(Proxy<S> source, Proxy<D> destination) throws NotFoundGetterMethodException, NotFoundSetterMethodException, NoZeroArgConstructorException {
        List<Field> destinationFields = Arrays.asList(destination.getClazz().getDeclaredFields());
        for (Field destinationField : destinationFields) {
            Object fieldValue = source.getFieldValue(destinationField);
            destination.setFieldValue(destinationField, fieldValue);
        }
        return destination.getInstance();
    }
}
