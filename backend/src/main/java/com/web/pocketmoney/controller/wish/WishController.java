package com.web.pocketmoney.controller.wish;

import com.web.pocketmoney.dto.wish.WishPageRequestDTO;
import com.web.pocketmoney.service.wish.WishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish")
@Log4j2
@RequiredArgsConstructor
public class WishController {

    private final WishService wishService;

    @GetMapping("/list/{id}")
    public void list(WishPageRequestDTO pageRequestDTO, Model model, @PathVariable("id") Long id){
        pageRequestDTO.setSize(9);

        model.addAttribute("result", wishService.findAll(pageRequestDTO, id));

    }
}
