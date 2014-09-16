package ch.ksimlee.it.TheSwagolouses;

public class Log {
	
	public enum Level {
		DEBUG,INFO,WARNING,ERROR  //ordinal order

		
	}
	
	private static Level CURRENT_LEVEL = Level.ERROR;
	

	public static void setLevel(Level level) {
		// TODO update the level
	}

	/**
	 * Log a message if the currently set level is lower or equal to the
	 * provided level.
	 *
	 * @param level
	 *            The level of this message.
	 * @param message
	 *            The message to log.
	 */
	public static void log(Level level, String message) {
		
		if (level.ordinal() >= CURRENT_LEVEL.ordinal()) {
			System.out.println(message);
		}
		
	}
	
	/**
	 * Convenience function to log error messages. This message is logged if the
	 * logger is set to error or lower.
	 *
	 * @param message	The message to log.
	 */
	public static void error(String message) {
		
		if ( Level.ERROR.ordinal() >= CURRENT_LEVEL.ordinal() ) {
			System.out.println(message);
		}
	}
	
	/**
	 * Convenience function to log warnings. This message is logged if the
	 * logger is set to warning or lower.
	 *
	 * @param message
	 *            The message to log.
	 */
	public static void warning(String message) {
		
		if ( Level.WARNING.ordinal() >= CURRENT_LEVEL.ordinal() ) {
			System.out.println(message);
		}
	}
	
	/**
	 * Convenience function to log info messages. This message is logged if the
	 * logger is set to info or lower.
	 *
	 * @param message	The message to log.
	 */
	public static void info(String message) {
		
		if ( Level.INFO.ordinal() >= CURRENT_LEVEL.ordinal() ) {
			System.out.println(message);
		}
	}
	
	/**
	 * Convenience function to log debug messages. This message is logged if the
	 * logger is set to debug or lower.
	 *
	 * @param message	The message to log.
	 */
	public static void debug(String message) {
		
		if ( Level.DEBUG.ordinal() >= CURRENT_LEVEL.ordinal() ) {
			System.out.println(message);
		}
	}

	/* ----- */
	
	private Log() {
		// Don't allow instances of this class.
	}
}