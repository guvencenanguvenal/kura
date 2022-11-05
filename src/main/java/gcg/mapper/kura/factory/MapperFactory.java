package gcg.mapper.kura.factory;

import gcg.mapper.kura.core.CoreMapper;
import gcg.mapper.kura.core.Mapper;
import gcg.mapper.kura.core.enums.Mappers;

/**
 * @author guvencenanguvenal
 */
public final class MapperFactory {

    public static Mapper getMapper(Mappers type) {
        if (type.equals(Mappers.CORE)) {
            return new CoreMapper();
        } else {
            return new CoreMapper();
        }
    }
}
