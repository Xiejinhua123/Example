package rpc;

import java.net.InetSocketAddress;

import rpc.service.EchoService;
import rpc.service.EchoServiceImpl;

public class RpcTest {

	public static void main(String[] args) {
		new Thread( new Runnable() {
			@Override
			public void run() {
				try {
					RpcExporter.exporter( "localhost" , 8088 );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} ).start();
		RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
		EchoService echo = importer.importer( EchoServiceImpl.class , new InetSocketAddress( "localhost", 8088 ) );
		System.out.println( echo.echo( "Are you OK ? " ) );
	}

}
