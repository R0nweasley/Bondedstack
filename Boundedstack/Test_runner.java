import java.util.List;

public class Test_runner {

    private static int pass = 0;
    private static int fail = 0;



     private static void check(String name, boolean condition) {
        if (condition) {
            pass++;
            System.out.println("[PASS] " + name);
        } else {
            fail++;
            System.out.println("[FAIL] " + name);
        }
    }




     public static void main(String[] args) {
        boolean assertsOn = false;
        assert assertsOn = true;
        if (!assertsOn) {
            System.out.println("WARNING: assertions disabled"
                    + " - re-run with: java -ea PlaylistTest\n");
        }



        // TEST เอง
        BoundedStack a = new BoundedStack();
        a.push("Harry");
        System.out.println(a.getsize());
        a.push("ASD");
        a.push("null");
         System.out.println(a.getsize());
        a.pop();
        System.out.println(a.getsize());
    }

}


