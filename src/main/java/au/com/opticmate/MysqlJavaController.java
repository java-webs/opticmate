package au.com.opticmate;

import java.util.List;

import model.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.TestDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MysqlJavaController {
	//DAO클래스가 자동 주입된다.
	@Autowired 
	private TestDao testDao;
		
	//URL요청시 아래와 같이 해야 한다.
	//http://localhost:8080/spring4hibernate/hibernate4
	@RequestMapping(value="/hibernate4")
    public String doAction(ModelMap model) {
		List<Test> list = testDao.list();
		model.addAttribute("emplist", list);
		return "test";
	}	
}
