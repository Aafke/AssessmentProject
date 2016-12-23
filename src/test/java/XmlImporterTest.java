import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class XmlImporterTest {
    @Test
    public void loadFromFileTest() throws JAXBException {
        XmlImporter xmlImporter = new XmlImporter();

        List<Transaction> expectedTransactions = new ArrayList<Transaction>();

        Transaction expectedTransaction1 = new Transaction(187997, "NL91RABO0315273637",
                "Clothes for Rik King", new BigDecimal(57.6).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(-32.98).setScale(2, RoundingMode.HALF_UP), new BigDecimal(24.62).setScale(2, RoundingMode.HALF_UP));
        Transaction expectedTransaction2 = new Transaction(154270, "NL56RABO0149876948",
                "Candy for Peter de Vries", new BigDecimal(5429).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(-939).setScale(2, RoundingMode.HALF_UP), new BigDecimal(6368).setScale(2, RoundingMode.HALF_UP));

        expectedTransactions.add(expectedTransaction1);
        expectedTransactions.add(expectedTransaction2);

        //todo: make pathname more dynamic
        List<Transaction> actualTransactions = xmlImporter.loadFromFile("C:\\Projects\\RaboAssessment\\project\\src\\test\\java\\recordsXmlTest.xml");

        Assert.assertEquals(expectedTransactions.size(), actualTransactions.size());
        for (int i = 0; i < expectedTransactions.size(); i++){
            Assert.assertEquals(expectedTransactions.get(i).reference, actualTransactions.get(i).reference);
            Assert.assertEquals(expectedTransactions.get(i).accountNumber, actualTransactions.get(i).accountNumber);
            assertTrue(expectedTransactions.get(i).startBalance.compareTo(actualTransactions.get(i).startBalance) ==0);
            assertTrue(expectedTransactions.get(i).endBalance.compareTo(actualTransactions.get(i).endBalance) ==0);
            assertTrue(expectedTransactions.get(i).mutation.compareTo(actualTransactions.get(i).mutation) ==0);
        }
    }

}
