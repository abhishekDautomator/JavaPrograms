import java.util.Arrays;
import java.util.List;

public class CToJavaVarConversionViceAVersa {
    public static void main(String[] args) {
        System.out.println(cToJavaVar("c_to_java"));
        System.out.println(javaToCVar("javaToC"));
    }

    public static String cToJavaVar(String cVar){
        if(cVar.isEmpty())
            return "Invalid Input";
        else if (cVar.length()==1) {
            return cVar;
        }
        List<String> strList = Arrays.stream(cVar.split("_")).toList();
        StringBuilder result = new StringBuilder(strList.get(0));
        for(int i=1; i<strList.size();i++){
            String s = strList.get(i);
            result.append(s.toUpperCase().charAt(0)).append(s.substring(1));
        }
        return result.toString();
    }

    public static String javaToCVar(String javaVar){
        if(javaVar.isEmpty())
            return "Invalid Input";
        else if (javaVar.length()==1) {
            return javaVar;
        }
        StringBuilder str = new StringBuilder();
        List<String> strList = Arrays.stream(javaVar.split("")).toList();
        for (String s : strList) {
            if(s.matches("[A-Z]")){
                str.append("_").append(s.toLowerCase());
            }else str.append(s);
        }
        return str.toString();
    }
}
