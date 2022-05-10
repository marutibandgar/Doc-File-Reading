import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DocReading {
	static org.apache.poi.xwpf.extractor.XWPFWordExtractor oleTextExtractor;
	
	public static String storedWORDData;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String filepath ="D:\\Docu\\API Testing Training.docx";
		try
		{
			FileInputStream fis = new FileInputStream("D:\\\\Docu\\\\DocData.docx");
			oleTextExtractor =new XWPFWordExtractor(new XWPFDocument(fis));
			storedWORDData = oleTextExtractor.getText(); 
			String str=null,str1 =null;
			str = storedWORDData.replace("Primary Kids Academy","Enter here New Opty");
			str1 =str.replace("$602.98","Enter here Total Monthly Recurring Charge");
			System.out.println("str="+str);
			System.out.println("str="+str1);
			XWPFDocument document = new XWPFDocument(); 
		    FileOutputStream out = new FileOutputStream( new File("D:\\Docu\\EditedFile.docx"));  
		    XWPFParagraph paragraph = document.createParagraph();
		    XWPFRun run = paragraph.createRun();
		    run.setText(str1);	
		    document.write(out);
		    out.close();
	
		    System.out.println("DocData.docx written successully");
			
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
