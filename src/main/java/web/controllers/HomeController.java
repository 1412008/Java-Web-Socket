package web.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

	@RequestMapping("home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("name", "Boss");
		return mv;
	}

	@RequestMapping("test")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test");
		return mv;
	}

	@MessageMapping("/hello")
	@SubscribeMapping("/greetings")
	@SendTo("/topic/greetings")
	public String greeting(String name) throws Exception {
		Thread.sleep(500);
		return name;
	}

}
