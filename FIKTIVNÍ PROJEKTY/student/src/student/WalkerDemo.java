
package student;

import myPackage.TeacherInterface;




public class WalkerDemo implements TeacherInterface
{

    @Override
    public int countWords(String text) 
    {
        System.out.println("\n\n###Method: WalkerDemo.countWords()");
        System.out.println("###vstupA: " +text);
        
        return -1;
    }
    
}
