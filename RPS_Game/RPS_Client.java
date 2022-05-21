import com.thinking.machines.nframework.client.*;
import java.util.*;
import java.io.*;
public class RPS_Client
{
private static javax.swing.Timer t=null;
public static void main(String gg[])
{
NFrameworkClient client=new NFrameworkClient();
System.out.println("Enter player Id:");
Scanner s=new Scanner(System.in); 
String player_no=s.nextLine();
int choice=0;
while(true)
{
System.out.println("********************");
System.out.println("1. ROCK");
System.out.println("2. PAPER");
System.out.println("3. SCISSOR");
System.out.println("Enter your choice");
Scanner sc=new Scanner(System.in);  
choice= sc.nextInt();  
if(choice!=1&&choice!=2&&choice!=3)
{
System.out.println("Invalid choice");
continue;
}
else break;
}
String  val=null;
if(choice==1)val="r";
else if(choice==2)val="p";
else if(choice==3)val="s";
try
{
while(true)
{
String output=(String)client.execute("/rockPaperScissor/output",val,player_no);
if(output==null)continue;
else 
{
System.out.println("*******************");
System.out.println(output);
break;
}
}
}catch(Throwable t)
{
System.out.println(t.getMessage());
}
}
}