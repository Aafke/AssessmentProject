import org.apache.commons.io.FilenameUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RabobankCustomerStatementProcessor {
    public static void main(String[] args) throws IOException {
        Validator validator = new Validator();
        List<Transaction> transactionList = new ArrayList<>();

        //todo:get from args which file should be read:
        //get from console which file should be read:
        String path = "getStringFromStart.xml";

        //create Importer based on extension
        TransactionImporter transactionImporter = ImporterFactory.getImporter(FilenameUtils.getExtension(path));

        //todo: add proper catch blocks.
        //todo: decide how to get file to be validated
        //get list with transaction in file
        try {
            transactionList = transactionImporter.loadFromFile("addFullPathNameOfFile");
        } catch (IOException exception){
            System.out.println("File was not found");
        } catch (JAXBException e) {
            System.out.println("JAXBException");
        }

        //Validate transactions and write invalid transactions to report.
        if(transactionList != null){
            //validate transactions
            List<Transaction> invalidTransactions = validator.validateTransactions(transactionList);

            ReportWriter.writeToReport(invalidTransactions);
        }

    }
}
