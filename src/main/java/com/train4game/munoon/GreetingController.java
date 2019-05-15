package com.train4game.munoon;

import com.train4game.munoon.domain.Part;
import com.train4game.munoon.repos.PartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class GreetingController {
    @Autowired
    private PartRepo partRepo;

    @GetMapping
    public String mainGetPage(
            Map<String, Object> model
    ) {
        Iterable<Part> parts = partRepo.findAll();
        List<Integer> list = new ArrayList<>();

        parts.forEach(part -> {
            if (part.isNeed())
                list.add(part.getCount());
        });

        if (list.size() == 0)
            model.put("computers", 0);
        else
            model.put("computers", Collections.min(list));

        model.put("parts", parts);
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
            @RequestParam String name,
            @RequestParam(required = false) boolean need,
            @RequestParam int count,
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
