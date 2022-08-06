package com.chirs.mybook.domain.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

  @GetMapping("/api/hello1")
  public String hello1() {
    return "hello";
  }

  @GetMapping("/api/hello2")
  public String hello2(@RequestParam String param) {
    return param;
  }
}
