import static spark.Spark.*;
import com.google.gson.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class finraServer {
    public static void main(String [] args){

        get("/getComb", (req, res) -> {
            String phone_number = req.queryParams("number");
            String number_sanitized = "";
            for(int i=0;i<phone_number.length();i++){
                if(Character.isDigit(phone_number.charAt(i))){
                    number_sanitized+=phone_number.charAt(i);
                }
            }
            System.out.println(number_sanitized);
            if(number_sanitized.length()!=7 && number_sanitized.length()!=10){
                return new Gson().toJson("Enter a valid number");
                //return "Enter a valid number";
            }
            else{
                List<String> t = getComb(number_sanitized);
                System.out.println(t);
                //return t;
                return new Gson().toJson(t);
            }
                }

        );
        before((req, res) -> {
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Headers", "*");
            res.type("application/json");
        });

 }

    public static List<String> getComb(String phone_number){
        //MAKE MAPPING OF DIGITS
        HashMap<String,ArrayList<String>> mapping = new HashMap<>();
        for(int i=0;i<10;i++){
            mapping.put(i+"",new ArrayList<>());
            mapping.get(i+"").add(i+"");
        }
        mapping.get("2").add("A");
        mapping.get("2").add("B");
        mapping.get("2").add("C");
        mapping.get("3").add("D");
        mapping.get("3").add("E");
        mapping.get("3").add("F");
        mapping.get("4").add("G");
        mapping.get("4").add("H");
        mapping.get("4").add("I");
        mapping.get("5").add("J");
        mapping.get("5").add("K");
        mapping.get("5").add("L");
        mapping.get("6").add("M");
        mapping.get("6").add("N");
        mapping.get("6").add("O");
        mapping.get("7").add("P");
        mapping.get("7").add("Q");
        mapping.get("7").add("R");
        mapping.get("7").add("S");
        mapping.get("8").add("T");
        mapping.get("8").add("U");
        mapping.get("8").add("V");
        mapping.get("9").add("W");
        mapping.get("9").add("X");
        mapping.get("9").add("Y");
        mapping.get("9").add("Z");


        //BEGIN GENERATING COMBINATIONS
        List<String> numberlist = new ArrayList<>();
        numberlist.add("");
        for(int j=0;j<phone_number.length();j++){
            List<String> current = new ArrayList<>();
            for(String entry:mapping.get(phone_number.charAt(j)+"")){
                for(String comb:numberlist){
                    current.add(comb+entry);
                }
            }
            numberlist=current;
        }
        return numberlist;
    }
}