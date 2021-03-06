package com.thevaindog.mx.dxmx.document;

@JsonFile("environment")
public class Environment {

	private String _id;
	
	private String name;
	
	private String description;

	public Environment() {super();}

	public Environment(String _id, String name, String description) {
		super();
		this._id = _id;
		this.name = name;
		this.description = description;
	}
	
	public String get_id() {return _id;}
	public void set_id(String _id) {this._id = _id;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Environment other = (Environment) obj;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Environment [_id=" + _id + ", name=" + name + ", description=" + description + "]";
	}
}
