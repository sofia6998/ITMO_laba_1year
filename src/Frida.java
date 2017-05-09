public class Frida extends Person {
    private String haveSaid;

    public Frida() {
        name = "Фрида";
        this.setGExp(name + " говорила с привидениями: ");
    }

    public String tell(String s) {
        System.out.println("Фрида говорит: " + s);
        haveSaid = s;
        return s;
    }

    public void setS(String s) {
        haveSaid = s;
    }

    public String getS() {
        return haveSaid;
    }

}