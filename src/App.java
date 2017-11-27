import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String filename_read = "/home/swain/IdeaProjects/Json/src/company.txt";
        String filename_write = "/home/swain/IdeaProjects/Json/companyDescription.txt";
        Functions func = new Functions();
        func.readFromFile(filename_read);
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1":
                func.writeToFile(filename_write);
                break;
            case "2":
                func.checkKeyPeople();
                break;
            case "3":
                func.printFax();
                break;
            case "4":
                func.extractDomain();
                //func.replaceWWW();
                break;
            default:
                System.out.println("Invalid case");
        }
    }
}
