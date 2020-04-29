package ku.opensrcsw._MidTerm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; //JSON��ü�� ����µ� ���
import org.json.simple.parser.JSONParser; //JSON��ü�� �Ľ��ؿ��µ� ���
import org.json.simple.parser.ParseException; //����ó��
import midterm.problem2.RegularExpression;
import java.util.StringTokenizer;


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
   	 	
   	 	RegularExpression re = new RegularExpression();
   	 	StringTokenizer tokens = new StringTokenizer(looking_for, "|");

   	 	// �ߺ� ���Ÿ� ����
   	 	List<String> my_list = new ArrayList<>();
   	 	
   	 	while(tokens.hasMoreTokens()) {
   	 		String split_string = tokens.nextToken();
   	 		// ����ϱ�
   	 		for(int i = 0; i < infoArray.size(); i++) {
   	 			
   	 			if(my_list.contains(Integer.toString(i))) continue;
   	 			else my_list.add(Integer.toString(i));
   	 			
   	 			JSONObject itemObject = (JSONObject) infoArray.get(i);
   	 			String temp = (String) itemObject.get("item");
   	 			
   	 			if(re.check(temp, split_string)) {
   	 				System.out.println("item " + i +": " + itemObject.get("item"));
   	 			}
   	 		}
        consol.close();
   	 	}
    }
}