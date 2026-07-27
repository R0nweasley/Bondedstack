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
        System.out.println(a.peek());
        a.push("lookkaree");
        System.out.println(a.peek());
        System.out.println(a.isEmpty());

        System.out.println("=== Playlist Test Suite ===\n");

        testCreators();
        testAdd();
        testRemove();
        testObservers();
        testProducer();
        testExposure();

        System.out.println("\n=== Summary ===");
        System.out.println("pass: " +pass);
        System.out.println("fail: " + fail);
        System.out.println("Total : " + (pass + fail));
        System.out.println(fail == 0 ? "ALL TESTSpass" : "SOME TESTS fail");

        if (fail > 0) {
            System.exit(1);
        }
    }

    private static void testCreators(){
        
    }
    private static void testAdd(){

    }
    private static void testRemove(){

    }
    private static void testObservers(){

    }
    private static void testProducer(){

    }
    private static void testExposure(){

    }

    
}


