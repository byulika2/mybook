package com.chirs.mybook.domain.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

  @GetMapping("/hello1")
  public String hello1() {
    return "hello";
  }

  @GetMapping("/hello2")
  public String hello2(@RequestParam String param) {
    return param;
  }
}
