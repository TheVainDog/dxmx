package com.thevaindog.mx.dxmx.document;

@JsonFile("format")
public class Format {

	private String _id;
	
	private String type;
	
	private String description;
	
	public Format() {super();}
	
	public Format(String _id, String type, String description) {
		super();
		this._id = _id;
		this.type = type;
		this.description = description;
	}
	
	public String get_id() {return _id;}
	public void set_id(String _id) {this._id = _id;}
	
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Format other = (Format) obj;
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Format [_id=" + _id + ", type=" + type + ", description=" + description + "]";
	}
}
