/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/10/18 13:58
 */
public class StringTest {
    public static void main(String[] args) {
        /**
         * System.identityHashCode(Object) 查看内存地址
         */
        String x = "string";
        String y = "string";
        String z = new String("string");
        System.out.println("---------x----------");
        System.out.println(x.hashCode()); //-891985903
        System.out.println(System.identityHashCode(x)); //1735600054
        System.out.println("---------y----------");
        System.out.println(y.hashCode()); //-891985903
        System.out.println(System.identityHashCode(y)); //1735600054
        System.out.println("---------z----------");
        System.out.println(z);
        System.out.println(z.hashCode()); //-891985903
        System.out.println(System.identityHashCode(z)); //21685669

        System.out.println("--------------------");
        System.out.println(x==y); //true
        System.out.println(y==z); //false
        System.out.println(x.equals(y)); //true
        System.out.println(x.equals(z)); //true

        char a = '2';
        char b = '2';
        char c = '3';

        System.out.println("--------a----------");
        System.out.println(System.identityHashCode(a));

        System.out.println("--------b----------");
        System.out.println(System.identityHashCode(b));

        System.out.println("--------c----------");
        System.out.println(System.identityHashCode(c));

        System.out.println("a == b : "+(a==b));
        System.out.println("a == c : "+(a==c));


        Object o1 = new Object();
        Object o2 = o1;
        System.out.println("--------o1----------");
        System.out.println(o1.hashCode());
        System.out.println(System.identityHashCode(o1));
        System.out.println("--------o2----------");
        System.out.println(o2.hashCode());
        System.out.println(System.identityHashCode(o2));

        System.out.println(o1.hashCode() == o2.hashCode());
        System.out.println(o1.equals(o2));

    }
}
