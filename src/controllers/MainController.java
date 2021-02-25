package controllers;

import commons.DuplicateMedicalRecordException;
import commons.Validations;
import models.BenhAn;
import models.BenhAnThuong;
import models.BenhAnVIP;
import services.QuanLyBenhAn;

import java.util.Scanner;

public class MainController {
    public static final int BENH_AN_THUONG = 1;
    public static final int BENH_AN_VIP = 2;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        while (true) {
            System.out.print("\n--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN--\n"
                    + "Chọn chức năng theo số (để tiếp tục):\n"
                    + "1. Thêm mới\n"
                    + "2. Xóa\n"
                    + "3. Xem danh sách các bệnh án\n"
                    + "4. Thoát\n"
                    + "Chọn chức năng: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    add();
                    break;
                case "2":
                    delete();
                    break;
                case "3":
                    show();
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("VUI LÒNG CHỌN MỘT CHỨC NĂNG TRONG DANH SÁCH");
            }
        }
    }

    public static void add() {
        while (true) {
            System.out.print("\n--THÊM BỆNH ÁN--\n"
                    + "1. Bệnh Án Thường\n"
                    + "2. Bệnh Án VIP\n"
                    + "3. Trở về menu trước\n"
                    + "4. Thoát\n"
                    + "Chọn loại bệnh án: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addBenhAn(BENH_AN_THUONG);
                    return;
                case "2":
                    addBenhAn(BENH_AN_VIP);
                    return;
                case "3":
                    displayMenu();
                case "4":
                    System.exit(0);
                default:
                    System.out.println("VUI LÒNG CHỌN MỘT LỰA CHỌN TRONG DANH SÁCH");
            }
        }
    }

    public static void addBenhAn(int loaiBenhAn) {
        BenhAn benhAn;
        System.out.println("\n--NHẬP THÔNG TIN BỆNH ÁN--");
        String maBenhAn;
        do {
            System.out.print("Mã bệnh án: ");
            maBenhAn = scanner.nextLine();
            try {
                if (Validations.isValidInput(Validations.MA_BENH_AN_REGEX, maBenhAn) && Validations.isNotExist(maBenhAn)) {
                    break;
                }
            } catch (DuplicateMedicalRecordException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        String maBenhNhan;
        do {
            System.out.print("Mã bệnh nhân: ");
            maBenhNhan = scanner.nextLine();
        } while (!Validations.isValidInput(Validations.MA_BENH_NHAN_REGEX, maBenhNhan));
        String tenBenhNhan;
        do {
            System.out.print("Tên bệnh nhân: ");
            tenBenhNhan = scanner.nextLine();
        } while (!Validations.isValidInput(Validations.STRING_REQUIRED_REGEX, tenBenhNhan));
        String ngayNhapVien;
        do {
            System.out.print("Ngày nhập viện: ");
            ngayNhapVien = scanner.nextLine();
        } while (!Validations.isValidInput(Validations.NGAY_REGEX, ngayNhapVien));
        String ngayRaVien;
        do {
            System.out.print("Ngày ra viện: ");
            ngayRaVien = scanner.nextLine();
        } while (!Validations.isValidInput(Validations.NGAY_REGEX, ngayRaVien) || !Validations.isAfter(ngayNhapVien, ngayRaVien));
        String lyDoNhapVien;
        do {
            System.out.print("Lý do nhập viện: ");
            lyDoNhapVien = scanner.nextLine();
        } while (!Validations.isValidInput(Validations.STRING_REQUIRED_REGEX, lyDoNhapVien));
        if (loaiBenhAn == BENH_AN_THUONG) {
            int phiNamVien;
            while (true) {
                System.out.print("Phí nằm viện: ");
                try {
                    phiNamVien = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("PHÍ NẰM VIỆN PHẢI LÀ ĐỊNH DẠNG SỐ");
                }
            }
            benhAn = new BenhAnThuong(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, phiNamVien);
        } else {
            String loaiVIP;
            do {
                System.out.print("Loại VIP: ");
                loaiVIP = scanner.nextLine();
            } while (!Validations.isValidInput(Validations.LOAI_VIP_REGEX, loaiVIP));
            String thoiHanVIP;
            do {
                System.out.print("Thời hạn VIP: ");
                thoiHanVIP = scanner.nextLine();
            } while (!Validations.isValidInput(Validations.NGAY_REGEX, thoiHanVIP));
            benhAn = new BenhAnVIP(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, loaiVIP, thoiHanVIP);
        }
        QuanLyBenhAn.add(benhAn);
        System.out.println("THÊM BỆNH ÁN THÀNH CÔNG.");
    }

    public static void delete() {
        System.out.println("\n--XÓA BỆNH ÁN--");
        String maBenhAn;
        do {
            System.out.print("Mã bệnh án muốn xóa: ");
            maBenhAn = scanner.nextLine();
            try {
                if (Validations.isNotExist(maBenhAn)) {
                    System.out.println("MÃ BỆNH ÁN KHÔNG TỒN TẠI.");
                }
            } catch (DuplicateMedicalRecordException e) {
                break;
            }
            do {
                System.out.println("\nBạn có muốn thử lại? (1.CÓ | 2.KHÔNG)");
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    break;
                } else if (choice.equals("2")) {
                    return;
                }
            } while (true);
        } while (true);
        do {
            System.out.println("\nXác nhận xóa bệnh án mã " + maBenhAn + "? (1.CÓ | 2.KHÔNG)");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                QuanLyBenhAn.delete(maBenhAn);
                System.out.println("ĐÃ XÓA THÀNH CÔNG.");
                show();
                return;
            } else if (choice.equals("2")) {
                return;
            }
        } while (true);
    }

    public static void show() {
        System.out.println("\n--DANH SÁCH BỆNH ÁN--");
        QuanLyBenhAn.showAll();
    }
}
