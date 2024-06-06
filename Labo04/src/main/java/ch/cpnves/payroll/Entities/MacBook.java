package ch.cpnves.payroll.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class MacBook {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private String capacity;

    public MacBook(){}

    public MacBook(String name, String capacity){
        this.setName(name);
        this.setCapacity(capacity);
    }

    public Long getID(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCapacity(){
        return this.capacity;
    }

    public void setCapacity(String role){
        this.capacity = role;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof MacBook macBook))
            return false;
        return Objects.equals(this.id, macBook.id) && Objects.equals(this.name, macBook.name)
                && Objects.equals(this.capacity, macBook.capacity);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.capacity);
    }

    @Override
    public String toString(){
        return "MacBook{" + "id=" + this.getID() + ", name='" + this.getName() + '\'' + ", capacity='" + this.getCapacity() + '\'' + '}';
    }
}
