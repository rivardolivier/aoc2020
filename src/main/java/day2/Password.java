package day2;

public class Password {

    private String character;
    private Integer min;
    private Integer max;
    private String password;

    public Password() {
    }

    public Password(String character, Integer min, Integer max, String password) {
        this.character = character;
        this.min = min;
        this.max = max;
        this.password = password;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
