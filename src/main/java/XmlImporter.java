import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlImporter implements TransactionImporter{
    public List<Transaction> loadFromFile(String pathname) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Transactions.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Transactions transactions = (Transactions) jaxbUnmarshaller.unmarshal(new File(pathname));

        return transactions.getTransactions();
    }
}
