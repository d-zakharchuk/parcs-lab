import parcs.*;

public class Algorithm implements AM {
	static String swap(String str, int i, int j){
        char ch;
        char[] array = str.toCharArray();
        ch = array[i];
        array[i] = array[j];
        array[j] = ch;
        return String.valueOf(array);
    }
    static void permute(String str,int low,int high, String result){
        if(low == high)
			result += str + "\n";
            //System.out.println(str);
 
        int i;
        for(i = low; i<=high; i++){
            str = swap(str,low,i);
            permute(str, low+1,high, result);
            str = swap(str,low,i);
        }
    }
	
    public void run(AMInfo info) {
    String result;
    String N = (String) info.parent.readObject();
    permute(N, 0, N.length()-1, result);
    point p = info.createPoint();
    channel c = p.createChannel();
    p.execute("Algorithm");
    c.write(N);
    info.parent.write(result);
    }
}
