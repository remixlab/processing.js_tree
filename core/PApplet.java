/**
 * 
 */
package processing.core;






import com.google.gwt.core.client.JavaScriptObject;
import com.gwtent.reflection.client.ClassType;
import com.gwtent.reflection.client.TypeOracle;




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
	
	private static boolean isMousePressed = false;	
	
	private JsEventhandler handler;
	

		
		 public  void addMouseAgent( String methodName, Object agent) {
		 
			 if(handler == null)
				 handler = new  JsEventhandler();
			 
			 handler.addMouseAgent(getCanvas(), agent, methodName);

	 	}
		 
		 public  void addKeyAgent( String methodName, Object agent) {
			 
			
			 if(handler == null)
				 handler = new  JsEventhandler();
			 
			 handler.addKeyAgent(getCanvas(), agent, methodName);

	 	}
		


		
	public void unregisterMethod(String string, Object defaultMouseAgent) {
		// TODO Auto-generated method stub
		handler = null;
	}

	public native void removeMouseAgent(JavaScriptObject canvas)/*-{
		
		
		var eventHandler = function(event) {};
		
		canvas.removeEventListener('mousemove',eventHandler,false);		
		canvas.removeEventListener('click',eventHandler,false);	
		canvas.removeEventListener('ondblclick',eventHandler,false);				
		canvas.removeEventListener('mousedown',eventHandler,false);				
		canvas.removeEventListener('mouseup',eventHandler,false);				
		canvas.removeEventListener('mouseout',eventHandler,false);	
		canvas.removeEventListener('mouseover',eventHandler,false);	
		// IE9, Chrome, Safari, Opera
		canvas.removeEventListener("mousewheel", eventHandler, false);
		// Firefox
		canvas.removeEventListener("DOMMouseScroll", eventHandler, false);
		
	}-*/;
	
	
	public class JsEventhandler {
	
	public native void addKeyAgent(JavaScriptObject canvas, Object agent, String methodName)/*-{
		
		
		
			var eventHandler = function(event) {
						
				var type = event.type;
				
				// new JsMouseEvent with the native event
				var JsKeyEvent = 
				@processing.eventjs.JsKeyEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)
				(event,canvas);	
				
				
				@processing.core.Reflect::ExecuteEvent(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)
				(agent,methodName, JsKeyEvent);
			
			
			}
			
			//listeners
			canvas.addEventListener('keydown',eventHandler,false);		
			canvas.addEventListener('keyup',eventHandler,false);	
	
	}-*/;
	
	/**
	 * Adds the event to the  mouse agent.
	 *
	 * @param canvas the canvas
	 * @param agent the anonymous agent to call the event with reflection
	 * @param methodName the method name to call the event with reflection
	 */
	public native void addMouseAgent(JavaScriptObject canvas, Object agent, String methodName)/*-{
		
		
		var eventHandler = function(event) {
						
			var type = event.type;
			
			

			//set if mouse is pressed 
			if (type === "mousedown"  )										
				@processing.core.PApplet::isMousePressed = true;
								  																								
			else if (type === "mouseup" )			
				@processing.core.PApplet::isMousePressed = false;
				
			else if (type === "mouseout" )			
				@processing.core.PApplet::isMousePressed = false;	
							
			else if (type === "mouseover" )			
				@processing.core.PApplet::isMousePressed = false;								
						
			var isMousePressed  = @processing.core.PApplet::isMousePressed;
			
		//	console.log(type + String(" "+isMousePressed) );

			// new JsMouseEvent with the native event
			var JsMouseEvent = 
			@processing.eventjs.JsMouseEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Z)
			(event,canvas, isMousePressed);			
			
			
		
			
			//pass to the agent the JsMouseEvent to run
		//	@processing.core.Reflect::ExecuteEvent(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;) 
			//(agent,methodName, JsMouseEvent);
			@processing.core.Reflect::ExecuteEvent(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)
			(agent,methodName, JsMouseEvent);
		//	console.log(methodName);

																    
		}
		
		
		//listeners
		canvas.addEventListener('mousemove',eventHandler,false);		
		canvas.addEventListener('click',eventHandler,false);	
		canvas.addEventListener('ondblclick',eventHandler,false);				
		canvas.addEventListener('mousedown',eventHandler,false);				
		canvas.addEventListener('mouseup',eventHandler,false);				
		canvas.addEventListener('mouseout',eventHandler,false);	
		canvas.addEventListener('mouseover',eventHandler,false);	
		// IE9, Chrome, Safari, Opera
		canvas.addEventListener("mousewheel", eventHandler, false);
		// Firefox
		canvas.addEventListener("DOMMouseScroll", eventHandler, false);		
		
	
	}-*/;	
		
	
	}
						
}
