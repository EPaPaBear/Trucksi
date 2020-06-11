package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PairDTO<DTO0, DTO1, ExtraT> {

	private DTO0 dto0;
	private DTO1 dto1;
	private ExtraT data;
}