package com.example.test01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test01.dao.ISimpleBbsDao;
import com.example.test01.domain.SimpleBbsDto;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

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
	
	@GetMapping("/writeForm")
	public String writeForm() {
		
		
		
		return "writeForm";
		
		
	}
	
/*	@PostMapping("/write")
	public String write(HttpServletRequest request, String writer, String title, String content) {
		
		//파라미터 받아서 db에 등록하기
		
		String writer_ = request.getParameter(writer); // request 참조변수를 매개변수에 만들어주면 request를 사용할 수 있다!
		String title_ = request.getParameter(title);
		String content_ = request.getParameter(content);
		
		// db에 넣을땐 dao를 이용해서 넣으니까 dao사용하고 안에 
		
		dao.write(writer_, title_, content_);
		
		return "redirect:list"; // list컨트롤러로 가서 dao에서 데이터가지고 와야하니까 redirect하고 list써준다. (그냥 list하면 jsp로간다.)
		
	}
*/	

	//@PostMapping("/write")
	public String write(HttpServletRequest request, String writer, String title, String content) {
		
		//파라미터 받아서 db에 등록하기
		
		String writer_ = request.getParameter("writer"); // 쌍따옴표 잊지말기!! request 참조변수를 매개변수에 만들어주면 request를 사용할 수 있다!
		System.out.println(writer_);
		String title_ = request.getParameter("title");// 쌍따옴표 잊지말기!! 
		String content_ = request.getParameter("content"); // 쌍 따옴표 잊지말기!!!
		// db에 넣을땐 dao를 이용해서 넣으니까 dao사용하고 안에 
		
		dao.write2(writer_, title_, content_);
		
		return "redirect:list"; // list컨트롤러로 가서 dao에서 데이터가지고 와야하니까 redirect하고 list써준다. (그냥 list하면 jsp로간다.)
		
	}

	
	//@PostMapping("/write") //위처럼 httpservletRequest를 안쓴다면 이렇게 쓰면됨
	public String write2(@RequestParam("writer") String writer, @RequestParam("title") String title, @RequestParam("content") String content) {
		
		//파라미터 받아서 db에 등록하기
		
		//String writer_ = request.getParameter(writer); // request 참조변수를 매개변수에 만들어주면 request를 사용할 수 있다!
		//String title_ = request.getParameter(title);
		//String content_ = request.getParameter(content);
		
		// db에 넣을땐 dao를 이용해서 넣으니까 dao사용하고 안에 
		
		dao.write2(writer, title, content);
		
		return "redirect:list";
	}
	
	//@PostMapping("/write")
	public String write(SimpleBbsDto dto) { //커멘드객체 사용
		
		dao.write2(dto.getWriter(), dto.getTitle(), dto.getContent());
		
		return "redirect:list";
	}
	
	@PostMapping("/write")
	public String write3(SimpleBbsDto dto) {
		
		dao.write3(dto);
		
		return "redirect:list";
		
	}
	
	@GetMapping("/command")
	public String command(SimpleBbsDto dto) { // command객체를 쓰면 model을 안써도되니 good...인데...
		System.out.println(dto.getTitle());
		return "command";
		
		
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") String id, Model model) {
		model.addAttribute("dto", dao.getDto(id));
	
		return "detail";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") String id) {
		System.out.println("Delete.......");
		dao.delete(id);
		
		return "redirect:list";
	}
	
	
	
}
