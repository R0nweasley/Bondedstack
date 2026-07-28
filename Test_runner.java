import java.util.Arrays;
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
                    + " - re-run with: java -ea Test_runner\n");
        }

       
        System.out.println("=== BoundedStack Test Suite ===\n");
    
        testCreators();
        testPeek();
        testPush();
        // testPop();
        // testObservers();
        // testProducer();
        
        System.out.println("\n=== Summary ===");
        System.out.println("pass: " +pass);
        System.out.println("fail: " + fail);
        System.out.println("Total : " + (pass + fail));
        System.out.println(fail == 0 ? "ALL TESTSpass" : "SOME TESTS fail");

        if (fail > 0) {
            System.exit(1);


            
        }
    }



  

     private static void testCreators() {
        // ชั้นหนังสือว่างไม่มีหนังสือจริงมั้ย
        BoundedStack stack = new BoundedStack(10);
        check("Create New Stack must be Empty", stack.isEmpty() );
        check("stack size = 0", stack.getSize() == 0);

        // capacity > 0
        boolean threwnNull = false;
        try {
             new BoundedStack(0);
        } catch (IllegalArgumentException e) {
            threwnNull= true;
        } check("capcity > 0", threwnNull);
        
     }


    private static void testPeek() {
        check("Show last book",
                new BoundedStack(List.of("A", "B", "C"), 3).peek().equals("C"));
    }


    private static void testPush() {
        boolean thewNull = false;
        try {
            BoundedStack a = new BoundedStack(4);
            a.push("");
        } catch (Exception e) {
            thewNull = true;
        }  check("namebook is empty string ", thewNull);


        BoundedStack a = new BoundedStack(List.of("A","B","C"),3);
        check("size = 3", a.getSize()==3);
        check("", thewNull);



    }   
    





    private static void testPop() {
        
    }

    private static void testObservers() {
        throw new UnsupportedOperationException("Unimplemented method 'testObservers'");
    }



     private static void testProducer() {
        throw new UnsupportedOperationException("Unimplemented method 'testProducer'");
    }




}


