package cn.hzau.edu.fishResearch.junittest;


import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cn.hzau.edu.fishResearch.DAO.ICatchFishDAO;
import cn.hzau.edu.fishResearch.DAO.IMonitDataDAO;
import cn.hzau.edu.fishResearch.DAO.impl.IMonitDataDAOImpl;
import cn.hzau.edu.fishResearch.domain.BaseMonitSite;
import cn.hzau.edu.fishResearch.domain.CatchFishObj;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-*.xml"})
@TransactionConfiguration(defaultRollback = false)
public class DAOUnitTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private IMonitDataDAO iMonitDataDAO;
	@Autowired
	private ICatchFishDAO iCatchFishDAO;
	
	public void IMonitDataDAOImplTest() {
		System.out.println("Initializing test class");
		
	}
	
	@org.junit.Before
	public void setUp() throws Exception
	{
		System.out.println("test is Starting");
	}
	
	@After
	public void tearDown() throws Exception
	{
		System.out.println("End");
	}
	
	@Test
	public void test() {
		
		try {
			CatchFishObj fishObj = new CatchFishObj();
			/*List<BaseMonitSite> findAll = iMonitDataDAO.findAll(baseMonitSite);*/
			List<CatchFishObj> findAll = iCatchFishDAO.findAll(fishObj);
			/*if (findAll.isEmpty()) {
				System.out.println("empty");
			}
			else {
				System.out.println("notEmpty");
			}*/
			System.out.println(findAll.isEmpty());
			System.out.println(findAll.size());
			System.out.println("success!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
