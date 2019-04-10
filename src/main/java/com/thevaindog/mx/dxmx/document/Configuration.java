package com.thevaindog.mx.dxmx.document;

import java.util.List;

@JsonFile("configuration")
public class Configuration {
	
	private String _id;
	
	private Implementation implementation;
	
	private Format format;
	
	private Environment environment;
	
	private List<SQLStatement> sqlStatement;
	
	private String description; 

	public Configuration() {super();}

	public Configuration(String _id, Implementation implementation, Format format, Environment environment,
			List<SQLStatement> sqlStatement, String description) {
		super();
		this._id = _id;
		this.implementation = implementation;
		this.format = format;
		this.environment = environment;
		this.sqlStatement = sqlStatement;
		this.description = description;
	}

	public String get_id() {return _id;}
	public void set_id(String _id) {this._id = _id;}

	public Implementation getImplementation() {return implementation;}
	public void setImplementation(Implementation implementation) {this.implementation = implementation;}

	public Format getFormat() {return format;}
	public void setFormat(Format format) {this.format = format;}

	public Environment getEnvironment() {return environment;}
	public void setEnvironment(Environment environment) {this.environment = environment;}

	public List<SQLStatement> getSqlStatement() {return sqlStatement;}
	public void setSqlStatement(List<SQLStatement> sqlStatement) {this.sqlStatement = sqlStatement;}

	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((environment == null) ? 0 : environment.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((implementation == null) ? 0 : implementation.hashCode());
		result = prime * result + ((sqlStatement == null) ? 0 : sqlStatement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Configuration other = (Configuration) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (environment == null) {
			if (other.environment != null)
				return false;
		} else if (!environment.equals(other.environment))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (implementation == null) {
			if (other.implementation != null)
				return false;
		} else if (!implementation.equals(other.implementation))
			return false;
		if (sqlStatement == null) {
			if (other.sqlStatement != null)
				return false;
		} else if (!sqlStatement.equals(other.sqlStatement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Configuration [_id=" + _id + ", implementation=" + implementation + ", format=" + format
				+ ", environment=" + environment + ", sqlStatement=" + sqlStatement + ", description=" + description
				+ "]";
	}
}
