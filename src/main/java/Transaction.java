import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "record")
@XmlAccessorType (XmlAccessType.FIELD)
public class Transaction {
    Integer transactionReference;
    String accountNumber;
    String description;
    BigDecimal startBalance;
    BigDecimal mutation;
    BigDecimal endBalance;

    public Transaction(){}

    public Transaction(Integer transactionReference, String accountNumber, String description, BigDecimal startBalance, BigDecimal mutation, BigDecimal endBalance) {
        this.transactionReference = transactionReference;
        this.accountNumber = accountNumber;
        this.startBalance = startBalance;
        this.mutation = mutation;
        this.description = description;
        this.endBalance = endBalance;
    }
}
