package com.example.shop_rent_manager.impl;

import com.example.shop_rent_manager.model.Repo;
import com.example.shop_rent_manager.repository.RepoRepository;
import com.example.shop_rent_manager.service.RepoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RepoServiceImpl implements RepoService {

    private RepoRepository repoRepository;

    @Override
    public Repo createRepo(Repo repo) {
        return repoRepository.save(repo);
    }

    @Override
    public Repo getRepoById(Long repoId) {
        Optional<Repo> optionalRepo = repoRepository.findById(repoId);
        return optionalRepo.get();
    }

    @Override
    public List<Repo> getAllRepos() {
        return repoRepository.findAll();
    }

    @Override
    public Repo updateRepo(Repo repo) {
        Repo existingRepo = repoRepository.findById(repo.getId()).get();
        existingRepo.setX(repo.getX());
        existingRepo.setY(repo.getY());
        existingRepo.setAmount(repo.getAmount());
        existingRepo.setLocation(repo.getLocation());
        existingRepo.setName(repo.getName());

        Repo updatedRepo = repoRepository.save(existingRepo);
        return updatedRepo;
    }

    @Override
    public void deleteRepo(Long repoId) {
        repoRepository.deleteById(repoId);
    }
}