/**
 * 
 */
package processing.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author cesar
 *
 */
public class PApplet extends ProcessingJS {
	
	
	public  PApplet (){}
	public  PApplet (JavaScriptObject ctx)
	{
		super(ctx);
		g = new PGraphics3D(ctx);
	}
	




	public PGraphics g;



	public IJsEventHandler eventHandler;


	public void setEventHaandler(IJsEventHandler eventHandler){
		this.eventHandler = eventHandler;
		
	}



	public void registerMethod( String methodName, Object agent) {
		// TODO Auto-generated method stub
//		JavaScriptObject canvas, 
		
		eventHandler.addMouseAgent(getCanvas(), agent, methodName);
	}






	

	
	
						
						
}
