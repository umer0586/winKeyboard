package winkeyboard;


public class Keyboard
{
    private native void KeyPress(int scanCode);
    private native void KeyRelease(int scanCode);
    
    static {
    	
	String jreArchitecture = System.getProperty("sun.arch.data.model");
     	    	
    	if(jreArchitecture.equals("64"))
    	  System.loadLibrary("SCGen64");
    	
    	else if(jreArchitecture.equals("32"))
    	  System.loadLibrary("SCGen32");
    	
    	else
    	  throw new RuntimeException("JRE architecture not 32/62 bit");
	    
    }
    
	/**
	 * Emulates keyboard key press by sending a scan code {@link ScanCode#}
	 * @param scanCode - An integer value representing keyboard scan code. All scan codes are available under ScanCode interface.
	 * @throws IllegalArgumentException If scanCode value is other than constants provided in the ScanCode interface
	 * @see #winKeyRelease(int)
	 */
    
	public void winKeyPress(int scanCode) throws IllegalArgumentException
	{
		if(scanCode>=1 && scanCode<=237)
			this.KeyPress(scanCode); 
		else
		    throw new IllegalArgumentException(scanCode+" is not a valid Scan Code");
		
	}
	
	/**
	 * Emulates keyboard key release by sending a scan code. Make sure that {@link #winKeyPress(int)} is called for the key you are releasing
	 * @param scanCode - An integer value representing keyboard scan code. All scan codes are available under ScanCode interface.
	 * @throws IllegalArgumentException If scanCode value is other than constants provided in the ScanCode interface
	 * 
	 */
	public void winKeyRelease(int scanCode) throws IllegalArgumentException
	{
		if(scanCode>=1 && scanCode<=237)
		   this.KeyRelease(scanCode); 
		else
		   throw new IllegalArgumentException(scanCode+" is not a valid Scan Code");
		
	} 
	
	/**
	 * Emulates multiple key press. Keys pressed via this method must be released using {@link #winReleaseCombination(int...)}}
	 * @param scanCodes - Multiple scan code values
	 */
	public void winPressCombination(int... scanCodes)
	{
		for(int scanCode : scanCodes)
			this.winKeyPress(scanCode);
	}
	
	/**
	 * Emulates multiple key release.
	 * @param scanCodes - Multiple scan code values
	 */
	public void winReleaseCombination(int... scanCodes)
	{
		for(int scanCode : scanCodes)
			this.winKeyRelease(scanCode);
	}
	
	
}
