
package ucitel;

//import z projektu, ktery jsem pribalil do Libraries
import annotations.InjectInstanceOfClass;
import codeHandlers.ZipHandler;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import myPackage.TeacherInterface;
import testmanager.TestProvider;
import static testmanager.ObjectExplorer.type.*;
import testmanager.ObjectExplorer;



public class Ucitel 
{
    
    @InjectInstanceOfClass(classNameRegex = ".+Runner$")
    public void testImplement(TeacherInterface object)
    {
        String vstup = "Ahoj jak se mas?";
        int expResult;
        int result;
        String className = object.getClass().getSimpleName();
        
        expResult = 4;
        result = (int)ObjectExplorer.invoke(object, "countWords", vstup);
        TestProvider.testEquals(expResult, result, "messageIfFalse");

    }
    
    @InjectInstanceOfClass(classNameRegex = ".+RunnerDemo$")
    public void testDeleniNulou(TeacherInterface object)
    {
        int vstup1 = 4;
        String vstup2 = "0";
        double expResult;
        double result;
        String className = object.getClass().getSimpleName();
        
        expResult = 4;
        //result = object.countWords(vstup);
        result = (double)ObjectExplorer.invoke(object, "deleni", vstup1, vstup2);
        
        //int deleniNulou = 4 / 0;
        TestProvider.testEquals(expResult, result, "expResult: " +expResult +", actual result: " +result);

    }
    
    @InjectInstanceOfClass(classNameRegex = ".+RunnerDemo$")
    public void testmimoIndex(TeacherInterface object)
    {
        String vstup = "Ahoj jak se mas?";
        int expResult;
        int result;
        String className = object.getClass().getSimpleName();
        
        expResult = 0;
        result = (int)ObjectExplorer.invoke(object, "countWords", vstup);
        
        List<String> list = null;
        int delka = list.size();
        
        TestProvider.testEquals(expResult, result, "messageIfFalse");

    }
    
    @InjectInstanceOfClass(classNameRegex = ".+RunnerDemo$")
    public void testCalendar(TeacherInterface object)
    {
        Calendar cal = Calendar.getInstance();
        System.out.println("testCalendar: " +cal.getTime());
        cal.set(2000, 10, 25);
        
        ObjectExplorer.invoke(object, "datum", cal);
    }
    
    @InjectInstanceOfClass(classNameRegex = ".+RunnerDemo$")
    public void testInfiniteLoop(TeacherInterface object)
    {

        ObjectExplorer.invoke(object, "infiniteLoop", null);
    }
    
