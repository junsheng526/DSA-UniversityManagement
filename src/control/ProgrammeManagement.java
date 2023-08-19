/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.ProgrammeManagementUI;
import entity.*;
import dao.ProgrammeDAO;
import utility.MessageUI;

public class ProgrammeManagement {

    private ListInterface<Programme> programmeList = new ArrayList<>();
    private ProgrammeManagementUI programmeUI = new ProgrammeManagementUI();
    private ProgrammeDAO programmeDAO = new ProgrammeDAO();

    public ProgrammeManagement() {
        programmeList = programmeDAO.retrieveFromFile();
    }

    public void runProgrammeManagement() {
        int choice = 0;
        do {
            choice = programmeUI.getMenuChoice();
            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    addNewProgramme();
                    programmeUI.displayMessage("New programme added.");
                    break;
                case 2:
                    listAllProgrammes();
                    break;
                case 3:
                    findProgramme();
                    break;
                case 4:
                    amendProgrammeDetails();
                    break;
                case 5:
                    listAllTutorialGroups();
                    break;
                case 6:
                    addTutorialGroup();
                    break;
                case 7:
                    removeTutorialGroup();
                    break;
                case 8:
                    generateReports();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public void addNewProgramme() {
        Programme newProgramme = programmeUI.inputProgrammeDetails();
        programmeList.add(newProgramme);
        programmeDAO.saveToFile(programmeList);
    }

    public void listAllProgrammes() {
        String outputStr = getAllProgrammes();
        programmeUI.displayMessage(outputStr);
    }

    public void findProgramme() {
        String programmeCode = programmeUI.inputProgrammeCode();
        Programme programme = findProgrammeByCode(programmeCode);
        if (programme != null) {
            programmeUI.displayProgrammeDetails(programme);
        } else {
            programmeUI.displayMessage("Programme not found.");
        }
    }

    public void amendProgrammeDetails() {
        String programmeCode = programmeUI.inputProgrammeCode();
        Programme programme = findProgrammeByCode(programmeCode);
        if (programme != null) {
            programmeUI.displayMessage("Enter new details:");
            Programme newProgrammeDetails = programmeUI.inputProgrammeDetails();
            programme.setCode(newProgrammeDetails.getCode());
            programme.setName(newProgrammeDetails.getName());
            programmeUI.displayMessage("Programme details amended.");
        } else {
            programmeUI.displayMessage("Programme not found.");
        }
    }

    public void listAllTutorialGroups() {

    }

    public void addTutorialGroup() {

    }

    public void removeTutorialGroup() {

    }

    public void generateReports() {
        // Implement generating relevant reports
        // This functionality will depend on the reports you need to generate
    }

    private Programme findProgrammeByCode(String programmeCode) {
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme programme = programmeList.getEntry(i);
            if (programme.getCode().equals(programmeCode)) {
                return programme;
            }
        }
        return null;
    }
    
    public String getAllProgrammes() {
        String outputStr = "List of Programmes:\n";
        Programme[] programmeArray = new Programme[programmeList.getNumberOfEntries()];

        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            programmeArray[i - 1] = programmeList.getEntry(i);
        }

        for (Programme programme : programmeArray) {
            outputStr += programme + "\n";
        }

        return outputStr;
    }

    public static void main(String[] args) {
        ProgrammeManagement programmeManagement = new ProgrammeManagement();
        programmeManagement.runProgrammeManagement();
    }
}


