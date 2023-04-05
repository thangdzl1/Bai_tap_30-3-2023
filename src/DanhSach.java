import java.util.ArrayList;

public class DanhSach{
    private ArrayList<NhanVien> danhSach;
    public DanhSach(){
        danhSach = new ArrayList<>();
    }
    public void addDanhSach(NhanVien nv){
        danhSach.add(nv);
    }

    public ArrayList<NhanVien> getDanhSach() {
        return danhSach;
    }

    public NhanVien getNhanVien(int i) {
        return danhSach.get(i);
    }
}
