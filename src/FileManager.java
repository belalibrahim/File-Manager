import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by billy on 4/30/17.
 */
public class FileManager {
    private Runtime runtime;
    private Process process;
    private BufferedReader input;
    private String line;
    private String result;

    public FileManager(){
        runtime = Runtime.getRuntime();
        process = null;
        input = null;
        line = null;
        result = "";
    }

    public String listDir(String path){

        try {
            process = runtime.exec("ls " + path);

            input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            result = "";
            while ((line = input.readLine()) != null)
                result += "\n" +  line;

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result.equals(""))
            result = "no such directory";

        return result;
    }

    public String changePermission(int permission, String path){

        //TODO
        try {
            process = runtime.exec("chmod " + permission + " " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String mkFile(String path){

        try {
            process = runtime.exec("touch " + path);
            result = "The file successfully created!";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String mkFolder(String path){

        try {
            process = runtime.exec("mkdir " + path);
            result = "The folder successfully created!";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String delFile(String path){

        try {
            process = runtime.exec("rm " + path);
            result = "The file successfully deleted!";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String delFolder(String path){

        try {
            process = runtime.exec("rmdir " + path);
            result = "The folder successfully deleted!";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
    public String mkLink(String path, String fpath){

        try {
            process = runtime.exec("ln -s " + fpath + " " + path);
            result = "The file is linked successfully!";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
    public String help(String fpath){
        try {
            process = runtime.exec("less " + fpath);

            input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            result = "";
            while ((line = input.readLine()) != null)
                result += "\n" +  line;

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result.equals(""))
            result = "no such directory";

        return result;
    }
}
