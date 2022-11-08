package gcg.mapper.kura.mapper;

import gcg.mapper.kura.KuraMapper;
import gcg.mapper.kura.core.Mapper;
import gcg.mapper.kura.core.enums.Mappers;
import gcg.mapper.kura.factory.MapperFactory;
import gcg.mapper.kura.factory.ProxyFactory;

/**
 * @author guvencenanguvenal
 */
public class BasicKuraMapper implements KuraMapper {

    private final Mapper mapper;

    public BasicKuraMapper() {
        mapper = MapperFactory.getMapper(Mappers.CORE);
    }

    @Override
    public <S, D> D map(S source, D destination) {
        return mapper.map(ProxyFactory.getProxy(source), ProxyFactory.getProxy(destination));
    }
}
