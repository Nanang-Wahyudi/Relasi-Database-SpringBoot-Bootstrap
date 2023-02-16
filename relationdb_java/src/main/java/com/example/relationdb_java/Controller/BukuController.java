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

import com.example.relationdb_java.Entity.Buku;
import com.example.relationdb_java.Repository.BukuRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class BukuController {

    @Autowired
    private BukuRepository BukuRepo;

    // Halaman Buku
    @GetMapping("/buku")
    public String buku(Model model) {

        List<Buku> list = BukuRepo.findAll();
        model.addAttribute("all_buku", list);

        return "Contents/Buku/Buku";
    }

    // Halaman Input Buku
    @GetMapping("/input_buku")
    public String inputBuku() {
        return "Contents/Buku/InputBuku";
    }

    @PostMapping("/save_buku")
    public String saveBuku(@ModelAttribute Buku buku, HttpSession session) {

        BukuRepo.save(buku);

        return "redirect:/buku";
    }

    // Halaman Edit Buku
    @GetMapping("/edit_buku/{id_buku}")
    public String editBuku(@PathVariable(value = "id_buku") Integer id_buku, Model model) {

        Optional<Buku> OptBuku = BukuRepo.findById(id_buku);
        Buku buku = OptBuku.get();
        model.addAttribute("dataBuku", buku);

        return "Contents/Buku/EditBuku";
    }

    @PostMapping("/update_buku")
    public String updateBuku(@ModelAttribute Buku buku, HttpSession session) {

        BukuRepo.save(buku);

        return "redirect:/buku";
    }

    // Hapus Data
    @GetMapping("/delete_buku/{id_buku}")
    public String deleteBuku(@PathVariable(value = "id_buku") Integer id_buku, HttpSession session) {

        BukuRepo.deleteById(id_buku);

        return "redirect:/buku";
    }

}
