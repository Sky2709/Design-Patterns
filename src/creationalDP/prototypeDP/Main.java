package creationalDP.prototypeDP;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address= new Address("123", "New York");
        Person originalPerson= new Person("John", 25, address);
        System.out.println("Original Person: "+originalPerson.getName()
                                              +" "
                                              +originalPerson.getAge()
                                              +" "+originalPerson.getAddress().getStreet()
                                              +" "+originalPerson.getAddress().getCity());

        Person clonedPerson= originalPerson.clone();
        clonedPerson.setName("Jack");
        System.out.println("Cloned Person: "+clonedPerson.getName()
                                            +" "
                                            +clonedPerson.getAge()
                                            +" "+clonedPerson.getAddress().getStreet()
                                            +" "+clonedPerson.getAddress().getCity());


        System.out.println("After cloning: " + originalPerson.getName()
                                              +" "
                                              +originalPerson.getAge()
                                              +" "+originalPerson.getAddress().getStreet()
                                              +" "+originalPerson.getAddress().getCity());
    }
}
