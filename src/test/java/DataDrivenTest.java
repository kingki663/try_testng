import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class DataDrivenTest {

    @DataProvider(name = "testDataFromCSV")
    public Object[][] testDataProvider() throws IOException, CsvValidationException {
        String filePath = "src/test/resources/testdata.csv";
        CSVReader reader = new CSVReader(new FileReader(filePath));

        // 读取 CSV 文件的标题行
        String[] headers = reader.readNext();

        // 计算行数和列数
        int rowCount = 0;
        while (reader.readNext() != null) {
            rowCount++;
        }
        int colCount = headers.length;

        // 重新打开文件以读取数据
        reader = new CSVReader(new FileReader(filePath));
        reader.readNext(); // 跳过标题行

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            String[] row = reader.readNext();
            for (int j = 0; j < colCount; j++) {
                data[i][j] = row[j];
            }
        }

        reader.close();

        return data;
    }

    @Test(dataProvider = "testDataFromCSV")
    public void testLogin(String username, String password) {
        System.out.println("Testing with username: " + username + " and password: " + password);
    }
}