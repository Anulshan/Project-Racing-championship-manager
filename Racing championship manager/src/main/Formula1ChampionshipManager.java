package main;

import racingleague.comparator.CustomComparator;
import racingleague.manager.RacingManager;
import racingleague.model.Formula1Driver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Formula1ChampionshipManager implements RacingManager {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object

    public static void main(String[] args) {

        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();
        boolean loop = true;
        while (loop==true) { //loops till user chooses to exit
            System.out.println("TO create a new driver: press 1 ");
            System.out.println("To delete a specific driver: press 2 ");
            System.out.println("To display the statistics of every driver: press 3 ");
            System.out.println("To exit interface: press 4 ");
            System.out.print("Please Enter your choice : ");

            int selectedChoice = formula1ChampionshipManager.myObj.nextInt();  // Read user input
            System.out.println("Selected Choice is: " + selectedChoice);  // Output user input

            if (selectedChoice==1) {
                formula1ChampionshipManager.createDriver();
            } else if (selectedChoice==2){
                formula1ChampionshipManager.myObj.nextLine();
                String teamCode;
                System.out.print("Enter the driver Code : ");
                teamCode = formula1ChampionshipManager.myObj.nextLine();
                formula1ChampionshipManager.deleteDriver(teamCode); //calls delete driver method and passes the user input
            } else if (selectedChoice==3){
                formula1ChampionshipManager.displayRaceTeams();
            } else if (selectedChoice==4){
                loop=false;
            } else {
                System.out.print("Enter a number between 1 and 4");
            }
        }
    }

    @Override
    public void createDriver() {
        Formula1Driver formula1Driver = new Formula1Driver();

            formula1Driver.setDriverName(myObj.nextLine());//extra line of code to solve an input issue
            System.out.print("Enter the driver name : ");
            formula1Driver.setDriverName(myObj.nextLine());
            System.out.print("Enter the driver Code : ");
            formula1Driver.setDriverCode(myObj.nextLine());
            System.out.print("Enter the driver location : ");
            formula1Driver.setDriverLocation(myObj.nextLine());
            System.out.print("Enter the driver team : ");
            formula1Driver.setDriverTeam(myObj.nextLine());
            System.out.print("Enter the match played date : ");
            formula1Driver.setRaceDate(myObj.nextLine());
            System.out.print("Enter the number of participated races : ");
            formula1Driver.setNoOfParticipatedRaces(myObj.nextInt());
            System.out.print("Enter the season points : ");
            formula1Driver.setSeasonPoints(myObj.nextInt());
            System.out.print("Enter the number position : ");
            formula1Driver.setPosition(myObj.nextInt());
            saveDetails(formula1Driver);
            System.out.println("You have successfully created new driver, driver details : \n" + formula1Driver);
    }
    @Override
    public void deleteDriver(String teamCode) {

        try {

            File inputFile = new File("driverDetails.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            File tempFile = new File("tempDriverDetails.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            boolean flag = false;
            int count = 0;
            System.out.println("Contents of the line");
            //Reading the contents of the file
            Scanner sc2 = new Scanner(new FileInputStream("driverDetails.txt"));
            while(sc2.hasNextLine()) {
                String line = sc2.nextLine();
                System.out.println(line);
                if(line.contains(teamCode)) {
                    System.out.println("Text found in this line : " + line);
                    flag = true;
                    count = count+1;
                }else{
                    System.out.println("Text not found in this lines : " + line);
                    writer.write(line + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();


            //line 178 - 179 contains alternative code that causes the form table to display all the modified data without erasing
            //the old existing record and the modified data shown are the increments of change meaning it shows the amount
            //by which the record would change.
            try{
                {

                    try (FileInputStream in = new FileInputStream(tempFile); FileOutputStream out = new FileOutputStream(inputFile)) {

                        int n;

                        // read() function to read the byte of data
                        while ((n = in.read()) != -1) {
                            // write() function to write the byte of data
                            out.write(n);
                        }
                    }
                    // close() function to close the stream
                    // close() function to close the stream
                    System.out.println("File Copied");
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
            if(flag) {
                System.out.println("File contains the specified word");
                System.out.println("Number of occurrences is: "+count+'\n');
            } else {
                System.out.println("File does not contain the specified word");
                System.out.println("Please enter a valid driver code."+'\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void displayRaceTeams() {
        ArrayList<Formula1Driver> formula1DriverList = new ArrayList<>();
        System.out.format("+------------------------------------------------------------------------------------" +
                "-------------------------------------------------------------------------------------------------" +
                "-----------------------------------------------------------------------------------------------------------+%n");
        System.out.format("%32s%32s%32s%32s%32s%32s%32s%32s%n",
                "Driver Name  |", "Driver Code |", "Driver Location |",
                "Driver Team |", "Race date |", "No of participated races |", "Season points |",
                "Position ");
        System.out.format("+------------------------------------------------------------------------------------" +
                "-------------------------------------------------------------------------------------------------" +
                "-----------------------------------------------------------------------------------------------------------+%n");
        try {
            Scanner sc2 = new Scanner(new FileInputStream("driverDetails.txt"));
            while(sc2.hasNextLine()) {
                Formula1Driver formula1Driver = new Formula1Driver();
                String line = sc2.nextLine();

                String[] result = line.split("[=,}]");

                formula1Driver.setDriverName(result[1]);
                formula1Driver.setDriverCode(result[3]);
                formula1Driver.setDriverLocation(result[5]);
                formula1Driver.setDriverTeam(result[7]);
                formula1Driver.setRaceDate(result[9]);
                formula1Driver.setNoOfParticipatedRaces(Integer.parseInt(result[11]));
                formula1Driver.setSeasonPoints(Integer.parseInt(result[13]));
                formula1Driver.setPosition(Integer.parseInt(result[15]));

                formula1DriverList.add(formula1Driver);

            }

            Collections.sort(formula1DriverList, new CustomComparator());

            for (Formula1Driver formula1Driver : formula1DriverList){
                System.out.format("%32s%32s%32s%32s%32s%32d%32d%32d%n",
                        formula1Driver.getDriverName(), formula1Driver.getDriverCode(), formula1Driver.getDriverLocation(),
                        formula1Driver.getDriverTeam(), formula1Driver.getRaceDate(),
                        formula1Driver.getNoOfParticipatedRaces(), formula1Driver.getSeasonPoints(),
                        formula1Driver.getPosition());

                System.out.format("+------------------------------------------------------------------------------------" +
                        "-------------------------------------------------------------------------------------------------" +
                        "-----------------------------------------------------------------------------------------------------------+%n");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private  String saveDetails(Formula1Driver formula1Driver) {
        try {

            File file = new File("driverDetails.txt");

            //if file doesn't exist, then create it
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("New File Created Now");
            }

            //true = append file
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(formula1Driver.toString());
            bufferWriter.close();
            fileWriter.close();

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

}
