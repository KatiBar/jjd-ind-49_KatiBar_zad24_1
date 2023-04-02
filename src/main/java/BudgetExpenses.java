public class BudgetExpenses {
    public static void main(String[] args) {
        BudgetDao budgetDao = new BudgetDao();
        System.out.println("Suma wydatków wynosi: ");
        System.out.printf(" -> %.2f zł\n", budgetDao.calculateSum(Type.EXPENSE.letter));
    }
}
