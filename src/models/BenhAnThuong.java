package models;

public class BenhAnThuong extends BenhAn {
    private int phiNamVien;

    public BenhAnThuong(String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, int phiNamVien) {
        super(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public BenhAnThuong(String[] benhAn) {
        super(Integer.parseInt(benhAn[0]), benhAn[1], benhAn[2], benhAn[3], benhAn[4], benhAn[5], benhAn[6]);
        this.phiNamVien = Integer.parseInt(benhAn[7]);
    }

    public int getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(int phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return super.toString() + "," + phiNamVien;
    }

    @Override
    public void showInfo() {
        System.out.println("BenhAnThuong{" +
                "stt=" + super.getStt() +
                ", maBenhAn='" + super.getMaBenhAn() + '\'' +
                ", maBenhNhan='" + super.getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + super.getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" + super.getNgayNhapVien() + '\'' +
                ", ngayRaVien='" + super.getNgayRaVien() + '\'' +
                ", lyDoNhapVien='" + super.getLyDoNhapVien() + '\'' +
                ", phiNamVien=" + phiNamVien +
                '}');
    }
}
