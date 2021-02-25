package models;

public class BenhAnVIP extends BenhAn {
    private String loaiVIP;
    private String thoiHanVIP;

    public BenhAnVIP(String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, String loaiVIP, String thoiHanVIP) {
        super(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.loaiVIP = loaiVIP;
        this.thoiHanVIP = thoiHanVIP;
    }

    public BenhAnVIP(String[] benhAn) {
        super(Integer.parseInt(benhAn[0]), benhAn[1], benhAn[2], benhAn[3], benhAn[4], benhAn[5], benhAn[6]);
        this.loaiVIP = benhAn[7];
        this.thoiHanVIP = benhAn[8];
    }

    public String getLoaiVIP() {
        return loaiVIP;
    }

    public void setLoaiVIP(String loaiVIP) {
        this.loaiVIP = loaiVIP;
    }

    public String getThoiHanVIP() {
        return thoiHanVIP;
    }

    public void setThoiHanVIP(String thoiHanVIP) {
        this.thoiHanVIP = thoiHanVIP;
    }

    @Override
    public String toString() {
        return super.toString() + "," + loaiVIP + "," + thoiHanVIP;
    }

    @Override
    public void showInfo() {
        System.out.println("BenhAnVIP{" +
                "stt=" + super.getStt() +
                ", maBenhAn='" + super.getMaBenhAn() + '\'' +
                ", maBenhNhan='" + super.getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + super.getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" + super.getNgayNhapVien() + '\'' +
                ", ngayRaVien='" + super.getNgayRaVien() + '\'' +
                ", lyDoNhapVien='" + super.getLyDoNhapVien() + '\'' +
                ", loaiVIP='" + loaiVIP + '\'' +
                ", thoiHanVIP=" + thoiHanVIP +
                '}');
    }
}
