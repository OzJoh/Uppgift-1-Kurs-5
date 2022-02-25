import java.util.HashMap;
import java.util.Locale;

public class morseLogic {

    private String output = "";

    public String translate(String input) {
        HashMap<Character, String> toMorse = new HashMap<Character, String>();
        HashMap<String, Character> toEnglish = new HashMap<String, Character>();

        char[] English = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '1', '2', '3', '4','5','6','7','8','9','0','.',',','?'};
        String[] Morse = new String[]{"*-","-***","-*-*","-**","*","**-*","--*","****","**","*---","-*-","*-**","--",
                "-*", "---","*--*","--*-","*-*","***","-","**-","***-","*--","-**-","-*--","--**","*----",
                "**---","***--","****-","*****","-****","--***","---**","----*","----","*-*-*-","--**--","**--**"};

        for (int i = 0;i<English.length;i++){
            toMorse.put(English[i],Morse[i]);
        }
        for (int i = 0;i<Morse.length;i++){
            toEnglish.put(Morse[i],English[i]);
        }

        input = input.toUpperCase();        /*Felhantering för att hantera stora/små bokstver*/
        String[] removeSpace = input.split(" ");

        boolean isEnglish = false;          /*Felhantering för tecken som inte ingår i engelska eller morsealfabetet*/
        boolean isMorse = false;
        for (int i = 0;i<input.length();i++){
            char a = input.charAt(i);
            if ((a>=65 && a<=90) || (a>=48 && a<=57) || a==46 || a==44 || a==63 ){
                isEnglish = true;
            }
            else{
                isEnglish = false;
                break;
            }
        }
        for (int i = 0;i<removeSpace.length;i++){
            for(int z = 0;z<removeSpace[i].length();z++) {
                char a = removeSpace[i].charAt(z);
                if (a == 45 || a == 42) {
                    isMorse = true;
                } else {
                    isMorse = false;
                    break;
                }
            }


        }
        if (isEnglish){
            for (int i = 0;i<(input.length());i++) { //loop för att översätta engelska ord till morse
                char c = input.charAt(i);
                output += toMorse.get(c) + " ";
            }
        }
        if (isMorse){
            for (int i = 0;i<(removeSpace.length);i++) {
                    String ch = removeSpace[i];
                    output += toEnglish.get(ch);
            }
        }


        if(!isEnglish && !isMorse){
            output = "Error: använder ogiltiga tecken och/eller blandar morse alfabetet med engelska alfabetet.";
        }
        else if (isEnglish && isMorse){
            output = "Error: använder ogiltiga tecken och/eller blandar morse alfabetet med engelska alfabetet.";
        }

        return output;
    }
}
