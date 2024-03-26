package com.example.java4_sql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ctsp")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_sp")
    private SanPham id_sp;
    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private MauSac id_MauSac;
    @ManyToOne
    @JoinColumn(name = "id_size")
    private Size id_Size;
    @Column(name = "gia_ban")
    private String giaBan;
    @Column(name = "so_luong_ton")
    private String soLuong;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;

    @Override
    public String toString() {
        return "ChiTietSanPhamREPO{" +
                "id=" + id +
                ", soLuong='" + soLuong + '\'' +
                ", giaBan='" + giaBan + '\'' +
                ", ngayTao=" + ngayTao +
                ", ngaySua=" + ngaySua +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
