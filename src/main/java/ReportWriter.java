import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReportWriter {
    public static void writeToReport(List<Transaction> invalidTransactions) throws IOException {

        //create new file and write errors away
        Path report = Paths.get("invalidRecords.txt");

        List<String> lines = new ArrayList<>();
        for (Transaction transaction : invalidTransactions){
            lines.add("Transaction reference = " + transaction.reference);
            lines.add("Transaction description = " + transaction.description);
            lines.add("");
        }
        Files.write(report, lines, Charset.forName("UTF-8"));
    }
}
