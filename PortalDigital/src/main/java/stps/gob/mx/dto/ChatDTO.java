package stps.gob.mx.dto;

public class ChatDTO extends RequestDTO{
	private String idChat;
	private String pendientesMasCampos;
	
	
	public String getIdChat() {
		return idChat;
	}
	public void setIdChat(String idChat) {
		this.idChat = idChat;
	}
	public String getPendientesMasCampos() {
		return pendientesMasCampos;
	}
	public void setPendientesMasCampos(String pendientesMasCampos) {
		this.pendientesMasCampos = pendientesMasCampos;
	}
	
	
}
