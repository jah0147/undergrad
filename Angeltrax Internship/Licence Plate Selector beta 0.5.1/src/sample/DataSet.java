package sample;

import java.util.ArrayList;

public class DataSet {

    private CsvReadWrite csvReadWrite = new CsvReadWrite();

    String directoryPath;

    // for now read from already extracted folder like you have been
    // but eventually this will be path to zip file
    public DataSet(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public ArrayList<LabelData> ReadAll() {
        // this function should read all the lines from csv file

        csvReadWrite.readCsv(directoryPath);
        return ReadAll(); 

    }

    public void WriteAll(ArrayList<LabelData> lineItems) {
        // this function should overwrite csv file completely

        csvReadWrite.writeCsv(directoryPath);

    }

    public void WriteOne(LabelData lineItem) {
        // this function should update single line in csv file
        ArrayList<LabelData> lineItems = ReadAll();
        boolean replaced = false;

        for(int i = 0; i < lineItems.size(); i++) {

            if(lineItems.get(i).getImageID() == lineItem.getImageID()) {
                replaced = true;
                lineItems.set(i, lineItem);
                break;
            }

        }

        // not overwriting so add to end
        if(!replaced) {
            lineItems.add(lineItem);
        }

        WriteAll(lineItems);
    }
}

