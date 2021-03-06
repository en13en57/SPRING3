package kr.green.boot;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.boot.service.PeopleService;
import kr.green.boot.vo.PeopleVO;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PeopleService peopleService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		// 추가!!!!
		model.addAttribute("list", peopleService.selectList() );
		return "home";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST )
	public String insert(@ModelAttribute PeopleVO peopleVO) {
		peopleService.insert(peopleVO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET )
	public String delete(@ModelAttribute PeopleVO peopleVO) {
		peopleService.delete(peopleVO);
		return "redirect:/";
	}
}

