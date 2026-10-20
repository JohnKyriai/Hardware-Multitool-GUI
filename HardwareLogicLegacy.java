import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HardwareLogicLegacy{

    public String getCPUInfo(){
        return executeCommand("wmic cpu get caption, name, deviceid, numberofcores, maxclockspeed, status");  // Runs the command to get cpu info
    }

    public String getRAMInfo(){
        return executeCommand("wmic memorychip get capacity, devicelocator, partnumber");  // Runs the command to get ram info
    }

    public String getBIOSInfo(){
        return executeCommand("wmic bios get serialnumber, manufacturer, version, releasedate");  // Runs the command to get bios info
    }

    public String getMOTHERBOARDInfo(){
        return executeCommand("wmic baseboard get manufacturer, product, serialnumber, version");  // Runs the command to get motherboard info
    }

    public String getDRIVEInfo(){
        return executeCommand("wmic diskdrive get caption, model, size, status");  // Runs the command to get drive info
    }

    public String getGPUInfo(){
        return executeCommand("wmic path Win32_VideoController get description, pnpdeviceid, driverversion"); // Runs the command to get gpu info
    }

    public String getNETWORKInfo(){
        return executeCommand("wmic nic get AdapterType, Name, MACAddress, Speed, PNPDeviceID");  // Runs the command to get network info
    }

    public String getFANInfo(){
        return executeCommand("wmic path Win32_Fan get DeviceID,Name,DesiredSpeed,ActiveCooling");  // Runs the command to get fan info
    }

    public String getSOUNDInfo(){
        return executeCommand("wmic sounddev get Manufacturer,Name,Status,DeviceID");  // Runs the command to get sound info
    }


    private String executeCommand(String command) {
        StringBuilder result = new StringBuilder();
        try { // Try catch incase of error
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    result.append(line.trim()).append("\n");
                }
            }
        } catch (Exception e) {
            return "Error retrieving hardware data: " + e.getMessage(); // Program ends gracefully if error is found
        }
        return result.length() > 0 ? result.toString() : "No data retrieved.";
    }
}