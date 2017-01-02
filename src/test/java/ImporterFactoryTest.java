import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ImporterFactoryTest {
    @Test
    public void getXmlImporter(){
        //todo: make pathname more dynamic
        String path = "C:\\Projects\\AssessmentProject\\src\\test\\java\\recordsXmlTest.xml";

        //create Importer based on extension
        TransactionImporter transactionImporter = ImporterFactory.getImporter(FilenameUtils.getExtension(path));
        assertTrue(transactionImporter instanceof XmlImporter);
    }

    @Test
    public void getCsvImporter(){
        //todo: make pathname more dynamic
        String path = "C:\\Projects\\AssessmentProject\\src\\test\\java\\recordsCSVTestFile.csv";

        //create Importer based on extension
        TransactionImporter transactionImporter = ImporterFactory.getImporter(FilenameUtils.getExtension(path));
        assertTrue(transactionImporter instanceof CsvImporter);
    }
}
