package com.example.demo.controller;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bright Gong
 */
@RestController("/")
public class HomePage {

  @GetMapping(path = {"", "{username}"})
  public String hello(@Nullable @PathVariable String username) {
    if (ObjectUtils.isEmpty(username)) {
      return "Hello, world!";
    } else {
      return "Hello, " + username;
    }
  }
}
