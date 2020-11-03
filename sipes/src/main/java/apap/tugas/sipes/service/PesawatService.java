package apap.tugas.sipes.service;

import apap.tugas.sipes.model.PesawatModel;

import java.util.List;

public interface PesawatService {
    void addPesawat(PesawatModel pesawat);

    List<PesawatModel> getPesawatList();

    String generateNomorSeri(PesawatModel pesawat);

}
