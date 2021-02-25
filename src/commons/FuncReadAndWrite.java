package commons;

import models.BenhAn;
import models.BenhAnThuong;
import models.BenhAnVIP;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncReadAndWrite {
    private static final String PATH = "src/data/medical_records.csv";

    public static void writeFile(List<BenhAn> list, boolean writeMode) {
        File file = new File(PATH);
        BufferedWriter bufferedWriter = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file, writeMode));
            for (BenhAn benhAn : list) {
                bufferedWriter.write(benhAn.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR IN WRITING FILE.");
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<BenhAn> readFile() {
        List<BenhAn> list = new ArrayList<>();
        File file = new File(PATH);
        BufferedReader bufferedReader = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String[] tempArr;
            while ((line = bufferedReader.readLine()) != null) {
                tempArr = line.split(",");
                BenhAn benhAn;
                if (tempArr.length == 8) {
                    benhAn = new BenhAnThuong(tempArr);
                } else {
                    benhAn = new BenhAnVIP(tempArr);
                }
                list.add(benhAn);
            }
        } catch (IOException e) {
            System.out.println("ERROR IN READING FILE.");
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
