/**
 * @author julkar nain 
 */
package org.opensrp.register.mcare.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.TypeDiscriminator;
import org.joda.time.LocalDate;
import org.motechproject.model.MotechBaseDataObject;

@TypeDiscriminator("doc.type === 'Mother'")
public class Mother extends MotechBaseDataObject {
	@JsonProperty
	private String caseId;
	@JsonProperty
	private String INSTANCEID;
	@JsonProperty
	private String PROVIDERID;
	@JsonProperty
	private String LOCATIONID;
	@JsonProperty
	private String GOBHHID;
	@JsonProperty
	private String JiVitAHHID;
	@JsonProperty
	private String FWWOMFNAME;
	@JsonProperty
	private String FWWOMNID;
	@JsonProperty
	private String FWWOMBID;
	@JsonProperty
	private String FWWOMAGE;
	@JsonProperty
	private String TODAY;
	@JsonProperty
	private String START;
	@JsonProperty
	private String END;
	@JsonProperty
	private String relationalid;
	@JsonProperty
    private String isClosed;
	@JsonProperty
	private Map<String, String> details;
	@JsonProperty
	private Map<String, String> ancVisitOne;
	@JsonProperty
	private Map<String, String> ancVisitTwo;
	@JsonProperty
	private Map<String, String> ancVisitThree;
	@JsonProperty
	private Map<String, String> ancVisitFour;
	@JsonProperty
	private Map<String, String> bnfVisit;
	@JsonProperty
	private Map<String, String> pncVisitOne;
	@JsonProperty
	private Map<String, String> pncVisitTwo;
	@JsonProperty
	private Map<String, String> pncVisitThree;
	
	public Mother() {

		this.details = new HashMap<>();
		this.ancVisitOne = new HashMap<>();
		this.ancVisitTwo = new HashMap<>();
		this.ancVisitThree = new HashMap<>();
		this.ancVisitFour = new HashMap<>();
		this.bnfVisit = new HashMap<>();
		this.setIsClosed(false);
	}
	
	public Mother withCaseId(String caseId) {
		this.caseId = caseId;
		return this;
	}

	public Mother withINSTANCEID(String INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
		return this;
	}

	public Mother withPROVIDERID(String PROVIDERID) {
		this.PROVIDERID = PROVIDERID;
		return this;
	}

	public Mother withLOCATIONID(String LOCATIONID) {
		this.LOCATIONID = LOCATIONID;
		return this;
	}

	public Mother withTODAY(String lmp) {
		this.TODAY = lmp;
		return this;
	}

	public Mother withSTART(String START) {
		this.START = START;
		return this;
	}

	public Mother withEND(String END) {
		this.END = END;
		return this;
	}
	public Mother withRelationalId(String relationalid) {
		this.relationalid = relationalid;
		return this;
	}

	public Mother withANCVisitOne(Map<String, String> ancVisitOne) {
        this.ancVisitOne = new HashMap<>(ancVisitOne);
        return this;
    }
	public Mother withANCVisitTwo(Map<String, String> ancVisitTwo) {
        this.ancVisitTwo = new HashMap<>(ancVisitTwo);
        return this;
    }
	public Mother withANCVisitThree(Map<String, String> ancVisitThree) {
        this.ancVisitThree = new HashMap<>(ancVisitThree);
        return this;
    }
	public Mother withANCVisitFour(Map<String, String> ancVisitFour) {
        this.ancVisitFour = new HashMap<>(ancVisitFour);
        return this;
    }
	public Mother withBNFVisit(Map<String, String> bnfVisit) {
        this.bnfVisit = new HashMap<>(bnfVisit);
        return this;
    }
	public Mother withPNCVisitOne(Map<String, String> pncVisitOne) {
        this.pncVisitOne = new HashMap<>(pncVisitOne);
        return this;
    }
	public Mother withPNCVisitTwo(Map<String, String> pncVisitTwo) {
        this.pncVisitTwo = new HashMap<>(pncVisitTwo);
        return this;
    }
	public Mother withPNCVisitThree(Map<String, String> pncVisitThree) {
        this.pncVisitThree = new HashMap<>(pncVisitThree);
        return this;
    }

	public String caseId() {
		return caseId;
	}

	public String INSTANCEID() {
		return INSTANCEID;
	}

	public String PROVIDERID() {
		return PROVIDERID;
	}

	public String LOCATIONID() {
		return LOCATIONID;
	}
	
	public String TODAY() {
		return TODAY;
	}
	public String START() {
		return START;
	}

	public String END() {
		return END;
	}
	
	public String relationalid() {
		return relationalid;
	}

	private String getCaseId() {
		return caseId;
	}

	public String getRelationalId() {
		return relationalid;
	}

	public Map<String, String> details() {
		return details;
	}
	public String getDetail(String name) {
		return details.get(name);
	}
	
	public Map<String, String> ancVisitOne() {
		return ancVisitOne;
	}
	public Map<String, String> ancVisitTwo() {
		return ancVisitTwo;
	}
	public Map<String, String> ancVisitThree() {
		return ancVisitThree;
	}
	public Map<String, String> ancVisitFour() {
		return ancVisitFour;
	}
	public Map<String, String> bnfVisit() {
		return bnfVisit;
	}
	public Map<String, String> pncVisitOne() {
		return pncVisitOne;
	}
	public Map<String, String> pncVisitTwo() {
		return pncVisitTwo;
	}
	public Map<String, String> pncVisitThree() {
		return pncVisitThree;
	}
    public Mother setIsClosed(boolean isClosed) {
        this.isClosed = Boolean.toString(isClosed);
        return this;
    }
	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o, "id", "revision");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "revision");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}