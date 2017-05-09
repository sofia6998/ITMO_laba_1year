public abstract class Entity {
    protected String name;
    protected String shine;

    public void setName(String newName) {
        name = newName;
        System.out.println("Имя установлено");
    }

    public void setShine(String newShine) {
        shine = newShine;
        System.out.println("Cияние установлено: " + shine);
    }

    public String getName() {
        return name;
    }

    public String getShine() {
        return shine;
    }

    public boolean equals(Entity b) {
        if (this.name == b.name) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return 123 + this.name.hashCode();
    }

    public String toString() {
        return this.name;
    }
}
