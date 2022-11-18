package gcg.mapper.kura.mapper;

import gcg.mapper.kura.KuraMapper;
import gcg.mapper.kura.core.Mapper;
import gcg.mapper.kura.core.enums.Mappers;
import gcg.mapper.kura.exception.NoZeroArgConstructorException;
import gcg.mapper.kura.exception.NotFoundGetterMethodException;
import gcg.mapper.kura.exception.NotFoundSetterMethodException;
import gcg.mapper.kura.factory.MapperFactory;
import gcg.mapper.kura.factory.ProxyFactory;

/**
 * @author guvencenanguvenal
 */
public class CacheableKuraMapper implements KuraMapper {

    private final Mapper mapper;

    public CacheableKuraMapper() {
        mapper = MapperFactory.getMapper(Mappers.CACHEABLE);
    }

    @Override
    public <S, D> D map(S source, Class<D> destination) throws NotFoundSetterMethodException, NotFoundGetterMethodException, NoZeroArgConstructorException {
        return mapper.map(ProxyFactory.getProxy(source), ProxyFactory.getProxy(destination));
    }
}
