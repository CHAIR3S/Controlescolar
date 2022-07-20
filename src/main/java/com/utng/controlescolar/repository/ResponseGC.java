package com.utng.controlescolar.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ResponseGC<T> implements Serializable{
//Esta clase genérica va a almacenar los datos que le vaya pasando del tipo que sea, se va a usar en 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private String status;
	
	@Getter @Setter
	private int count = 0;
	
	@Getter @Setter
	private String message;
	
	@Getter @Setter
	private T data;  //Variable data de tipo "T" lo que regresa la ArrayList y podemos guardar objetos de todo tipo
	


	private List<T> list = null; 
	
	//Get de list<T>
	public List<T> getList() {
		List<T> tmp = null;
		if(this.list !=null) 
		{
			tmp = new ArrayList<T>(this.list);
		}
		return tmp;
	}
	
	//Set de List<T>
	public void setList(List<T> tmp) {
		if(tmp != null) 
		{
			this.list = new ArrayList<T> (tmp);
		}		
	}
	
}
