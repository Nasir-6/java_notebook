package equals_assignment_by_ref_or_val;

public class PassByValue {

    // The Java Spec says that everything in Java is pass-by-value.
    // Whenever a variable (primitive or object) is passed into a method/function
    // It is passed as a value - i.e a copy is made!!!
    // This means any changes to the variable inside the method won't affect the variable outside!
    // Unless it is an object - the memory location value is passed through allowing changes to the properties to be made
    // BUT you cannot change the memory location of the original Object within the method/function
    // i.e it is a pass-by-value (passed in memory value)
    // NOT pass-by-reference (we cannot pass the memory reference and adjust it inside the method/function)!

    public static void main(String[] args) {

//        stringPassByValue();
        objectPassByValue();

    }



    public static void stringPassByValue() {
        int homerAge = 30;
        changeHomerAge(homerAge);
        System.out.println(homerAge); // 30
        // It doesn't change to 35 as the local homerAge is just copied into the method - see name below
        // You'd think it would change but the variable passed in is just copied - NOT referenced!
        // kinda like copiedHomerAge = homerAge; - assignByValue
    }

    static void changeHomerAge(int copiedHomerAge) {
        copiedHomerAge = 35;
    }


    public static class Person{
        String name;

        Person(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void objectPassByValue() {
        Person nasir = new Person("Nasir");
        changePersonName(nasir);
        System.out.println("Person outside the method");
        System.out.println(nasir);      // Person{name='Mohammed'} - the name is changed within the method 0_0
        // Note: here it seems as though it is a pass by reference
        // But it is pass by value - as we are passing the value of the memory location of Person nasir
        // and the value is adjusted - i.e the values within the memory location are adjusted


        // Why is it not a pass by Reference
        // Because you cannot change the memory location pointer of the object you just passed in!!
        // see below!
        System.out.println("Testing the change in reference");
        changePersonMemoryLocation(nasir);
        System.out.println(nasir);  // Person{name='Mohammed'} - still same!! despite the above method changing the memory location pointer!

    }

    private static void changePersonName(Person someCopiedPerson) {
        someCopiedPerson.setName("Mohammed");
        System.out.println("Person inside the method");
        System.out.println(someCopiedPerson);   // Person{name='Mohammed'}
        // Actually adjusts the
    }

    private static void changePersonMemoryLocation( Person somePerson) {
        somePerson = new Person("A new Person");
        System.out.println(somePerson);     // Person{name='A new Person'}
        // NOTE: THIS WILL NOT REASSIGN THE MEMORY LOCATION OF nasir
        // but rather just reassign the memory location value of somePerson
        // Originally it was set to nasir's location
        // But now it is to a new person despite nasir being passed in as somePerson
        // i.e the memory location is passed in as a VALUE not as a REFERENCE

        // IN some languages like C++, Ada, Pascal and other languages that support pass-by-reference,
        // you can actually change the variable memory location that was passed!!!
        // Not in Java though!
    }
}
