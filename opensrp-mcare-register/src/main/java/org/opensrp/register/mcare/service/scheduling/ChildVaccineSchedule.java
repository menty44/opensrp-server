/**
 * @author Asifur
 */

package org.opensrp.register.mcare.service.scheduling;

import static org.opensrp.common.AllConstants.HHRegistrationFields.REFERENCE_DATE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.joda.time.LocalDate;
import org.opensrp.form.domain.FormSubmission;
import org.opensrp.register.mcare.domain.Members;
import org.opensrp.register.mcare.service.MembersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildVaccineSchedule {
	
	private static Logger logger = LoggerFactory.getLogger(MembersService.class.toString());
	private MembersScheduleService membersScheduleService;
	
	@Autowired
	public ChildVaccineSchedule(MembersScheduleService membersScheduleService) {
		this.membersScheduleService = membersScheduleService;		
	}
	
	public void immediateChildVaccine(FormSubmission submission, Members members, Map<String, String> membersFields, String scheduleName, String immediateScheduleName, String refDate, String age, String age_days, String cond, int agenum, int days) {
		
		if (membersFields.containsKey(cond))
		if (membersFields.get(cond) == null || membersFields.get(cond).equalsIgnoreCase("")){
		if(membersFields.containsKey(age))
		if(!membersFields.get(age).equalsIgnoreCase("") && membersFields.get(age) != null)
		if(Integer.parseInt(membersFields.get(age))<agenum){
			if(membersFields.containsKey(refDate))
			if (!membersFields.get(refDate).equalsIgnoreCase("") && membersFields.get(refDate) != null)
			if(isValidDate(membersFields.get(refDate)))
				membersScheduleService.enrollimmediateMembersVisit(
					members.caseId(),submission.anmId(),membersFields.get(refDate),submission.instanceId(),scheduleName,immediateScheduleName);							
			}
		}
		
		if (membersFields.containsKey(cond))
			if (membersFields.get(cond) == null || membersFields.get(cond).equalsIgnoreCase("")){
			if(membersFields.containsKey(age_days))
				if(!membersFields.get(age_days).equalsIgnoreCase("") && membersFields.get(age_days) != null)
				if(Integer.parseInt(membersFields.get(age_days))<=days){
				if(membersFields.containsKey(refDate))
				if (!membersFields.get(refDate).equalsIgnoreCase("") && membersFields.get(refDate) != null)
				if(isValidDate(membersFields.get(refDate)))
					membersScheduleService.enrollimmediateMembersVisit(
						members.caseId(),submission.anmId(),membersFields.get(refDate),submission.instanceId(),scheduleName,immediateScheduleName);							
				}
			}

		if (membersFields.containsKey(cond))
		if (membersFields.get(cond) != null && !membersFields.get(cond).equalsIgnoreCase("")){
			membersScheduleService.unEnrollAndCloseSchedule(
					members.caseId(),submission.anmId(),immediateScheduleName,LocalDate.parse(submission.getField(REFERENCE_DATE)));
		}		
	}
	
	public void AfterimmediateChildVisit(FormSubmission submission, Members members, String scheduleName, String immediateScheduleName, String refDate, String age, String age_days, String cond, int agenum, int days){
		if (submission.getField(cond) == null || submission.getField(cond).equalsIgnoreCase("")){
		if(!submission.getField(age).equalsIgnoreCase("") && submission.getField(age) != null)
		if(Integer.parseInt(submission.getField(age))<1)
			if (!submission.getField(refDate).equalsIgnoreCase("") && submission.getField(refDate) != null)
			if(isValidDate(submission.getField(refDate))){
				membersScheduleService.enrollAfterimmediateVisit(
						members.caseId(),submission.anmId(),submission.getField(refDate),submission.instanceId(),scheduleName,immediateScheduleName);							
			}
		}
		
		if (submission.getField(cond) == null || submission.getField(cond).equalsIgnoreCase("")){
		if(!submission.getField(age_days).equalsIgnoreCase("") && submission.getField(age_days) != null)
			if(Integer.parseInt(submission.getField(age_days))<=agenum)
			if (!submission.getField(refDate).equalsIgnoreCase("") && submission.getField(refDate) != null)
			if(isValidDate(submission.getField(refDate))){
				membersScheduleService.enrollAfterimmediateVisit(
						members.caseId(),submission.anmId(),submission.getField(refDate),submission.instanceId(),scheduleName,immediateScheduleName);							
			}
		}
		
		if (submission.getField(cond) != null && !submission.getField(cond).equalsIgnoreCase(""))
			membersScheduleService.unEnrollAndCloseSchedule(
					members.caseId(),submission.anmId(),scheduleName,LocalDate.parse(submission.getField(REFERENCE_DATE)));		
	}
	
	public void ChildVaccine(FormSubmission submission, Members members, Map<String, String> membersFields, String scheduleName, String refDate, String age, String age_days, String cond, int agenum, int days) {
		
		if (membersFields.containsKey(cond))
		if (membersFields.get(cond) == null || membersFields.get(cond).equalsIgnoreCase("")){
		if(membersFields.containsKey(age))
		if(!membersFields.get(age).equalsIgnoreCase("") && membersFields.get(age) != null)
		if(Integer.parseInt(membersFields.get(age))<agenum){
			if(membersFields.containsKey(refDate))
			if (!membersFields.get(refDate).equalsIgnoreCase("") && membersFields.get(refDate) != null)
			if(isValidDate(membersFields.get(refDate)))
				membersScheduleService.enrollChildVisit(
					members.caseId(),submission.anmId(),scheduleName,membersFields.get(refDate));							
			}
		}
		
		if (membersFields.containsKey(cond))
		if (membersFields.get(cond) == null || membersFields.get(cond).equalsIgnoreCase("")){
		if(membersFields.containsKey(age_days))
			if(!membersFields.get(age_days).equalsIgnoreCase("") && membersFields.get(age_days) != null)
			if(Integer.parseInt(membersFields.get(age_days))<=days){
			if(membersFields.containsKey(refDate))
			if (!membersFields.get(refDate).equalsIgnoreCase("") && membersFields.get(refDate) != null)
			if(isValidDate(membersFields.get(refDate)))
				membersScheduleService.enrollChildVisit(
					members.caseId(),submission.anmId(),scheduleName,membersFields.get(refDate));							
			}
		}

		if (membersFields.containsKey(cond))
		if (membersFields.get(cond) != null && !membersFields.get(cond).equalsIgnoreCase("")){
			membersScheduleService.unEnrollAndCloseSchedule(
					members.caseId(),submission.anmId(),scheduleName,LocalDate.parse(submission.getField(REFERENCE_DATE)));
		}
	}
	
	public void ChildFollowupVaccine(FormSubmission submission, Members members, String scheduleName, String refDate, String age, String age_days, String cond, int agenum, int days) {
	
		if (submission.getField(cond) == null || submission.getField(cond).equalsIgnoreCase("")){
		if(!submission.getField(age).equalsIgnoreCase("") && submission.getField(age) != null)
		if(Integer.parseInt(submission.getField(age))<5)
			if (!submission.getField(refDate).equalsIgnoreCase("") && submission.getField(refDate) != null)
			if(isValidDate(submission.getField(refDate))){
				membersScheduleService.enrollChildVisit(members.caseId(),submission.anmId(),scheduleName,submission.getField(refDate));
			}				
		}
		
		if (submission.getField(cond) == null || submission.getField(cond).equalsIgnoreCase("")){
		if(!submission.getField(age_days).equalsIgnoreCase("") && submission.getField(age_days) != null)
			if(Integer.parseInt(submission.getField(age_days))<=agenum)
			if (!submission.getField(refDate).equalsIgnoreCase("") && submission.getField(refDate) != null)
			if(isValidDate(submission.getField(refDate))){
				membersScheduleService.enrollChildVisit(members.caseId(),submission.anmId(),scheduleName,submission.getField(refDate));
			}				
		}
		
		if (submission.getField(cond) != null && !submission.getField(cond).equalsIgnoreCase(""))
			membersScheduleService.unEnrollAndCloseSchedule(
					members.caseId(),submission.anmId(),scheduleName,LocalDate.parse(submission.getField(REFERENCE_DATE)));
		
		
	}
	
	public boolean isValidDate(String dateString) {
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        df.parse(dateString);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}
	

}
