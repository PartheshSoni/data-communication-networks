import java.util.*;

class charStuff{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
        String flag="FLAG";
        String data=new String();
        System.out.println("Enter the data: ");
        data=sc.next();
        String dat="";
        dat+=flag;
        int c=0;
        for(int i=0; i<data.length(); i++){
            if(i<=data.length()-4&&data.charAt(i)=='F'&&data.charAt(i+1)=='L'&&data.charAt(i+2)=='A'&&data.charAt(i+3)=='G'){
                dat+="ESC";
                dat+=data.charAt(i);
            }
            else if(i<=data.length()-3&&data.charAt(i)=='E'&&data.charAt(i+1)=='S'&&data.charAt(i+2)=='C'){
                dat+="ESC";
                dat+=data.charAt(i);
            }
            else
                dat+=data.charAt(i);
        }
        dat+=flag;
        System.out.println("The sender output is: "+dat);	
        
        String out="";
        for(int i=4; i<dat.length()-4; i++){
            if(i<=dat.length()-4-6&&dat.charAt(i)=='E'&&dat.charAt(i+1)=='S'&&dat.charAt(i+2)=='C'&&dat.charAt(i+3)=='E'&&dat.charAt(i+4)=='S'&&dat.charAt(i+5)=='C'){
                out+="ESC";
                i+=6;
            }
            else if(i<=dat.length()-4-7&&dat.charAt(i)=='E'&&dat.charAt(i+1)=='S'&&dat.charAt(i+2)=='C'&&dat.charAt(i+3)=='F'&&dat.charAt(i+4)=='L'&&dat.charAt(i+5)=='A'&&dat.charAt(i+6)=='G'){
                out+="FLAG";
                i+=7;
            }
            else
                out+=dat.charAt(i);
        }
        
    System.out.println("The data extracted at reciever side: "+out);
        
        
	}
}