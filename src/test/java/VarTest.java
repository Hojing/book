/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/11/7 16:30
 */
public class VarTest {
    public static void main(String[] args) {
        int i=1;
        int p;
        int n;
        p = ++i;
        n = i++;
        System.out.println("i="+i);
        System.out.println("p=++i="+p);
        System.out.println("n=i++="+n);
    }
}
