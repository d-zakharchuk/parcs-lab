import parcs.*;
import java.math.BigInteger;

public class Algorithm implements AM {
	private final static BigInteger ONE  = new BigInteger("1");

    public static BigInteger sqrt(BigInteger x)
            throws IllegalArgumentException {
        if (x.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Negative argument.");
        }
        // square roots of 0 and 1 are trivial and
        // y == 0 will cause a divide-by-zero exception
        if (x == BigInteger.ZERO || x == BigInteger.ONE) {
            return x;
        } // end if
        BigInteger two = BigInteger.valueOf(2L);
        BigInteger y;
        // starting with y = x / 2 avoids magnitude issues with x squared
        for (y = x.divide(two);
             y.compareTo(x.divide(y)) > 0;
             y = ((x.divide(y)).add(y)).divide(two));
        if (x.compareTo(y.multiply(y)) == 0) {
            return y;
        } else {
            return y.add(BigInteger.ONE);
        }
    } // end bigIntSqRootCeil

	
	
	public BigInteger FermatFactor(BigInteger N)
    {
        BigInteger a = sqrt(N);
        BigInteger b2 = a.multiply(a).subtract(N);
        while (!isSquare(b2))
        {
            a = a.add(ONE);
	    b2 = a.multiply(a).subtract(N);
        }
        BigInteger r1 = a.subtract(sqrt(b2));
        return r1;
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
    BigInteger res1 = FermatFactor(N);
    BigInteger res2 = N.divide(res1);
    point p = info.createPoint();
    channel c = p.createChannel();
    p.execute("Algorithm");
    c.write(N);
    info.parent.write(res1);
    info.parent.write(res2);
    }
}
