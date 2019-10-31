package web;

import service.ChatService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class ChatServlet extends HttpServlet {

    private ChatService chatService;
    private String currentUser;

    @Override
    public void init() throws ServletException {
        chatService = new ChatService();
        chatService.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!currentUser.isEmpty()) {
            req.setCharacterEncoding("UTF-8");
            req.setAttribute("users", chatService.getUsers());
            req.setAttribute("messages", chatService.getMessages());
            req.setAttribute("userName", currentUser);
            req.getRequestDispatcher("chat.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("index.html").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");

        if (action == null) {
            req.getRequestDispatcher("index.html").forward(req, resp);
        }

        switch (action) {
            case "signIn":
                String name = req.getParameter("name");
                if (chatService.alreadyExists(name)) {                                  // Не можем зайти в чат, если пользователь с таким именем существует
                    req.getRequestDispatcher("index.html").forward(req, resp);
                } else {
                    chatService.addUser(name);
                    currentUser = name;
                    resp.sendRedirect("chat");
                }
                break;
            case "sendMessage":
                String user = req.getParameter("user");
                String message = req.getParameter("mess");
                String time = req.getParameter("dateTime");
                if (message.isEmpty()) {
                    resp.sendRedirect("chat");
                } else {
                    chatService.addMessage(message.trim(), time, user);
                    resp.sendRedirect("chat");
                }
                break;
        }
    }
}
