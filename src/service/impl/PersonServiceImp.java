package service.impl;

import exseptions.MyException;
import lms.Person;
import service.PersonService;
import java.util.List;
import java.util.Scanner;

public class PersonServiceImp  implements PersonService {
    private List <Person> PrsSrcImp;{
    }

    public PersonServiceImp(List<Person> prsSrcImp) {
        PrsSrcImp = prsSrcImp;
    }

    @Override
    public String login() {
        try{
        System.out.println("Kiruu uchun emaildy jana parolunuzdu jazynyz!");
        System.out.println("Electronduk pochtanyzdy jazynyz");
        String email=new Scanner(System.in).nextLine();
        System.out.println("Parol jazynyz:");
        String pass=new Scanner(System.in).nextLine();
        for (Person person:PrsSrcImp) {
            if(person.getEmail().equals(email)&&person.getPassword().equals(pass)){
                return "Kosh keldiniz";
            }
            else{
                throw  new MyException("Electronduk pochta je parol tuura emes") ;
            }}
        }
        catch (MyException e){
            System.out.println(e.getMessage());
        }
        return "Electronduk pochta je parol tuura emes";
    }

    @Override
    public String resetPassword() {
        System.out.println("Parol ozgortuu uchun email jaz:");
        String email=new Scanner(System.in).nextLine();
        for (Person person:PrsSrcImp){
            if(person.getEmail().equals(email)){
                System.out.println("Parol jazynyz (Paroldun uzundugu 7 simvoldon  az bolbosun): ");
                String pass=new Scanner(System.in).nextLine();
                if(pass.length()>=7){
                    person.setPassword(pass);
                    System.out.println(person.toString());
                    return "Parol saktaldy";
                }
                else{
                    System.out.println("Paroldun uzundugu 7 simvoldon  az bolbosun");
                }
            }
            else{
                System.out.println("Siz jazyp jatkan pochta tabylgan jok");
            }
        }


        return "Paroldun uzundugu 7 simvoldon  az bolbosun";
    }
}
