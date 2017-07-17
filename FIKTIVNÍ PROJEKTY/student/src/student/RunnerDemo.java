
package student;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import myPackage.TeacherInterface;
import teacherwriter.TeacherWriter;





public class RunnerDemo implements TeacherInterface
{

    private String privateField = "This is private field!";
    public String publicField = "This is public field!";
    
    public static void main(String[] args) 
    {
        
    }

    @Override
    public int countWords(String vstup) 
    {
        int ret = 0;
//        boolean check = true;
//        int index = 0;
//        String subString = vstup;
//        String temp = "";
//        
//        
//        System.out.println("\n\n###Method: RunnerDemo.countWords()");
//        System.out.println("###vstupA: " +vstup);
//        
//        while(check)
//        {
//            
//            if(subString.indexOf(" ") > 0)
//            {
//                temp = subString.substring(0, subString.indexOf(" "));
//                index = subString.indexOf(" ", 0) +1;
//                subString = subString.substring(index);
//                ret++;
//            }
//            else
//            {
//                ret++;
//                check = false;
//            }
//        }
//        System.out.println("-----------------vytvareni souboru");
//        File f = new File("C:\\Users\\Mawerickk\\Desktop\\imageOutput\\Restricted\\");
//        System.out.println("-----------------soubor vytvoren");
//        System.out.println("-----------------can write: " +f.canWrite());
//    teacherwriter.TeacherWriter.writeMethod();
        NoImplementDemo nid = new NoImplementDemo();
        nid.countWords(vstup);
        return ret;
    }
    
    public void datum(Calendar cal)
    {
        System.out.println(cal.getTime()); 
    }
    
    public void infiniteLoop()
    {
        while(true){}
    }
    
    public double nasobeni(int vstupA, String vstupB) throws Exception
    {
        System.out.println("\n\n###Method: nasobeni");
        System.out.println("###vstupA: " +vstupA +", vstupB: " +vstupB);
        
        double delitel = Double.parseDouble(vstupB);
        
        throw new Exception("Toto je studentova výjimka");
        
        //return vstupA*delitel;
    }
    
    public static double deleni(int vstupA, String vstupB)
    {
        System.out.println("\n\n###Static method: deleni");
        System.out.println("###vstupA: " +vstupA +", vstupB: " +vstupB);
        
        double delitel = Double.parseDouble(vstupB);
        System.out.println("###vstupA: " +vstupA +", delitel: " +delitel);
        
        return vstupA/delitel;
    }
    
    public void writeToFile()
    {
        TeacherWriter.writeMethod("\\");
        TeacherWriter.writeMethod("\\");
        writeFileOutputStream();
        writePrintWriter();
        writeFiles();
        
    }
    
    private void writeFileOutputStream()
    {
        FileOutputStream fos = null;
        try {
            boolean ret = true;
            File f = new File("C:\\Users\\Mawerickk\\Desktop\\Diplomka\\listopad\\TEST\\student\\"+"FileOutputStream.txt");
            fos = new FileOutputStream(f);
            fos.write(new String("MyHomeWorkDemo: FileOutputStream write").getBytes());
            
            //Writer, OutputStream, Files
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RunnerDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RunnerDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(RunnerDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void writePrintWriter()
    {
        try{
            PrintWriter writer = new PrintWriter("C:\\Users\\Mawerickk\\Desktop\\Diplomka\\listopad\\TEST\\student\\"+"printWriter.txt", "UTF-8");
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(RunnerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void writeFiles()
    {
        List<String> lines = Arrays.asList("The first line", "The second line");
        Path file = Paths.get("C:\\Users\\Mawerickk\\Desktop\\Diplomka\\listopad\\TEST\\student\\" +"writeFiles.txt");
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(RunnerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
