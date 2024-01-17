package com.SearchingandUpdating.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.SearchingandUpdating.dao.UserDao;
import com.SearchingandUpdating.entity.UserEntity;
@Controller
public class MainController {
@Autowired
UserDao dao;
@GetMapping("/listuser")
public String getAllUsers(ModelMap map) {
List<UserEntity> list= dao.getAllUsers();
map.addAttribute("list", list);
return "users";
}
@GetMapping("/details")
public String getUser(HttpServletRequest request,ModelMap map) {
long id=Long.parseLong(request.getParameter("id"));
UserEntity entity=dao.getUserById(id);
map.addAttribute("obj",entity);
return "details";
}
@GetMapping("/success")
public void updateUser(HttpServletRequest request,ModelMap map) {
long id=Long.parseLong(request.getParameter("id"));
String name=request.getParameter("name");
String salary=request.getParameter("salary");
dao.updateUser(id,name,salary);
}
}
