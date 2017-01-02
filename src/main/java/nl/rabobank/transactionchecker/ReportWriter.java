package nl.rabobank.transactionchecker;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Writes invalid transaction to invalidRecords.txt
 */
public class ReportWriter {
    /**
     * Writes reference and description of invalid transaction to invalidRecords.txt
     * @param invalidTransactions List of transactions which have
     *                            duplicate reference numbers or invalid end balance
     * @throws IOException Will be thrown if file was not found or could not be written
     */
    public static void writeToReport(List<Transaction> invalidTransactions) throws IOException {

        //create new file and write errors away
        Path report = Paths.get("invalidRecords.txt");

        List<String> lines = new ArrayList<>();
        for (Transaction transaction : invalidTransactions){
            lines.add("nl.rabobank.transactionchecker.Transaction reference = " + transaction.reference);
            lines.add("nl.rabobank.transactionchecker.Transaction description = " + transaction.description);
            lines.add("");
        }
        Files.write(report, lines, Charset.forName("UTF-8"));
    }
}
