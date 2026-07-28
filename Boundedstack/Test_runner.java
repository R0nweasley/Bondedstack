import java.lang.classfile.Signature.TypeArg.Bounded;
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
        testPush();
        testPop();
        testObservers();
        // testProducer();
        
        
        
        System.out.println("\n=== Summary ===");
        System.out.println("pass: " +pass);
        System.out.println("fail: " + fail);
        System.out.println("Total : " + (pass + fail));
        System.out.println(fail == 0 ? "ALL TESTS pass" : "SOME TESTS fail");

        if (fail > 0) {
            System.exit(1);
        }
    }



  

     private static void testCreators() {
        // ชั้นหนังสือว่างไม่มีหนังสือจริงมั้ย
        BoundedStack stack = new BoundedStack(10);
        check("Create New Stack must be Empty", stack.isEmpty() );
        check("stack size must = 0", stack.getSize() == 0);

        // capacity > 0
        boolean threwnNull = false;
        try {
             new BoundedStack(0);
        } catch (IllegalArgumentException e) {
            threwnNull= true;
        } check("capcity must > 0", threwnNull);
        
     }



    private static void testPush() {
        boolean thewNull = false;
        try {
            BoundedStack a = new BoundedStack(4);
            a.push("");
        } catch (Exception e) {
            thewNull = true;
        }  check("namebook is empty string? ", thewNull);


        BoundedStack a = new BoundedStack(List.of("A","B","C"),3);
        check("size must = 3", a.getSize()==3);
  

    }   
    

    private static void testPop() {
       BoundedStack p = new BoundedStack(3);
       try {
        p.pop();
        check("POP can't use if stack null", false);
       } catch (Exception e) {
        check("POP can't use if stack null", true);
       }
    }

    private static void testObservers() {
        // ===peek===
          check("Show last book",
         new BoundedStack(List.of("A", "B", "C"), 3).peek().equals("C")); // แสดงตัวสุดท้าย

        BoundedStack p = new BoundedStack(1);
        try {
            p.peek();
            check("Peek can't use if stack null", false);
            } catch (Exception e) {
            check("Peek can't use if stack null", true);
        }

        // ===isEmpty===
        BoundedStack b1 = new BoundedStack(List.of(), 3);
    check("stack ว่าง ต้อง isEmpty = true", b1.isEmpty() == true);

    BoundedStack b2 = new BoundedStack(List.of("A"), 3);
    check("stack มี 1 ตัว ต้อง isEmpty = false", b2.isEmpty() == false);

    BoundedStack b3 = new BoundedStack(List.of("A","B","C"), 3);        
    check("stack เต็ม ต้อง isEmpty = false", b3.isEmpty() == false);


        // ===isFull===
        BoundedStack f1 = new BoundedStack(List.of("A","B","C"), 3);
    check("stack เต็มพอดี (size == capacity) ต้อง isFull = true", f1.isFull() == true);

        BoundedStack f2 = new BoundedStack(List.of("A","B"), 3);
    check("stack ยังไม่เต็ม ต้อง isFull = false", f2.isFull() == false);

        BoundedStack f3 = new BoundedStack(List.of("A"), 1);
    check("capacity = 0 (สร้างมาก็เต็มแล้ว) ต้อง isFull = true", f3.isFull() == true);

         BoundedStack f4 = new BoundedStack(List.of(), 3);
     check("stack ว่าง ต้อง isFull = false", f4.isFull() == false);

        // ===getSize===
        BoundedStack a = new BoundedStack(List.of("A","B","C"),3);
    check("size must = 3", a.getSize()==3);

        BoundedStack s2 = new BoundedStack(List.of(), 3);
    check("size must = 0 ตอน stack ว่าง", s2.getSize()==0);
    }



     private static void testProducer() {
        throw new UnsupportedOperationException("Unimplemented method 'testProducer'");
    }




}


