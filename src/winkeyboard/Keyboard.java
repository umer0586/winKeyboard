package winkeyboard;


public class Keyboard
{
    private native void KeyPress(int scanCode);
    private native void KeyRelease(int scanCode);
    
    static {
    	
    	
    	boolean is64bit = false;
    	if (System.getProperty("os.name").contains("Windows")) 
    	    is64bit = (System.getenv("ProgramFiles(x86)") != null);
    	else 
    	    is64bit = (System.getProperty("os.arch").indexOf("64") != -1);
    	    	
    	if(is64bit)
    	  System.loadLibrary("SCGen64");
    	else
    	  System.loadLibrary("SCGen32");	
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
	
}
