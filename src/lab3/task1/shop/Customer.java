package lab3.task1.shop;

import java.util.ArrayList;

public class Customer {
    private final String firstName;
    private final String lastName;
    private ArrayList<Check> history;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.history = new ArrayList<>();
    }

    public void addCheck(Check check){
        history.add(check);
    }

    public void printHistory(){
        System.out.println(firstName + " " + lastName);
        for(Check check : history){
            System.out.println(check);
        }
    }

    public ArrayList<Check> getHistory() {
        return history;
    }
}
