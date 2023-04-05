public class GiamDoc extends TruongPhong{
    public static int luongMotNgay =300;
    private int coPhan =0, thuNhap;

    public GiamDoc() {
        this.coPhan = coPhan;
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

    public void setCoPhan(int coPhan) {
        this.coPhan = coPhan;
    }
}
