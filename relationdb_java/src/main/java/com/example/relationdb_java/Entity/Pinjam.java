package com.example.relationdb_java.Entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pinjam")
public class Pinjam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pinjam;

    @Column(name = "tgl_pinjam", length = 25, nullable = true)
    private String tgl_pinjam;

    @Column(name = "tgl_kembali", length = 25, nullable = true)
    private String tgl_kembali;

    // Contoh Relasi ManyToOne :
    @ManyToOne
    @JoinColumn(name = "id_buku")
    private Buku buku;

    @ManyToOne
    @JoinColumn(name = "id_anggota")
    private Anggota anggotaMTO;

    // selain menggunakan Set, kita juga bisa menggunakan List
    // Contoh Relasi ManyToMany :
    @ManyToMany(mappedBy = "pinjam")
    private Set<Anggota> anggota;

    public Pinjam() {
        super();
    }

    public Pinjam(String tgl_pinjam, String tgl_kembali) {
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_kembali = tgl_kembali;
    }

    public int getId_pinjam() {
        return id_pinjam;
    }

    public void setId_pinjam(int id_pinjam) {
        this.id_pinjam = id_pinjam;
    }

    public String getTgl_pinjam() {
        return tgl_pinjam;
    }

    public void setTgl_pinjam(String tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    public String getTgl_kembali() {
        return tgl_kembali;
    }

    public void setTgl_kembali(String tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Set<Anggota> getAnggota() {
        return anggota;
    }

    public void setAnggota(Set<Anggota> anggota) {
        this.anggota = anggota;
    }

    public Anggota getAnggotaMTO() {
        return anggotaMTO;
    }

    public void setAnggotaMTO(Anggota anggotaMTO) {
        this.anggotaMTO = anggotaMTO;
    }

    @Override
    public String toString() {
        return "Pinjam [id_pinjam=" + id_pinjam + ", tgl_pinjam=" + tgl_pinjam + ", tgl_kembali=" + tgl_kembali + "]";
    }

}
