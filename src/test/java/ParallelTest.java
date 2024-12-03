import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelTest {

    @Test(invocationCount = 5, threadPoolSize = 3)
    public void testMethod() {
        // 模拟一些计算或数据库操作
        int computationResult = 2 + 2;
        Assert.assertEquals(computationResult, 4);
    }
}