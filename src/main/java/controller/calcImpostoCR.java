package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CidadeCR")
public class calcImpostoCR extends HttpServlet implements ICidadeStrategy {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idade = request.getParameter("idade");
        String areaTotal = request.getParameter("areaTotal");
        double imposto = 0;

        if (idade != null && areaTotal != null) {
            float area = Float.parseFloat(areaTotal);
            double num = Double.parseDouble(idade);
           
            if (num>50) {
            	 imposto = calcularImposto(area, num *3);
            }
            else if (num<20) {
            imposto = calcularImposto(area, num*2);
        } else if(num > 20 && num>50) {
        	  
        	 imposto = calcularImposto(area, num * 2.5);
        }
        }
        request.setAttribute("imposto", imposto);

        RequestDispatcher rd = request.getRequestDispatcher("CidadeCR.jsp");
        rd.forward(request, response);
    }

    public double calcularImposto(float area, double num) {
       
        double imposto = (area * 5) + (num);
        return imposto;
    }
}


