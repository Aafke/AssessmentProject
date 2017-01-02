package nl.rabobank.transactionchecker.importers;

import nl.rabobank.transactionchecker.importers.CsvImporter;
import nl.rabobank.transactionchecker.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CsvImporterTest {
    @Test
    public void loadFromFileTest() throws IOException{
        CsvImporter csvImporter = new CsvImporter();

        List<Transaction> expectedTransactions = new ArrayList<>();

        Transaction expectedTransaction1 = new Transaction(177666, "NL93ABNA0585619023",
                "Flowers for Rik Theuß", new BigDecimal(44.85).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(-22.24).setScale(2, RoundingMode.HALF_UP), new BigDecimal(22.61).setScale(2, RoundingMode.HALF_UP));
        Transaction expectedTransaction2 = new Transaction(112806, "NL69ABNA0433647324",
                "Subscription for Jan Theuß", new BigDecimal(45.59).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(+48.18).setScale(2, RoundingMode.HALF_UP), new BigDecimal(93.77).setScale(2, RoundingMode.HALF_UP));

        expectedTransactions.add(expectedTransaction1);
        expectedTransactions.add(expectedTransaction2);

        String workingDir = System.getProperty("user.dir");
        List<Transaction> actualTransactions = csvImporter.loadFromFile(workingDir + "\\src\\test\\java\\recordsCSVTestFile.csv");

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
