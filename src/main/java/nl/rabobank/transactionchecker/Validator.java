package nl.rabobank.transactionchecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Validates the transactions on unique reference numbers and valid end balance.
 */
public class Validator {
    /**
     * Validates the transaciton on unique reference numbers and valid end balance.
     * If transaction is invalid it is returned in the list with invalid transactions.
     * @param transactionList List of transactions to be validated
     * @return List of invalid transactions
     */
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
        return (transaction.startBalance.add(transaction.mutation).equals(transaction.endBalance) );
    }
}
