package apap.tugas.sipes.service;

import apap.tugas.sipes.model.PenerbanganModel;

import java.util.List;

public interface PenerbanganService {
    List<PenerbanganModel> getPenerbanganList();

    void addPenerbangan(PenerbanganModel penerbangan);
}
