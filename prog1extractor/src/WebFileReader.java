package prog1extractor.src;

import java.io.*;

public class WebFileReader {
    private String inputFileName;
    private String outputFileName;

    public WebFileReader(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    public void processFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                // Process each line, format with indentation, and write to output file
                String formattedLine = addIndentation(line);
                bw.write(formattedLine);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateStatistics() {
        try (BufferedReader br = new BufferedReader(new FileReader(outputFileName))) {

            int lines = 0;
            int words = 0;
            int characters = 0;

            String line;
            while ((line = br.readLine()) != null) {
                // Count lines, words, and characters
                lines++;
                words += countWords(line);
                characters += line.length();
            }

            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + characters);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String addIndentation(String line) {
        return "\t" + line;
    }

    private int countWords(String line) {
        return line.split("\\s+").length;
    }

    public static void main(String[] args) {
        WebFileReader jandjFileProcessor = new WebFileReader("./prog1extractor/data/j&j2023.txt", "./prog1extractor/data/j&jOutput.txt");
        jandjFileProcessor.processFile();
        jandjFileProcessor.generateStatistics();
        WebFileReader generalMillsFileProcessor = new WebFileReader("./prog1extractor/data/generalMills2023.txt", "./prog1extractor/data/generalMillsOutput.txt");
        generalMillsFileProcessor.processFile();
        generalMillsFileProcessor.generateStatistics();
    }
}