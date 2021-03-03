package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public class UserController implements PageController {

    @Override
    @GET
    @POST
    @Path("/register")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String inputName = request.getParameter("inputName");
        String inputPassword = request.getParameter("inputPassword");

        User user = new User();
        user.setName("name");
        user.setPassword("123456");
        user.setEmail("123456@qq.com");
        user.setPhoneNumber("13911112222");
        boolean success = DatabaseUserRepository.userRepository.save(user);

        return "success.jsp";
    }
}