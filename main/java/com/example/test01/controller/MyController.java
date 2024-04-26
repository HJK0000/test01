package com.example.test01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test01.dao.ISimpleBbsDao;

@Controller
public class MyController {
	
	@Autowired
	private ISimpleBbsDao dao; // 인터페이스여서 구현체가 있어야 한다. 클래스를 만들지 않고 xml파일을 만듦. (mybatis를 쓰는 이유!) 오토와이어드 써서 만들어진 객체 중 하나를 골라달라고 하면된다.
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		
		return "^^";
		
		
	}
	
	@RequestMapping("/main")
	public String mainPage() {
		
		
		return "main";
	}
	
	@GetMapping("/list")
	public String list(Model model) { //servlet의 request 객체의 역할을 Model이 해준다.
		
		model.addAttribute("list", dao.getList()); // key, value(들어갈 데이터)
				
		return "list";
	}
}
