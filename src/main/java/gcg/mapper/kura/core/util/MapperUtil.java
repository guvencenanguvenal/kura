package gcg.mapper.kura.core.util;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author guvencenanguvenal
 */
public final class MapperUtil {

    public static Boolean checkFieldsMapping(List<Field> sourceFields, List<Field> destinationFields) {
        List<String> sourceFieldNames = sourceFields.stream().map(f -> f.getName()).toList();
        List<String> destinationFieldNames = destinationFields.stream().map(f -> f.getName()).toList();

        List<String> strings = sourceFieldNames.stream().filter(f -> destinationFieldNames.contains(f)).toList();
        return strings.size() > 0;
    }
}
