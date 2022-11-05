package gcg.mapper.kura.core.enums;

import java.util.Locale;

/**
 * @author guvencenanguvenal
 */
public enum MethodNameEnum {

    GET("get"),
    SET("set");

    String methodName;

    MethodNameEnum(String methodName) {
        this.methodName = methodName;
    }

    public String getFieldMethodName(String fieldName) {
        return methodName + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
}
