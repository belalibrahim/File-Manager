import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * Created by billy on 4/30/17.
 */
public class fm extends Application{
    public static void main(String[] args) {
        launch(args);
        FileManager fm = new FileManager();
        String helpPath = "help/help.txt";
        if(args.length !=0 && (args[0].equals("-h") || args[0].equals("--help"))){

                //TODO
                System.out.println(fm.help(helpPath));



        }else {

            String selection;
            String path;

            Scanner input = new Scanner(System.in);

            System.out.println("<<<<<<<<<<<<<<<FILE MANAGER>>>>>>>>>>>>>>>");

            do {

                System.out.println("\nPress 'A' to List files/directories.\n" +
                        "Press 'B' to Change permissions of files.\n" +
                        "Press 'C' to Make/delete files/directories.\n" +
                        "Press 'D' to Create symbolic link files.\n" +
                        "Press 'E' to Exit.");
                System.out.print("$ ");
                selection = input.next().toUpperCase();

                switch (selection) {
                    case "A":
                        System.out.println("Enter the path you want to list.");
                        System.out.print("$ ");
                        path = input.next();
                        System.out.println(fm.listDir(path));
                        break;

                    case "B":
                        System.out.println("Enter the type of permission in decimal.");
                        System.out.print("$ ");
                        int permission = input.nextInt();
                        System.out.println("Enter the file path you want to change permission.");
                        System.out.print("$ ");
                        path = input.next();
                        System.out.println(fm.changePermission(permission, path));
                        break;

                    case "C":
                        System.out.println("Press 1 to make a file.\n" +
                                "Press 2 to make a folder.\n" +
                                "Press 3 to delete a file.\n" +
                                "Press 4 to delete a folder");

                        System.out.print("$ ");
                        int option = input.nextInt();

                        switch (option) {
                            case 1:
                                System.out.println("Enter the file path you want to make in.");
                                System.out.print("$ ");
                                path = input.next();
                                System.out.println(fm.mkFile(path));
                                break;

                            case 2:
                                System.out.println("Enter the folder path you want to make in.");
                                System.out.print("$ ");
                                path = input.next();
                                System.out.println(fm.mkFolder(path));
                                break;

                            case 3:
                                System.out.println("Enter the file path you want to delete.");
                                System.out.print("$ ");
                                path = input.next();
                                System.out.println(fm.delFile(path));
                                break;

                            case 4:
                                System.out.println("Enter the folder path you want to delete.");
                                System.out.print("$ ");
                                path = input.next();
                                System.out.println(fm.delFolder(path));
                                break;

                            default:
                                System.out.println("Error!");
                        }
                        break;

                    case "D":
                        System.out.println("Enter the file path you want to link.");
                        System.out.print("$ ");
                        String fpath = input.next();
                        System.out.println("Enter the path you want to link the file in.");
                        System.out.print("$ ");
                        path = input.next();
                        System.out.println(fm.mkLink(path, fpath));
                        break;

                    case "E":
                        break;

                    default:
                        System.out.println("Error!");
                }
            } while (!selection.equals("E"));
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("File Manager");
        FileManagerGui gui=new FileManagerGui();
        Scene Sc=new Scene(gui,800,500);
        primaryStage.setScene(Sc);
        primaryStage.show();
    }
}
