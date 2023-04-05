
public class TruongPhong extends NhanVien {
    protected int soNhanVienDuoiQuyen = 0;
    protected static int luongMotNgay = 200;
    @Override
    public void display() {
        super.display();
        System.out.println("Nhung nhan vien duoi quyen: ");

    }

    @Override
    public void setLuongMotThang() {
        this.luongMotThang = luongMotNgay * soNgayLamViec + 100 * soNhanVienDuoiQuyen;
    }
    public void increaseSoNhanVienDuoiQuyen(){
        soNhanVienDuoiQuyen++;
    }
    public void decreaseSoNhanVienDuoiQuyen(){
        soNhanVienDuoiQuyen--;
    }
    public int getNhanVienDuoiQuyen() {
        return this.soNhanVienDuoiQuyen;
    }
}
