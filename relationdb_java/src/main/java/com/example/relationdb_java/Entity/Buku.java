package com.example.relationdb_java.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "buku")
public class Buku implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_buku;

    @Column(name = "judul", length = 50, nullable = true)
    private String judul;

    @Column(name = "tahun_terbit", length = 6, nullable = true)
    private String tahun_terbit;

    @Column(name = "jenis_buku", length = 25, nullable = true)
    private String jenis_buku;

    public Buku() {
        super();
    }

    public Buku(String judul, String tahun_terbit, String jenis_buku) {
        this.judul = judul;
        this.tahun_terbit = tahun_terbit;
        this.jenis_buku = jenis_buku;
    }

    public int getId_buku() {
        return id_buku;
    }

    public void setId_buku(int id_buku) {
        this.id_buku = id_buku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTahun_terbit() {
        return tahun_terbit;
    }

    public void setTahun_terbit(String tahun_terbit) {
        this.tahun_terbit = tahun_terbit;
    }

    public String getJenis_buku() {
        return jenis_buku;
    }

    public void setJenis_buku(String jenis_buku) {
        this.jenis_buku = jenis_buku;
    }

    @Override
    public String toString() {
        return "Buku [id_buku=" + id_buku + ", judul=" + judul + ", tahun_terbit=" + tahun_terbit + ", jenis_buku="
                + jenis_buku + "]";
    }

}
