package gcg.mapper.kura;

public interface KuraMapper {

    <S, D> D map(S source, D destination);
}
