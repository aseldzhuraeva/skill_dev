package skill_dev.python;

import jep.Interpreter;
import jep.JepConfig;
import jep.JepException;
import jep.SubInterpreter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@Service
public class PythonRunner {

    public String executePythonScript(String script, String input) {
        // Python код для перенаправления stdout и переопределения input
        String baseScript = "import sys\n" +
                "from io import StringIO\n" +
                "sys.stdout = mystdout = StringIO()\n" +
                "input_value = '" + input + "'\n" +
                "def input(prompt=''):\n" +
                "    return input_value\n" +
                script + "\n" +
                "output = mystdout.getvalue()";
        try (Interpreter interpreter = new SubInterpreter(new JepConfig())) {
            // Выполнение Python кода
            interpreter.exec(baseScript);

            // Получение вывода
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

}
