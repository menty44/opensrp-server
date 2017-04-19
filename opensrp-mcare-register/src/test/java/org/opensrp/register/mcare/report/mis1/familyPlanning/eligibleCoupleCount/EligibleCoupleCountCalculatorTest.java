package org.opensrp.register.mcare.report.mis1.familyPlanning.eligibleCoupleCount;


import org.junit.Test;
import org.opensrp.register.mcare.domain.Members;
import org.opensrp.register.mcare.report.mis1.MIS1Report;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EligibleCoupleCountCalculatorTest {

    @Test
    public void newEligibleCoupleVisitCountTest() {
        int totalCount = 1000;
        int validCount = 600;
        long startDateTime = 140000;
        long endDateTime = 170000;
        EligibleCoupleCountData eligibleCoupleCountData =
                new EligibleCoupleCountData(totalCount, validCount, startDateTime, endDateTime);
        List<Members> membersList = eligibleCoupleCountData.getNewEligibleCoupleVisitData();
        MIS1Report mis1Report = new MIS1Report(membersList, startDateTime, endDateTime);
        int newEligibleCoupleVisitCount = mis1Report.getFamilyPlanningReport().getEligibleCoupleCountCalculator().
                getNewEligibleCoupleVisitCount();

        assertEquals(newEligibleCoupleVisitCount, eligibleCoupleCountData.validCount);
    }
}
