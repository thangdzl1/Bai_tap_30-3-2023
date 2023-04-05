import java.util.Scanner;

public class GiamDoc extends TruongPhong{
    public static int luongMotNgay =300;
    private int coPhan =0, thuNhap;

    @Override
    public void inputInfo(Scanner in) {
        super.inputInfo(in);
        System.out.println("Nhap so co phan: ");
        coPhan = Integer.parseInt(in.nextLine());
    }

    @Override
    public void display() {
        super.display();
        System.out.println("So co phan: "+ coPhan +"%");
    }

    @Override
    public void setLuongMotThang() {
        luongMotThang = luongMotNgay*soNgayLamViec;
    }

    public int getCoPhan() {
        return coPhan;
    }

    public int getThuNhap() {
        return thuNhap;
    }

    public void setThuNhap(int loiNhuanCongTy) {
        this.thuNhap =(int)(luongMotThang + (double)coPhan*loiNhuanCongTy/100);
    }
}
