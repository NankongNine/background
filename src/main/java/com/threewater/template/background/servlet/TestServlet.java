package com.threewater.template.background.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/api/v1/servlet/test", name = "testServlet")
public class TestServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(TestServlet.class);

    @Override
    public void init(){
        log.info("test servlet init...");
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet...");
        resp.getWriter().print("test sevlet");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("doPost...");
        this.doGet(req, resp);
    }
    @Override
    public void destroy(){
        log.info("test servlet destroy...");
    }
}
