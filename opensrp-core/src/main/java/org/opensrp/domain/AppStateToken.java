package org.opensrp.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.TypeDiscriminator;
import org.motechproject.model.MotechBaseDataObject;

@TypeDiscriminator("doc.type === 'AppStateToken'")
public class AppStateToken extends MotechBaseDataObject {
    @JsonProperty
    private String name;
    
    @JsonProperty
    private Object value;
    
    @JsonProperty
    private long lastEditDate;
    
    @JsonProperty
    private String description;

    protected AppStateToken() {
    }

    public AppStateToken(String name, Object value, long lastEditDate) {
		this.name = name;
		this.value = value;
		this.lastEditDate = lastEditDate;
	}

	public AppStateToken(String name, Object value, long lastEditDate, String description) {
		this.name = name;
		this.value = value;
		this.lastEditDate = lastEditDate;
		this.description = description;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}
	
	public long longValue() {
		return Long.parseLong(value.toString());
	}
	
	public int intValue() {
		return Integer.parseInt(value.toString());
	}
	
	public float floatValue() {
		return Float.parseFloat(value.toString());
	}
	
	public double doubleValue() {
		return Double.parseDouble(value.toString());
	}
	
	public String stringValue() {
		return value.toString();
	}
	
	public boolean booleanValue() {
		return Boolean.parseBoolean(value.toString());
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

	public long getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(long lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id");
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
