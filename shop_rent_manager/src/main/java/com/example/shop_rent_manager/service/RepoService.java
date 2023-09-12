package com.example.shop_rent_manager.service;

import com.example.shop_rent_manager.model.Repo;

import java.util.List;

public interface RepoService {
    Repo createRepo(Repo repo);

    Repo getRepoById(Long repoId);

    List<Repo> getAllRepos();

    Repo updateRepo(Repo repo);

    void deleteRepo(Long repoId);
}