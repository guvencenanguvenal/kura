package gcg.mapper.kura.core.mapper;

import gcg.mapper.kura.core.Mapper;
import gcg.mapper.kura.proxy.Proxy;

/**
 * @author guvencenanguvenal
 */
public class CacheableMapper implements Mapper {

    @Override
    public <S, D> D map(Proxy<S> source, Proxy<D> destination) {
        return null;
    }
}
