package com.train4game.munoon;

import com.train4game.munoon.domain.Part;
import com.train4game.munoon.repos.PartRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class GreetingController {
    private final PartRepo partRepo;

    public GreetingController(PartRepo partRepo) {
        this.partRepo = partRepo;
    }

    @GetMapping
    public String mainGetPage(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "sort", required = false) String sort,
            Map<String, Object> model
    ) {
        Iterable<Part> parts;

        if (sort != null && !sort.isEmpty()) {
            parts = partRepo.findAll(Sort.by(sort).descending());
        } else {
            parts = partRepo.findAll();
        }

        model = MainPageHelper.mainPage(model, parts, parts, page);
        return "index";
    }

    @PostMapping
    public String mainPostPage(
            @RequestParam(name = "filter", required = false) String filter,
            @RequestParam int page,
            Map<String, Object> model
    ) {
        Iterable<Part> parts;

        if (filter == null || filter.isEmpty()) {
            parts = partRepo.findAll();
        } else {
            parts = partRepo.findByName(filter);
        }

        model = MainPageHelper.mainPage(model, parts, partRepo.findAll(), page);

        return "index";
    }

    @GetMapping("/add")
    public String addGetPage() {
        return "add";
    }

    @PostMapping("/add")
    public String addPostPage(
            @RequestParam String name,
            @RequestParam(required = false) boolean need,
            @RequestParam int count,
            Map<String, Object> model
    ) {
        Part part = new Part(name, need, count);
        partRepo.save(part);

        return "add";
    }

    @GetMapping("/edit")
    public String editGetPage(
            @RequestParam(name = "id", required = true) Long id,
            Map<String, Object> model
    ) {
        Part part = partRepo.findById(id).get();
        model.put("part", part);
        return "edit";
    }

    @PostMapping("/edit")
    public String editPostPage(
            @RequestParam(name = "id", required = true) Long id,
            @RequestParam(name = "name", required = true, defaultValue = "New PAert") String name,
            @RequestParam(required = false) boolean need,
            @RequestParam(name = "count") int count,
            Map<String, Object> model
    ) {
        Part part = partRepo.findById(id).get();
        part.setName(name);
        part.setNeed(need);
        part.setCount(count);
        partRepo.save(part);
        model.put("part", part);
        return "edit";
    }

    @PostMapping("/delete")
    public String deletePostPage(
            @RequestParam(name = "id", required = true) Long id,
            Map<String, Object> model
    ) {
        partRepo.deleteById(id);
        return "redirect:/";
    }
}
