package cn.hzau.edu.fishResearch.DAO;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hzau.edu.fishResearch.domain.BaseBen;

/**
 * Biology information DAO(Data Access Object) with commons methods to CRUD POJOs.
 * 
 * @author Eric
 *
 */

@Repository
public interface IBioInfoDAO<T,PK extends Serializable> {
	
	/**
	 * Find a list of records by named query
	 * @param queryName
	 * @return list of records founded
	 */
	
	T findBioInfoBySpeciesStr(String queryName,String tableStr);
	T findBioInfoByFamilyStr(String queryName,String tableStr);
	List<T> getFishBio();
	List<T> getBenBio();
	List<T> getPhyBio();
	List<T> getZooBio();

}
