import parcs.*;
import java.math.BigInteger;

public class Algorithm implements AM {
	
    public void run(AMInfo info) {
    BigInteger res1 = new BigInteger("0");
    BigInteger res2 = new BigInteger("0");
    BigInteger N = (BigInteger) info.parent.readObject();
    point p = info.createPoint();
    channel c = p.createChannel();
    p.execute("Algorithm");
    c.write(N);
    info.parent.write(res1);
    info.parent.write(res2);
    }
}
