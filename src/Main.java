import com.sun.org.apache.xpath.internal.objects.XString;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.lang.management.GarbageCollectorMXBean;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Code dau vao
        Scanner in = new Scanner(System.in);
        DanhSach danhSachNhanVien = new DanhSach();
        DanhSach danhSachTruongPhong = new DanhSach();
        DanhSach danhSachGiamDoc = new DanhSach();

        //Code xu ly
        boolean check = true;
        menu();
        while (check) {
            System.out.println("Vui long chon: ");
            int nhap = Integer.parseInt(in.nextLine());
            switch (nhap) {
                case 0:
                    check = false;
                    break;
                case 1:
                    nhapThongTin(danhSachNhanVien, danhSachTruongPhong, danhSachGiamDoc, in);
                    break;
                case 2:
                    phanBoNhanVien(in, danhSachNhanVien, danhSachTruongPhong);
                    break;
                case 3:
                    themNhanVien(danhSachNhanVien, danhSachTruongPhong, danhSachGiamDoc, in);
                    break;
                case 4:
                    xoaNhanVien(danhSachNhanVien, danhSachTruongPhong, danhSachGiamDoc, in);
                    break;
                case 5:
                    xuatThongTin(danhSachNhanVien, danhSachTruongPhong, danhSachGiamDoc);
                    break;
                case 6:
                    tinhVaXuatTongLuong(danhSachNhanVien, danhSachTruongPhong, danhSachGiamDoc);
                    break;
                case 7:
                    nhanVienLuongCaoNhat(danhSachNhanVien);
                    break;
                case 8:
                    nhanVienDuoiQuyenMax(danhSachTruongPhong);
                    break;
                case 9:
                    sapXepAlphabet(danhSachNhanVien, danhSachTruongPhong, danhSachGiamDoc);
                    break;
                case 10:
                    sapXepTheoLuong(danhSachNhanVien, danhSachTruongPhong, danhSachGiamDoc);
                    break;
                case 11:
                    giamDocCoPhanCaoNhat(danhSachGiamDoc);
                    break;
                case 12:
                    thuNhapTungGiamDoc(danhSachGiamDoc, in);
                    break;
                default:
                    System.out.println("Vui long chon dung!");
            }
        }
    }

    public static void menu() {
        System.out.println("===============================================MENU================================================");
        System.out.println("1.  Nhap thong tin.");
        System.out.println("2.  Phan bo nhan vien vao Truong phong.");
        System.out.println("3.  Them mot nhan su.");
        System.out.println("4.  Xoa mot nhan su.");
        System.out.println("5.  Xuat ra thong tin toan bo cong ty");
        System.out.println("6.  Xuat tong luong cho toan cong ty.");
        System.out.println("7.  Xuat ra nhan vien Thuong co luong cao nhat.");
        System.out.println("8.  Truong phong co nhieu nhan vien duoi quyen nhieu nhat");
        System.out.println("9.  Sap xep nhan vien theo alphabet.");
        System.out.println("10. Sap xep nhan vien theo thu tu luong giam dan.");
        System.out.println("11. Giam doc co luong co phan cao nhat.");
        System.out.println("12. Tinh va xuat tong thu nhap cua tung Giam doc.");
        System.out.println("===============================================MENU================================================");
    }

    public static void nhapThongTin(DanhSach danhSachNhanVien, DanhSach danhSachTruongPhong, DanhSach danhSachGiamDoc, Scanner in) {
        System.out.println("nhap so nhan vien muon them: ");
        int soNhanVien = Integer.parseInt(in.nextLine());
        for (int i = 0; i < soNhanVien; i++) {
            danhSachNhanVien.addDanhSach(new NhanVien());
            danhSachNhanVien.getNhanVien(i).inputInfo(in);
        }
        System.out.println("nhap so truong phong muon them: ");
        int soTruongPhong = Integer.parseInt(in.nextLine());
        for (int i = 0; i < soTruongPhong; i++) {
            danhSachTruongPhong.addDanhSach(new TruongPhong());
            ((TruongPhong) danhSachTruongPhong.getNhanVien(i)).inputInfo(in);
        }
        System.out.println("nhap so giam doc muon them: ");
        int soGiamDoc = Integer.parseInt(in.nextLine());
        for (int i = 0; i < soGiamDoc; i++) {
            danhSachGiamDoc.addDanhSach(new GiamDoc());
            ((GiamDoc) danhSachGiamDoc.getNhanVien(i)).inputInfo(in);
        }
    }

    public static void phanBoNhanVien(Scanner in, DanhSach danhSachNhanVien, DanhSach danhSachTruongPhong) {
        int count = 1;
        System.out.println("Danh sach truong phong: ");
        for (NhanVien nv : danhSachTruongPhong.getDanhSach()) {
            System.out.println(count + ". " + nv.getHoTen());
            count++;
        }
        boolean check = true;
        while (check) {
            System.out.println("Nhap truong phong muon phan bo nhan vien vao (chi nhap so thu tu, nhap 0 de thoat)");
            int thuTuTruongPhong = Integer.parseInt(in.nextLine());
            if (thuTuTruongPhong == 0) break;
            System.out.println("Danh sach nhan vien: ");
            int count2 = 1;
            for (NhanVien nv : danhSachNhanVien.getDanhSach()) {
                System.out.println(count2 + ". " + nv.getHoTen());
            }
            System.out.println("Nhap nhan vien muon phan bo (chi nhap so thu tu cua danh sach da in ra tren man hinh, nhap 0 de ket thuc) :");
            while (true) {
                int nhap = Integer.parseInt(in.nextLine());
                if (nhap == 0) break;
                danhSachNhanVien.getNhanVien(nhap - 1).setSep(danhSachTruongPhong.getNhanVien(thuTuTruongPhong - 1).getHoTen());
                ((TruongPhong) danhSachTruongPhong.getNhanVien(thuTuTruongPhong - 1)).increaseSoNhanVienDuoiQuyen();
                System.out.print(" Nhap thanh cong !");
                System.out.println(" Nhap 0 de ket thuc !");
            }
        }
    }

    public static void themNhanVien(DanhSach danhSachNhanVien, DanhSach danhSachTruongPhong, DanhSach danhSachGiamDoc, Scanner in) {
        System.out.println("Chon kieu nhan vien muon them: ");
        System.out.println("1. Nhan vien");
        System.out.println("2. Truong Phong");
        System.out.println("3. Giam Doc");
        int nhap = Integer.parseInt(in.nextLine());
        switch (nhap) {
            case 1:
                danhSachNhanVien.addDanhSach(new NhanVien());
                danhSachNhanVien.getNhanVien(danhSachNhanVien.getDanhSach().size() - 1).inputInfo(in);
                break;
            case 2:
                danhSachTruongPhong.addDanhSach(new NhanVien());
                danhSachTruongPhong.getNhanVien(danhSachTruongPhong.getDanhSach().size() - 1).inputInfo(in);
                break;
            case 3:
                danhSachGiamDoc.addDanhSach(new NhanVien());
                danhSachGiamDoc.getNhanVien(danhSachGiamDoc.getDanhSach().size() - 1).inputInfo(in);
                break;
            default:
                System.out.println("Vui long nhap dung!");
        }
    }

    public static void xoaNhanVien(DanhSach danhSachNhanVien, DanhSach danhSachTruongPhong, DanhSach danhSachGiamDoc, Scanner in) {
        System.out.println("Chon kieu nhan vien muon xoa: ");
        System.out.println("1. Nhan vien");
        System.out.println("2. Truong Phong");
        System.out.println("3. Giam Doc");
        int nhap = Integer.parseInt(in.nextLine());
        int count = 0;
        switch (nhap) {
            case 1:
                count = 0;
                System.out.println("Danh sach nhan vien: ");
                for (NhanVien nv : danhSachNhanVien.getDanhSach()) {
                    System.out.println(count + ". " + nv.getHoTen());
                    count++;
                }
                System.out.println("Nhap index cua nhan vien muon xoa: ");
                int index = Integer.parseInt(in.nextLine());
                for (NhanVien nv : danhSachTruongPhong.getDanhSach()) {
                    if (danhSachNhanVien.getNhanVien(index - 1).getSep().equals(nv.getHoTen())) {
                        ((TruongPhong) nv).decreaseSoNhanVienDuoiQuyen();
                        break;
                    }
                }
                danhSachNhanVien.getDanhSach().remove(index - 1);
                count = 0;
                System.out.println("danh sach nhan vien moi: ");
                for (NhanVien nv : danhSachNhanVien.getDanhSach()) {
                    System.out.println(count + ". " + nv.getHoTen());
                    count++;
                }
                break;

            case 2:
                count = 0;
                System.out.println("Danh sach truong phong: ");
                for (NhanVien nv : danhSachTruongPhong.getDanhSach()) {
                    System.out.println(count + ". " + nv.getHoTen());
                    count++;
                }
                System.out.println("Nhap index cua truong phong muon xoa: ");
                int index2 = Integer.parseInt(in.nextLine());
                for (NhanVien nv : danhSachNhanVien.getDanhSach()) {
                    if (nv.getSep().equals(danhSachTruongPhong.getNhanVien(index2 - 1))) ;
                    nv.setSep(null);
                }
                danhSachTruongPhong.getDanhSach().remove(index2 - 1);
                count = 0;
                System.out.println("Danh sach truong phong moi: ");
                for (NhanVien nv : danhSachTruongPhong.getDanhSach()) {
                    System.out.println(count + ". " + nv.getHoTen());
                    count++;
                }
                break;

            case 3:
                count = 0;
                System.out.println("Danh sach giam doc: ");
                for (NhanVien nv : danhSachGiamDoc.getDanhSach()) {
                    System.out.println(count + ". " + nv.getHoTen());
                    count++;
                }
                System.out.println("Nhap index cua truong phong muon xoa: ");
                int index3 = Integer.parseInt(in.nextLine());
                danhSachGiamDoc.getDanhSach().remove(index3 - 1);
                count = 0;
                for (NhanVien nv : danhSachGiamDoc.getDanhSach()) {
                    System.out.println(count + ". " + nv.getHoTen());
                    count++;
                }
                System.out.println("Danh sach giam doc moi: ");
                for (NhanVien nv : danhSachGiamDoc.getDanhSach()) {
                    System.out.println(count + ". " + nv.getHoTen());
                    count++;
                }
                break;
            default:
                System.out.println("Vui long nhap dung!");
        }
    }

    public static void xuatThongTin(DanhSach danhSachNhanVien, DanhSach danhSachTruongPhong, DanhSach danhSachGiamDoc) {
        System.out.println("Danh sach nhan vien: ");
        for (int i = 0; i < danhSachNhanVien.getDanhSach().size(); i++) {
            danhSachNhanVien.getNhanVien(i).display();
        }
        System.out.println("Danh sach truong phong: ");
        for (int i = 0; i < danhSachTruongPhong.getDanhSach().size(); i++) {
            ((TruongPhong) danhSachTruongPhong.getNhanVien(i)).display();
        }
        System.out.println("Danh sach giam doc: ");
        for (int i = 0; i < danhSachGiamDoc.getDanhSach().size(); i++) {
            ((GiamDoc) danhSachGiamDoc.getNhanVien(i)).display();
        }
    }

    public static void tinhVaXuatTongLuong(DanhSach danhSachNhanVien, DanhSach danhSachTruongPhong, DanhSach danhSachGiamDoc) {
        int sum = 0;
        for (NhanVien nv : danhSachNhanVien.getDanhSach()) {
            sum += nv.getLuongMotThang();
        }
        for (NhanVien nv : danhSachTruongPhong.getDanhSach()) {
            sum += nv.getLuongMotThang();
        }
        for (NhanVien nv : danhSachGiamDoc.getDanhSach()) {
            sum += nv.getLuongMotThang();
        }
        System.out.println("Tong luong toan cong ty: " + sum);
    }

    public static void nhanVienLuongCaoNhat(DanhSach danhSachNhanVien) {
        int max = danhSachNhanVien.getNhanVien(0).getLuongMotThang();
        String name = "";
        for (NhanVien nv : danhSachNhanVien.getDanhSach()) {
            if (max < nv.getLuongMotThang()) {
                max = nv.getLuongMotThang();
                name = nv.getHoTen();
            }
        }
        System.out.println("Nhan vien co luong cao nhat: " + name);
    }

    public static void nhanVienDuoiQuyenMax(DanhSach danhSachTruongPhong) {
        int max = ((TruongPhong) danhSachTruongPhong.getNhanVien(0)).getNhanVienDuoiQuyen();
        String name = "";
        for (NhanVien nv : danhSachTruongPhong.getDanhSach()) {
            if (max < ((TruongPhong) nv).getNhanVienDuoiQuyen()) {
                max = ((TruongPhong) nv).getNhanVienDuoiQuyen();
                name = nv.getHoTen();
            }
        }
        System.out.println("Truong phong nhan vien duoi quyen nhieu nhat: " + name);
    }

    public static void sortTen(DanhSach danhSach) {
        Collections.sort(danhSach.getDanhSach(), new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return o1.getHoTen().compareTo(o2.getHoTen());
            }
        });
    }

    public static void sapXepAlphabet(DanhSach danhSachNhanVien, DanhSach danhSachTruongPhong, DanhSach danhSachGiamDoc) {
        sortTen(danhSachNhanVien);
        sortTen(danhSachTruongPhong);
        sortTen(danhSachGiamDoc);
        System.out.println("Sap xep danh sach thanh cong!");
        xuatThongTin(danhSachNhanVien, danhSachTruongPhong, danhSachGiamDoc);
    }

    public static void sortLuong(DanhSach danhSach) {
        Collections.sort(danhSach.getDanhSach(), new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return (int) o2.getLuongMotThang() - o1.getLuongMotThang();
            }
        });
    }

    public static void sapXepTheoLuong(DanhSach danhSachNhanVien, DanhSach danhSachTruongPhong, DanhSach danhSachGiamDoc) {
        sortLuong(danhSachNhanVien);
        sortLuong(danhSachTruongPhong);
        sortLuong(danhSachGiamDoc);
        System.out.println("Sap xep danh sach thanh cong!");
        xuatThongTin(danhSachNhanVien, danhSachTruongPhong, danhSachGiamDoc);
    }

    public static void giamDocCoPhanCaoNhat(DanhSach danhSachGiamDoc) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < danhSachGiamDoc.getDanhSach().size(); i++) {
            if (((GiamDoc) danhSachGiamDoc.getNhanVien(i)).getCoPhan() > max) {
                max = (((GiamDoc) danhSachGiamDoc.getNhanVien(i)).getCoPhan());
                index = i;
            }
        }
        System.out.println("Giam doc co so luong co phan nhieu nhat: ");
        ((GiamDoc) danhSachGiamDoc.getNhanVien(index)).display();
    }

    public static void thuNhapTungGiamDoc(DanhSach danhSachGiamDoc, Scanner in) {
        System.out.println("Nhap tong thu nhap cua cong ty");
        int sum = Integer.parseInt(in.nextLine());
        for (NhanVien nv : danhSachGiamDoc.getDanhSach()) {
            ((GiamDoc) nv).setThuNhap(sum);
        }
        for (NhanVien nv : danhSachGiamDoc.getDanhSach()) {
            System.out.println("Thu nhap cua giam doc " + nv.getHoTen() + "la: " + ((GiamDoc) nv).getThuNhap());
        }
    }
}
