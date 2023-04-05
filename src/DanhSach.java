import java.util.ArrayList;
import java.util.List;

public class DanhSach{
    private ArrayList<NhanVien> danhSach;
    public DanhSach(){
        danhSach = new ArrayList<>();
    }
    public DanhSach(ArrayList danhSach){
        this.danhSach = danhSach;
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
