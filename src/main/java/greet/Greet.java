package greet;

public class  Greet {

    private String username;

    public String greetUser(String language, String userName) {

        if (userName != "") this.username = userName;

        try {

            switch (Languages.valueOf(language)) {
                case isixhosa:
                    return  Languages.valueOf(language).getLang() + ", " + username;
                case english:
                    return  Languages.valueOf(language).getLang() + ", " + username;
                case isizulu:
                    return  Languages.valueOf(language).getLang() + ", " + username;
                default:
                    return Languages.isixhosa.getLang() + " " + username;
            }

        }catch (IllegalArgumentException e) {
            System.out.println("Error: " + e);

        }


        return language;
    }
}
