package nl.rabobank.transactionchecker;

import nl.rabobank.transactionchecker.Transaction;
import nl.rabobank.transactionchecker.Validator;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void validateTransactionsTestAllValidRecords() {
        Validator validator = new Validator();
        List<Transaction> transactionList = new ArrayList<>();

        Transaction transaction1 = new Transaction(177666, "NL93ABNA0585619023",
                "Flowers for Rik Theuß", new BigDecimal(44.85).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(-22.24).setScale(2, RoundingMode.HALF_UP), new BigDecimal(22.61).setScale(2, RoundingMode.HALF_UP));
        Transaction transaction2 = new Transaction(112806, "NL69ABNA0433647324",
                "Subscription for Jan Theuß", new BigDecimal(45.59).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(+48.18).setScale(2, RoundingMode.HALF_UP), new BigDecimal(93.77).setScale(2, RoundingMode.HALF_UP));

        transactionList.add(transaction1);
        transactionList.add(transaction2);

        List<Transaction> result = validator.validateTransactions(transactionList);
        assertTrue(result.size() == 0);
    }

    @Test
    public void validateTransactionsTestIdenticalTransactionReference(){
        Validator validator = new Validator();
        List<Transaction> transactionList = new ArrayList<>();

        Transaction transaction1 = new Transaction(177666, "NL93ABNA0585619023",
                "Flowers for Rik Theuß", new BigDecimal(44.85).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(-22.24).setScale(2, RoundingMode.HALF_UP), new BigDecimal(22.61).setScale(2, RoundingMode.HALF_UP));

        Transaction transaction2 = new Transaction(177666, "NL88ABNA0585619023",
                "More flowers for Rik Theuß", new BigDecimal(44.85).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(-22.24).setScale(2, RoundingMode.HALF_UP), new BigDecimal(22.61).setScale(2, RoundingMode.HALF_UP));

        Transaction transaction3 = new Transaction(112806, "NL69ABNA0433647324",
                "Subscription for Jan Theuß", new BigDecimal(45.59).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(+48.18).setScale(2, RoundingMode.HALF_UP), new BigDecimal(93.77).setScale(2, RoundingMode.HALF_UP));

        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);

        List<Transaction> result = validator.validateTransactions(transactionList);
        assertTrue(result.size() == 1);

        //todo: tests that trans ref = 177666 and accountnumber = NL88ABNA0585619023.
    }

    @Test
    public void validateTransactionsTestInvalidEndBalance() {
        Validator validator = new Validator();
        List<Transaction> transactionList = new ArrayList<>();

        Transaction transaction1 = new Transaction(177666, "NL93ABNA0585619023",
                "Flowers for Rik Theuß", new BigDecimal(44.85).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(-22.24).setScale(2, RoundingMode.HALF_UP), new BigDecimal(88.61).setScale(2, RoundingMode.HALF_UP));

        Transaction transaction2 = new Transaction(207666, "NL88ABNA0585619023",
                "More flowers for Rik Theuß", new BigDecimal(44.85).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(-22.24).setScale(2, RoundingMode.HALF_UP), new BigDecimal(22.61).setScale(2, RoundingMode.HALF_UP));

        Transaction transaction3 = new Transaction(112806, "NL69ABNA0433647324",
                "Subscription for Jan Theuß", new BigDecimal(45.59).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(+48.18).setScale(2, RoundingMode.HALF_UP), new BigDecimal(93.77).setScale(2, RoundingMode.HALF_UP));

        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);

        List<Transaction> result = validator.validateTransactions(transactionList);
        assertTrue(result.size() == 1);

        //todo: tests that trans ref = 177666 and accountnumber = NL93ABNA0585619023.
    }

    @Test
    public void validateTransactionsTestIdenticalTransactionReferenceAndInvalidEndBalance() {
        Validator validator = new Validator();
        List<Transaction> transactionList = new ArrayList<>();

        Transaction transaction1 = new Transaction(177666, "NL93ABNA0585619023",
                "Flowers for Rik Theuß", new BigDecimal(44.85).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(-22.24).setScale(2, RoundingMode.HALF_UP), new BigDecimal(22.61).setScale(2, RoundingMode.HALF_UP));

        Transaction transaction2 = new Transaction(177666, "NL88ABNA0585619023",
                "More flowers for Rik Theuß", new BigDecimal(44.85).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(-22.24).setScale(2, RoundingMode.HALF_UP), new BigDecimal(88.61).setScale(2, RoundingMode.HALF_UP));

        Transaction transaction3 = new Transaction(112806, "NL69ABNA0433647324",
                "Subscription for Jan Theuß", new BigDecimal(45.59).setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(+48.18).setScale(2, RoundingMode.HALF_UP), new BigDecimal(93.77).setScale(2, RoundingMode.HALF_UP));

        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);

        List<Transaction> result = validator.validateTransactions(transactionList);
        assertTrue(result.size() == 1);

        //todo: tests that trans ref = 177666 and accountnumber = NL88ABNA0585619023.
    }
}
