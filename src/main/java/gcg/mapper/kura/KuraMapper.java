package gcg.mapper.kura;

import gcg.mapper.kura.exception.NoZeroArgConstructorException;
import gcg.mapper.kura.exception.NotFoundGetterMethodException;
import gcg.mapper.kura.exception.NotFoundSetterMethodException;

public interface KuraMapper {

    <S, D> D map(S source, Class<D> destinationClazz) throws NotFoundSetterMethodException, NotFoundGetterMethodException, NoZeroArgConstructorException;
}
