public class Person {
    private int id;
    private int age;

    public Person(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        Person otherPerson = (Person) obj;
        return this.age == otherPerson.getAge() &&
                this.id == otherPerson.getId();
    }
}
