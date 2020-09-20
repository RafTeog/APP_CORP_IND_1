/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
//@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int number1, number2;
        String operator;
        
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        number1 = Integer.parseInt(request.getParameter("number1"));
        number2 = Integer.parseInt(request.getParameter("number2"));
        operator = request.getParameter("operator");


        response.addCookie(new Cookie(Double.toHexString(Math.random()), Double.toHexString(Math.random())));
        Cookie cookies[]=request.getCookies();


        /*String textoAntigo = "";
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("uses")) {
                textoAntigo = cookie.getValue();
            }
        }

        String texto = request.getParameter("uses");
        String textoNovo = textoAntigo + texto;
        Cookie cookie = new Cookie(texto, textoNovo);
        response.addCookie(cookie);*/
        OperatingClass oc = new OperatingClass(number1, number2, operator);

        oc.calc();

        out.write(
                "<html>");
        out.write(
                "<head><title>calculator</title></head>");
        out.write(
                "<body>");
        if (operator.equals(
                "/")) {
            out.write(number1 + " " + operator + " " + number2 + " = " + oc.getResult2());
        } else {
            out.write(number1
                    + " " + operator + " " + number2 + " = " + oc.getResult1());
        }

        out.write(
                "<p>");
        out.write(
                "Número de vezes acessada:" + cookies.length);
        out.write(
                "</p>");
        out.write(
                "</body>" + "</html>");

    }

}
