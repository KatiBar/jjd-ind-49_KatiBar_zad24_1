public class BudgetIncomes {
    public static void main(String[] args) {
        BudgetDao budgetDao = new BudgetDao();
        System.out.println("Suma przychodów wynosi: ");
        System.out.printf(" -> %.2f zł \n", budgetDao.calculateSum(Type.INCOME.letter));
    }
}
