public class Person {
    private int id;
    private int age;

    /**
     * Ctor. Creates a Person from and an age.
     * @param id: id number of the person.
     * @param age: age of the person
     */
    public Person(int id, int age) {
        this.id = id;
        this.age = age;
    }

    /**
     * Returns id number of current Person.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns age of current Person.
     * @return age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Override equals with custom equals of id and age of Person.
     * @param obj
     * @return true if equals, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        Person otherPerson = (Person) obj;
        return this.age == otherPerson.getAge() &&
                this.id == otherPerson.getId();
    }
}
