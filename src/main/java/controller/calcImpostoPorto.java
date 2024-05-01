package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CidadePT")
public class calcImpostoPorto extends HttpServlet implements ICidadeStrategy {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numComodos = request.getParameter("areaGaragem");
        String areaTotal = request.getParameter("areaTotal");
        double imposto = 0;

        if (numComodos != null && areaTotal != null) {
            float area = Float.parseFloat(areaTotal);
            int num = Integer.parseInt(numComodos);
            imposto = calcularImposto(area, num);
        }
        
        
        request.setAttribute("imposto", imposto);

        RequestDispatcher rd = request.getRequestDispatcher("CidadePT.jsp");
        rd.forward(request, response);
    }

    public double calcularImposto(float area, double num) {
       
    	if (num!=0) {
        double imposto = (area * 7.5) + (num * 2.5);
    	
        return imposto;
    }
    else {
     double imposto = area*8;
     return imposto;
    }
    }
}
