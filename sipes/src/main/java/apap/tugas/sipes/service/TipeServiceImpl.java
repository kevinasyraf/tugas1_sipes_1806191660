package apap.tugas.sipes.service;

import apap.tugas.sipes.model.TipeModel;
import apap.tugas.sipes.repository.TipeDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipeServiceImpl implements TipeService {

    @Autowired
    TipeDb tipeDb;

    @Override
    public List<TipeModel> getAllTipe() {
        return tipeDb.findAll();
    }

    @Override
    public TipeModel getTipeById(Long id) {
        return tipeDb.findById(id).get();
    }
}
