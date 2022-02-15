package kr.green.boot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@GetMapping(value = {"/","/index","/index.it"}) // 주소를 동시에 여러개 생성
	public ModelAndView inedex() {
		// templates/index.html 을 뷰로 사용하겠다. (application.properties에서 그렇게 적용함)
		ModelAndView mv = new ModelAndView("index");
		// 서비스 클래스를 호출하여 원하는 결과를 받아 ModelAndView에 저장해주면 template에서 그 내용을 출력해 사용한다. 
		Map<String, Object> map = new HashMap<>();
		map.put("name", "한사람");
		map.put("age", "22");
		map.put("gender", "여자");
		
		List<String> hobby = new ArrayList<>();
		hobby.add("잠자기");
		hobby.add("술먹기");
		hobby.add("고성방가");
		
		mv.addObject("map",map);
		mv.addObject("hobby",hobby);
		mv.addObject("title","타임리프를 이용한 출력 만들기");
		
		return mv;
	}
	@RequestMapping(value = "/hi")
	public String hello(@RequestParam(required = false) String name,@RequestParam(defaultValue = "22") int age, Model model) {
		if(name==null || name.trim().length()==0) name="손";
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "hello"; // 뷰 이름을 리턴한다.
	}
	
}
