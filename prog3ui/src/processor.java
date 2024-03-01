package prog3ui.src;

import java.io.*;
import java.util.regex.*;
import java.util.Scanner;

public class processor {
    private String inputFileName;
    private String section;
    private static String company;

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
                String gmEnd = "PART II)";
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

            //DIRECTORS/EXECUTIVE OFFICERS COMMAND CASE
            if(section.equals("directors")){
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

            //SUMMARY COMMAND CASE
            if(section.equals("summary")){
                String startStringSum = "Item 1.BUSINESS";
                String endStringSum = "19";
                String gmStart = "PART I)";
                String gmEnd = "PART II)";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringSum)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringSum)) {
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

            //OPERATIONS AND DISCLOSURES COMMAND CASE
            if(section.equals("operations and disclosures")){
                String startStringOD = "    PART II";
                String endStringOD = "    PART III";
                String gmStart = "PART II)";
                String gmEnd = "PART III)";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringOD)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringOD)) {
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

            //FINANCIAL STATEMENTS COMMAND CASE
            if(section.equals("financial statements")){
                String startStringFin = "PART IV ";
                String endStringFin = "The Company hereby agrees to furnish a copy of any such instrument to the SEC upon request.";
                String gmStart = "PART IV)";
                String gmEnd = "96";
                while ((line = br.readLine()) != null) {
                    //J&J CASE
                    if (line.equals(startStringFin)) {
                        while ((line = br.readLine()) != null && !line.equals(endStringFin)) {
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
            company = keyboard.nextLine().toLowerCase();
            if(company.equals("general mills")){
                System.out.println("Company Given: General Mills");
                fileName = "prog3ui\\data\\generalMills2023.txt";
                check1 = true;
            }
            else if(company.equals("johnson & johnson")){
                System.out.println("Company Given: Johnson & Johnson");
                fileName = "prog3ui\\data\\j&j2023.txt";
                check1 = true;
            }
            else{
                System.out.println("Company not recognized. Please select from the listed options and ensure spelling is correct");
            }
        }
        boolean check2 = false;
        while(check2 == false){
            System.out.println("What would you like to know about "+company+"?");
            System.out.println("Possible Options: Everything, Risk Factors, Operations, Disclosures, Directors/Executive Officers, Financial Statements, Properties, Legal Proceedings, Mine Safety Disclosures,  ");
            String userQuery = keyboard.nextLine().toLowerCase();
            Pattern quit = Pattern.compile(".*q.*");
            Matcher quitMatcher = quit.matcher(userQuery);
            boolean containsQuit = quitMatcher.matches();

            Pattern risk = Pattern.compile(".*\\brisk\\b.*");
            Matcher riskMatcher = risk.matcher(userQuery);
            boolean containsRisk = riskMatcher.matches();

            Pattern properties = Pattern.compile(".*\\bproperties\\b.*");
            Matcher propertiesMatcher = properties.matcher(userQuery);
            boolean containsProperties = propertiesMatcher.matches();

            Pattern legal = Pattern.compile(".*\\blegal\\b.*");
            Matcher legalMatcher = legal.matcher(userQuery);
            boolean containsLegal = legalMatcher.matches();

            Pattern mine = Pattern.compile(".*\\bmine\\b.*");
            Matcher mineMatcher = mine.matcher(userQuery);
            boolean containsMine = mineMatcher.matches();

            Pattern executives = Pattern.compile(".*\\bexecutive\\b.*");
            Matcher execMatcher = executives.matcher(userQuery);
            boolean containsExec = execMatcher.matches();

            Pattern directors = Pattern.compile(".*\\bdirectors\\b.*");
            Matcher directorsMatcher = directors.matcher(userQuery);
            boolean containsDirector = directorsMatcher.matches();

            Pattern allInfo = Pattern.compile(".*\\beverything\\b.*");
            Matcher allMatcher = allInfo.matcher(userQuery);
            boolean containsAll = allMatcher.matches();

            Pattern operations = Pattern.compile(".*\\boperate\\b.*");
            Matcher opMatcher = operations.matcher(userQuery);
            boolean containsOp = opMatcher.matches();

            Pattern disclosures = Pattern.compile(".*\\bdisclosures\\b.*");
            Matcher discMatcher = disclosures.matcher(userQuery);
            boolean containsDisc = discMatcher.matches();

            Pattern financial = Pattern.compile(".*\\bstatements\\b.*");
            Matcher finMatcher = financial.matcher(userQuery);
            boolean containsFin = finMatcher.matches();

            if(userQuery.equals("tell me about "+company)){
                query = "summary";
                processor p = new processor(fileName, query);
                p.processQuery();
            }
            else if(!containsQuit && !containsRisk && !containsProperties && !containsLegal && !containsMine && !containsExec && !containsDirector && !containsAll && !containsDisc & !containsFin && !containsOp){
                System.out.println("I do not know this information");
            }
            else if(containsQuit){
                System.out.println("Quitting program, goodbye!");
                check2 = true;
                break;
            }
            else if(containsRisk){
                query = "risk factors";
                processor p = new processor(fileName, query);
                p.processQuery();
            }
            else if(containsProperties){
                query = "properties";
                processor p = new processor(fileName, query);
                p.processQuery();
            }
            else if(containsLegal){
                query = "legal proceedings";
                processor p = new processor(fileName, query);
                p.processQuery();
            }
            else if(containsMine){
                query = "mine safety disclosures";
                processor p = new processor(fileName, query);
                p.processQuery();
            }
            else if(containsExec || containsDirector){
                query = "directors";
                processor p = new processor(fileName, query);
                p.processQuery();
            }
            else if(containsOp || containsDisc){
                query = "operations and disclosures";
                processor p = new processor(fileName, query);
                p.processQuery();
            }
            else if(containsFin){
                query = "financial statements";
                processor p = new processor(fileName, query);
                p.processQuery();
            }
            else if(containsAll){
                query = "all information";
                processor p = new processor(fileName, query);
                p.processQuery();
            }
        }
        keyboard.close();
    }
}