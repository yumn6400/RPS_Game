import com.thinking.machines.nframework.server.*;
import com.thinking.machines.nframework.server.annotations.*;
import java.lang.annotation.*;
import java.util.*;
@Path("/rockPaperScissor")
public class RPS_Server
{
private static String player1_step;
private static String player2_step;
private static int player1_id;
private static int player2_id;
@Path("/output")
public String getResult(String value,String player_id)throws RPSException
{
int player_number=Integer.parseInt(player_id);
if(player1_step==null&&player1_id==0)
{
player1_step=value;
player1_id=player_number;
}
else if(player2_step==null&&player1_id!=player_number&&player2_id==0)
{
player2_step=value;
player2_id=player_number;
}
if(player1_step==null||player2_step==null)
{
return null;
}
String rps[]={"r","p","s"};
String player1_move=player1_step;
String player2_move=player2_step;
if(player_number==player2_id)
{
String dummy;
dummy=player2_move;
player2_move=player1_move;
player1_move=dummy;
}
if(player1_move.equals(player2_move))
{
return "The game was a trial";
}
else if(player1_move.equals("r"))
{
if(player2_move.equals("p"))return "You lose!";
if(player2_move.equals("s"))return "You Win!";
}
else if(player1_move.equals("p"))
{
if(player2_move.equals("s"))return "You lose!";
if(player2_move.equals("r"))return "You Win!";
}
else if(player1_move.equals("s"))
{
if(player2_move.equals("r"))return "You lose!";
if(player2_move.equals("p"))return "You Win!";
} 
return null;
}
public static void main(String gg[])
{
NFrameworkServer server=new NFrameworkServer();
server.registerClass(RPS_Server.class);
server.start();
}
}