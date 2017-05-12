import java.util.Scanner;

/**
 * Created by billy on 4/30/17.
 */
public class fm {
    public static void main(String[] args) {
        FileManager fm = new FileManager();
        String helpPath = System.getProperty("user.dir") + "/help/help.txt";
        if(args.length !=0){

            //HELP ARGUMENTS
            if((args[0].equals("-h") || args[0].equals("--help"))) {

                //TODO
                System.out.println(fm.help(helpPath));

                //LIST ARGUMENTS
            }else if(args.length > 1){

                if((args[0].equals("-l") || args[0].equals("--list"))){

                    System.out.println(fm.listDir(args[1]));

                    //CHANGE PERMISSION ARGUMENTS
                }else if((args[0].equals("-c") || args[0].equals("--changepermission"))){

                    if(args.length > 2) {

                        System.out.println(fm.changePermission(Integer.parseInt(args[1]), args[2]));

                    }else
                        System.out.println("Invalid argument!");

                    //MAKE FILE ARGUMENTS
                }else if((args[0].equals("-mf") || args[0].equals("--makefile"))){

                    System.out.println(fm.mkFile(args[1]));

                    //MAKE DIRECTORY ARGUMENTS
                }else if((args[0].equals("-md") || args[0].equals("--makedir"))){

                    System.out.println(fm.mkFolder(args[1]));

                    //DELETE FILE ARGUMENTS
                }else if((args[0].equals("-df") || args[0].equals("--deletefile"))){

                    System.out.println(fm.delFile(args[1]));

                    //DELETE DIRECTORY ARGUMENTS
                }else if((args[0].equals("-dd") || args[0].equals("--deletedir"))){

                    System.out.println(fm.delFolder(args[1]));

                    //SYMBOLIC LINK ARGUMENTS
                }else if((args[0].equals("-sl") || args[0].equals("--symboliclink"))){

                    if(args.length > 2) {

                        System.out.println(fm.mkLink(args[1], args[2]));

                    }else
                        System.out.println("Invalid argument!");

                }

            }else

                System.out.println("ERROR: Invalid argument(s)!");

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
                        System.out.println(fm.mkLink(fpath, path));
                        break;

                    case "E":
                        break;

                    default:
                        System.out.println("Error!");
                }
            } while (!selection.equals("E"));
        }
    }
}
