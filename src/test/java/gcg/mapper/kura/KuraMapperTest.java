package gcg.mapper.kura;

import gcg.mapper.kura.exception.NoZeroArgConstructorException;
import gcg.mapper.kura.exception.NotFoundGetterMethodException;
import gcg.mapper.kura.exception.NotFoundSetterMethodException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KuraMapperTest {

    private KuraMapper kuraMapper;

    @BeforeEach
    public void beforeEach() {
        kuraMapper = new KuraMapper();
    }

    @Test
    void map() throws NotFoundSetterMethodException, NoZeroArgConstructorException, NotFoundGetterMethodException {
        KuraMapperTest.Test1 test1 = new KuraMapperTest.Test1();
        KuraMapperTest.Test2 test2 = new KuraMapperTest.Test2();
        test2 = kuraMapper.map(test1, test2.getClass());
        assertEquals(test1.getDataInt(), test2.getDataInt());
        assertEquals(test1.getDataLong(), test2.getDataLong());
        assertEquals(test1.getDataStr(), test2.getDataStr());
    }


    public static class Test1 {
        private Integer dataInt = 1;
        private Long dataLong = 2L;
        private String dataStr = "TEST";

        public Integer getDataInt() {
            return dataInt;
        }

        public void setDataInt(Integer dataInt) {
            this.dataInt = dataInt;
        }

        public Long getDataLong() {
            return dataLong;
        }

        public void setDataLong(Long dataLong) {
            this.dataLong = dataLong;
        }

        public String getDataStr() {
            return dataStr;
        }

        public void setDataStr(String dataStr) {
            this.dataStr = dataStr;
        }
    }

    public static class Test2 {
        private Integer dataInt;
        private Long dataLong;
        private String dataStr;

        public Integer getDataInt() {
            return dataInt;
        }

        public void setDataInt(Integer dataInt) {
            this.dataInt = dataInt;
        }

        public Long getDataLong() {
            return dataLong;
        }

        public void setDataLong(Long dataLong) {
            this.dataLong = dataLong;
        }

        public String getDataStr() {
            return dataStr;
        }

        public void setDataStr(String dataStr) {
            this.dataStr = dataStr;
        }
    }

}