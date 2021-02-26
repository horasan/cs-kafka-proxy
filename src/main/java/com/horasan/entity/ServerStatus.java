package com.horasan.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServerStatus {

	private String id;
	private String ip;
	private String port;
	private String status;
	@Override
	public String toString() {
		return "ServerStatus [id=" + id + ", ip=" + ip + ", port=" + port + ", status=" + status + "]";
	}
	
	
}
