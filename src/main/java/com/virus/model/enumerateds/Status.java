package com.virus.model.enumerateds;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Status {
	NONE, WAITING_PLAYERS, ACTIVE, FINISHED
}
