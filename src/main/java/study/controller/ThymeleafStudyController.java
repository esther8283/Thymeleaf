package study.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import study.dto.Member;

@Controller
public class ThymeleafStudyController {
	private int count = 0; 
	
//	웹 브라우저의 주소창에 입력된 url
	@RequestMapping("/")
	public String index() {
//		@Controller 어노테이션이 사용되었을 경우 @RequestMapping으로 연동된 메서드의 반환타입이 String일 경우 return "문자열"입력 시 지정된 위치(templates 폴더)에서 지정한 문자열을 가진 html 파일을 찾음
		return "index"; // templates 폴더에서 index.html 파일을 호출함
	}

	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model) {
//		Model 클래스는 Controller에서 사용자가 요청한 정보의 처리된 내용을 담고 있는 객체
//		View 부분으로 넘겨줄 데이터의 모음
		
		String result = "";
		boolean flag = false;
		
		if(count % 2 == 0) {
			result = "짝수";
			flag = true;
			
			count++;
		}
		else {
			result = "홀수";
			flag = false;
			count++;
		}
		
		Member member = new Member();
		member.setName("홍길동");
		member.setEmail("asdasd@asd.net");
		member.setTel("010-1234-5678");
		member.setAddress("부산");
				
		Member member2 = new Member("아이유", "iu@gamil.com", "010-1234-5678", "서울");
		Member member3 = new Member("유인나", "uina@gamil.com", "010-2345-6789", "서울");
		Member member4 = new Member("정인선", "jung@gamil.com", "010-3456-7890", "서울");
		
		List<Member> list = new ArrayList<Member>();
		list.add(member);
		list.add(member2);
		list.add(member3);
		list.add(member4);
		
//		thymeleaf 가 받을 데이터, 첫번째 매개변수가 thymeleaf에서 사용할 변수명, 두번째 매개변수가 실제 데이터가 됨
		model.addAttribute("data", "thymeleaf");
		model.addAttribute("hi", "Hello world!!");
		model.addAttribute("btnText", result);
		model.addAttribute("member", member);
		model.addAttribute("url", "test");
		model.addAttribute("h", "hello");
		model.addAttribute("w","world");
		model.addAttribute("flag", flag);
		model.addAttribute("btnPrimary", "btn btn-primary");
		model.addAttribute("chk",true);
		model.addAttribute("datas", list);
		return "thymeleaf";
	}
	
	@RequestMapping("/test/test")
	public String testtest() {
		return "/test/test";
	}
}
