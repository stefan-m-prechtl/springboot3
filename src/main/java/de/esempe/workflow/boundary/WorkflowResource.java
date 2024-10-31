package de.esempe.workflow.boundary;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.esempe.workflow.boundary.json.ConfigJsonSerialization;
import de.esempe.workflow.domain.Workflow;

@RestController
@RequestMapping("workflow")
public class WorkflowResource
{
	@Autowired
	private WorkflowRepository repository;

	@Autowired
	ConfigJsonSerialization serializationConfig;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Workflow>> getAll()
	{
		this.serializationConfig.setFullObjReference(false);

		final List<Workflow> all = this.repository.findAll();
		final var result = ResponseEntity.status(HttpStatus.OK).body(all);
		return result;
	}

	@GetMapping(path = "/{objId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getOneByObjId(@PathVariable final UUID objId)
	{
		this.serializationConfig.setFullObjReference(true);

		final Workflow dbResult = this.repository.findByObjId(objId);
		if (null == dbResult)
		{
			final ResponseEntity<?> result = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			return result;
		}

		final var result = ResponseEntity.status(HttpStatus.OK).body(dbResult);
		return result;
	}

}
