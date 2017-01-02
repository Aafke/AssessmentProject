import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {

    public List<Transaction> validateTransactions(List<Transaction> transactionList) {
        Map<Integer, Transaction> uniqueTransactions = new HashMap<>();
        List<Transaction> failedTransactions = new ArrayList<>();

        for (Transaction transaction : transactionList) {
            if (uniqueTransactions.containsKey(transaction.reference) || !validEndBalance(transaction)) {
                failedTransactions.add(transaction);
            } else {
                uniqueTransactions.put(transaction.reference, transaction);
            }
        }
        return failedTransactions;
    }

    private boolean validEndBalance(Transaction transaction) {
        //todo: see how this is working with the decimals!
        return (transaction.startBalance.add(transaction.mutation).equals(transaction.endBalance) );
    }
}
