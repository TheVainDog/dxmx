package com.thevaindog.mx.dxmx.document;

import java.util.List;

@JsonFile("sqlstatement")
public class SQLStatement {

	private String _id;
	
	private String type;
	
	private List<Field> fields;
	
	private String description;

	public SQLStatement() {super();}

	public SQLStatement(String _id, String type, List<Field> fields, String description) {
		super();
		this._id = _id;
		this.type = type;
		this.fields = fields;
		this.description = description;
	}

	public String get_id() {return _id;}
	public void set_id(String _id) {this._id = _id;}

	public String getType() {return type;}
	public void setType(String type) {this.type = type;}

	public List<Field> getFields() {return fields;}
	public void setFields(List<Field> fields) {this.fields = fields;}

	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		SQLStatement other = (SQLStatement) obj;
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
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SQLStatement [_id=" + _id + ", type=" + type + ", fields=" + fields + ", description=" + description
				+ "]";
	}
}
