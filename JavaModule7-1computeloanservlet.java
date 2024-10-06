import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Import the Loan class
import yourpackage.Loan;

@WebServlet("/computeLoan")
public class ComputeLoanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double annualInterestRate = Double.parseDouble(request.getParameter("interestRate"));
        int numberOfYears = Integer.parseInt(request.getParameter("years"));

        // Create a Loan object
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

        // Calculate monthly and total payments
        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();

        // Set response content type
        response.setContentType("text/html");

        // Write the response
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Loan Calculator Result</title></head><body>");
        out.println("<h2>Loan Calculator Result</h2>");
        out.println("<p>Loan Amount: $" + loanAmount + "</p>");
        out.println("<p>Annual Interest Rate: " + annualInterestRate + "%</p>");
        out.println("<p>Number of Years: " + numberOfYears + "</p>");
        out.println("<p>Monthly Payment: $" + String.format("%.2f", monthlyPayment) + "</p>");
        out.println("<p>Total Payment: $" + String.format("%.2f", totalPayment) + "</p>");
        out.println("</body></html>");
        out.close();
    }
}
