package net.gdut.controller;

import net.gdut.service.TbBookService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class TbBookController {
    @Resource
    TbBookService tbBookService;


}
