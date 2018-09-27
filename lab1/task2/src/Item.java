public class Item {

    private String name;
    private int age;
    private int salary;
    private Item linkedItem;

    public Item(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.linkedItem = null;
    }

    public void linkItem(Item item) {
        this.linkedItem = item;
    }

    public Item getLinkedItem() {
        return linkedItem;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}' + "\n";
    }
}
