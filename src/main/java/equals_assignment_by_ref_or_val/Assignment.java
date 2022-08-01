package equals_assignment_by_ref_or_val;

import java.util.Arrays;

public class Assignment {

    // This example clarifies when the equal operator assigns by refernce or value
    // To summarise:
    // Primitives are assigned by value (A copy is made - even if it is a copy of an object's property)
    // Objects are assigned by Reference (uses same memory location - so changing one object will change the other)
    // Arrays are also Objects

    public static void main(String[] args) {

        assignByValue();

        assignByReferenceArrays();
        assignByReferenceObject();

        // Extra cases
//        advancedPrimitiveAssignedByValue();


    }

    public static void assignByValue(){
        int x = 3;
        int y = x;
        x = 4;

        System.out.println("x is " + x); // x is 4
        // as expected

        System.out.println("y is " + y);    // y is 3
        // it just copies value (old value of x which is 3) - doesn't point to x!!!

        // Assignment by Value
    }


    // This person class was made for the Object refernce below
    public static class Person{
        String name;
        int age;

        Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void assignByReferenceObject(){
        // ALL OBJECTS ARE ASSIGNED BY REFERENCE!!!
        Person nasir = new Person("Nasir", 23);
        Person bob = nasir;
        System.out.println(nasir);  // Person{name='Nasir', age=23}
        System.out.println(bob);    // Person{name='Nasir', age=23}

        // Changing Bob's name
        bob.name = "Bob";
        System.out.println(bob);    // Person{name='Bob', age=23}
        // Notice also Nasir's name changes!!!!
        System.out.println(nasir);  // Person{name='Bob', age=23}

        // This is because bob is still pointing to the same Person Object Nasir in the memory stack
        // So changing Bob is changing Nasir as they both refer to the same Object!!


        System.out.println("=============");
        System.out.println("Extra experiment to show how primitives are always assigned by value!!!");
        // Extra experiment - shows how primitives are assignedByValue always!!
        int grabbedAge = bob.age;
        System.out.println(bob.age);    // 23
        System.out.println(grabbedAge); // 23


        bob.age = 200;
        System.out.println(bob.age);    // 200
        System.out.println(grabbedAge); // 23   - NOTICE HOW THE primitive didn't change!! - it is assigned by value!


    }


    public static void assignByReferenceArrays(){
        // NOTE: Java Arrays are also Java Objects - so they are assigned by Reference aswell!!
        // Tip: that's why System.out.println(arr1) - will give a memory location - so need to use .toString()!!
        int[] arr1 = new int[] {1,2,3};
        int[] arr2 = arr1;
        System.out.println(Arrays.toString(arr1)); // [1, 2, 3]
        System.out.println(Arrays.toString(arr2)); // [1, 2, 3]


        // Changing arr1 will also change arr2 - as they refer to the same Object in the heap
        arr1[0] = 100;

        System.out.println(Arrays.toString(arr1)); // [100, 2, 3]
        System.out.println(Arrays.toString(arr2)); // [100, 2, 3]

        // Changing arr2 will also change arr1!!! - as AGAIN they refer to the same Object in the heap
        // Doesn't matter if arr2 = arr1!! - they refer to the same memory location in the heap!
        arr2[0] = 99;

        System.out.println(Arrays.toString(arr1)); // [99, 2, 3]
        System.out.println(Arrays.toString(arr2)); // [99, 2, 3]

    }

}
