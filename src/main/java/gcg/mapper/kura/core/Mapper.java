package gcg.mapper.kura.core;

import gcg.mapper.kura.exception.NoZeroArgConstructorException;
import gcg.mapper.kura.exception.NotFoundGetterMethodException;
import gcg.mapper.kura.exception.NotFoundSetterMethodException;
import gcg.mapper.kura.proxy.Proxy;

/**
 * @author guvencenanguvenal
 */
public interface Mapper {

    <S, D> D map(Proxy<S> source, Proxy<D> destination) throws NotFoundGetterMethodException, NotFoundSetterMethodException, NoZeroArgConstructorException;
}
