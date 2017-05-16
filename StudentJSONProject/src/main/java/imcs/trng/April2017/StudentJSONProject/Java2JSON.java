package imcs.trng.April2017.StudentJSONProject;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import imcs.trng.StudentJson.Pojo.Address;
import imcs.trng.StudentJson.Pojo.Marks;
import imcs.trng.StudentJson.Pojo.Student;

public class Java2JSON {
	
	public static void main(String[] args) throws JsonParseException, IOException {
		Java2JSON convert  = new Java2JSON();
        convert.marshalling();
        convert.unmarshalling();
            
        
    }
	
	private void unmarshalling() throws IOException {
		// TODO Auto-generated method stub
		byte[] jsonData = Files.readAllBytes(Paths.get("G:\\Manoj\\Software Engineering\\IMCS\\ClassTraining\\StudentJSONProject\\src\\main\\resource\\Student.json"));
		ObjectMapper objectMapper = new ObjectMapper();
		Student student = objectMapper.readValue(jsonData, Student.class);
		
		System.out.println(student);
		
		
	}

	public void marshalling() throws JsonGenerationException, JsonMappingException, IOException{
		Address address1 = new Address();
        address1.setType("HOME");
        address1.setStreet("MacArthur");
        address1.setCity("DALLAS");
        address1.setState("TX");
        Address address2 = new Address();
        address2.setType("WORK");
        address2.setStreet("RanchView");
        address2.setCity("IRVING");
        address2.setState("TX");
        List<Address> addressList = new ArrayList<Address>();
        addressList.add(address1);
        addressList.add(address2);
        Marks subject1 = new Marks("MATHS",78.0);
        Marks subject2 = new Marks("ENGLISH",90);
        List<Marks> marksList = new ArrayList<Marks>();
        marksList.add(subject1);
        marksList.add(subject2);
        Student student = new Student("Manoj",addressList,marksList);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        StringWriter stringEmp = new StringWriter();
        objectMapper.writeValue(stringEmp, student);
        System.out.println("Student JSON is\n"+stringEmp);
        
    
		
	}
 
    
}
