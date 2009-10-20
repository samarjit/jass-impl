/**
 * 
 */
package dto;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * <p><b>JobAdvertDTOTest</b> will be used to test {@link JobAdvertDTO}class</p>
 * @author Samarjit Samanta
 * @version 1.0
 */
public class JobAdvertDTOTest extends TestCase{
@Test
public void testGetCompanyDesc(){
	JobAdvertDTO jobadvertDTO = new JobAdvertDTO();
	jobadvertDTO.setCmpnyDesc("My New Company");
	String newComp = jobadvertDTO.getCmpnyDesc();
	assertEquals("The two must be same","My New Company",newComp);
}


}
