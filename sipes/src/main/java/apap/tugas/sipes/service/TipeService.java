package apap.tugas.sipes.service;

import apap.tugas.sipes.model.TipeModel;

import java.util.List;
import java.util.Optional;

public interface TipeService {
    List<TipeModel> getAllTipe();

    TipeModel getTipeById(Long id);
}
