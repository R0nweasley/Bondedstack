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
 *  BounededStack ตัวอย่างการใช้งาน
 *  push()   เพิ่มข้อมูลไว้บนสุด
 *  pop()    ลบตัวบนสุด
 *  peek()   อ่านข้อมูลตัวบนสุด
 *  isEmpty() เช็กว่าว่างมั้ย
 *  isFull()  เช็กว่าเต็มมั้ย
 *  getSize() คืนจำนวนหนังสือปัจจุบัน
 *  copy()    สร้างสแตกใหม่จากเนื้อหาปัจจุบัน
 *  
 * Creators / Producers / Observers / Mutators
 * Representation Invariant (RI) และตรวจสอบด้วย checkRep()
 */

public class BoundedStack {
        
        
         // ===== representation =====
        private final List<String> book;  
        private final int capacity ;

        /**
         * Abstraction Function:
         * AF(book, capacity) = สแตกความจุ capacity เล่ม โดย 
         * book.get(0) คือหนังสือล่างสุด (เข้าก่อน)
         * book.get(book.size()-1) คือหนังสือบนสุด (เข้าล่าสุด พร้อมถูก pop/peek)
        
         * 
         * Representation Invariant(RI):
         * 1 ห้าม Null
         * 2 ไม่เป็นสตริงว่าง ""
         * 3 book ไม่ซ้ำกัน
         * 4 จำนวนข้อมูลในbook ต้องไม่เกิน capacity
         * 5 capacity ต้องมากกว่า 0
        */

         // ===== Checkrep =====
        /*
           แปลง  RI --> assert    
         */
        private void checkRep(){
            assert book != null : "book's not null";
            assert capacity > 0;
            assert book.size() <= capacity;
            Set<String> seen = new HashSet<>();
            for (String s : book) {
            assert s!=null ;
            assert !(s.isEmpty());
            assert seen.add(s);
        }
        
    }


        // ===== Creator =====
        /*
            สร้างแสตกว่างเปล่า
        */
       public BoundedStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        this.book = new ArrayList<>();
        checkRep();
    }

        // ===== Creator 2 =====
        /*
            สร้างแสตกจาก list ที่มีอยู่แล้ว
         */
         public BoundedStack(List<String> nameBook, int capacity) {
         if (capacity <= 0) throw new IllegalArgumentException(); // เหตุผลเดียวกับ constructor แรก
         if (nameBook == null) throw new IllegalArgumentException();
         if (nameBook.size() > capacity) throw new IllegalArgumentException(); // ล้นความจุที่กำหนด

         Set<String> seen = new HashSet<>();
         for (String s : nameBook) {
         if (s == null || s.isEmpty()) throw new IllegalArgumentException();
         if (!seen.add(s)) throw new IllegalArgumentException();
         }

         this.capacity = capacity;
         this.book = new ArrayList<>(nameBook);
         checkRep();
     }

  

        //  ===== Mutators เพิ่มสมาชิก=====
        /*       
        @param element สมาชิกที่จะเพิ่ม
        @throws IllegalArgumentException ถ้า element เป็น null 
        @throws IllegalArgumentException ถ้า element ซ้ำกับที่มีอยู่แล้ว
        @throws IllegalStateException ถ้า stack เต็มแล้ว
         */
        public void push(String nameBook){
            if (nameBook == null || nameBook.equals("")) throw new IllegalArgumentException(); // != null 
            if (book.contains(nameBook))  throw new IllegalArgumentException(); //ไม่ซ้ำ
            if (book.size()==capacity) throw new IllegalStateException(); // เกินขอบเขต
           
            book.add(nameBook);
            checkRep();
        }


        //  ===== Mutators 2 ลบสมาชิกตัวบนสุด =====
        /*
        @throws IllegalStateException ถ้า stack ไม่มีอะไรให้ลบ
         */
        public String pop(){
            if(book.isEmpty()) throw new IllegalStateException();
            String result = book.get(book.size()-1);
            book.remove(book.size()-1); // ลบหนังสือตัวบนสุด ต้อง -1 เพราะอาเรย์นับเป็น 0 1 2 
            
            checkRep();
            return result;
        }


        //  =====Observers =====
        public String peek(){
            if(book.isEmpty()) throw new IllegalStateException();
            return book.get(book.size()-1);
        }
        /*
        ตรวจสอบว่าแสตกว่าว่างหรือไม่
        @return true ถ้าแสตกว่าง
        */
        public Boolean isEmpty(){
            return book.isEmpty();
        }
        /*
        ตรวจสอบว่าแสตกว่าเต็มหรือไม่
        @return true ถ้าแสตกเต็ม
        */
        public Boolean isFull(){
            return book.size() == capacity;
        }
        /*
        คืนจำนวนหนังสือที่อยู่ใน stack ขณะนี้
        @return จำนวนหนังสือ (0 ถึง capacity)
        */
        public int getSize(){
            return book.size();
        }
       


        //  ===== Producer =====
        /*
            สร้างสแตกใหม่จากเนื้อหาปัจจุบัน พร้อมกำหนดความจุใหม่
            @param newCapacity ความจุของสแตกใหม่ ต้อง > 0 และ >= จำนวนหนังสือปัจจุบัน
            @throws IllegalArgumentException ถ้า newCapacity <= 0
            @throws IllegalArgumentException ถ้า newCapacity น้อยกว่าจำนวนหนังสือที่มีอยู่
        */
       
        // public BoundedStack copy(int newCapacity) {
        //     if (newCapacity <= 0) throw new IllegalArgumentException();
        //     return new BoundedStack(this.book, newCapacity);
        // }

        
}
