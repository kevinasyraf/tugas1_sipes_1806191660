package apap.tugas.sipes.service;

import apap.tugas.sipes.model.PesawatModel;
import apap.tugas.sipes.repository.PesawatDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class PesawatServiceImpl implements PesawatService {

    @Autowired
    PesawatDb pesawatDb;

    @Override
    public void addPesawat(PesawatModel pesawat) {
        pesawatDb.save(pesawat);
    }

    @Override
    public List<PesawatModel> getPesawatList() {
        return pesawatDb.findAll();
    }

    @Override
    public String generateNomorSeri(PesawatModel pesawat) {
        String jenisPesawat = pesawat.getJenisPesawat();
        String jenis = "";
        if (jenisPesawat.equals("Komersial")) {
            jenis += 1;
        } else if (jenisPesawat.equals("Militer")) {
            jenis += 2;
        }

        String tipePesawat = pesawat.getTipeModel().getNama();
        String tipe = "";

        if (tipePesawat.equals("Boeing")) {
            tipe = "BO";
        } else if (tipePesawat.equals("ATR")) {
            tipe = "AT";
        } else if (tipePesawat.equals("Airbus")) {
            tipe = "AB";
        } else if (tipePesawat.equals("Bombardier")) {
            tipe = "BB";
        }

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
        cal.setTime(pesawat.getTanggalDibuat());
        Integer tahunPesawat = cal.get(Calendar.YEAR);
        String tahunPesawatBalik = "";
        for (int i = Integer.toString(tahunPesawat).length()-1; i >= 0; i--) {
            tahunPesawatBalik += Integer.toString(tahunPesawat).charAt(i);
        }

        Random r = new Random();
        char firstKapitalRandom = (char)(r.nextInt(26) + 'A');
        char secondKapitalRandom = (char)(r.nextInt(26) + 'A');

        String nomorSeri = jenis + tipe + tahunPesawatBalik + (tahunPesawat + 8) + firstKapitalRandom + secondKapitalRandom;

        return nomorSeri;
    }

    @Override
    public PesawatModel getPesawatModelById(Long id) {
        return pesawatDb.findById(id).get();
    }

    @Override
    public PesawatModel updatePesawat(PesawatModel pesawat) {
        pesawatDb.save(pesawat);
        return pesawat;
    }
}
