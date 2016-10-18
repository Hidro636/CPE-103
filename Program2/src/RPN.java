
import java.util.Scanner;

/**
 * A class that evaluates reverse polish notation
 *
 * @author Lucas Robertson
 * @version Program 2
 */
public class RPN {

    /**
     * Evaluates the given infix expression. The given expression must be a
     * well-formed infix expression. You are strongly encouraged to use your
     * other methods to solve this problem.
     *
     * @param infix the infix expression to evaluate
     * @return the result of the infix expression
     */
    public static double evaluateInfix(String infix) {
        return evaluateRPN(toRPN(infix));
    }

    /**
     * Evaluates the given RPN expression. The given expression must be a
     * well-formed RPN expression. This method supports all numeric values
     * (integers and floating points) and the operators +, −, ∗, and /. Every
     * value and operator in the expression must have at least one whitespace
     * character around it. Note that there may be more whitespace around values
     * and operators. This assumption is designed to encourage you to use the
     * Scanner class methods to parse the expressions.
     *
     * @param expression the RPN expression to evaluate
     * @return the result of the RPN expression
     */
    public static double evaluateRPN(String expression) {
        SimpleLinkedStack<Double> stack = new SimpleLinkedStack<>();
        try (Scanner read = new Scanner(expression)) {
            read.useDelimiter(" ");

            String value;

            while (read.hasNext()) {
                value = read.next();
                switch (value) {
                    case "+":
                        stack.push((double) stack.pop() + (double) stack.pop());
                        break;
                    case "-":
                        stack.push(-1 * (double) stack.pop() + (double) stack.pop());
                        break;
                    case "*":
                        stack.push((double) stack.pop() * (double) stack.pop());
                        break;
                    case "/":
                        stack.push((1 / (double) stack.pop()) * (double) stack.pop());
                        break;

                    default:
                        stack.push(Double.valueOf(value));
                        break;
                }
            }
        }
        return stack.pop();

    }

    /**
     * Converts the given infix expression to reverse polish notation. The given
     * expression must be a well-formed infix expression. This method supports
     * all numeric values (integers and floating points), the operators +, −, ∗,
     * and /, and any amount of parentheses.
     *
     * @param infix the infix expression to convert
     * @return the resulting RPN expression
     */
    public static String toRPN(String infix) {
        SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
        String expression = "";
        Scanner read = new Scanner(infix);
        read.useDelimiter(" ");

        String value;
        while (read.hasNext()) {
            value = read.next();
            switch (value) {
                case "*":
                case "/":
                    while (stack.size() > 0 && !(stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("("))) {
                        expression += stack.pop() + " ";
                    }
                    stack.push(value);
                    break;

                case "+":
                case "-":
                    while (stack.size() > 0 && !stack.peek().equals("(")) {
                        expression += stack.pop() + " ";
                    }
                    stack.push(value);
                    break;

                case "(":
                    stack.push(value);
                    break;

                case ")":
                    while (!stack.peek().equals("(")) {
                        expression += stack.pop() + " ";
                    }
                    stack.pop();
                    break;

                default:
                    expression += value + " ";
                    break;

            }
        }

        while (stack.size() > 0) {
            expression += stack.pop() + " ";
        }

        return expression.trim();
    }
}
