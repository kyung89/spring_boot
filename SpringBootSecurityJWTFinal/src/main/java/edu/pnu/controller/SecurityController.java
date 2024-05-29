package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController{
	
	@GetMapping("/public") public String index() { return "index"; }
	
	@GetMapping("/intra/marketing") public String marketing() { return "marketing"; }
	
	@GetMapping("/intra/develop") public String develop() { return "develop"; }
	
	@GetMapping("/intra/finance") public String finance() { return "finance"; }
	
	@GetMapping("/admin") public String admin() { return "admin"; }
}