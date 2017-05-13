import javafx.application.Application;
import javafx.application.Platform;
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
        String helpPath = "/opt/File-Manager/help/help.txt";

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
                }else if((args[0].equals("-rf") || args[0].equals("--removefile"))){

                    System.out.println(fm.rmFile(args[1]));

                    //DELETE DIRECTORY ARGUMENTS
                }else if((args[0].equals("-rd") || args[0].equals("--removedir"))){

                    System.out.println(fm.rmFolder(args[1]));

                    //SYMBOLIC LINK ARGUMENTS
                }else if((args[0].equals("-sl") || args[0].equals("--symboliclink"))){

                    if(args.length > 2) {

                        System.out.println(fm.mkLink(args[1], args[2]));

                    }else
                        System.out.println("Invalid argument!");

                }

            }else

                System.out.println("ERROR: Invalid argument(s)!");

        }
        }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("File Manager");
        FileManagerGui gui=new FileManagerGui();
        Scene Sc=new Scene(gui,800,500);
        primaryStage.setScene(Sc);
        primaryStage.show();
        primaryStage.setOnCloseRequest( e -> {
            Platform.exit();
            System.exit(0);
        });
    }
}
