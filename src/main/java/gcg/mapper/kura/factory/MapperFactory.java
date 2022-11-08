package gcg.mapper.kura.factory;

import gcg.mapper.kura.core.mapper.BasicMapper;
import gcg.mapper.kura.core.Mapper;
import gcg.mapper.kura.core.enums.Mappers;
import gcg.mapper.kura.core.mapper.CacheableMapper;

/**
 * @author guvencenanguvenal
 */
public final class MapperFactory {

    public static Mapper getMapper(Mappers type) {
        if (type.equals(Mappers.CORE)) {
            return new BasicMapper();
        } else if (type.equals(Mappers.CACHEABLE)) {
            return new CacheableMapper();
        } else {
            return new BasicMapper();
        }
    }
}
