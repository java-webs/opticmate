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
	//DAOŬ������ �ڵ� ���Եȴ�.
	@Autowired 
	private TestDao testDao;
		
	//URL��û�� �Ʒ��� ���� �ؾ� �Ѵ�.
	//http://localhost:8080/spring4hibernate/hibernate4
	@RequestMapping(value="/hibernate4")
    public String doAction(ModelMap model) {
		List<Test> list = testDao.list();
		model.addAttribute("emplist", list);
		return "test";
	}	
}
