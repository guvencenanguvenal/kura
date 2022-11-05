package gcg.mapper.kura;

import gcg.mapper.kura.config.MapConfiguration;
import gcg.mapper.kura.core.Mapper;
import gcg.mapper.kura.core.enums.Mappers;
import gcg.mapper.kura.factory.MapperFactory;
import gcg.mapper.kura.proxy.Proxy;

import java.util.List;

public final class KuraMapper {

    private final Mapper mapper = MapperFactory.getMapper(Mappers.CORE);

    public <S, D> D map(S source, D destination) {
        return (D) mapper.map(new Proxy(source), new Proxy(destination));
    }

    public <S, D> D map(S source, D destination, List<MapConfiguration> configuration) {
        return (D) mapper.map(new Proxy(source), new Proxy(destination), configuration);
    }
}
