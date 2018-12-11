import java.util.*;
import java.math.*;

/*class stopAndWait{
	static int ack=-1;
	static 	int sns=-1;
	static	int snr=0;
	static	int timer=0;
	static	int ts=14;
	static int fine=1;
	static void Sender(){
			Scanner sc=new Scanner(System.in);
			String data=getData();
			String data1=prepareFrame(data);
			String copy=copyfile(data1);
			System.out.println("Enter the time elapsed: ");
			timer=sc.nextInt();
			
			try{
			Thread.sleep(500);
			}
			catch(Exception e){
				System.out.println();
			}

			sendToRec(data1);

			if(timer>ts){
				System.out.println("Timer expired.");
				fine=0;
			}
			else if(ack==1){

				System.out.println("Sender:	The data sent successfully!! Acknowledgement recieved!");
				System.out.println();
			}
			else
				System.out.println("Sender: There seems to be an error in the sent message.");
			sns=(sns+1)%2;
			ack=-1;
		}

		static void Reciever(String input){
			Scanner sc=new Scanner(System.in);
			snr=(snr+1)%2;
			if(snr==sns){
				System.out.println("Reciever: Discarding the frame...Duplicate frame recieved.");
				ack=-1;
			}
			else
			{	
				
				System.out.println("Received codeword: "+input);
				System.out.print("The data recieved(extracted) at the Reciever side: ");
				String data=extract(input);
				System.out.println(data);
				System.out.print("Do you want to change Acknowledgement?(1/0): ");
				int acc=sc.nextInt();
				if(acc!=0)
					ack=0;
				else
				ack=1;	
			}
		}

		static String getData(){
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter the data to be sent: ");
			String data=sc.next();
			return data;
		}

		static String extract(String input){
			return input.substring(4, input.length()-4);
		}

		static String prepareFrame(String inp){
			String left="1011";
			String right="0110";

			String data=left+inp+right;
			return data;
		}

		static String copyfile(String copy)
		{
			return copy;
		}

		static void sendToRec(String code){
			Reciever(code);	
		}

	public static void main(String[] args) {

	
		while(true){
			ack=-1;
			sns=-1;
			snr=-1;
			timer=0;
			ts=14;
			Sender();
		}
	}
}*/

import java.util.*;
import java.math.*;

class Comm{
	int tle=15;
	int ackch[];
	int winsize=0;
	class Sender{
		
		int m;
		String wins[];
		int ss[];
		int timers[];
		Sender(int mi){
			m=mi;
			wins=new String[Math.pow(2, mi)-1];
			ss=new int[Math.pow(2, mi)-1];
			winsize=Math.pow(2, mi)-1;
			ackch=new int[winsize];
			Arrays.fill(ackch, -1);
			timers=new int[winsize];
		}

		void run(){
			Scanner sc=new Scanner(System.in);
			for(int i=0; i<winsize; i++){
				System.out.println("Enter frame "+i+1);
				String temp=sc.next();
				wins[i]=temp;
				System.out.println("Enter time elapsed: ");
				ss[i]=sc.nextInt();
				try{
					Thread.sleep(1000);
				}
				catch(Exception e){
					System.out.println();
				}
				int ack=rec.call(temp);
				int dec;

				if(ss[i]>tle)
				{
					
				}
				System.out.println("Lose ack?(1/0): ");
				if(dec==1){
					ackch[i]=-1;
				}
				else
					ackch[i]=ack;

			}
		}
	}
	
	class Reciever{
		int m;
		String winr[];
		int rs[];
		Reciever(int mi){
			m=mi;
			winr=new String[winsize];
			rs=new int[winsize];
		}
		void call(String inp){
			Scanner sc=new Scanner(System.in);
			System.out.println("Reciever: The data obtained-> "+inp);
			System.out.println("Give Acknowledgement?(1/0): ");
			int dec=sc.nextInt();
			return dec;
		}

	}

}


class goBackNArq{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m;
		System.out.print("Enter the value of m: ");
		m=sc.nextInt();

		Comm.Sender send=new Sender(m);
		Comm.Reciever rec=new Reciever(m);
		send.run();
	}
}