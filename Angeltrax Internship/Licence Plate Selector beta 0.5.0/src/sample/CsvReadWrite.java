package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvReadWrite {

    List<LabelData> labelDatasList = new ArrayList<LabelData>();

//    Main main = new Main();
//    int theImageID = main.imageID;
//    double theMinX = main.selectionBounds.getMinX();
//    double theMaxX = main.selectionBounds.getMaxX();
//    double theMinY = main.selectionBounds.getMinY();
//    double theMaxY = main.selectionBounds.getMaxY();
//    File theExcelFile = main.excelFile;


//        System.out.println("starting write user.csv file: " + filePath);
//        writeCsv(filePath);
//
//        System.out.println("starting read user.csv file");
//        readCsv(filePath);


    public void writeCsv(String filePath) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);

            fileWriter.append("Id, x1, y1, x2, y2, x3, y3, x4, y4\n");
            for(LabelData label: labelDatasList) {
                fileWriter.append(String.valueOf(label.getImageID()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(label.getSelectedX1()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(label.getSelectedY1()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(label.getSelectedX2()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(label.getSelectedY2()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(label.getSelectedX3()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(label.getSelectedY3()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(label.getSelectedX4()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(label.getSelectedY4()));
                fileWriter.append("\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void readCsv(String filePath) {
        BufferedReader reader = null;

        //File file = new File(filePath);


        try {
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();

            while((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if(fields.length > 0) {
                    LabelData labelData = new LabelData();


                    labelData.setImageID(Integer.parseInt(fields[0]));
                    labelData.setSelectedX1(Double.parseDouble(fields[1]));
                    labelData.setSelectedY1(Double.parseDouble(fields[2]));
                    labelData.setSelectedX2(Double.parseDouble(fields[3]));
                    labelData.setSelectedY2(Double.parseDouble(fields[4]));
                    labelData.setSelectedX3(Double.parseDouble(fields[5]));
                    labelData.setSelectedY3(Double.parseDouble(fields[6]));
                    labelData.setSelectedX4(Double.parseDouble(fields[7]));
                    labelData.setSelectedY4(Double.parseDouble(fields[8]));
                    labelDatasList.add(labelData);
                }
            }

            for(LabelData label: labelDatasList) {
                System.out.printf("[userId=%d, x1=%f, y1=%f, x2=%f, y2=%f, x3=%f, y3=%f, x4=%f, y4=%f]\n",
                        label.getImageID(), label.getSelectedX1(), label.getSelectedY1(), label.getSelectedX2(), label.getSelectedY2(),
                        label.getSelectedX3(), label.getSelectedY3(), label.getSelectedX4(), label.getSelectedY4());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
