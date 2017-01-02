package nl.rabobank.transactionchecker.importers;

import nl.rabobank.transactionchecker.Transaction;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads csv files, convert lines into transactions
 */
public class CsvImporter implements TransactionImporter {
    /**
     * Reads transactions from file
     * @param path Location of file to be imported
     * @return List of transactions
     * @throws IOException Will be thrown if file was not found or could not be read
     */
    public List<Transaction> loadFromFile(String path) throws IOException{
        ArrayList<Transaction> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

        //First line is header, so nothing is done with this.
        String line = reader.readLine();

        while ((line = reader.readLine()) != null){
            String[] entries = line.split(",");

            Transaction transaction = new Transaction(Integer.parseInt(entries[0]), entries[1],
                    entries[2], new BigDecimal(entries[3]), new BigDecimal(entries[4]), new BigDecimal(entries[5]));

            result.add(transaction);
        }

        return result;
    }
}
