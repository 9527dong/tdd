import org.junit.Test;

import static org.junit.Assert.*;

public class MulitiCurrencyMoneyTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);

        assertEquals(new Dollar(10), five.times(2));

        assertEquals(new Dollar(15), five.times(3));
    }

    /**
     * 为什么要写两个测试用例，使用的是三角法（Triangulation）。
     * 如果两个已知间距的接收站都能测定无线电信号的方向的话，那么就有足够的信息计算信号的方位和范围，这种计算称为三角法。
     * 所以当采用三角法时，我们只有在例子达到2个或更多时才对代码实施一般化。
     */
    @Test
    public void testEquality() {
        assertEquals(new Dollar(5), new Dollar(5));

        assertNotEquals(new Dollar(6), new Dollar(5));

    }
}
