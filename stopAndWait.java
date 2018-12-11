import java.util.*;
import java.math.*;

class stopAndWait{
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
				System.out.println("Reciever:Discarding the frame...Duplicate frame recieved.");
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
}
