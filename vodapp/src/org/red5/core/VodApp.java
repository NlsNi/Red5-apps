package org.red5.core;



import org.red5.logging.Red5LoggerFactory;
import org.red5.server.adapter.IApplication;
import org.red5.server.adapter.MultiThreadedApplicationAdapter;
import org.red5.server.api.IConnection;
import org.red5.server.api.scope.IScope;
import org.red5.server.api.stream.IBroadcastStream;
import org.red5.server.api.stream.IOnDemandStream;
import org.red5.server.api.stream.IStream;
import org.red5.server.api.stream.IStreamHandler;
import org.slf4j.Logger;


public class VodApp extends MultiThreadedApplicationAdapter  {
	
	private static Logger log = Red5LoggerFactory.getLogger(VodApp.class);

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
    
}
