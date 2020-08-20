package generalutils;

import org.apache.log4j.Logger;

public class log {
	private static Logger Log = Logger.getLogger(log.class);

	// This is to print log for the beginning of the test scenario, as we
	// usually run so many test scenarios as a test suite
	public static void startTestScenario(String scenarioName) {
		Log.info("**************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$ Starting Scenario    " + scenarioName + "  $$$$$$$$$$$$$$$$$$$$$");
		Log.info("**************************************************************************************");
	}

	// This is to print log for the ending of the test scenario

	public static void endTestScenario(String scenarioName) {
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-END-" + "             XXXXXXXXXXXXXXXXXXXXXX");
	}

	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message) {
		Log.error(message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}

	public static void debug(String message) {
		Log.debug(message);
	}

}
