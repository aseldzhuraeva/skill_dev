package skill_dev.python;

import jep.Jep;
import jep.JepConfig;
import jep.JepException;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import jep.Interpreter;
import jep.JepConfig;
import jep.JepException;
import jep.SubInterpreter;

@Service
public class PythonRunner {


    public String executePythonScript(String script) {
        // Python код в виде строки
        String baseScript = "import sys\n" +
                "from io import StringIO\n" +
                "sys.stdout = mystdout = StringIO()\n" +
                script + "\n" +
                "output = mystdout.getvalue()";
        try (Interpreter interpreter = new SubInterpreter(new JepConfig())) {
            interpreter.exec(baseScript);
            String output = (String) interpreter.getValue("output");
            System.out.println("Output from Python script:");
            System.out.println(output);
            return output;
        } catch (JepException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String executePythonFunction(String script, String functionName, Object... args) {
        try (Interpreter interpreter = new SubInterpreter(new JepConfig())) {
            interpreter.exec(script);
            return interpreter.invoke(functionName, args).toString();
        } catch (JepException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
/*
    public String executePythonScript(String script) {
        // Python код в виде строки
        String baseScript = "import sys\n" +
                "from io import StringIO\n" +
                "sys.stdout = mystdout = StringIO()\n" +
                script + "\n" +
                "output = mystdout.getvalue()";
        try (Jep jep = new Jep()) {
            jep.exec(baseScript);
            String output = (String) jep.getValue("output");
            System.out.println("Output from Python script:");
            System.out.println(output);
            return output;
        } catch (JepException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String executePythonFunction(String script, String functionName, Object... args) {
        try (Jep jep = new Jep()) {
            jep.exec(script);
            return jep.invoke(functionName, args).toString();
        } catch (JepException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
*/
}
