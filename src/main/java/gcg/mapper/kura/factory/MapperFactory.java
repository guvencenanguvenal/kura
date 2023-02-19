package gcg.mapper.kura.factory;

import gcg.mapper.kura.KuraMapper;
import gcg.mapper.kura.core.mapper.BasicMapper;
import gcg.mapper.kura.core.Mapper;
import gcg.mapper.kura.core.enums.Mappers;
import gcg.mapper.kura.core.mapper.CacheableMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * @author guvencenanguvenal
 */
public final class MapperFactory {

    private final static String PROPERTIES_FILE_NAME = "kura.properties";
    private final static String MAPPER_STRATEGY = "kura.mapper.strategy";

    public static Mapper createMapper() {
        Properties properties = new Properties();
        try (InputStream is = MapperFactory.class.getResourceAsStream(PROPERTIES_FILE_NAME)) {
            if (Objects.isNull(is)) {
                return new BasicMapper();
            }
            properties.load(is);
            String mapperStrategy = properties.getProperty(MAPPER_STRATEGY);
            return mapperChooser(mapperStrategy);
        } catch (IOException e) {
            return new BasicMapper();
        }
    }

    private static Mapper mapperChooser(String strategy) {
        if (Mappers.CORE.name().equals(strategy)) {
            return new BasicMapper();
        } else if (Mappers.CACHEABLE.name().equals(strategy)) {
            return new CacheableMapper();
        }
        return new BasicMapper();
    }
}
