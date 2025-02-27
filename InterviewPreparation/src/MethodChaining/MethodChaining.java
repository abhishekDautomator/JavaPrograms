package MethodChaining;

public class MethodChaining {
    public static void main(String[] args) {
        String result = new StringBuilderExample("Hello")
                .append(" World")
                .toUpperCase()
                .build();
        System.out.println(result); // Outputs: HELLO WORLD
    }
}

class StringBuilderExample {
    private String str;

    StringBuilderExample(String str) {
        this.str = str;
    }

    public StringBuilderExample append(String s) {
        this.str += s; // Append the string
        return this;   // Return the current object
    }

    public StringBuilderExample toUpperCase() {
        this.str = this.str.toUpperCase(); // Convert to upper case
        return this; // Return the current object
    }

    public String build() {
        return str; // Return the final string
    }
}