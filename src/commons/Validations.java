package commons;

import models.BenhAn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Validations {
    public static final String STRING_REQUIRED_REGEX = "^\\w.*$";
    public static final String MA_BENH_AN_REGEX = "^BA-\\d{3}$";
    public static final String MA_BENH_NHAN_REGEX = "^BN-\\d{3}$";
    public static final String NGAY_REGEX = "^([0-2][1-9]|[1-3]0|31)/(0[1-9]|1[0-2])/(190[1-9]|19[1-9]\\d|2\\d{3})$";
    public static final String LOAI_VIP_REGEX = "^((VIP\\sI)|(VIP\\sII)|(VIP\\sIII))$";

    public static boolean isValidInput(String regex, String string) {
        boolean check = Pattern.matches(regex, string);
        if (!check) {
            System.out.println("INPUT KHÔNG HỢP LỆ.");
        }
        return check;
    }

    public static boolean isNotExist(String maBenhAn) throws DuplicateMedicalRecordException {
        List<BenhAn> list = FuncReadAndWrite.readFile();
        for (BenhAn benhAn : list) {
            if (benhAn.getMaBenhAn().equals(maBenhAn)) {
                throw new DuplicateMedicalRecordException();
            }
        }
        return true;
    }

    public static boolean isAfter(String ngayNhapVien, String ngayRaVien) {
        Date date1 = new Date();
        Date date2 = new Date();
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(ngayNhapVien);
            date2 = new SimpleDateFormat("dd/MM/yyyy").parse(ngayRaVien);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        boolean check = date1.compareTo(date2) <= 0;
        if (!check) {
            System.out.println("NGÀY NHẬP VIỆN PHẢI TRƯỚC NGÀY RA VIỆN.");
        }
        return check;
    }
}
