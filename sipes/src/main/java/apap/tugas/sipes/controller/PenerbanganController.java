package apap.tugas.sipes.controller;

import apap.tugas.sipes.model.PenerbanganModel;
import apap.tugas.sipes.service.PenerbanganService;
import apap.tugas.sipes.service.PesawatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PenerbanganController {
    @Qualifier("penerbanganServiceImpl")

    @Autowired
    PenerbanganService penerbanganService;

    @Autowired
    PesawatService pesawatService;

    @GetMapping("/penerbangan")
    public String viewPenerbangan(Model model) {
        List<PenerbanganModel> listPenerbangan = penerbanganService.getPenerbanganList();
        model.addAttribute("listPenerbangan", listPenerbangan);
        return "penerbangan";
    }

    @GetMapping("/penerbangan/tambah")
    public String addpenerbanganFormPage(Model model) {
        model.addAttribute("penerbangan", new PenerbanganModel());
        return "form-tambah-penerbangan";
    }

    @PostMapping("/penerbangan/tambah")
    public String addPenerbanganSubmit(
            @ModelAttribute PenerbanganModel penerbangan,
            Model model
    ) {
        penerbangan.setPesawatModel(pesawatService.getPesawatModelById(1L));
        penerbanganService.addPenerbangan(penerbangan);

        model.addAttribute("penerbangan", penerbangan);

        return "tambah-penerbangan";
    }
}
