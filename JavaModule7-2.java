<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Addition Quiz</title>
</head>
<body>
<%
    // Number of questions
    int numQuestions = 5;
    // Array to store the questions
    int[][] questions = new int[numQuestions];
    // Array to store the user's answers
    int[] answers = new int[numQuestions];
    // Generate random questions
    for (int i = 0; i < numQuestions; i++) {
        questions[i] = (int) (Math.random() * 10);
        questions[i] = (int) (Math.random() * 10);
    }
    // Check if the form has been submitted
    if (request.getParameter("submit") != null) {
        // Retrieve user's answers from the form
        for (int i = 0; i < numQuestions; i++) {
            answers[i] = Integer.parseInt(request.getParameter("answer" + i));
        }
        // Calculate the score
        int score = 0;
        for (int i = 0; i < numQuestions; i++) {
            if (answers[i] == questions[i] + questions[i]) {
                score++;
            }
        }
%>
        <!-- Display the results -->
        <h2>Your Score: <%= score %> out of <%= numQuestions %></h2>
        <ul>
            <% for (int i = 0; i < numQuestions; i++) { %>
                <li><%= questions[i] %> + <%= questions[i] %> = <%= questions[i] + questions[i] %> 
                    (Your answer: <%= answers[i] %>)</li>
            <% } %>
        </ul>
        <a href="additionQuiz.jsp">Try Again</a>
<%
    } else {
%>
        <!-- Display the quiz form -->
        <form method="post" action="additionQuiz.jsp">
            <% for (int i = 0; i < numQuestions; i++) { %>
                <p><%= questions[i] %> + <%= questions[i] %> = 
                    <input type="text" name="answer<%= i %>" /></p>
            <% } %>
            <input type="submit" name="submit" value="Submit" />
        </form>
<%
    }
%>
</body>
</html>
