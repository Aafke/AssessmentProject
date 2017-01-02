package nl.rabobank.transactionchecker;

import nl.rabobank.transactionchecker.importers.ImporterFactory;
import nl.rabobank.transactionchecker.importers.TransactionImporter;
import org.apache.commons.io.FilenameUtils;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class RabobankCustomerStatementProcessor {
    public static void main(String[] args) {

        //todo:get from args which file should be read:
        //get from console which file should be read:
        String path = args[0];

        //create Importer based on extension
        TransactionImporter transactionImporter = ImporterFactory.getImporter(FilenameUtils.getExtension(path));

        //get list with transaction in file
        List<Transaction> transactionList;
        try {
            transactionList = transactionImporter.loadFromFile(path);

            //Validate transactions and write invalid transactions to report.
            Validator validator = new Validator();
            if(transactionList != null){
                List<Transaction> invalidTransactions = validator.validateTransactions(transactionList);

                ReportWriter.writeToReport(invalidTransactions);
            }
        } catch (FileNotFoundException exception){
            System.out.println("File was not found");
        } catch (JAXBException e) {
            System.out.println("JAXBException");
        } catch (IOException exception){
            System.out.println("Oeps, could not read or write content");
        }
    }
}
