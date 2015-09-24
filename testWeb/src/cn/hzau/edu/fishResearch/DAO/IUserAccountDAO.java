package cn.hzau.edu.fishResearch.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import cn.hzau.edu.fishResearch.domain.SyUserInfo;

/**
 * 
 * @author Ericliu
 * @version 1.0
 * @date Saturday,28 March
 *
 */


@Repository
public interface IUserAccountDAO<SyUserInfo> {
	/**
	 * get the user by account and password
	 * @param userName
	 * @param password
	 */
	List<SyUserInfo> readByAccount(String userName,String password);
	
	
	/**
	 * get the user by id
	 * @param id
	 */
	/*SyUserInfo readById(int id);
*/
}
