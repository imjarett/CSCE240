package prog2processor.src;

import java.io.*;
import java.util.Scanner;

public class processor {
    private String inputFileName;
    private String section;

    public processor(String inputFileName, String section) {
        this.inputFileName = inputFileName;
        this.section = section;
    }

    public void processQuery() {
        String response = "";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            //ALL INFO COMMAND HANDLING
            if(section.equals("all information")){
                while ((line = br.readLine()) != null) {
                    response += line + "\n";
                }
                System.out.println(response);
            }

            //RISK FACTORS COMMAND HANDLING
            if(section.equals("risk factors")){
            String startStringRisk = "Item 1A.    RISK FACTORS";
            String endStringRisk = "15";
            String gmStart = " ITEM 1A - Risk Factors";
            String gmEnd = " ITEM 1B - Unresolved Staff Comments";
                while ((line = br.readLine()) != null) {

                    //J&J CASE
                    if (line.equals(startStringRisk)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringRisk)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }
            //PROPERTIES COMMAND CASE
            if(section.equals("properties")){
                String startStringProperties = "Item 2.PROPERTIES";
                String endStringProperties = "Item 3.LEGAL PROCEEDINGS";
                String gmStart = "ITEM 2 - Properties";
                String gmEnd = "ITEM 3 - Legal Proceedings";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringProperties)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringProperties)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }

            //LEGAL PROCEEDINGS COMMAND CASE
            if(section.equals("legal proceedings")){
                String startStringLegal = "Item 3.LEGAL PROCEEDINGS";
                String endStringLegal = "Item 4.MINE SAFETY DISCLOSURES";
                String gmStart = "ITEM 3 - Legal Proceedings";
                String gmEnd = "ITEM 4 - Mine Safety Disclosures";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringLegal)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringLegal)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }

            //MINE SAFTEY DISCLOSURE COMMAND HANDLING
            if(section.equals("mine safety disclosures")){
                String startStringMine = "Item 4.MINE SAFETY DISCLOSURES";
                String endStringMine = "16";
                String gmStart = "ITEM 4 - Mine Safety Disclosures";
                String gmEnd = "PART II";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringMine)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringMine)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }

            //EXECUTIVE OFFICERS COMMAND CASE
            if(section.equals("executive officers")){
                String startStringExec = "EXECUTIVE OFFICERS OF THE REGISTRANT";
                String endStringExec = "19";
                String gmStart = "INFORMATION ABOUT OUR EXECUTIVE OFFICERS";
                String gmEnd = "WEBSITE ACCESS";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringExec)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringExec)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                    //GENERAL MILLS CASE
                    else if (line.equals(gmStart)) {
                        while ((line = br.readLine()) != null && !line.equals(gmEnd)) {
                            response += line+"\n";
                        }
                        System.out.println(response);
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "";
        String query = "";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the 10-K processor");
        System.out.println("Which companies 10-K form would you like to view?\n Options: 'General Mills', 'Johnson & Johnson'\n");
        boolean check1 = false;
        while(check1 == false){
            String company = keyboard.nextLine().toLowerCase();
            if(company.equals("general mills")){
                System.out.println("Company Given: General Mills");
                fileName = "./prog2processor/data/generalMills2023.txt";
                check1 = true;
            }
            else if(company.equals("johnson & johnson")){
                System.out.println("Company Given: Johnson & Johnson");
                fileName = "./prog2processor/data/j&j2023.txt";
                check1 = true;
            }
            else{
                System.out.println("Company not recognized. Please select from the listed options and ensure spelling is correct");
            }
        }
        System.out.println("Which section of the 10-K would you like to view?\n Options: 'Risk Factors', 'Properties', 'Legal Proceedings', 'Mine Safety Disclosures', 'Executive Officers', 'All Information'");
        boolean check2 = false;
        while(check2 == false){
            String userQuery = keyboard.nextLine().toLowerCase();
            if(!userQuery.equals("risk factors") && !userQuery.equals("properties") && !userQuery.equals("legal proceedings") && !userQuery.equals("mine safety disclosures") && !userQuery.equals("executive officers") && !userQuery.equals("all information")){
                System.out.println("Section not recognized. Please select from the listed options and ensure spelling is correct");
            }
            else{
                query = userQuery;
                check2 = true;
            }
        }
        processor p = new processor(fileName, query);
        p.processQuery();
        keyboard.close();
    }
}