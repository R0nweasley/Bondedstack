
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
        testProducer();
        
        
        
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

        // capacity ต้อง > 0
        boolean threwnNull = false;
        try {
             new BoundedStack(0);
        } catch (IllegalArgumentException e) {
            threwnNull= true;
        } check("capcity must > 0", threwnNull);

        // capacity ติดลบ 
        boolean threwNeg = false;
        try {
            new BoundedStack(-5);
        } catch (IllegalArgumentException e) {
            threwNeg = true;
        } check("capacity ติดลบ throw", threwNeg);

        // มีสมาชิกว่าง "" ต้อง throw
        boolean threwEmptyStr = false;
        try {
            new BoundedStack(Arrays.asList("A", ""), 5);
        } catch (IllegalArgumentException e) {
            threwEmptyStr = true;
        } check("nameBook มีสมาชิกเป็นสตริงว่าง ต้อง throw", threwEmptyStr);

        // มีสมาชิกเป็น null ต้อง throw
        boolean threwEle = false;
        try {
            new BoundedStack(Arrays.asList("A", null), 5);
        } catch (IllegalArgumentException e) {
            threwEle = true;
        } check("nameBook มีสมาชิกเป็น null ต้อง throw", threwEle);

        // มีสมาชิกซ้ำ ต้อง throw
        boolean threwDup = false;
        try {
            new BoundedStack(List.of("A", "A", "B"), 5);
        } catch (IllegalArgumentException e) {
            threwDup = true;
        } check("nameBook มีสมาชิกซ้ำ throw", threwDup);

        // nameBook.size() > capacity ต้อง throw
        boolean threwOverflow = false;
        try {
            new BoundedStack(List.of("A", "B", "C"), 2);
        } catch (IllegalArgumentException e) {
            threwOverflow = true;
        } check("nameBook ล้น capacity ที่กำหนด throw", threwOverflow);
     }



    private static void testPush() {
        // push string ว่าง ต้อง throw
        boolean thewNull = false;
        try {
            BoundedStack a = new BoundedStack(4);
            a.push("");
        } catch (Exception e) {
            thewNull = true;
        }  check("namebook is empty string? ", thewNull);

        // push null ต้อง throw
        boolean threwNull = false;
        try {
            new BoundedStack(3).push(null);
        } catch (IllegalArgumentException e) {
            threwNull = true;
        } check("namebook is null?", threwNull);

        // push ชื่อซ้ำ ต้อง throw
        boolean threwDup = false;
        try {
            BoundedStack b = new BoundedStack(List.of("A"), 3);
            b.push("A");
        } catch (IllegalArgumentException e) {
            threwDup = true;
        } check("push ชื่อซ้ำ ต้อง throw", threwDup);

        // push จนเต็มแล้ว push อีก ต้อง throw IllegalStateException
        boolean threwFull = false;
        try {
            BoundedStack full = new BoundedStack(List.of("A", "B"), 2);
            full.push("C");
        } catch (IllegalStateException e) {
            threwFull = true;
        } check("push ตอน stack เต็ม ต้อง throw", threwFull);
  

    }   
    

    private static void testPop() {
        // pop ใช้ไม่ได้ถ้า แสตกว่าง
        BoundedStack p = new BoundedStack(3);
        try {
            p.pop();
            check("POP can't use if stack null", false);
        } catch (Exception e) {
            check("POP can't use if stack null", true);
        }

       // pop แล้ว size ต้องลดลงตาม
        BoundedStack s2 = new BoundedStack(List.of("A", "B"), 3);
        s2.pop();
        check("pop แล้ว size ต้องลดลงเหลือ 1", s2.getSize() == 1);

        // pop จนหมด แล้ว isEmpty ต้องเป็น true
        BoundedStack s3 = new BoundedStack(List.of("A"), 1);
        s3.pop();
        check("pop จนหมดแล้ว isEmpty ต้อง true", s3.isEmpty() == true);

        // push สลับ pop หลายรอบ ต้องรักษาลำดับ LIFO ถูกต้อง
        BoundedStack s4 = new BoundedStack(3);
        s4.push("A");
        s4.push("B");
        check("pop กลาง sequence ต้องได้ B", s4.pop().equals("B"));
        s4.push("C");
        check("push ใหม่แล้ว pop ต้องได้ C", s4.pop().equals("C"));
        check("pop ต่อไปต้องได้ A", s4.pop().equals("A"));


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
    check("capacity = 1 (สร้างมาก็เต็มแล้ว) ต้อง isFull = true", f3.isFull() == true);

         BoundedStack f4 = new BoundedStack(List.of(), 3);
     check("stack ว่าง ต้อง isFull = false", f4.isFull() == false);

        // ===getSize===
        BoundedStack a = new BoundedStack(List.of("A","B","C"),3);
    check("size must = 3", a.getSize()==3);

        BoundedStack s2 = new BoundedStack(List.of(), 3);
    check("size must = 0 ตอน stack ว่าง", s2.getSize()==0);
    }



     private static void testProducer() {

        // copy พื้นฐาน: ขนาดข้อมูลต้องเท่าเดิม 
        BoundedStack original = new BoundedStack(List.of("A", "B", "C"), 3);
        BoundedStack copied = original.copy(5);
        check("copy: size ต้องเท่าของเดิม", copied.getSize() == original.getSize());

        // copy แล้วลำดับต้องเหมือนเดิม (peek ตัวบนสุดต้องตรงกัน) 
        check("copy: peek ต้องได้ตัวบนสุดเดิม",
                copied.peek().equals(original.peek()));

        // copy ด้วย newCapacity เท่ากับจำนวนหนังสือปัจจุบัน ต้องเต็มพอดี
        BoundedStack fullCopy = original.copy(3);
        check("copy: newCapacity เท่ากับ size เดิม ต้อง isFull = true",
                fullCopy.isFull() == true);

        // copy ด้วย newCapacity มากกว่าจำนวนหนังสือ  ต้องไม่เต็ม
        BoundedStack roomyCopy = original.copy(10);
        check("copy: newCapacity มากกว่า size เดิม ต้อง isFull = false",
                roomyCopy.isFull() == false);

        // copy จาก stack ว่าง 
        BoundedStack emptyOriginal = new BoundedStack(List.of(), 3);
        BoundedStack emptyCopy = emptyOriginal.copy(2);
        check("copy: จาก stack ว่าง ต้องได้ stack ว่าง", emptyCopy.isEmpty() == true);

        // newCapacity <= 0 ต้อง throw 
        boolean threwZero = false;
        try {
            original.copy(0);
        } catch (IllegalArgumentException e) {
            threwZero = true;
        } check("copy: newCapacity = 0 ต้อง throw", threwZero);

        boolean threwNegative = false;
        try {
            original.copy(-1);
        } catch (IllegalArgumentException e) {
            threwNegative = true;
        } check("copy: newCapacity ติดลบ ต้อง throw", threwNegative);

        // newCapacity น้อยกว่าจำนวนหนังสือปัจจุบัน ต้อง throw 
        boolean threwTooSmall = false;
        try {
            original.copy(2); // original มี 3 เล่ม ขอ capacity ใหม่แค่ 2
        } catch (IllegalArgumentException e) {
            threwTooSmall = true;
        } check("copy: newCapacity น้อยกว่าจำนวนหนังสือปัจจุบัน ต้อง throw", threwTooSmall);

        // copy ต้องแก้ตัวใหม่ ไม่กระทบตัวเดิม
        BoundedStack src = new BoundedStack(List.of("A", "B"), 5);
        BoundedStack dup = src.copy(5);
        dup.push("C");
        check("copy: แก้ copy แล้วต้นฉบับต้องไม่เปลี่ยน", src.getSize() == 2);

        src.push("Z");
        check("copy: แก้ต้นฉบับแล้ว copy ต้องไม่เปลี่ยน", dup.getSize() == 3); // dup มี A,B,C

    }



}


