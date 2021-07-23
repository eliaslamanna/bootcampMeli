package ejercicio1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    public Pattern regex;
    public String password;

    public Password(String regex) {
        this.regex = Pattern.compile(regex);
    }

    public Password() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setValue(String password) throws Exception{
        Matcher matcher = this.regex.matcher(password);
        if(matcher.find()) {
            this.password = password;
        }
        else {
            throw new Exception();
        }
    }
}
