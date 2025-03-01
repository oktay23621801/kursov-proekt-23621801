public class Main {
    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet("data.csv");
        spreadsheet.printTable();
        spreadsheet.saveFile();
    }
}
