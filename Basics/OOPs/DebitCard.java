package Basics.OOPs;

public class DebitCard extends  Card{

    DebitCard( String cardNo,String name){
        super(name,cardNo);
    }

    public void pay(){
        System.out.println("Making Payment via DebitCard");
    }
}
