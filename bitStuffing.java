import java.util.*;

class bitStuff{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String flag="011110";
		String data=new String();
		System.out.println("Enter the data: ");
		data=sc.next();
		String out="";
		out+=flag;
		int c=0;
		for(int i=0; i<data.length(); i++){
			if(data.charAt(i)=='1'){
				if(c==3){
					out+='0';
					c=1;
					out+='1';
				}
				else{
					out+='1';
					c++;
				}
				
			}
			else{
				out+='0';
				c=0;
	    	}
		}
		out+=flag;
		System.out.println("The output of sender: "+out);
		
		String inp="";
		for(int i=6; i<out.length()-6; i++){
			inp+=out.charAt(i);
		}
		
		String finalin="";
		c=0;
		for(int i=0; i<inp.length(); i++){
			if(inp.charAt(i)=='1'){
				c++;
				finalin+='1';
			}
			if(inp.charAt(i)=='0'){
				if(c==3){
					c=0;
					continue;
				}
				else{
					finalin+='0';
					c=0;
				}
					
			}
		}
		System.out.println("The data retrieved by reciever: "+finalin);
		
	}
}