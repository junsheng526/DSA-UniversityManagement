/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Programme;
import java.util.Scanner;

public class ProgrammeManagementUI {

    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("\nPROGRAMME MANAGEMENT MENU");
        System.out.println("1. Add a new programme");
        System.out.println("2. Remove a programme");
        System.out.println("3. Find a programme");
        System.out.println("4. Amend programme details");
        System.out.println("5. List all programmes");
        System.out.println("6. Add a tutorial group to a programme");
        System.out.println("7. Remove a tutorial group from a programme");
        System.out.println("8. List all tutorial groups for a programme");
        System.out.println("9. Generate relevant reports");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    public Programme inputProgrammeDetails() {
        System.out.print("Enter programme code: ");
        String programmeCode = scanner.nextLine();
        System.out.print("Enter programme name: ");
        String programmeName = scanner.nextLine();
        return new Programme(programmeCode, programmeName);
    }

    public String inputProgrammeCode() {
        System.out.print("Enter programme code: ");
        String code = scanner.nextLine();
        return code;
    }

    public String inputTutorialGroupCode() {
        System.out.print("Enter tutorial group code: ");
        String code = scanner.nextLine();
        return code;
    }

    public void displayProgrammeDetails(Programme programme) {
        System.out.println("Programme Details");
        System.out.println("Programme code: " + programme.getCode());
        System.out.println("Programme name: " + programme.getName());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
