package greet;

public enum Languages {
    Isixhosa("Molo"),
    English("Hello"),
    IsZulu("Dumela");

    //Define a lang variable to Store data
    private String lang;

    //Define a constructor to be able to use it later
     Languages(String lang){
        this.lang = lang;
    }

    //Define a getter Method to be able to get access to enum data
    public String getLang(){return lang;}
}
