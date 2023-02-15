package com.example.relationdb_java.Entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "anggota")
public class Anggota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_anggota;

    @Column(name = "nama", length = 50, nullable = true)
    private String nama;

    @Column(name = "kota", length = 25, nullable = true)
    private String kota;

    @Column(name = "tanggal_lahir", length = 25, nullable = true)
    private String tanggal_lahir;

    @Column(name = "no_hp", length = 13, nullable = true)
    private String no_hp;

    // selain menggunakan Set, kita juga bisa menggunakan List
    // Contoh Relasi ManyToMany :
    @ManyToMany
    @JoinTable(name = "anggota_pinjam", joinColumns = @JoinColumn(name = "id_pinjam"), inverseJoinColumns = @JoinColumn(name = "id_anggota"))
    private Set<Pinjam> pinjam;

    public Anggota() {
        super();
    }

    public Anggota(String nama, String kota, String tanggal_lahir, String no_hp) {
        this.nama = nama;
        this.kota = kota;
        this.tanggal_lahir = tanggal_lahir;
        this.no_hp = no_hp;
    }

    public int getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(int id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public Set<Pinjam> getPinjam() {
        return pinjam;
    }

    public void setPinjam(Set<Pinjam> pinjam) {
        this.pinjam = pinjam;
    }

    @Override
    public String toString() {
        return "Anggota [id_anggota=" + id_anggota + ", nama=" + nama + ", kota=" + kota + ", tanggal_lahir="
                + tanggal_lahir + ", no_hp=" + no_hp + "]";
    }

}
