package awt.grocery;

import awt.grocery.frame.service.FrameServiceImpl;

public class GroceryAwtApplication {
	
	public static void main(String[] args) {
		
		FrameServiceImpl frameService = new FrameServiceImpl();
		
		frameService.getStartFrame();
		
	}

}
