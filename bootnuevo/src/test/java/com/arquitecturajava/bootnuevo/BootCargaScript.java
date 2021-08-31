package com.arquitecturajava.bootnuevo;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({ "/schema.sql", "/data.sql" })
class BootCargaScript {

	@PersistenceContext
	EntityManager em;

	@Test
	void cargaDatos() {
		
	}
}
