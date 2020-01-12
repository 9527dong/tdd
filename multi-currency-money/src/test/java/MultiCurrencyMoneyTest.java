import org.junit.Test;

import static org.junit.Assert.*;

public class MultiCurrencyMoneyTest {

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);

        assertEquals(Money.dollar(10), five.times(2));

        assertEquals(Money.dollar(15), five.times(3));
    }

    /**
     * 为什么要写两个测试用例，使用的是三角法（Triangulation）。 如果两个已知间距的接收站都能测定无线电信号的方向的话，那么就有足够的信息计算信号的方位和范围，这种计算称为三角法。 所以当采用三角法时，我们只有在例子达到2个或更多时才对代码实施一般化。
     */
    @Test
    public void testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(6), Money.dollar(5));

        //将一个困扰的问题转化为测试用例
        assertNotEquals(Money.franc(5), Money.dollar(5));

    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddtion() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10),reduced);
    }
    @Test
    public void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum)result;

        assertEquals(five,sum.augend);
        assertEquals(five,sum.addend);
    }
    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }
    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1),result);
    }

}
