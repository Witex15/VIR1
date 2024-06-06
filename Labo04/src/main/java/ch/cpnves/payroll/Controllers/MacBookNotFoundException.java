package ch.cpnves.payroll.Controllers;

public class MacBookNotFoundException extends RuntimeException{

    MacBookNotFoundException(Long id){
        super("Could not find employee " + id);
    }
}
