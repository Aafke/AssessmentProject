import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ImporterFactoryTest {
    @Test
    public void getXmlImporter(){
        String workingDir = System.getProperty("user.dir");
        String path = workingDir +"\\src\\test\\java\\recordsXmlTest.xml";

        //create Importer based on extension
        TransactionImporter transactionImporter = ImporterFactory.getImporter(FilenameUtils.getExtension(path));
        assertTrue(transactionImporter instanceof XmlImporter);
    }

    @Test
    public void getCsvImporter(){
        String workingDir = System.getProperty("user.dir");
        String path = workingDir +"\\src\\test\\java\\recordsCSVTestFile.csv";

        //create Importer based on extension
        TransactionImporter transactionImporter = ImporterFactory.getImporter(FilenameUtils.getExtension(path));
        assertTrue(transactionImporter instanceof CsvImporter);
    }
}
