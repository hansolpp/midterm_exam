package ku.opensrcsw._MidTerm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; //JSON��ü�� ����µ� ���
import org.json.simple.parser.JSONParser; //JSON��ü�� �Ľ��ؿ��µ� ���
import org.json.simple.parser.ParseException; //����ó��

public class App 
{
    public static void main( String[] args ) throws ParseException, FileNotFoundException, IOException
    {
    	
    	// json���� �б�
    	JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("C:\\Users\\hansol\\Desktop\\opensrcsw_lecture\\midterm.json"));
        JSONObject things = (JSONObject) obj;
        JSONArray infoArray = (JSONArray) things.get("poem");
        System.out.println(things);
        
        // Ű���� �Է� �ޱ�
        Scanner consol = new Scanner(System.in);
   	 	System.out.print("Enter the keyword you are looking for: ");
   	 	// ã���� �ϴ°� ����
   	 	String looking_for = consol.next();
   	 	
   	 	// ����ϱ�
   	 	for(int i = 0; i < infoArray.size(); i++) {
   	 		JSONObject itemObject = (JSONObject) infoArray.get(i);
   	 		String temp = (String) itemObject.get("item");
   	 		if(temp.contains(looking_for)) {
   	 			System.out.println("item " + i +": " + itemObject.get("item"));
   	 		}
   	 	}
        consol.close();
    }
}
