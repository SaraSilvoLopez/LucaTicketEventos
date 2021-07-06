package com.example.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection="recintos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Recinto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@MongoId(FieldType.OBJECT_ID)
	private String id;
	
	@Indexed
	private String ciudad;
	
	private String nombre;
	private String lugar;
	private Integer aforo;

}
