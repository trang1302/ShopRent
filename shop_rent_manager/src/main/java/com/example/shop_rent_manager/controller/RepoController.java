package com.example.shop_rent_manager.controller;

import com.example.shop_rent_manager.model.Repo;
import com.example.shop_rent_manager.service.RepoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/repos")
public class RepoController {

    private RepoService repoService;

    // Build create Repo REST API
    @PostMapping
    public ResponseEntity<Repo> createRepo(@RequestBody Repo repo){
        try {
            Repo savedRepo = repoService.createRepo(repo);
            return new ResponseEntity<>(savedRepo, HttpStatus.CREATED);
        } catch (Exception e) {
            // Xử lý lỗi thêm repo không thành công
            // Thông báo lỗi hoặc thực hiện các thao tác phù hợp
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Build get repo by id REST API
    // http://localhost:8080/api/repos/1
    @GetMapping("{id}")
    public ResponseEntity<Repo> getRepoById(@PathVariable("id") Long repoId){
        Repo repo = repoService.getRepoById(repoId);
        return new ResponseEntity<>(repo, HttpStatus.OK);
    }

    // Build get all repos REST API
    // http://localhost:8080/api/repos
    @GetMapping
    public ResponseEntity<List<Repo>> getAllRepos(){
        List<Repo> repos = repoService.getAllRepos();
        return new ResponseEntity<>(repos, HttpStatus.OK);
    }

    // Build update repo REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/repos/1
    public ResponseEntity<Repo> updateRepo(@PathVariable("id") Long repoId,
                                                       @RequestBody Repo repo){
        repo.setId(repoId);
        Repo updatedRepo = repoService.updateRepo(repo);
        return new ResponseEntity<>(updatedRepo, HttpStatus.OK);
    }

    // Build delete repo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRepo(@PathVariable("id") Long repoId){
        repoService.deleteRepo(repoId);
        return new ResponseEntity<>("Repo successfully deleted!", HttpStatus.OK);
    }
}