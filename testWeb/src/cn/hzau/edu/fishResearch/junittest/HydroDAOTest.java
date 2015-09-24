package cn.hzau.edu.fishResearch.junittest;

import java.sql.Blob;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;


import cn.hzau.edu.fishResearch.DAO.IBioInfoDAO;
import cn.hzau.edu.fishResearch.DAO.IMonitHydroDAO;
import cn.hzau.edu.fishResearch.DAO.impl.IBioInfoDAOImpl;
import cn.hzau.edu.fishResearch.DAO.impl.IMonitHydroDAOImpl;
import cn.hzau.edu.fishResearch.domain.BaseBen;
import cn.hzau.edu.fishResearch.domain.BaseFish;
import cn.hzau.edu.fishResearch.domain.BaseMonitSite;
import cn.hzau.edu.fishResearch.domain.BasePhy;
import cn.hzau.edu.fishResearch.domain.BaseZooplan;
import cn.hzau.edu.fishResearch.domain.MonitBen;
import cn.hzau.edu.fishResearch.domain.MonitPhy;
import cn.hzau.edu.fishResearch.domain.MonitZooplan;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-*.xml"})
@TransactionConfiguration(defaultRollback = false)
public class HydroDAOTest extends  AbstractTransactionalJUnit4SpringContextTests
{
	@Autowired
	private IMonitHydroDAOImpl<MonitBen,String,Long> monitBenService;
	@Autowired
	private IMonitHydroDAOImpl<MonitBen,String,Long> monitBenDAO;
	@Autowired
	private IMonitHydroDAOImpl<MonitPhy,String,Long> monitPhyDAO;
	@Autowired
	private IMonitHydroDAOImpl<MonitZooplan,String,Long> monitZooDAO;
	@Autowired
	private IBioInfoDAO<BaseBen, Long> bioBenInfoDAO;
	@Autowired
	private IBioInfoDAO<BaseFish, Long> bioFishInfoDAO;
	@Autowired
	private IBioInfoDAO<BasePhy, Long> bioPhyInfoDAO;
	@Autowired
	private IBioInfoDAOImpl<BaseZooplan, Long> bioZooInfoDAO;
	
	
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
				BaseZooplan bioZooplan = new BaseZooplan();
				/*bioZooplan = bioZooInfoDAO.findZooBioInfoByNamed("test");*/
				/*List<MonitPhy> queryResult = monitPhyDAO.findDataByParam("Select o from MonitPhy o where o.phyName=:name","×ªÂÖ³æ");
				if (queryResult.isEmpty()) {
					System.out.println("empty");
				}
				else {
					System.out.println("notEmpty");
					System.out.println(queryResult.size());
				}
				System.out.println(queryResult);*/
				System.out.println(bioZooplan);
			monitZooDAO.saveImgToDB("C:/Users/Administrator/Desktop/temp/abc.png", bioZooplan);
			
			System.out.println(bioZooplan.getPicture().toString());
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}


}
