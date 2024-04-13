import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class file_handler {
    public static void main(String[] args) {
        String filename = "E:\\Programming\\Projects\\Java'\\Assignment_3\\src\\files\\A3_input_file.txt"; // Replace with your file path

        List<String> columnHeadings = new ArrayList<>();
        List<List<String>> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isColumnHeading = true;
            int columnIndex = 0;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) {
                    if (!isColumnHeading) {
                        columnIndex++;
                    }
                    columnHeadings.add(line.substring(1).trim());
                    data.add(new ArrayList<>());
                    isColumnHeading = true;
                } else if (!line.isEmpty()) {
                    data.get(columnIndex).add(line.trim());
                    isColumnHeading = false;
                }
            }

            // Print the first column
            System.out.println("First column:");
            List<String> firstColumnData = data.get(2);
            for (String value : firstColumnData) {
                System.out.println(value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}