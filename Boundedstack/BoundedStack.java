import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  ภาคิน ศรีเหรา 6821601348
 *  วรชิต วสุธนพิริยะ 6821601402
 *  
 *  BoundedStack is ตัวเก็บชุดข้อมูลแบบแนวตั้ง
 *  
 *  ex. [   "C"
 *          "B"
 *          "A"   ]
 * 
 *  BounedStack ตัวอย่างการใช้งาน
 *  push()   เพิ่มข้อมูลไว้บนสุด
 *  pop()    ลบตัวบนสุด
 *  peek()   อ่านข้อมูลตัวบนสุด
 *  isEmty() เช็กว่าว่างมั้ย
 *  
 *  
 * 
 * Creators / Producers / Observers / Mutators
 * Representation Invariant (RI) และตรวจสอบด้วย checkRep()
 */

public class BoundedStack {
        
        public static final int Bound = 10  ;
        
         // ===== representation =====
        private final List<String> Book;   
        /**
         * Abstraction Function:
         * AF(info) = ลำดับข้อมูล เช่น [info1 , info2 , info3] โดยลำดับมีความหมาย — ข้อมูลต้องเรียงโชว์ตามลำดับ
         * 
         * 
         * 
         * Representation Invariant(RI):
         * 1 ห้าม Null
         * 2 ไม่เป็นสตริงว่าง ""
         * 3 Book ไม่ซ้ำกัน
         * 4 ใส่ข้อมูลไม่เกิน Bound (ขอบเขต)
         * 
      

         // ===== Checkrep =====
        /*
           แปลง  RI --> assert    
         */
        public void checkRep(){
            assert Book != null : "Book's not null";
            assert Book.size() <= Bound;
            Set<String> seen = new HashSet<>();
            for (String s : Book) {
            assert s!=null ;
            assert !(s=="") ;
            assert seen.add(s) : "Dupplicate song" +s;
        }
        
    }


        // ===== Creator =====
        /*
            สร้างที่เก็บหนังสือ boundedStack
        */

        public BoundedStack(){
            this.Book = new ArrayList<>();
            checkRep();
        }

         // ===== Creator 2 =====
        /*
            รับชื่อหนังสือมาสร้างที่เก็บ
         */

        public BoundedStack(List<String> name_book){
            if (name_book == null||name_book.size()>Bound ) throw new IllegalArgumentException();
            Set<String> seen = new HashSet<>();
            for (String s : name_book) {
            if(s==null||s=="") throw new IllegalArgumentException();
            if(!seen.add(s)) throw new IllegalArgumentException();
        }

        this.Book = new ArrayList<>(name_book);  // แก้บรรทัดนี้
        checkRep();
        }
  

        //  ===== Mutators =====
        public void push(){
            
        }
        public void pop(){
            
        }


        //  =====Observers =====
        public void peek(){
            
        }
        public void isEmpty(){
            
        }
        public void isFull(){
            
        }

        //  ===== Producer =====


}
