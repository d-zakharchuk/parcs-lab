import java.util.*;
import java.io.*;
import java.math.BigInteger;
import parcs.*;

public class Fermat implements AM {

public static void main(String[] args) {
        task curtask = new task();
        curtask.addJarFile("Fermat.jar");
        (new Fermat()).run(new AMInfo(curtask, (channel)null));
        curtask.end();
    }

    public void run(AMInfo info) {
        BigInteger num1 = new BigInteger("0");
	BigInteger num2 = new BigInteger("0");
	BigInteger n;
	try
	{
		Scanner sc = new Scanner(new File(info.curtask.findFile("Fermat.data")));
		n = sc.nextBigInteger();
	}
		catch (IOException e) {e.printStackTrace(); return;}
        System.out.println("Input string: " + n);
		point p = info.createPoint();
        channel c = p.createChannel();
        p.execute("Algorithm");
        c.write(n);
	System.out.println("Waiting for result...");
	num1 = (BigInteger) c.readObject();
	num2 = (BigInteger) c.readObject();
	System.out.println("Result found.");
	    System.out.println(num1);
	    System.out.println(num2);
	try {
          PrintWriter out = new PrintWriter(new FileWriter(info.curtask.addPath("Fermat.res")));
          out.println(num1);
	  out.println(num2);
          out.close();
      } catch (IOException e) {e.printStackTrace(); return;}
    }
}
