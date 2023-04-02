import java.util.Scanner;

public class BudgetApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean result = true;

        while (result) {
            showOptions();
            String option = scanner.nextLine();

            switch (option) {
                case "1" -> BudgetInsert.main(new String[0]);
                case "2" -> BudgetUpdate.main(new String[0]);
                case "3" -> BudgetDelete.main(new String[0]);
                case "4" -> BudgetIncomes.main(new String[0]);
                case "5" -> BudgetExpenses.main(new String[0]);
                case "6" -> result = false;
                default -> System.out.println("Błędny wybór!");
            }
        }
    }

    private static void showOptions() {
        System.out.println("Dostępne opcje:");
        System.out.println("1. Dodaj transakcję");
        System.out.println("2. Modyfikuj transakcję");
        System.out.println("3. Usuń transakcję");
        System.out.println("4. Wyświetl wszystkie przychody");
        System.out.println("5. Wyświetl wszystkie wydatki");
        System.out.println("6. Zamknij aplikację");
    }
}
