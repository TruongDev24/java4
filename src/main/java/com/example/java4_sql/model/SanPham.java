package com.example.java4_sql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "san_pham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ma_san_pham")
    private String ma;
    @Column(name = "ten_san_pham")
    private String ten;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @ManyToOne
    @JoinColumn(name = "id_danh_muc")
    private DanhMuc id_danhMuc;

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", ngayTao=" + ngayTao +
                ", ngaySua=" + ngaySua +
                ", id_danhMuc=" + id_danhMuc +
                '}';
    }
}
