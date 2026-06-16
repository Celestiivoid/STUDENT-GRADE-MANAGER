import java.util.Scanner;
import java.util.ArrayList;

public class STUDENTGRADEMANAGER {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> array = new ArrayList<>();
    static ArrayList<Double> arrayD = new ArrayList<>();
    static ArrayList<String> arrayS = new ArrayList<>();
    public static void main(String[] args) {
        while(true) {
            System.out.println("=====STUDENT-GRADE-MANAGER=====");
            System.out.println("[1] Add Student");
            System.out.println("[2] View All Students");
            System.out.println("[3] Search Student");
            System.out.println("[4] Edit Student Grade");
            System.out.println("[5] Remove Student");
            System.out.println("[6] Show Class Average");
            System.out.println("[7] Exit");

            System.out.println("Enter an option: ");
            int option = -1;

            try {
                option = Integer.parseInt(scanner.nextLine());
                if(option < 1 || option >= 8) {
                    System.out.println("Out of range!");
                    continue;
                }
            } catch(NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            switch(option) {
                case 1 -> ADD();
                case 2 -> VIEW();
                case 3 -> SEARCH();
                case 4 -> EDIT();
                case 5 -> REMOVE();
                case 6 -> SHOWAVG();
                case 7 -> {
                    while(true) {
                        System.out.println("Do you want to exit? ");
                        String exit = scanner.nextLine();

                        if(exit.equalsIgnoreCase("Yes")) {
                            return;
                        } else if(exit.equalsIgnoreCase("No")) {
                            break;
                        }
                        else {
                            System.out.println("Invalid input!");
                        }
                    }
                }
            }
        }
    }
    static void ADD() {
        while(true) {
            System.out.println("=====ADD-A-STUDENT=====");
            System.out.println("Enter a student name: ");
            String studentname = scanner.nextLine();


            if(studentname.isEmpty()) {
                System.out.println("Student name field cannot be empty.");
                continue;
            }

            System.out.println("Enter grade: ");
            Double grades;

            try {
                grades = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }


            if(grades > 100.0) {
                System.out.println("System says: Grades cannot go beyond more than 100.0%.");
                continue;
            } else {
                if(grades >= 75) {
                    String StatPass = "Pass";
                    arrayS.add(StatPass);
                } else if(grades < 75) {
                    String StatFail = "Fail";
                    arrayS.add(StatFail);
                }
                array.add(studentname);
                arrayD.add(grades);
                System.out.println("Successfully added " + studentname + ".");
                return;
            }
        }
    }
    static void VIEW() {
        System.out.println("=====VIEW-STUDENTS=====");

        if(array.isEmpty()) {
            System.out.println("No records of students.");
            return;
        }

        for(int i = 0; i < array.size() && i < arrayD.size() && i < arrayS.size(); i++) {
            System.out.println((i + 1) + "." + array.get(i) + " | " + arrayD.get(i) + " | " + arrayS.get(i));
        } 
    }
    static void SEARCH() {
        while(true) {
            System.out.println("=====SEARCH-STUDENT=====");

            if(array.isEmpty() && arrayD.isEmpty() && arrayS.isEmpty()) {
                System.out.println("No students in list.");
                return;
            }

            System.out.println("Enter a student name: ");
            String search = scanner.nextLine();

            for(int i = 0; i < array.size() && i < arrayD.size() && i < arrayS.size(); i++) {
                if(search.equalsIgnoreCase(array.get(i))) {
                    System.out.println(array.get(i) + " | " + arrayD.get(i) + " | " + arrayS.get(i));
                    return;
                }
            }
            System.out.println("Sutdent not found");
        }
    }
    static void EDIT() {
        while(true) {
            System.out.println("=====EDIT-STUDENTS-INFORMATIONS=====");
            
            if(array.isEmpty() && arrayD.isEmpty() && arrayS.isEmpty()) {
                System.out.println("No students informations to edit.");
                return;
            }

            for(int i = 0; i < array.size() && i < arrayD.size() && i < arrayS.size(); i++) {
                System.out.println((i + 1) + "." + array.get(i) + " | " + arrayD.get(i) + " | " + arrayS.get(i));
            }

            System.out.println("Select a student to edit: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("numbers only!");
                continue;
            }

            if(choice < 1 || choice > array.size() && choice > arrayD.size() && choice > arrayS.size()) {
                System.out.println("Out of range!");
                continue;
                }
            
            System.out.println("Enter new student name: ");
            String newSname = scanner.nextLine();

            System.out.println("Enter new grade: ");
            Double newSgrade;

            try {
                newSgrade = Double.parseDouble(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(newSgrade >= 75) {
                String newStatPass = "Pass";
                arrayS.set(choice - 1,newStatPass);
            }
            else if(newSgrade < 75) {
                String newStatFail = "Fail";
                arrayS.set(choice - 1,newStatFail);
            }

            array.set(choice - 1, newSname);
            arrayD.set(choice -1,newSgrade);
            System.out.println("Successfully edited!");
            return;
        }
    } 
    static void REMOVE() {
        while(true) {
            System.out.println("=====REMOVE-STUDENT=====");

            if(array.isEmpty() && arrayD.isEmpty() && arrayS.isEmpty()) {
                System.out.println("No students in list for removal.");
                return;
            }

            for(int i = 0; i < array.size() && i < arrayD.size() && i < arrayS.size(); i++) {
                System.out.println((i + 1) + "." + array.get(i) + " | " + arrayD.get(i) + " | " + arrayS.get(i));
            }

            System.out.println("Pick a student to remove: ");
            int choice;
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(choice < 1 || choice > array.size() && choice > arrayD.size() && choice > arrayS.size()) {
                System.out.println("Out of range!");
                continue;
            }

            String removed = array.remove(choice - 1);
            arrayD.remove(choice - 1);
            arrayS.remove(choice -1);
            System.out.println("Successfully removed! " + removed);
            return;
        }
    }
    static void SHOWAVG() {
        System.out.println("=====STUDENTS-AVERAGE=====");
        double total = 0;

        if(array.isEmpty() && arrayD.isEmpty() && arrayS.isEmpty()) {
            System.out.println("No class average to display.");
            return;
        }

        for(int i = 0; i < array.size() && i < arrayD.size() && i < arrayS.size(); i++) {
            System.out.println((i + 1) + "." + array.get(i) + " | " + arrayD.get(i) + " | " + arrayS.get(i));
            total += arrayD.get(i);
        }
        Double average = total / arrayD.size();
        System.out.println("Class average: " + average);
    }
}