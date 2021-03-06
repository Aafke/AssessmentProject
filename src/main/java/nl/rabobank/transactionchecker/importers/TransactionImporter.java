package nl.rabobank.transactionchecker.importers;

import nl.rabobank.transactionchecker.Transaction;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface TransactionImporter {
    List<Transaction> loadFromFile(String pathname) throws IOException, JAXBException;
}
