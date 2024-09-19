
package ui;
import java.util.Scanner;

public class Seguimiento2_parte2 {

    private Scanner escaner;
    private static boolean flag;

    private static String[] names = new String[10];
    private static String[] departments = new String[10];
    private static double[] budgetDept = new double[10];

    private static int totalPlaces = 0; 

    public Seguimiento2_parte2() {
        escaner = new Scanner(System.in);
    }

    /**
     * Description: The menu is displayed and the user input is processed.
     * preconditions: 
     * - The scanner must be initialized
     * 
     * postconditions:
     * - Depending on the option selected by the user, it calls register(); to register a biodiversity place.
     * - You can call departmentBudget(); Shows the budget of the selected department.
     * - You can exit the program.
     * 
     * @param flag value to keep track of the while loop.
     */
    public void run() {
        flag = false;

        System.out.println("Welcome volunteer to the COP 16 Cali - Colombia Biodiverse Sites Management application: ");
        System.out.println("We present the following options, enter: ");

        while (!flag) {
            System.out.println("Options:\n" +
                               "1. Register a place with biological diversity\n" +
                               "2. Check the average budget by department\n" +
                               "3. Exit the program\n");

            int option = escaner.nextInt();
            escaner.nextLine(); // Clean buffer

            switch (option) {
                case 1:
                    register();
                    break;
                case 2:
                    departmentBudget();
                    break;
                case 3:
                    flag = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Seguimiento2_parte2 mainApp = new Seguimiento2_parte2();
        mainApp.run();
    }

    /**
     * Description: This method allows you to register a new biodiversity site.
     * preconditions: 
     * - The scanner must be initialized and open.
     * - totalPLaces must be initialized to 0.
     * - the arrays names, departments and budgetDept must be initialized and accessible.
     * 
     * postconditions: 
     * - the name of the place, department and budget of ​​the site are saved in each list in the corresponding position.
     * - the variable totalPLaces is increased by 1 each time a new site is registered.. 
     */
    public void register() {
        if (totalPlaces >= 10) {
            System.out.println("The limit of possible places to register has been reached.");
            return;
        }

        System.out.print("Enter the name of the biodiverse place: ");
        String name = escaner.nextLine();

        System.out.print("Enter the department in which the place is located (Choco, Valle, Cauca, Narino): ");
        String department = escaner.nextLine();

        System.out.print("Enter the national budget allocated for this place: ");
        double budget = escaner.nextDouble();
        escaner.nextLine(); // Clean buffer

        names[totalPlaces] = name;
        departments[totalPlaces] = department;
        budgetDept[totalPlaces] = budget;

        totalPlaces++;
        System.out.println("Place entered successfully.");
    }

    /**
     * Description: This method calculates and shows the average budget for a selected department.
     * preconditions:
     * - There must be at least one registered site.
     * postconditions:
     * - The average budget for the selected department is displayed.
     */
    private void departmentBudget() {
        System.out.println("Select one of the four departments to review the budget average: Valle, Chocó, Cauca, or Narino.");
        String department = escaner.nextLine();

        double sumBudget = 0;
        int count = 0;

        for (int i = 0; i < totalPlaces; i++) {
            if (departments[i].equalsIgnoreCase(department)) {
                sumBudget += budgetDept[i];
                count++;
            }
        }

        if (count > 0) {
            double averageBudget = sumBudget / count;
            System.out.println("The average budget for the department of " + department + " is: " + averageBudget + " COP. ");
        } else {
            System.out.println("No places were found in the department " + department);
        }
    }
}