    @InjectInstanceOfClass(classNameRegex = ".+RunnerDemo$")
    public void testWritePermissions(TeacherInterface object)
    {
        ObjectExplorer.invoke(object, "writeToFile", null);
    }

//    @InjectInstanceOfClass(classNameRegex = ".+RunnerDemo$")
//    void testMethod (Object object)
//    {
//        int vstupA = 5; 
//        String vstupB = "0.5";     
//        double expResult = vstupA * Double.parseDouble(vstupB) +1;
//        Throwable result = ObjectExplorer.invokeMethodException(object, "nasobeni", vstupA, vstupB); 
//        double delta = 0.1;
//        
//        boolean check = ObjectExplorer.typesEqual(Exception.class, result.getCause().getClass());
//        TestProvider.isTrue(check, "Studentova výjimka není datového typu Exception");
//    }
//
//    @InjectInstanceOfClass(classNameRegex = ".+RunnerDemo$")
//    void testStaticMethod ()
//    { 
//        int vstupA = 5;
//        String vstupB = "4";  
//        double expResult = vstupA / Double.parseDouble(vstupB);
//        double result = (double)ObjectExplorer.invokeStatic("deleni", vstupA, vstupB); 
//        double delta = 0.1;
//        
//        TestProvider.testEquals(expResult, result, delta, "messageIfFalse");
//        
//        System.out.println("###testStaticMethod : OK");
//    }
//    
//    @InjectInstanceOfClass(classNameRegex = ".+RunnerDemo$")
//    void testExists(Object object)
//    {
//        String methodName = "countWords";
//        boolean methodExists = ObjectExplorer.methodExists(object, methodName);
//        
//        String fieldName = "privateField";
//        boolean fieldExists = ObjectExplorer.fieldExists(object, fieldName);
//        
//        String parentName = "TeacherInterface";
//        boolean isSuccessorOf = ObjectExplorer.isSuccessorOf(object.getClass(), TeacherInterface.class);
//        
//        String className = "RunnerDemo";
//        boolean isClassPublic = ObjectExplorer.isPublic(object, className, CLASS);
//        boolean isFieldPrivate = ObjectExplorer.isPrivate(object, fieldName, FIELD);
//        boolean isMethodStatic = ObjectExplorer.isStatic(object, methodName, METHOD);
//
//        System.out.println("TOHLE SE JESTE OBJEVI !!!");
//        TestProvider.fail("Učitel použil metodu fail !!");
//        System.out.println("TOHLE SE NESMI OBJEVIT !!!");
//        System.out.println("***methodExists: " +methodExists);
//        System.out.println("***fieldExists: " +fieldExists);
//        System.out.println("***isSuccessorOf: " +isSuccessorOf);
//        System.out.println("***isClassPublic: " +isClassPublic);
//        System.out.println("***isFieldprivate: " +isFieldPrivate);
//        System.out.println("***isMethodStatic: " +isMethodStatic);
//    }
//    
//    //pouze na demonstraci ruznych testu. 
//    //Metody bez anotace se nespusti. 
//    //Pro zprovozneni staci pridat: 
//    @InjectInstanceOfClass()
//    void testShouldntBeVisible()
//    { 
//        int vstupA = 5;
//        String vstupB = "4";  
//        double expResult = vstupA / Double.parseDouble(vstupB);
//        double result = (double)ObjectExplorer.invokeStatic("deleni", vstupA, vstupB); 
//        double delta = 0.1;
//        
//        TestProvider.testEquals(expResult, result, delta, "messageIfFalse");
//        
//        System.out.println("###testStaticMethod : OK");
//        System.out.println("###testShouldntBeVisible : OK");
////        System.out.println("------###testAllTests###------");
////        int index = 1;
////        
////        System.out.println(index++ +". test");
////        long longExp = 5;
////        long longReal = 5;  
////        TestProvider.testEquals(longExp, longReal, "messageIfFalse");
////        
////        System.out.println(index++ +". test");
////        double doubleExp = 5.22;
////        double doubleReal = 5.5;
////        double delta = 0.01;
////        TestProvider.testEquals(doubleExp, doubleReal, delta, "messageIfFalse");
////        
////        System.out.println(index++ +". test");
////        String StringExp = "String";
////        String StringReal = "String";  
////        TestProvider.testEquals(StringExp, StringReal, "messageIfFalse");
////        
////        System.out.println(index++ +". test");
////        long longExpN = 5;
////        long longRealN = 6;  
////        TestProvider.testNotEquals(longExpN, longRealN, "messageIfFalse");
////        
////        System.out.println(index++ +". test");
////        double doubleExpN = 5.22;
////        double doubleRealN = 5.41; 
////        double deltaN = 0.1;
////        TestProvider.testNotEquals(doubleExpN, doubleRealN, "messageIfFalse");
////        
////        System.out.println(index++ +". test");
////        String StringExpN = "String1";
////        String StringRealN = "String2";  
////        TestProvider.testNotEquals(StringExpN, StringRealN, "messageIfFalse");
////        
////        System.out.println(index++ +". test");
////        StringBuilder StringBExpN = new StringBuilder("Ahoj");
////        StringBuilder StringBRealN = new StringBuilder("Ahoj");  
////        TestProvider.testNotSame(StringBExpN, StringBRealN, "messageIfFalse");
////        
////        System.out.println(index++ +". test");
////        String smaller = "Ahoj";
////        String greather = "Ahoj!";
////        TestProvider.testGreaterThan(smaller, greather, "messageIfFalse");
//        
//    }
  
}
