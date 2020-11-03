package apap.tugas.sipes.controller;

import apap.tugas.sipes.model.PesawatModel;
import apap.tugas.sipes.model.TeknisiModel;
import apap.tugas.sipes.model.TipeModel;
import apap.tugas.sipes.service.PesawatService;
import apap.tugas.sipes.service.TeknisiService;
import apap.tugas.sipes.service.TipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PesawatController {
    @Qualifier("pesawatServiceImpl")

    @Autowired
    private PesawatService pesawatService;

    @Autowired
    private TipeService tipeService;

    @Autowired
    private TeknisiService teknisiService;

    @GetMapping("/pesawat")
    public String viewPesawat(Model model) {
        List<PesawatModel> listPesawat = pesawatService.getPesawatList();
        model.addAttribute("listPesawat", listPesawat);
        return "pesawat";
    }

    @GetMapping("/pesawat/tambah")
    public String addPesawatFormPage(Model model) {
        List<TipeModel> listTipe = tipeService.getAllTipe();
        List<TeknisiModel> listTeknisi = teknisiService.getAllTeknisi();

        model.addAttribute("pesawat", new PesawatModel());
        model.addAttribute("listTipe", listTipe);
        model.addAttribute("listTeknisi", listTeknisi);
        return "form-tambah-pesawat";
    }

    @PostMapping("/pesawat/tambah")
    public String addPesawatSubmit(
            @ModelAttribute PesawatModel pesawat,
            Model model
    ) {
        pesawat.setTipeModel(tipeService.getTipeById(pesawat.getIdTipeModel()));
        String nomorSeri = pesawatService.generateNomorSeri(pesawat);
        pesawat.setNomorSeri(nomorSeri);
        pesawatService.addPesawat(pesawat);

        model.addAttribute("pesawat", pesawat);

        return "tambah-pesawat";
    }

    @GetMapping("pesawat/{id}")
    public String viewDetailPesawatById(
            @PathVariable(value = "id") Long id,
            Model model
    ) {
        PesawatModel pesawat = pesawatService.getPesawatModelById(id);
        model.addAttribute("pesawat", pesawat);

        return "view-pesawat";
    }

    @GetMapping("pesawat/ubah/{id}")
    public String ubahPesawatById(
            @PathVariable(value = "id") Long id,
            Model model
    ) {
        PesawatModel pesawat = pesawatService.getPesawatModelById(id);
        model.addAttribute("pesawat", pesawat);

        return "form-ubah-pesawat";
    }

    @PostMapping("pesawat/ubah")
    public String ubahPesawatSubmit(
            @ModelAttribute PesawatModel pesawat,
            Model model
    ) {
        String nomorSeri = pesawatService.generateNomorSeri(pesawat);
        pesawat.setNomorSeri(nomorSeri);
        PesawatModel updatedPesawat = pesawatService.updatePesawat(pesawat);

        model.addAttribute("pesawat", updatedPesawat);
        return "ubah-pesawat";
    }
}
