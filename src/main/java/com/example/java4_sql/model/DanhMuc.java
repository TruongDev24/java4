package com.example.java4_sql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "danh_muc")
public class DanhMuc {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_danh_muc")
    private String ma_danh_muc;

    @Column(name = "ten_danh_muc")
    private String ten_danh_muc;

    @Column(name = "trang_thai")
    private String trang_thai;

    @Column(name = "ngay_tao")
    private Date ngay_tao;

    @Column(name = "ngay_sua")
    private Date ngay_sua;

    @Override
    public String toString() {
        return "DanhMuc{" +
                "id=" + id +
                ", ma_danh_muc='" + ma_danh_muc + '\'' +
                ", ten_danh_muc='" + ten_danh_muc + '\'' +
                ", trang_thai='" + trang_thai + '\'' +
                ", ngay_tao=" + ngay_tao +
                ", ngay_sua=" + ngay_sua +
                '}';
    }
}
