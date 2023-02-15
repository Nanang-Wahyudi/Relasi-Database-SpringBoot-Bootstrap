package com.example.relationdb_java.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @GetMapping("/edit_buku")
    public String editBuku() {
        return "Contents/Buku/EditBuku";
    }

}
