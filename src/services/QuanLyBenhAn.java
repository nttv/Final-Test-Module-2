package services;

import commons.FuncReadAndWrite;
import models.BenhAn;

import java.util.ArrayList;
import java.util.List;

public class QuanLyBenhAn {

    public static void showAll() {
        List<BenhAn> list = FuncReadAndWrite.readFile();
        if (list.isEmpty()) {
            System.out.println("KHÔNG CÓ BỆNH ÁN NÀO ĐƯỢC LƯU.");
            return;
        }
        int i = 1;
        for (BenhAn benhAn : list) {
            System.out.print(i + ". ");
            benhAn.showInfo();
            i++;
        }
    }

    public static void add(BenhAn benhAn) {
        List<BenhAn> list = new ArrayList<>();
        list.add(benhAn);
        FuncReadAndWrite.writeFile(list, true);
    }

    public static void delete(String maBenhAn) {
        List<BenhAn> list = FuncReadAndWrite.readFile();
        for (BenhAn benhAn : list) {
            if (benhAn.getMaBenhAn().equals(maBenhAn)) {
                list.remove(benhAn);
                FuncReadAndWrite.writeFile(list, false);
                return;
            }
        }
    }
}
