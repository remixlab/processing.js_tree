/**
 * 
 */
package processing.core;




import remixlab.bias.js.JsEventHandler;

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

//	public IJsEventHandler eventHandler;
//	
//
//
//	public void setEventHaandler(IJsEventHandler eventHandler){
//		this.eventHandler = eventHandler;
//		
//	}
//
//	 public  void registerMethod( String methodName, Object agent) {
//		 		 
//		 if(eventHandler != null)		 			 
//			 eventHandler.addMouseAgent(getCanvas(), agent, methodName);
//
//	}
	
	 
		private JsEventHandler eventHandler;
		
		
		public boolean IsNullJsEventHandler()
		{
			if (eventHandler == null)
				return true;
							
			else
				return false;							
		}
		

		public void setEventHaandler(JsEventHandler eventHandler){
			this.eventHandler = eventHandler;
			
		}
		
		 public  void addMouseAgent( String methodName, Object agent) {
		 
			if(eventHandler == null)
				eventHandler = new JsEventHandler();
				
				 eventHandler.addMouseAgent(getCanvas(), agent, methodName);

	 	}
		 
		 public  void addKeyAgent( String methodName, Object agent) {
			 
			if(eventHandler == null)
				eventHandler = new JsEventHandler();
				
				 eventHandler.addKeyAgent(getCanvas(), agent, methodName);

	 	}
		

//		 public  void registerMethod( String methodName, Object agent) {
//			 		 
//			 if(eventHandler != null)		 			 
//				 eventHandler.addMouseAgent(getCanvas(), agent, methodName);
//
//		}
			 
	 
	 
//	public  void registerMethod( String methodName, Object agent, Object param){	
//		
//		 if(eventHandler != null)
//		 {
//			 
//			 
//		 }
//		// Reflect.ExecuteEvent(agent, methodName , param);
//		
//		
//	    //ClassType<? extends Object> classType = TypeOracle.Instance.getClassType(agent.getClass());		    
//	    //classType.invoke(agent,methodName, param);
//	}
	
		
	public void unregisterMethod(String string, Object defaultMouseAgent) {
		// TODO Auto-generated method stub
		eventHandler = null;
	}

					
						
}
