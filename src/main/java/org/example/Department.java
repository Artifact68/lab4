public class Department {
    private static int nextId = 1;
    private int id;
    private String name;

    public Department(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Department that = (Department) obj;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
