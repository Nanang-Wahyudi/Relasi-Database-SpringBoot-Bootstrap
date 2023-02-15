package com.example.relationdb_java.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.relationdb_java.Entity.Anggota;
import com.example.relationdb_java.Entity.Buku;
import com.example.relationdb_java.Entity.Pinjam;
import com.example.relationdb_java.Repository.AnggotaRepository;
import com.example.relationdb_java.Repository.BukuRepository;
import com.example.relationdb_java.Repository.PinjamRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class PinjamController {

    @Autowired
    private PinjamRepository PinjamRepo;

    @Autowired
    private BukuRepository BukuRepo;

    @Autowired
    private AnggotaRepository AnggotaRepo;

    // Halaman Pinjam Buku
    @GetMapping("/pinjam_buku")
    public String pinjamBuku(Model model) {

        List<Pinjam> listPinjam = PinjamRepo.findAll();
        model.addAttribute("all_pinjam", listPinjam);

        return "Contents/Pinjam/Pinjam";
    }

    // Halaman Input Pinjam Buku
    @GetMapping("/input_peminjam")
    public String inputPeminjam(Model model) {

        List<Buku> listBuku = BukuRepo.findAll();
        List<Anggota> listAnggota = AnggotaRepo.findAll();

        model.addAttribute("pinjam", new Pinjam(null, null));
        model.addAttribute("list_buku", listBuku);
        model.addAttribute("list_anggota", listAnggota);

        return "Contents/Pinjam/InputPinjam";
    }

    @PostMapping("/save_pinjam")
    public String savePinjam(@ModelAttribute Pinjam pinjam, HttpSession session) {

        PinjamRepo.save(pinjam);

        return "redirect:/pinjam_buku";
    }

    // Halaman Edit Pinjam Buku
    @GetMapping("/edit_peminjam/{id_pinjam}")
    public String editPeminjam(@PathVariable(value = "id_pinjam") Integer id_pinjam, Model model) {

        Optional<Pinjam> OptPinjam = PinjamRepo.findById(id_pinjam);
        Pinjam pinjam = OptPinjam.get();
        model.addAttribute("dataPinjam", pinjam);

        List<Buku> listBuku = BukuRepo.findAll();
        model.addAttribute("list_buku", listBuku);

        List<Anggota> listAnggota = AnggotaRepo.findAll();
        model.addAttribute("list_anggota", listAnggota);

        return "Contents/Pinjam/EditPinjam";
    }

    @PostMapping("/update_pinjam")
    public String updatePinjam(@ModelAttribute Pinjam pinjam, HttpSession session) {

        PinjamRepo.save(pinjam);

        return "redirect:/pinjam_buku";
    }

    // Hapus Data
    @GetMapping("/delete_peminjam/{id_pinjam}")
    public String deletePeminjam(@PathVariable(value = "id_pinjam") Integer id_pinjam, HttpSession session) {

        PinjamRepo.deleteById(id_pinjam);

        return "redirect:/pinjam_buku";
    }

}
