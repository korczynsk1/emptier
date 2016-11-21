package it.korczynski.emptier;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import it.korczynski.emptier.batch.BatchTestSuite;
import it.korczynski.emptier.dataaccess.DataaccessTestSuite;
import it.korczynski.emptier.rest.RestTestSuite;
import it.korczynski.emptier.service.ServiceTestSuite;

@RunWith(Suite.class)
@SuiteClasses({BatchTestSuite.class, DataaccessTestSuite.class, RestTestSuite.class, ServiceTestSuite.class})
public class AllTests {

}
