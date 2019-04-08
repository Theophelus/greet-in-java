package greet;

public class  Greet {

    private String username;
    Languages languages; // Enum accessor inside this class
//    Greeted greeted = new Greeted();

    public String greetUser(String language, String userName) {
        //greeted.setGreetedUsers(userName);
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


    public String getUsername() {
        return username;
    }

    //Define a getter method that is going to get greet
    public boolean getLanguages(String lang) {
        return languages.getLang().equalsIgnoreCase(lang);
    }
}
