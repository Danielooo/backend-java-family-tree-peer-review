import java.util.ArrayList;
import java.util.List;

public class Person {

    // VARIABLES
    private String name;
    private String middleName;
    private String lastName;
    private String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<>();
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();

    // CONSTRUCTORS
    public Person(String name, String middleName, String lastName, String sex, int age) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public Person(String name, String lastName, String sex, int age) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    // FUNCTIONS
    public void addParent(Person person) {

        if (person.getSex().equalsIgnoreCase("male")) {
            this.father = person;
            person.addChild(this);
        } else if (person.getSex().equalsIgnoreCase("female")) {
            this.mother = person;
            person.addChild(this);
        } else {
            System.out.println("Parent type can't be processed");
        }
    }

    public void addChild(Person person) {
        // Adds child only to 'children' if the object is not already added.
        if (!children.contains(person)) {
            this.children.add(person);
            person.addParent(this);
        } else {
            System.out.println("Child " + person.getName() + " is (already) added to " + this.getName());
        }
    }

    public void addSibling(Person person) {
        if (!siblings.contains(person)) {
            this.siblings.add(person);
            person.addSibling(this);
        } else {
            System.out.println("Sibling " + person.getName() + " is (already) added to " + this.getName() +"'s list of siblings");
        }
    }

    public List<Person> getGrandChildren() {
        List<Person> grandChildren = new ArrayList<>();

        for (Person child : this.children) {
            if (!child.getChildren().isEmpty()) {
                for (Person grandKid : child.getChildren()) {
                    grandChildren.add(grandKid);
                }
            }
        }
        return grandChildren;
    }

    public void printGrandChildren() {
        List<Person> grandChildren = getGrandChildren();
        System.out.println("Names of " + this.name + "'s grandchildren: ");
        for (Person grandKid : grandChildren) {
            System.out.println(grandKid.getName());
        }

    }

    public void addPet(Pet pet) {
        if (!pets.contains(pet)) {
            this.pets.add(pet);
            pet.addOwner(this);
        }
    }


    public void printPerson() {
        System.out.println("Name: " + this.name);
        System.out.println("Middle name: " + this.middleName);
        System.out.println("Last name: " + this.lastName);
        System.out.println("Sex: " + this.sex);
        System.out.println("Age: " + this.age);
        System.out.println("Mother: " + this.mother);
        System.out.println("Father: " + this.father);
        System.out.println("Siblings: " + this.siblings);
        System.out.println("Children: " + this.children);
        System.out.println("Pet: " + this.pets);
    }




    // GETTERS AND SETTERS


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }


}
