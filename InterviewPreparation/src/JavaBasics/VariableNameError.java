package JavaBasics;

public class VariableNameError {
    public static void main(String[] args) {
        int Integer = 24;
        System.out.println(Integer);
        char String = 'I';
        System.out.println(String);
    }
    //In Java, variable names (also known as identifiers) must follow specific rules.
    // Here’s a breakdown of what is allowed and what is not when it comes to naming variables.
    //
    //Allowed Variable Names
    //Start with a Letter, Dollar Sign, or Underscore:
    //
    //Variable names can start with any letter (uppercase or lowercase), the dollar sign (\$), or an underscore (_).
    //Examples: myVariable, _temp, \$value
    //Followed by Letters, Digits, Dollar Signs, or Underscores:
    //
    //After the first character, you can use letters, digits (0-9), dollar signs, and underscores.
    //Examples: var123, data_\$value, count_1
    //Case Sensitive:
    //
    //Variable names are case-sensitive. For example, myVar and myvar are considered different variables.
    //No Length Restrictions:
    //
    //There is no fixed limit on the length of variable names, but it's advisable to keep them reasonably short while still being descriptive.
    //Not Allowed Variable Names
    //Cannot Start with a Digit:
    //
    //Variable names cannot begin with a digit.
    //Example: 1stVariable is invalid.
    //Reserved Keywords:
    //
    //Java has reserved keywords that cannot be used as variable names. These include words like int, class, public, void, if, else, while, etc.
    //Example: class, return, and for are invalid variable names.
    //Special Characters:
    //
    //Variable names cannot contain special characters other than \$ and _. This means characters like @, #, %, ^, &, *, etc., are not allowed.
    //Example: my-variable and data@home are invalid.
    //Spaces:
    //
    //Spaces are not allowed in variable names.
    //Example: my variable is invalid.
    //Non-ASCII Characters:
    //
    //While Java allows Unicode characters in identifiers, it's generally best practice to avoid non-ASCII characters for better readability and compatibility.
    //Example: Using characters from other languages may lead to confusion.
    //Summary
    //In summary, valid variable names in Java must start with a letter, dollar sign, or underscore, and can contain letters, digits, dollar signs, and underscores thereafter. They cannot start with a digit, use reserved keywords, contain special characters (other than \$ and _), have spaces, or contain non-ASCII characters. Following these rules helps ensure that your code is clear, maintainable, and free of syntax errors.
}
