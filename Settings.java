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
    public Settings(String file_name) {
        loadSettings(file_name);
    }
    public String file_import = "Enter file name here";
    public ArrayList<Trial> loaded_trials = new ArrayList<>();
    public int red() {return red;}
    public void setRed(int set) {red = set; updateSettings("AppleAnalysis_Settings");};
    public int green() {return green;}
    public void setGreen(int set) {green = set; updateSettings("AppleAnalysis_Settings");};
    public int blue() {return blue;}
    public void setBlue(int set) {blue = set; updateSettings("AppleAnalysis_Settings");}
    public double variance() {return variance;}
    public void setVariance(double set) {variance = set;}
    public String fileImport() {return file_import;}
    public void setFileImport(String file_name) {file_import = file_name; updateSettings("AppleAnalysis_Settings");}
    public ArrayList<Trial> trials() {return loaded_trials;}
    public void setTrials(ArrayList<Trial> new_list) {loaded_trials = new_list;}
    public void addTrial(Trial add) { /* adds trial to ArrayList of trials */
        loaded_trials.add(add);
        updateTrials("AppleAnalysis_Trials");
    }
    /* removes trial from array list using String trial_name */
    public boolean removeTrial(String remove_name) {
        boolean remove_success = false;
        for(int i = loaded_trials.size() - 1; i > -1; i--) {
            /* if trial name matches name of trial to remove, remove it from list */
            if(loaded_trials.get(i).trialName().equals(remove_name)) {
                loaded_trials.remove(i);
                remove_success = true; /* specified trial found and removed successfully */
                updateTrials("AppleAnalysis_Trials");
            }
        }
        return remove_success;
    }
    public boolean loadSettings(String file_name) {
        try {
            FileReader file = new FileReader(file_name);
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
            return true;
        } catch (IOException e) {
            //Print("Error reading settings file\n");
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    /* updates "TextManipulator_Settings" with new values from program - will be run every time the user changes settings */
    public boolean updateSettings(String file_name) {
        boolean success = true;
        try {
            FileWriter file = new FileWriter(file_name);
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
    public boolean loadTrials(String file_name) {
        boolean load = true;
        try {
            FileReader file = new FileReader(file_name);
            BufferedReader read_trials = new BufferedReader(file);
            String line = "";
            while((line = read_trials.readLine()) != null) {
                boolean success[] = new boolean[1];
                Trial load_trial = new Trial();
                load_trial = load_trial.ReadDataFile(line, success);
                if(success[0]) {
                    addTrial(load_trial); /* add trial to array */
                } 
            }   
        } catch (IOException e) {
            //Print("Error reading settings file\n");
            load = false;
        }
        return load; /* returns whether "TextManipulator_Settings" was accessed and read */
    }
    public boolean updateTrials(String file_name) {
        try {
            FileWriter file = new FileWriter(file_name);
            BufferedWriter write_trials = new BufferedWriter(file);
            /* write settings to file (in the correct order), first converting each value to a char and comma-separating them */
            for(int i = 0; i < loaded_trials.size(); i++) {
                Trial write_trial = loaded_trials.get(i);
                write_trials.write(write_trial.fileName()); /* write file name of the trial to file */
                write_trials.newLine();
            }
            write_trials.close();
            return true;
        } catch(IOException e) {
            return false;
        }
    }

}
