package nl.rabobank.transactionchecker;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "record")
@XmlAccessorType (XmlAccessType.FIELD)
public class Transaction {
    @XmlAttribute
    Integer reference;

    String accountNumber;
    String description;
    BigDecimal startBalance;
    BigDecimal mutation;
    BigDecimal endBalance;

    public Transaction(){}

    public Transaction(Integer reference, String accountNumber, String description, BigDecimal startBalance, BigDecimal mutation, BigDecimal endBalance) {
        this.reference = reference;
        this.accountNumber = accountNumber;
        this.startBalance = startBalance;
        this.mutation = mutation;
        this.description = description;
        this.endBalance = endBalance;
    }


    public Integer getReference() {
        return reference;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getStartBalance() {
        return startBalance;
    }

    public BigDecimal getMutation() {
        return mutation;
    }

    public BigDecimal getEndBalance() {
        return endBalance;
    }
}
