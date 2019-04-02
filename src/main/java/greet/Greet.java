package greet;

public class  Greet implements GreetMethods{

    private String username;
    Languages languages; // Enum accessor inside this class

    @Override
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
                return "";
        }
    }

//    @Override
//    public String greeted() {
//        return null;
//    }
//
//    @Override
//    public void exit() {
//
//    }
//
//    @Override
//    public void help() {
//    }
}
