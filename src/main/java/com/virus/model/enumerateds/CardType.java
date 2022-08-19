package com.virus.model.enumerateds;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CardType {
	CORAZON, HUESO, CEREBRO, ESTOMAGO, ORGANO_ESPECIAL
}
