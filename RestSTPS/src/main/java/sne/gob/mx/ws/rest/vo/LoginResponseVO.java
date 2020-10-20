package sne.gob.mx.ws.rest.vo;

import java.util.ArrayList;

public class LoginResponseVO extends ResponseVO {
	private ArrayList<LoginObjectVO> list;

	public ArrayList<LoginObjectVO> getList() {
		return list;
	}

	public void setList(ArrayList<LoginObjectVO> list) {
		this.list = list;
	}

	
}
