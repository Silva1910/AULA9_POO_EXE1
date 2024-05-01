package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CidadeSP")
public class calcImpostoSP extends HttpServlet implements ICidadeStrategy {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numComodos = request.getParameter("numComodos");
        String areaTotal = request.getParameter("areaTotal");
        double imposto = 0;

        if (numComodos != null && areaTotal != null) {
            float area = Float.parseFloat(areaTotal);
            int num = Integer.parseInt(numComodos);
            imposto = calcularImposto(area, num);
        }

        request.setAttribute("imposto", imposto);

        RequestDispatcher rd = request.getRequestDispatcher("CidadeSP.jsp");
        rd.forward(request, response);
    }

    public double calcularImposto(float area, double num) {
       
        double imposto = (area * 10) + (num * 2);
        return imposto;
    }
}
