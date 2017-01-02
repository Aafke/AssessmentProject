import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Reads xml files, convert xml into transactions
 */
public class XmlImporter implements TransactionImporter{
    /**
     * Reads transactions from file
     * @param path Location of file to be imported
     * @return List of transactions
     * @throws JAXBException Will be thrown if xml cannot be read
     */

    public List<Transaction> loadFromFile(String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Transactions.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Transactions transactions = (Transactions) jaxbUnmarshaller.unmarshal(new File(path));

        return transactions.getTransactions();
    }
}
