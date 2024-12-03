import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {

    private String result = "";

    @Test
    public void testFirst() {
        result = "initial";
    }

    @Test(dependsOnMethods = "testFirst")
    public void testSecond() {
        Assert.assertEquals(result, "initial");
        result = "modified";
    }

    @Test(dependsOnMethods = "testSecond")
    public void testThird() {
        Assert.assertEquals(result, "modified");
    }
}