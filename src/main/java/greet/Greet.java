package greet;

public class  Greet {

    private String username;
    Languages languages; // Enum accessor inside this class

    public String greetUser(String language, String userName) {

        if (userName != "") this.username = userName;

        switch (Languages.valueOf(language)) {
            case Isixhosa:
                return  Languages.valueOf(language).getLang() + ", " + username;
            case English:
                return  Languages.valueOf(language).getLang() + ", " + username;
            case IsiZulu:
                return  Languages.valueOf(language).getLang() + ", " + username;
            default:
                return Languages.Isixhosa.getLang() + " " + username;
        }
    }
    //Define a getter method that is going to get greet

    public boolean getLanguages(String lang) {
        return languages.getLang().equalsIgnoreCase(lang);
    }
}
