package com.gdg.rocky.hibernate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.gdg.rocky.hibernate.DataInsertion;

import junit.framework.TestCase;

public class insertTest
{
	@Test
	public void test()
	{
	//	DataProvider dp = new DataProvider();
	//	DataInsertion di = new DataInsertion();
		Assert.assertEquals(DataInsertion.insertInfo(), true);
				
	}
	
	@Before
	public void beforeTest()
	{
		Assert.assertEquals(DataInsertion.deleteInfo(), true);
	}
	
	@After
	public void afterTest()
	{
		Assert.assertEquals(DataInsertion.updateInfo(), true);
	}
}
