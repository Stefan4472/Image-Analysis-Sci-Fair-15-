
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Trial {
    public static String file_name;
    public static String trial_name;
    public static Double brightness;
    public static Double scaled_brightness;
    public static int rank;
    
    public static boolean ReadTrial(String file) {
        boolean success = true;
        file_name = file;
        try {
            FileReader trial = new FileReader(file_name);
            BufferedReader read_trial = new BufferedReader(trial);
            String line = "";
            int line_counter = 1;
            while((line = read_trial.readLine()) != null) {
                switch(line_counter) {
                    case 1: 
                        trial_name = line;
                        break;
                    case 2:
                        brightness = Double.parseDouble(line);
                        break;    
                }
                line_counter++;
            }
        } catch (IOException e) {
            //Print("Error reading settings file\n");
            success = false;
        }
        return success;
    }
}
