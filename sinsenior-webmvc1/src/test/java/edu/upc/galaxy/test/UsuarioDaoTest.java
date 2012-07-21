package edu.upc.galaxy.test;

import edu.upc.galaxy.dao.UsuarioDao;
import edu.upc.galaxy.entity.Usuario;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gian
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-base-test.xml")
@Transactional
public class UsuarioDaoTest {
    
    private static Logger log = LoggerFactory.getLogger(UsuarioDaoTest.class);
    
    @Autowired
    UsuarioDao usuarioDao;
        
    @Test
    public void testInsertarUsuario() {
        Usuario usuario = new Usuario("admin","admin@admin.com","admin");
        Integer id = usuarioDao.insertar(usuario);
        Assert.assertNotNull(id);
    }
}
