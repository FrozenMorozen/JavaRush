package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {

    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;

   /* static {
        intVar = 2;
        doubleVar = 1.2;
        DoubleVar = 2.3;
        booleanVar = true;
        ObjectVar = null;
        ExceptionVar = new Exception();
        StringVar = "string";
    }*/

   public void main(){
       System.out.println(intVar);
       System.out.println(doubleVar);
       System.out.println(DoubleVar);
       System.out.println(booleanVar);
       System.out.println(ObjectVar);
       System.out.println(ExceptionVar);
       System.out.println(StringVar);
   }

    public static void main(String[] args) {
       Solution solution = new Solution();
       solution.main();
    }
}
