package skill_dev;

import jep.JepException;
import jep.MainInterpreter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class SkillDevApplication {

	public static void main(String[] args) {

		System.load("C:\\Users\\mephi\\AppData\\Local\\Programs\\Python\\Python312\\python312.dll");
		try {
			MainInterpreter.setJepLibraryPath(new File("C:\\Users\\mephi\\AppData\\Local\\Programs\\Python\\Python312\\Lib\\site-packages\\jep\\jep.dll").getAbsolutePath());
		} catch (JepException e) {
			throw new RuntimeException(e);
		}

		SpringApplication.run(SkillDevApplication.class, args);
	}

}
