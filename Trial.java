
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Trial {
    public String file_name;
    public String trial_name;
    public Double brightness_change;
    
    public Trial() {}
    public Trial(String file_name, String trial_name, Double brightness_change) {
        this.file_name = file_name;
        this.trial_name = trial_name;
        this.brightness_change = brightness_change;
    }
    public void setTrial(String file, String trial, Double change) {
        file_name = file;
        trial_name = trial;
        brightness_change = change;
    }
    /* methods for setting and getting object attributes */
    public void setFileName(String name) {file_name = name;}
    public String fileName() {return file_name;}
    public void setTrialName(String name) {trial_name = name;}
    public String trialName() {return trial_name;}
    public void setBrightnessChange(Double change) {brightness_change = change;}
    public Double brightnessChange() {return brightness_change;}
    public ArrayList<String> getData() {
        return new ArrayList<String>() {{add(file_name);
            add(trial_name); add(Double.toString(brightness_change));}};
    }
    /* returns trial data as String */
    public void getString(Trial trial) {
        System.out.print(trial.fileName() + " | " + trial.trialName() + " | " + trial.brightnessChange());
    }
    /* prints trial data (for debugging purposes) */
    public void Println(Trial trial) {
        System.out.println(trial.fileName() + " | " + trial.trialName() + " | " + trial.brightnessChange());
    }
    /* gets trial info from specified file */
    public Trial ReadDataFile(String file, boolean success[]) {
        success[0] = true;
        file_name = file;
        try {
            FileReader trial = new FileReader(file_name);
            BufferedReader read_trial = new BufferedReader(trial);
            String line = "";
            while((line = read_trial.readLine()) != null) {
                file_name = line.substring(0, line.indexOf(","));
                trial_name = line.substring(line.indexOf(",") + 1, line.lastIndexOf(","));
                brightness_change = Double.parseDouble(line.substring(line.lastIndexOf(",") + 1));
            }
            return new Trial(file_name, trial_name, brightness_change);
        } catch (IOException e) {
            success[0] = false;
        } catch (NumberFormatException e) {
            success[0] = false;
        }
        return null; /* unable to import */
    }
    public boolean writeToFile(Trial trial) {
        try {
            FileWriter file = new FileWriter(trial.fileName());
            BufferedWriter write_data = new BufferedWriter(file);
            /* write settings to file (in the correct order), first converting each value to a char and comma-separating them */
            write_data.write(trial.fileName() + "," + trial.trialName() + "," + trial.brightnessChange());
            write_data.close();
            return true;
        } catch(IOException e) {
            return false;
        }
    }
    /* writes trial info to file */
    public boolean writeToFile(String file_name, String trial_name, Double brightness_change) {
        try {
            FileWriter file = new FileWriter(file_name);
            BufferedWriter write_data = new BufferedWriter(file);
            /* write settings to file (in the correct order), first converting each value to a char and comma-separating them */
            write_data.write(file_name + "," + trial_name + "," + brightness_change);
            write_data.close();
            return true;
        } catch(IOException e) {
            return false;
        }
    }
    public int Compare(Trial compare) {
        int action = 0; /* +1 : move up; 0 : equal; -1 : move down;*/
        if(brightness_change > compare.brightness_change)
            return 1;
        else if(brightness_change < compare.brightness_change)
            return -1;
        else
            return 0;
    }
}
