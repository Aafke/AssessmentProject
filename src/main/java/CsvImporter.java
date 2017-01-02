import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CsvImporter implements TransactionImporter{
    //Todo: add comments?
    public List<Transaction> loadFromFile(String pathname) throws IOException{
        ArrayList<Transaction> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(pathname)));

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
