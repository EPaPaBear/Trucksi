package it.contrader.converter;

import java.util.List;
import java.util.Set;

/**
 * Questa interfaccia firma i metodi dei converter parametrizzati dai tipi
 * Entity e DTO.
 * 
 * @author Vittorio Valent
 * @author Girolamo Murdaca
 *
 * @param <Entity>
 * @param <DTO>
 * 
 * @see AbstractConverter
 */
public interface Converter<Entity,DTO> {

	public Entity toEntity(DTO dto);
	
	public DTO toDTO(Entity entity);
	
	public Entity toEntityS(DTO dto); 
	
	public DTO toDTOS(Entity entity);
	
	public List<DTO> toDTOList(Iterable<Entity> entityList);
	
	public List<Entity> toEntityList(Iterable<DTO> dtoList);
	
}