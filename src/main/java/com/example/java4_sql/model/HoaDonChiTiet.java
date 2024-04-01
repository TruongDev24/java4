package com.example.java4_sql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "hdct")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hdon;
    @ManyToOne
    @JoinColumn(name = "id_ctsp")
    private ChiTietSP ctsp;
    @Column(name = "so_luong_mua")
    private Integer soLuong;
    @Column(name = "gia_ban")
    private String giaBan;
    @Column(name = "tong_tien")
    private String tongTien;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;
}
