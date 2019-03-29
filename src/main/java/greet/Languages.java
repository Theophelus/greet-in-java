package greet;

public enum Languages {
    Isixhosa("Molo"),
    English("Hello"),
    IsZulu("Dumela");

    //Define a variable that will allow me to get values of langs
    private String lang;

    //Define a constructor to be able to use it later
    Languages(String lang){
        this.lang = lang;
    }

    //Define a getter Method to be able to get access to enum values
    private String getLang(){return lang;}
}
