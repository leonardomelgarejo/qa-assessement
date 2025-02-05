package com.hostfully.svc.qa_assessment.suite;

import com.hostfully.svc.qa_assessment.tests.BookingE2ETests;
import com.hostfully.svc.qa_assessment.tests.PropertyE2ETests;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        com.hostfully.svc.qa_assessment.tests.HealthCheckAPITests.class,
        com.hostfully.svc.qa_assessment.tests.ContractsTests.class,
        PropertyE2ETests.class,
        BookingE2ETests.class
})
public class AllTestsSuite {
}
