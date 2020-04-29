package ku.opensrcsw._MidTerm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; //JSON객체를 만드는데 사용
import org.json.simple.parser.JSONParser; //JSON객체를 파싱해오는데 사용
import org.json.simple.parser.ParseException; //예외처리

public class App 
{
    public static void main( String[] args ) throws ParseException, FileNotFoundException, IOException
    {
    	
    	// json파일 읽기
    	JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("C:\\Users\\hansol\\Desktop\\opensrcsw_lecture\\midterm.json"));
        JSONObject things = (JSONObject) obj;
        JSONArray infoArray = (JSONArray) things.get("poem");
        System.out.println(things);
        
        // 키보드 입력 받기
        Scanner consol = new Scanner(System.in);
   	 	System.out.print("Enter the keyword you are looking for: ");
   	 	// 찾고자 하는거 담음
   	 	String looking_for = consol.next();
   	 	
   	 	// 출력하기
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
