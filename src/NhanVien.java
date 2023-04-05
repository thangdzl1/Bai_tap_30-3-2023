import java.util.Scanner;

public class NhanVien extends Person {
    public static int luongMotNgay = 100;
    private String sep = null;
    public NhanVien() {
    }

    public void display() {
        System.out.println("ma so: " + maSo + "\tho ten: " + hoTen + "\tSo dien thoai: " +
                soDienThoai + "\tSo ngay lam viec: " + soNgayLamViec + "\tLuong mot thang: " + luongMotThang);
    }

    public void inputInfo(Scanner in) {
        System.out.println("nhap so ma so: ");
        setMaSo(in.nextLine());
        System.out.println("nhap so ho ten: ");
        setHoTen(in.nextLine());
        System.out.println("nhap so dien thoai: ");
        setSoDienThoai(in.nextLine());
        System.out.println("nhap so ngay lam viec: ");
        setSoNgayLamViec(Integer.parseInt(in.nextLine()));
    }

    public String getSep() {
        return sep;
    }

    public void setSep(String sep) {
        this.sep = sep;
    }

    public int getLuongMotThang() {
        return luongMotThang;
    }

    public void setLuongMotThang() {
        this.luongMotThang = luongMotNgay * soNgayLamViec;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }
}
