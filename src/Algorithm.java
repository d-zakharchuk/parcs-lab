import parcs.*;
import java.math.BigInteger;

public class Algorithm implements AM {

public static BigInteger sqrt(BigInteger x) {
    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
    BigInteger div2 = div;
    // Loop until we hit the same value twice in a row, or wind
    // up alternating.
    for(;;) {
        BigInteger y = div.add(x.divide(div)).shiftRight(1);
        if (y.equals(div) || y.equals(div2))
            return y;
        div2 = div;
        div = y;
    }
} 
	
	
	public BigInteger FermatFactor(BigInteger N)
    {
        BigInteger a = sqrt(N);
        BigInteger b2 = a.multiply(a).subtract(N);
        while (!isSquare(b2))
        {
            a = a.add(ONE);
	    b2 = a.multiply(a).subtract(N);
        }
        BigInteger res1 = a.subtract(sqrt(b2));
        return res1;
        //display(r1, r2);
    }
    public boolean isSquare(BigInteger N)
    {
        BigInteger sqr = sqrt(N);
	if (sqr.multiply(sqr).equals(N) || (sqr.add(ONE)).multiply(sqr.add(ONE)).equals(N))
            return true;
        return false;
    }
	
    public void run(AMInfo info) {
    BigInteger N = (BigInteger) info.parent.readObject();
    BigInteger res1 = new BigInteger("0");
    BigInteger res2 = new BigInteger("0");
    res1 = FermatFactor(N);
    res2 = N.divide(res1);
    point p = info.createPoint();
    channel c = p.createChannel();
    p.execute("Algorithm");
    c.write(N);
    info.parent.write(res1);
    info.parent.write(res2);
    }
}
