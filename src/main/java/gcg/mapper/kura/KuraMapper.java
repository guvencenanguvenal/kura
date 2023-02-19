package gcg.mapper.kura;

import gcg.mapper.kura.core.Mapper;
import gcg.mapper.kura.exception.NoZeroArgConstructorException;
import gcg.mapper.kura.exception.NotFoundGetterMethodException;
import gcg.mapper.kura.exception.NotFoundSetterMethodException;
import gcg.mapper.kura.factory.MapperFactory;
import gcg.mapper.kura.factory.ProxyFactory;

/**
 * @author guvencenanguvenal
 */
public class KuraMapper {

    private final Mapper mapper;

    public KuraMapper() {
        mapper = MapperFactory.createMapper();
    }

    public <S, D> D map(S source, Class<D> destination) throws NotFoundSetterMethodException, NotFoundGetterMethodException, NoZeroArgConstructorException {
        return mapper.map(ProxyFactory.createFactory(source), ProxyFactory.createFactory(destination));
    }
}
