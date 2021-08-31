package com.arquitecturajava.bootnuevo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({ "/esquema.sql", "/data.sql" })
class BootCargaScript {


	@Test
	void cargaDatos() {

	}


}
