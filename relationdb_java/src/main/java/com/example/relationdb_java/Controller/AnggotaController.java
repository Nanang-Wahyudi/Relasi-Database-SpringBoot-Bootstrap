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
    @GetMapping("/edit_anggota/{id_anggota}")
    public String editAnggota(@PathVariable(value = "id_anggota") Integer id_anggota, Model model) {

        Optional<Anggota> OptAnggota = AnggotaRepo.findById(id_anggota);
        Anggota anggota = OptAnggota.get();
        model.addAttribute("dataAnggota", anggota);

        return "Contents/Anggota/EditAnggota";
    }

    @PostMapping("/update_anggota")
    public String updateAnggota(@ModelAttribute Anggota anggota, HttpSession session) {

        AnggotaRepo.save(anggota);

        return "redirect:/anggota";
    }

    // Hapus Data
    @GetMapping("/delete_anggota/{id_anggota}")
    public String deleteAnggota(@PathVariable(value = "id_anggota") Integer id_anggota, HttpSession session) {

        AnggotaRepo.deleteById(id_anggota);

        return "redirect:/anggota";
    }

}
