import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Settings {
    public int red = 0;
    public int green = 0;
    public int blue = 0;
    public double variance = 0.0;
    public String file_import = "Enter file name here";
    public ArrayList<Trial> loaded_trials = new ArrayList<>();
    /// note: it is better practice to access these variables with "getter" and "setter" methods
    public int GetRed() {return red;}
    public void SetRed(int set) {red = set; UpdateSettings();};
    public int GetGreen() {return green;}
    public void SetGreen(int set) {green = set; UpdateSettings();};
    public int GetBlue() {return blue;}
    public void SetBlue(int set) {blue = set; UpdateSettings();}
    public double GetVariance() {return variance;}
    public void SetVariance(double set) {variance = set;}
    public String GetFileImport() {return file_import;}
    public void SetFileImport(String file_name) {file_import = file_name; UpdateSettings();}
    public ArrayList<Trial> GetTrials() {return loaded_trials;}
    public void SetTrials(ArrayList<Trial> new_list) {loaded_trials = new_list;}
    public void AddTrial(Trial add) { /* adds trial to vector of trials */
        loaded_trials.add(add);
        UpdateTrials();
    }
    /* removes trial from array list */
    public boolean RemoveTrial(Trial remove) {
        boolean remove_success;
        do {
            remove_success = loaded_trials.remove(remove);
        }while (remove_success);
        return remove_success;
    }
    /* removes trial from array list using String trial_name */
    public boolean RemoveTrial(String remove_name) {
        boolean remove_success = false;
        for(int i = loaded_trials.size() - 1; i > -1; i--) {
            /* if trial name matches name of trial to remove, remove it from list */
            if(loaded_trials.get(i).GetTrialName().equals(remove_name)) {
                System.out.println("Removed " + loaded_trials.get(i).GetTrialName());
                loaded_trials.remove(i);
                remove_success = true; /* specified trial found and removed successfully */
            }
        }
        return remove_success;
    }
    public void PrintTrials() {
        Trial trial = new Trial();
        for(int i = 0; i < loaded_trials.size(); i++)
            trial.Println(loaded_trials.get(i));
        System.out.println(loaded_trials.size() + " trials loaded.");
    }
    public Settings LoadSettings() {
        boolean load = true;
        try {
            FileReader file = new FileReader("AppleAnalysis_Settings");
            BufferedReader read_settings = new BufferedReader(file);
            String line = "";
            int line_counter = 1;
            while((line = read_settings.readLine()) != null) {
                switch(line_counter) {
                    case 1: 
                        file_import = line;
                        break;
                    case 2:
                        red = Integer.parseInt(line.trim());
                        break;
                    case 3:
                        green = Integer.parseInt(line.trim());
                        break;
                    case 4:
                        blue = Integer.parseInt(line.trim());
                        break;
                        
                }
                line_counter++;
            }
        } catch (IOException e) {
            //Print("Error reading settings file\n");
            load = false;
        }
        Settings settings = new Settings();
        settings.SetRed(red);
        settings.SetGreen(green);
        settings.SetBlue(blue);
        settings.SetFileImport(file_import);
        return settings; /* returns whether "TextManipulator_Settings" was accessed and read */
    }
    /* updates "TextManipulator_Settings" with new values from program - will be run every time the user changes settings */
    public boolean UpdateSettings() {
        boolean success = true;
        try {
            FileWriter file = new FileWriter("AppleAnalysis_Settings");
            BufferedWriter write_settings = new BufferedWriter(file);
            /* write settings to file (in the correct order), first converting each value to a char and comma-separating them */
            write_settings.write(file_import);
            write_settings.newLine();
            write_settings.write(Integer.toString(red));
            write_settings.newLine();
            write_settings.write(Integer.toString(green));
            write_settings.newLine();
            write_settings.write(Integer.toString(blue));
            write_settings.close();
        } catch(IOException e) {
            //Print("Error writing to file\n");
            success = false;
        }
        return success;
    }
    public boolean LoadTrials() {
        boolean load = true;
        try {
            FileReader file = new FileReader("AppleAnalysis_Trials");
            BufferedReader read_trials = new BufferedReader(file);
            String line = "";
            while((line = read_trials.readLine()) != null) {
                boolean success[] = new boolean[1];
                Trial load_trial = new Trial();
                load_trial = load_trial.ReadDataFile(line, success);
                if(success[0]) {
                    AddTrial(load_trial); /* add trial to array */
                } 
            }   
        } catch (IOException e) {
            //Print("Error reading settings file\n");
            load = false;
        }
        return load; /* returns whether "TextManipulator_Settings" was accessed and read */
    }
    public boolean UpdateTrials() {
        boolean success = true;
        try {
            FileWriter file = new FileWriter("AppleAnalysis_Trials");
            BufferedWriter write_trials = new BufferedWriter(file);
            /* write settings to file (in the correct order), first converting each value to a char and comma-separating them */
            for(int i = 0; i < loaded_trials.size(); i++) {
                Trial write_trial = loaded_trials.get(i);
                System.out.println("Updated " + write_trial.GetTrialName());
                write_trials.write(write_trial.GetFileName()); /* write file name of the trial to file */
                write_trials.newLine();
            }
            write_trials.close();
        } catch(IOException e) {
            //Print("Error writing to file\n");
            success = false;
        }
        return success;
    }

}
