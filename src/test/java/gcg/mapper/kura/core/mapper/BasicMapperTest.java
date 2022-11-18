package gcg.mapper.kura.core.mapper;

import gcg.mapper.kura.exception.NoZeroArgConstructorException;
import gcg.mapper.kura.exception.NotFoundGetterMethodException;
import gcg.mapper.kura.exception.NotFoundSetterMethodException;
import gcg.mapper.kura.factory.ProxyFactory;
import gcg.mapper.kura.proxy.Proxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author guvencenanguvenal
 */
class BasicMapperTest {

    private BasicMapper testClass;

    @BeforeEach
    public void before() {
        testClass = new BasicMapper();
    }

    @Test
    void map() throws NotFoundSetterMethodException, NoZeroArgConstructorException, NotFoundGetterMethodException {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        Proxy<Test1> test1Proxy = ProxyFactory.getProxy(test1);
        Proxy<Test2> test2Proxy = ProxyFactory.getProxy(test2);
        test2 = testClass.map(test1Proxy, test2Proxy);
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