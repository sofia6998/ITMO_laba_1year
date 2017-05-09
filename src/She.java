public class She extends Person {
    public She() {
        name = "Она";
        this.setGExp(name + " говорила с привидениями: ");
    }

    private String mood;

    public void setMood(String s) {
        mood = s;
        System.out.println("Ее настроение: " + s);
    }

    public String getMood() {
        return mood;
    }

    public void compare(String s1, String s2) {
        System.out.println("Она сравнивает (" + s1 + ") c (" + s2 + ")");
    }
}