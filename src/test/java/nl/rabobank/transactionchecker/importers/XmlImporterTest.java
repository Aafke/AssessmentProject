package nl.rabobank.transactionchecker.importers;

import nl.rabobank.transactionchecker.importers.XmlImporter;
import nl.rabobank.transactionchecker.Transaction;
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

        List<Transaction> expectedTransactions = new ArrayList<>();

        Transaction expectedTransaction1 = new Transaction(187997, "NL91RABO0315273637",
                "Clothes for Rik King", new BigDecimal(57.6).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(-32.98).setScale(2, RoundingMode.HALF_UP), new BigDecimal(24.62).setScale(2, RoundingMode.HALF_UP));
        Transaction expectedTransaction2 = new Transaction(154270, "NL56RABO0149876948",
                "Candy for Peter de Vries", new BigDecimal(5429).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(-939).setScale(2, RoundingMode.HALF_UP), new BigDecimal(6368).setScale(2, RoundingMode.HALF_UP));

        expectedTransactions.add(expectedTransaction1);
        expectedTransactions.add(expectedTransaction2);

        String workingDir = System.getProperty("user.dir");
        List<Transaction> actualTransactions = xmlImporter.loadFromFile(workingDir + "\\src\\test\\java\\recordsXmlTest.xml");

        Assert.assertEquals(expectedTransactions.size(), actualTransactions.size());
        for (int i = 0; i < expectedTransactions.size(); i++){
            Assert.assertEquals(expectedTransactions.get(i).getReference(), actualTransactions.get(i).getReference());
            Assert.assertEquals(expectedTransactions.get(i).getAccountNumber(), actualTransactions.get(i).getAccountNumber());
            assertTrue(expectedTransactions.get(i).getStartBalance().compareTo(actualTransactions.get(i).getStartBalance()) ==0);
            assertTrue(expectedTransactions.get(i).getEndBalance().compareTo(actualTransactions.get(i).getEndBalance()) ==0);
            assertTrue(expectedTransactions.get(i).getMutation().compareTo(actualTransactions.get(i).getMutation()) ==0);
        }
    }

}
