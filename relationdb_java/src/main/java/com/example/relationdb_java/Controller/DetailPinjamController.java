package com.example.relationdb_java.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailPinjamController {

    // Halaman Detail Peminjam Buku
    @GetMapping("/detail_peminjam")
    public String detailPeminjam() {
        return "Contents/DetailPinjam/DetailPinjam";
    }

}
