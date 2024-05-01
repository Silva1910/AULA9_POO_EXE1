package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CidadeBH")
public class calcImpostoBH extends HttpServlet implements ICidadeStrategy {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numComodos = request.getParameter("numQuartos");
        String areaTotal = request.getParameter("areaTotal");
        double imposto = 0;

        if (numComodos != null && areaTotal != null) {
            float area = Float.parseFloat(areaTotal);
            int num = Integer.parseInt(numComodos);
            imposto = calcularImposto(area, num);
        }

        request.setAttribute("imposto", imposto);

        RequestDispatcher rd = request.getRequestDispatcher("CidadeBH.jsp");
        rd.forward(request, response);
    }

    public double calcularImposto(float area, double num) {
       
        double imposto = (area * 7) + (num * 4);
        return imposto;
    }
}
