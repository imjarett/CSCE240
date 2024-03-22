package prog4uiuserintent2querymapper.src;

import java.util.regex.*;
import java.util.Scanner;

public class processor {
    private static String company;
    private static String fileName = "";


    public static void calculateAndReadMatch(String userQuery) {
        String query = "";
        double riskPercent = countWordsContained(userQuery, "what are the risk factors for "+company, "Risk");
        double propertiesPercent = countWordsContained(userQuery, "tell me about "+company+"'s properties", "Properties");
        double legalPercent = countWordsContained(userQuery, "tell me about "+company+"'s' legal proceedings", "Legal Proceedings");
        double minePercent = countWordsContained(userQuery, "what are "+company+"'s mine safety disclosures", "Mine Safety Disclosures");
        double directorsPercent = countWordsContained(userQuery, "who are the directors","Directors");
        double execPercent = countWordsContained(userQuery, "who are the executives","Executives");
        double everythingPercent = countWordsContained(userQuery, "tell me everything","Everything");
        double operatePercent = countWordsContained(userQuery, "what markets does "+company+" operate in?","Operations");
        double disclosuresPercent = countWordsContained(userQuery, "are there aby disclosures from "+company,"Disclosures");
        double statementsPercent = countWordsContained(userQuery, "tell me about "+company+ "'s statements","Financial Statements");
        double generalAboutPercent = countWordsContained(userQuery, "tell me about "+company,"General About");
        double businessPercent = countWordsContained(userQuery, "explain the business of "+company, "Business");
        double ceoPercent = countWordsContained(userQuery, "who is "+company+"'s ceo", "CEO");
        double[] values = {riskPercent, propertiesPercent, legalPercent, minePercent, directorsPercent, execPercent, everythingPercent, operatePercent, disclosuresPercent, statementsPercent, generalAboutPercent, businessPercent, ceoPercent};
        double max = 0.0;
        System.out.println("Match Percentage: ");
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        System.out.println("Max percentage: "+max);
        if (max >= 70.0){
            if (max == riskPercent){
                query = "risk factors";
                Reader reader = new Reader(fileName, query);
                reader.processQuery();
            }
            else if (max == propertiesPercent){
                query = "properties";
                Reader reader = new Reader(fileName, query);
                reader.processQuery();
            }
            else if (max == legalPercent){
                query = "legal proceedings";
                Reader reader = new Reader(fileName, query);
                reader.processQuery();
            }
            else if (max == minePercent){
                query = "mine safety disclosures";
                Reader reader = new Reader(fileName, query);
                reader.processQuery();
            }
            else if (max == directorsPercent || max == execPercent){
                query = "directors";
                Reader reader = new Reader(fileName, query);
                reader.processQuery();
            }
            else if (max == everythingPercent){
                query = "all information";
                Reader reader = new Reader(fileName, query);
                reader.processQuery();
            }
            else if (max == operatePercent || max == disclosuresPercent){
                query = "operations and disclosures";
                Reader reader = new Reader(fileName, query);
                reader.processQuery();
            }
            else if (max == statementsPercent){
                query = "financial statements";
                Reader reader = new Reader(fileName, query);
                reader.processQuery();
            }
            else if (max == generalAboutPercent){
                query = "general";
                Reader reader = new Reader(fileName, query);
                reader.processQuery();
            }
            else if (max == businessPercent){
                query = "business";
                Reader reader = new Reader(fileName, query);
                reader.processQuery();
            }
            else if (max == ceoPercent){
                query = "ceo";
                Reader reader = new Reader(fileName, query);
                reader.processQuery();
            }
        }
        else{
            System.out.println("Query does not have high match percentage for any topic, please check spelling and include key words");
        }
    }

    public static double countWordsContained(String userQuery, String reportTopic, String title) {
        double queryMatchCount = 0;
        double totalWordCount = 0;

        String[] wordsInUserQuery = userQuery.split("\\s+");
        totalWordCount = wordsInUserQuery.length;
        System.out.println(title+"'s Total Word Count: "+totalWordCount);
        String[] wordsInReportTopic = reportTopic.split("\\s+");

        // Iterate over each word in string1
        for (String reportWord : wordsInReportTopic) {
            // Check if the word is contained in string2
            for (String userWord : wordsInUserQuery) {
                if (reportWord.equals(userWord)) {
                    queryMatchCount++;
                    break; // Break out of inner loop once a match is found
                }
            }
        }
        System.out.println(title+"'s Query Match Count: "+queryMatchCount);
        double temp = queryMatchCount / totalWordCount;
        double matchPercentage = temp * 100;
        System.out.println("Match Percentage: "+matchPercentage);
        return matchPercentage;
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the 10-K processor");
        System.out.println("Which companies 10-K form would you like to view?\n Options: 'General Mills', 'Johnson & Johnson'\n");
        boolean check1 = false;
        while(check1 == false){
            company = keyboard.nextLine().toLowerCase();
            if(company.equals("general mills")){
                System.out.println("Company Given: General Mills");
                fileName = "prog4uiuserintent2querymapper\\data\\generalMills2023.txt";
                check1 = true;
            }
            else if(company.equals("johnson & johnson")){
                System.out.println("Company Given: Johnson & Johnson");
                fileName = "prog4uiuserintent2querymapper\\data\\j&j2023.txt";
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
            if(containsQuit){
                System.out.println("Quitting program, goodbye!");
                check2 = true;
                break;
            }
            else{
                calculateAndReadMatch(userQuery);
            }
        }
        keyboard.close();
    }
}