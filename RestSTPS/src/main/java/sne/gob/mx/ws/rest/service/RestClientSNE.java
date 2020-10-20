package sne.gob.mx.ws.rest.service;

import sne.gob.mx.ws.rest.vo.VOUsuario;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


public class RestClientSNE {
	public static void main(String[] args) {
		VOUsuario vo = new VOUsuario();
		VOUsuario res = new VOUsuario();
		vo.setUsuario("Java");
		vo.setPassword("1234");
		vo.setUserValido(false);
		
		ClientConfig clientconfig = new DefaultClientConfig();
		clientconfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientconfig);
		WebResource webresource = client.resource("http://192.168.1.67:7001/RestSNE/services/SNE/validaUsuario");
		
		
		ClientResponse response = webresource.type("application/json").post(ClientResponse.class,vo);
		System.out.println(" Header response: "+response.getHeaders().toString());
		System.out.println(" Date response: "+response.getResponseDate());
		
		res = (VOUsuario)response.getEntity(VOUsuario.class);
		
		System.out.println(" Usuario response: "+res.getUsuario());
		System.out.println("User is Valid response: "+res.isUserValido());
		
	}
}
