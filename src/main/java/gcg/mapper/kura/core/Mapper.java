package gcg.mapper.kura.core;

import gcg.mapper.kura.config.MapConfiguration;
import gcg.mapper.kura.proxy.Proxy;

import java.util.List;

/**
 * @author guvencenanguvenal
 */
public interface Mapper {

    <S, D> D map(Proxy<S> source, Proxy<D> destination);

    <S, D> D map(Proxy<S> source, Proxy<D> destination, List<MapConfiguration> configuration);
}
