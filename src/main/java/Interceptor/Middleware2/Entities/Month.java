package Interceptor.Middleware2.Entities;

public class Month {

    private int monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;

    public Month(int monthNumber, String englishName, String italianName, String germanName) {
        this.monthNumber = monthNumber;
        this.englishName = englishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }
}
