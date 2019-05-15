package com.train4game.munoon.repos;

import com.train4game.munoon.domain.Part;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartRepo extends JpaRepository<Part, Long> {
    List<Part> findByName(String name);
}
