import java.io.*;
import java.util.*;

public class Spreadsheet {
    private List<List<String>> data = new ArrayList<>();
    private String filename;

    public Spreadsheet(String filename) {
        this.filename = filename;
        loadFile();
    }

    public void loadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(Arrays.asList(line.split(",")));
            }
        } catch (IOException e) {
            System.out.println("File not found. Starting with an empty spreadsheet.");
        }
    }

    public void saveFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (List<String> row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public void printTable() {
        for (List<String> row : data) {
            System.out.println("| " + String.join(" | ", row) + " |");
        }
    }

    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet("data.csv");
        spreadsheet.printTable();
        spreadsheet.saveFile();
    }
}
