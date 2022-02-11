package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvReadWrite {

    private List<LabelData> labelDataList = new ArrayList<>();

    public void writeCsv(String filePath) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);

            fileWriter.append("Name, x1, y1, x2, y2, x3, y3, x4, y4\n");
            for(LabelData label: labelDataList) {
                fileWriter.append(String.valueOf(label.getImageName()));
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

            System.out.println("\nWritten Data:");
            for(LabelData label: labelDataList) {
                System.out.printf("\t[imageName=%s, x1=%f, y1=%f, x2=%f, y2=%f, x3=%f, y3=%f, x4=%f, y4=%f]\n",
                        label.getImageName(), label.getSelectedX1(), label.getSelectedY1(), label.getSelectedX2(),
                        label.getSelectedY2(), label.getSelectedX3(), label.getSelectedY3(), label.getSelectedX4(),
                        label.getSelectedY4());
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

    public LabelData[] readCsv(String filePath) {
        BufferedReader reader = null;
        int i = 0;

        try {
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();

            while((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if(fields.length > 0) {
                    LabelData labelData = new LabelData();
                    createLabelData(labelData, fields);
                    labelDataList.add(labelData);
                }
            }

            System.out.println("\nRead in Data:");
            for(LabelData label: labelDataList) {
                System.out.printf("\t[imageName=%s, x1=%f, y1=%f, x2=%f, y2=%f, x3=%f, y3=%f, x4=%f, y4=%f]\n",
                        label.getImageName(), label.getSelectedX1(), label.getSelectedY1(), label.getSelectedX2(),
                        label.getSelectedY2(), label.getSelectedX3(), label.getSelectedY3(), label.getSelectedX4(),
                        label.getSelectedY4());
                i++;
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

        LabelData ld[] = new LabelData[i];
        int y = 0;
        for(LabelData label: labelDataList) {
            ld[y] = label;
            y++;
        }

        return ld;
    }

    public List<LabelData> add(LabelData data) {
        boolean setData = false;
        for(LabelData label: labelDataList) {
            if(label.getImageName().equals(data.getImageName())) {
                label.setImageName(data.getImageName());
                label.setSelectedX1(data.getSelectedX1());
                label.setSelectedY1(data.getSelectedY1());
                label.setSelectedX2(data.getSelectedX2());
                label.setSelectedY2(data.getSelectedY2());
                label.setSelectedX3(data.getSelectedX3());
                label.setSelectedY3(data.getSelectedY3());
                label.setSelectedX4(data.getSelectedX4());
                label.setSelectedY4(data.getSelectedY4());
                setData = true;
                break;
            }
        }

        if (!setData) {
            labelDataList.add(data);
        }

        return labelDataList;
    }

    public void createLabelData(LabelData ld, String[] fields) {
        ld.setImageName(fields[0]);
        ld.setSelectedX1(Double.parseDouble(fields[1]));
        ld.setSelectedY1(Double.parseDouble(fields[2]));
        ld.setSelectedX2(Double.parseDouble(fields[3]));
        ld.setSelectedY2(Double.parseDouble(fields[4]));
        ld.setSelectedX3(Double.parseDouble(fields[5]));
        ld.setSelectedY3(Double.parseDouble(fields[6]));
        ld.setSelectedX4(Double.parseDouble(fields[7]));
        ld.setSelectedY4(Double.parseDouble(fields[8]));
    }
}
