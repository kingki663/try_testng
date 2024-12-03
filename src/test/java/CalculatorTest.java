import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero.");
        }
        return (double) a / b;
    }

    @Test(description = "test add", groups = {"unitTests"})
    public void testAdd() {
        int res = add(6, 3);
        Assert.assertEquals(res, 9, "The add method should return 9 for 6 + 3");
    }

    @Test(description = "test subtract", groups = {"unitTests"})
    public void testSubtract() {
        int res = subtract(10, 4);
        Assert.assertEquals(res, 6, "The subtract method should return 6 for 10 - 4");
    }

    @Test(description = "test multiply", groups = {"unitTests"})
    public void testMultiply() {
        int res = multiply(4, 3);
        Assert.assertEquals(res, 12, "The multiply method should return 12 for 4 * 3");
    }

//   测试抛出异常的状况
    @Test(description = "test divide", expectedExceptions = IllegalArgumentException.class, groups = {"exceptionTests"})
    public void testDivideByZero() {
        divide(10, 0);
    }

    @Test(description = "test divide", groups = {"unitTests"})
    public void testDivide() {
        double res = divide(12, 3);
        Assert.assertEquals(res, 4.0, "The divide method should return 4.0 for 12 / 3");
    }
}