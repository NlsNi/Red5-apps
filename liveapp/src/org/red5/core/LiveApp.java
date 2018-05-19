package org.red5.core;


import java.io.IOException;

import org.red5.logging.Red5LoggerFactory;
import org.red5.server.adapter.MultiThreadedApplicationAdapter;
import org.red5.server.api.IConnection;
import org.red5.server.api.scope.IScope;
import org.red5.server.api.stream.IBroadcastStream;
import org.slf4j.Logger;


import org.red5.server.api.stream.*;


public class LiveApp extends MultiThreadedApplicationAdapter {
	
	private static Logger log = Red5LoggerFactory.getLogger(LiveApp.class);


    @Override
	public boolean connect(IConnection conn, IScope scope, Object[] params) {
    	log.info("appConnect");
		return true;
	}

    @Override
	public void disconnect(IConnection conn, IScope scope) {
    	log.info("disconnect");
		super.disconnect(conn, scope);
	}
    
    @Override
    public void streamPublishStart(IBroadcastStream stream)
    {
		if(true)
    	{
    		try 
			{
    			String streamName = stream.getPublishedName();
    			log.info("Recording stream: " + streamName );
				stream.saveAs(streamName, true);
				
			} 
			catch (IOException | ResourceNotFoundException
					| ResourceExistException e) 
			{
				e.printStackTrace();
			}
    	}

    }
	

}
