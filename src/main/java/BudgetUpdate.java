import java.util.Scanner;

public class BudgetUpdate {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BudgetDao budgetDao = new BudgetDao();

        System.out.println("Podaj ID transakcji, którą chcesz modyfikować:");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Dokonaj zmian:");
        System.out.println("Dodajesz " + Type.EXPENSE + ", czy " + Type.INCOME + "?");
        String type = scanner.nextLine();
        System.out.println("Dodaj opis:");
        String description = scanner.nextLine();
        System.out.println("Podaj kwotę:");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Podaj datę wykonania transakcji: yyyy-mm-dd");
        String dateFromUser = scanner.nextLine();
        Budget budget = new Budget(id, type, description, amount, dateFromUser);
        budgetDao.update(budget);

    }
}
