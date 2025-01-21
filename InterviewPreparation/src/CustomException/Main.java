package CustomException;

public class Main {
    public static void main(String[] args) throws CustomException {
        try {
            String a = "";
            if (a.isEmpty()) throw new CustomException("getting empty value");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }


    }
}
