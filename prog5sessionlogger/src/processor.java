package prog5sessionlogger.src;

import java.util.regex.*;
import java.util.Scanner;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class processor {
    private static String company;
    private static String fileName = "";
    private static int systemUtteranceCount;
    private static int userUtteranceCount;
    private static String chatLog = "";

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
                System.out.println(reader.processQuery());
                chatLog += reader.processQuery() + "\n";
            }
            else if (max == propertiesPercent){
                query = "properties";
                Reader reader = new Reader(fileName, query);
                System.out.println(reader.processQuery());
                chatLog += reader.processQuery() + "\n";
            }
            else if (max == legalPercent){
                query = "legal proceedings";
                Reader reader = new Reader(fileName, query);
                System.out.println(reader.processQuery());
                chatLog += reader.processQuery() + "\n";
            }
            else if (max == minePercent){
                query = "mine safety disclosures";
                Reader reader = new Reader(fileName, query);
                System.out.println(reader.processQuery());
                chatLog += reader.processQuery() + "\n";
            }
            else if (max == directorsPercent || max == execPercent){
                query = "directors";
                Reader reader = new Reader(fileName, query);
                System.out.println(reader.processQuery());
                chatLog += reader.processQuery() + "\n";
            }
            else if (max == everythingPercent){
                query = "all information";
                Reader reader = new Reader(fileName, query);
                System.out.println(reader.processQuery());
                chatLog += reader.processQuery() + "\n";
            }
            else if (max == operatePercent || max == disclosuresPercent){
                query = "operations and disclosures";
                Reader reader = new Reader(fileName, query);
                System.out.println(reader.processQuery());
                chatLog += reader.processQuery() + "\n";
            }
            else if (max == statementsPercent){
                query = "financial statements";
                Reader reader = new Reader(fileName, query);
                System.out.println(reader.processQuery());
                chatLog += reader.processQuery() + "\n";
            }
            else if (max == generalAboutPercent){
                query = "general";
                Reader reader = new Reader(fileName, query);
                System.out.println(reader.processQuery());
                chatLog += reader.processQuery() + "\n";
            }
            else if (max == businessPercent){
                query = "business";
                Reader reader = new Reader(fileName, query);
                System.out.println(reader.processQuery());
                chatLog += reader.processQuery() + "\n";
            }
            else if (max == ceoPercent){
                query = "ceo";
                Reader reader = new Reader(fileName, query);
                System.out.println(reader.processQuery());
                chatLog += reader.processQuery() + "\n";
            }
        }
        else{
            System.out.println("I don't know this information");
            chatLog += "I don't know this information\n";
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
    public static void main(String[] args) throws IOException {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String formattedDateTime = currentTime.format(formatter);
        String outputFileName = formattedDateTime + ".txt";
        System.out.println(fileName);
        File chatFile = new File("./prog5sessionlogger/data/chat_sessions/" + outputFileName);
        if (chatFile.createNewFile()) {
            System.out.println("File created: " + chatFile.getAbsolutePath());
        } else {
            System.out.println("File already exists.");
        }
        long startTime = System.currentTimeMillis();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the 10-K processor");
        chatLog += "Welcome to the 10-K processor\n";
        System.out.println("Which companies 10-K form would you like to view?\n Options: 'General Mills', 'Johnson & Johnson'\n");
        chatLog += "Which companies 10-K form would you like to view?\n Options: 'General Mills', 'Johnson & Johnson'\n";
        boolean check1 = false;
        while(check1 == false){
            company = keyboard.nextLine().toLowerCase();
            userUtteranceCount++;
            chatLog += company + "\n";
            if(company.equals("general mills")){
                System.out.println("Company Given: General Mills");
                chatLog += "Company Given: General Mills\n";
                systemUtteranceCount++;
                fileName = "prog5sessionlogger\\data\\generalMills2023.txt";
                check1 = true;
            }
            else if(company.equals("johnson & johnson")){
                System.out.println("Company Given: Johnson & Johnson");
                chatLog += "Company Given: Johnson & Johnson\n";
                systemUtteranceCount++;
                fileName = "prog5sessionlogger\\data\\j&j2023.txt";
                check1 = true;
            }
            else{
                System.out.println("Company not recognized. Please select from the listed options and ensure spelling is correct");
                chatLog += "Company not recognized. Please select from the listed options and ensure spelling is correct";
                systemUtteranceCount++;
            }
        }
        boolean check2 = false;
        while(check2 == false){
            System.out.println("What would you like to know about "+company+"?");
            System.out.println("Possible Options: Everything, Risk Factors, Operations, Disclosures, Directors/Executive Officers, Financial Statements, Properties, Legal Proceedings, Mine Safety Disclosures");
            System.out.println("Commands for CSV file: '-summary' , '-showchat-summary' , '-showchat'");
            chatLog += "What would you like to know about "+company+"?\nPossible Options: Everything, Risk Factors, Operations, Disclosures, Directors/Executive Officers, Financial Statements, Properties, Legal Proceedings, Mine Safety Disclosures\nCommands for CSV file: '-summary' , '-showchat-summary' , '-showchat'";
            String userQuery = keyboard.nextLine().toLowerCase();
            chatLog += userQuery + "\n";
            userUtteranceCount++;
            Pattern quit = Pattern.compile(".*q.*");
            Matcher quitMatcher = quit.matcher(userQuery);
            boolean containsQuit = quitMatcher.matches();
            if(containsQuit){
                System.out.println("Quitting program, goodbye!");
                systemUtteranceCount++;
                chatLog += "Quitting program, goodbye!";
                check2 = true;
                break;
            }
            else if(userQuery.equals("-summary")){
                int localLineCount = -1;
                String localLine;
                BufferedReader localReader = new BufferedReader(new FileReader("./prog5sessionlogger/data/chat_statistics.csv"));
                while ((localLine = localReader.readLine()) != null) {
                    localLineCount++;
                }
                if(localLineCount == 0){
                    System.out.println("Error: CSV file has no data to summarize yet.");
                }
                else{
                    String finalLine;
                    String[] parts = {};
                    int chatSum = 0;
                    int userUttSum = 0;
                    int systemUttSum = 0;
                    double timeSum = 0.0;
                    BufferedReader finalReader = new BufferedReader(new FileReader("./prog5sessionlogger/data/chat_statistics.csv"));
                    finalReader.readLine();
                    while ((finalLine = finalReader.readLine()) != null) {
                        parts = finalLine.split(",");
                        chatSum += Integer.parseInt(parts[0]);
                        userUttSum += Integer.parseInt(parts[2]);
                        systemUttSum += Integer.parseInt(parts[3]);
                        timeSum += Double.parseDouble(parts[4]);
                    }
                    System.out.println("There are "+chatSum+" chats to date with the user asking "+userUttSum+" times and the system responding "+systemUttSum+"times. Total duration is "+timeSum+" seconds");
                }
            }
            else if(userQuery.equals("-showchat-summary")){
                System.out.println("Which chat number would you like a summary of?");
                int chatChoice = keyboard.nextInt();
                int localLineCount = -1;
                String localLine;
                BufferedReader localReader = new BufferedReader(new FileReader("./prog5sessionlogger/data/chat_statistics.csv"));
                while ((localLine = localReader.readLine()) != null) {
                    localLineCount++;
                }
                if(localLineCount == 0){
                    System.out.println("Error: CSV file has no data to summarize yet.");
                }
                else if (localLineCount < chatChoice){
                    System.out.println("Error: There are only "+localLineCount+" chat sessions, please pick a valid number next time.");
                }
                else if(chatChoice < 0){
                    System.out.println("Error: Chat number can't be negative.");
                }
                else{
                    String finalLine;
                    String[] parts = {};
                    BufferedReader finalReader = new BufferedReader(new FileReader("./prog5sessionlogger/data/chat_statistics.csv"));
                    while ((finalLine = finalReader.readLine()) != null) {
                        parts = finalLine.split(",");
                    }
                    System.out.println("Chat "+parts[0]+" has the user asking "+parts[2]+" times and the system responding "+parts[3]+"times. Total duration is "+parts[4]+" seconds");
                }
            }
            else if(userQuery.equals("-showchat")){
                System.out.println("Which chat number would you like to see?");
                int chatChoice = keyboard.nextInt();
                int localLineCount = -1;
                String localLine;
                BufferedReader localReader = new BufferedReader(new FileReader("./prog5sessionlogger/data/chat_statistics.csv"));
                while ((localLine = localReader.readLine()) != null) {
                    localLineCount++;
                }
                if(localLineCount == 0){
                    System.out.println("Error: CSV file has no chats yet.");
                }
                else if (localLineCount < chatChoice){
                    System.out.println("Error: There are only "+localLineCount+" chat sessions, please pick a valid number next time.");
                }
                else if(chatChoice < 0){
                    System.out.println("Error: Chat number can't be negative.");
                }
                else{
                    String finalLine;
                    String file = "";
                    BufferedReader finalReader = new BufferedReader(new FileReader("./prog5sessionlogger/data/chat_statistics.csv"));
                    while ((finalLine = finalReader.readLine()) != null) {
                        String[] parts = finalLine.split(",");
                        file = "./prog5sessionlogger/data/chat_sessions/"+parts[1];
                    }
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            }
            else{
                calculateAndReadMatch(userQuery);
                systemUtteranceCount++;
            }
        }
        long endTime = System.currentTimeMillis();
        long elapsedMilliseconds = endTime - startTime;
        double elapsedSeconds = elapsedMilliseconds/1000.0;
        System.out.println("Elapsed Time in seconds: " + elapsedSeconds);
        System.out.println("User Utterance Count: " + userUtteranceCount);
        System.out.println("System Response Count: " + systemUtteranceCount);
        System.out.println("Current Date: " + currentTime);
        System.out.println(chatLog);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(chatFile));
        bufferedWriter.write(chatLog);
        bufferedWriter.close();
        int lineCount = 0;
        String line;
        String prefix = "";
        BufferedReader reader = new BufferedReader(new FileReader("./prog5sessionlogger/data/chat_statistics.csv"));
        while ((line = reader.readLine()) != null) {
            lineCount++;
            prefix += line+"\n";
        }
		FileWriter fr = null;
		fr = new FileWriter("./prog5sessionlogger/data/chat_statistics.csv", true);
        fr.write("\n"+lineCount+","+outputFileName+","+userUtteranceCount+","+systemUtteranceCount+","+elapsedSeconds);
        reader.close();
        fr.close();
        keyboard.close();
    }
}