package cn.hzau.edu.fishResearch.DAO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.hzau.edu.fishResearch.domain.MonitPhy;

/**
 * Common method to CRUD POJOs
 * 
 * @author EricLiu
 *
 * @param <typeMonitClass> 
 * @param <PK>
 */

@Repository
public interface IMonitHydroDAO<typeMonitClass,typeForInput,PK extends Serializable>{
	
	/**
	 * Look up all rows in a table
	 * @return List of populated objects
	 */
	List<typeMonitClass> getAllBen();
	List<typeMonitClass> getAllPhy();
	List<typeMonitClass> getAllZoo();
	/**
	 * get an object based on class and identifier
	 * @return an object
	 */
	typeMonitClass getBen(PK id);
	
	/**
	 * Checks for existence of an object of type T using the id arg
	 * @return true or false
	 */
	boolean existsBen(PK id);
	
	/**
	 * Save an object - handles both updates and insert
	 * @return the persisted object
	 */
	typeMonitClass save(typeMonitClass object);
	
	/**
	 * delete an object based on class and id
	 */
	void remove(PK id);
	
	/**
	 * Find a list of records by named query
	 * @param queryName
	 * @return list of records founded
	 */
	List<typeMonitClass> findBenByNamedQuery(String queryName);
	
	List<typeMonitClass> findBenBySiteNameQuery(String queryName);
	
	List<typeMonitClass> groupBySiteNameQuery(final String queryName);
	
	List<typeMonitClass> findDataByParam(final String hQLState,final typeForInput hQLValue);
	

}
