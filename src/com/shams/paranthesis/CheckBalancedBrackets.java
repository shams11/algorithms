package com.shams.paranthesis;

import java.util.Stack;

public class CheckBalancedBrackets {
  static Stack<Character> stack;

  public static void main(String[] args) {
    String exp1 = "[()]{}{[()()]()}";
    String exp = "]";

    if (exp.length() % 2 != 0) {
      System.out.println("Brackets not balanced");
      return;
    }
    if (areBracketsBalanced(exp)) {
      System.out.println("Brackets balanced");
      return;
    }
    System.out.println("Brackets not balanced");
  }

  private static boolean areBracketsBalanced(String exp) {
    stack = new Stack<>();
    char y;
    for (int i = 0; i < exp.length(); ++i) {
      char x = exp.charAt(i);
      if (x == '(' || x == '{' || x == '[') {
        stack.push(exp.charAt(i));
        continue;
      }


      switch (x) {
        case ')':
          y = stack.pop();
          if (y == '{' || y == '[')
            return false;
          break;
        case ']':
          y = stack.pop();
          if (y == '{' || y == '(')
            return false;
          break;
        case '}':
          y = stack.pop();
          if (y == '(' || y == '[')
            return false;
          break;
        default:
          return false;
      }
    }
    return stack.isEmpty();
  }

  private static boolean matches(char openBracket, char closeBracket) {
    if (openBracket == '{' && closeBracket == '}') {
      return true;
    }
    if (openBracket == '(' && closeBracket == ')') {
      return true;
    }
    if (openBracket == '[' && closeBracket == ']') {
      return true;
    }
    return false;
  }
}
