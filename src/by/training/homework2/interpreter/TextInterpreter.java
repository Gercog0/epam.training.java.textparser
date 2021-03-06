package by.training.homework2.interpreter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TextInterpreter {
    private static final String SCRIPT_ENGINE_NAME = "JavaScript";

    private static Logger logger = LogManager.getLogger(TextInterpreter.class);

    private TextInterpreter() {
    }

    public static String convertExpression(String expression) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName(SCRIPT_ENGINE_NAME);
        String resultExpression;
        try {
            resultExpression = engine.eval(expression).toString();
            logger.debug("Successful convert expression: " + expression);
        } catch (ScriptException exp) {
            resultExpression = expression;
            logger.debug("Exception during convert expression:" + expression);
        }
        return resultExpression;
    }
}
