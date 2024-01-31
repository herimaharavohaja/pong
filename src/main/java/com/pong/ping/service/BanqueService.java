package com.pong.ping.service;

import com.pong.ping.model.banque;
import com.pong.ping.repository.BanqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BanqueService {
    private final BanqueRepository repository;

    public BanqueService(BanqueRepository repository) {
        this.repository = repository;
    }
    public banque findById(int id) {
        return repository.findById(id);
    }

    public List<banque> findAll() {
        return (List<banque>) repository.findAll();
    }

    public banque save(banque banque) {
        return repository.save(banque);
    }

    public List<banque> saveAll(List<banque> banques) {
        return (List<banque>) repository.saveAll(banques);
    }

}
