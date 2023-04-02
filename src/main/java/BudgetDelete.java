import java.util.Scanner;

public class BudgetDelete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BudgetDao budgetDao = new BudgetDao();

        System.out.println("Podaj ID transakcji, którą chcesz usunąć:");
        long id = scanner.nextLong();
        scanner.nextLine();

        budgetDao.delete(id);
    }
}
