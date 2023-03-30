import com.sun.org.apache.xpath.internal.objects.XString;

import javax.lang.model.type.NullType;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DanhSach danhSachNhanVien = new DanhSach();
        DanhSach danhSachTruongPhong = new DanhSach();
        DanhSach danhSachGiamDoc = new DanhSach();

        nhapThongTin(danhSachNhanVien, danhSachTruongPhong, danhSachGiamDoc, in);
        phanBoNhanVien(in, danhSachNhanVien, danhSachTruongPhong);
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
        System.out.println("Vui long chon: ");

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
            danhSachTruongPhong.getNhanVien(i).inputInfo(in);
        }
        System.out.println("nhap so giam doc muon them: ");
        int soGiamDoc = Integer.parseInt(in.nextLine());
        for (int i = 0; i < soGiamDoc; i++) {
            danhSachGiamDoc.addDanhSach(new GiamDoc());
            danhSachGiamDoc.getNhanVien(i).inputInfo(in);
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
                count =0;
                System.out.println("Danh sach nhan vien: ");
                for (NhanVien nv : danhSachNhanVien.getDanhSach()) {
                    System.out.println(count + ". " + nv.getHoTen());
                    count++;
                }
                System.out.println("Nhap index cua nhan vien muon xoa: ");
                int index = Integer.parseInt(in.nextLine());
                for (NhanVien nv : danhSachTruongPhong.getDanhSach()) {
                    if(danhSachNhanVien.getNhanVien(index-1).getSep().equals(nv.getHoTen())){
                        ((TruongPhong)nv).decreaseSoNhanVienDuoiQuyen();
                        break;
                    }

                }
                danhSachNhanVien.getDanhSach().remove(index-1);
                break;

            case 2:
                count = 0;
                System.out.println("Danh sach truong phong: ");
                for (NhanVien nv : danhSachTruongPhong.getDanhSach()) {
                    System.out.println(count + ". " + nv.getHoTen());
                    count++;
                }
                System.out.println("Nhap index cua truong phong muon xoa: ");
                int index2= Integer.parseInt(in.nextLine());
                for (NhanVien nv : danhSachNhanVien.getDanhSach()) {
                    if (nv.getSep().equals(danhSachTruongPhong.getNhanVien(index2-1)));
                }
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

    public static void xuatThongTin(DanhSach danhSachNhanVien, DanhSach danhSachTruongPhong, DanhSach danhSachGiamDoc) {
        System.out.println("Danh sach nhan vien: ");
        for (int i = 0; i < danhSachNhanVien.getDanhSach().size(); i++) {
            danhSachNhanVien.getNhanVien(i).display();
        }
        System.out.println("Danh sach truong phong: ");
        for (int i = 0; i < danhSachTruongPhong.getDanhSach().size(); i++) {
            danhSachTruongPhong.getNhanVien(i).display();
        }
        System.out.println("Danh sach giam doc: ");
        for (int i = 0; i < danhSachGiamDoc.getDanhSach().size(); i++) {
            danhSachGiamDoc.getNhanVien(i).display();
        }
    }
}
