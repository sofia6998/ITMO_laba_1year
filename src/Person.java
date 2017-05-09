public class Person extends Entity {
    private String GhostsExpierence = "";

    public void talktoG(Ghost g) {
        this.setGExp(g.Gname());
    }

    public void goTo(Places p) {
        System.out.println(name + " пришел в " + p.getName());
    }

    public void setGExp(String s) {
        if (this.GhostsExpierence.isEmpty()) {
            this.GhostsExpierence = s;
        } else {
            this.GhostsExpierence = this.GhostsExpierence + " " + s + ",";
        }
        System.out.println(name + ": опыт установлен");
    }

    public String getGExp() {
        return this.GhostsExpierence;
    }
}