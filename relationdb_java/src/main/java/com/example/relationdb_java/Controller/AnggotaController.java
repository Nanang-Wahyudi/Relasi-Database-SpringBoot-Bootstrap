package com.example.relationdb_java.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.relationdb_java.Entity.Anggota;
import com.example.relationdb_java.Repository.AnggotaRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AnggotaController {

    @Autowired
    private AnggotaRepository AnggotaRepo;

    // Halaman Data Anggota
    @GetMapping("/anggota")
    public String anggota(Model model) {

        List<Anggota> list = AnggotaRepo.findAll();
        model.addAttribute("all_anggota", list);

        return "Contents/Anggota/Anggota";
    }

    // Halaman Input Data Anggota
    @GetMapping("/input_anggota")
    public String inputAnggota() {
        return "Contents/Anggota/InputAnggota";
    }

    @PostMapping("/save_anggota")
    public String saveAnggota(@ModelAttribute Anggota anggota, HttpSession session) {

        AnggotaRepo.save(anggota);

        return "redirect:/anggota";
    }

    // Halaman Edit Data Anggota
    @GetMapping("/edit_anggota")
    public String editAnggota() {
        return "Contents/Anggota/EditAnggota";
    }

}
