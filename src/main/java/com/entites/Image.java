package com.entites;

public class Image {

	private String name;
	private Long size;
	private String extension;
	private String path;
	
	public Image() {
	}
	
	public Image(String name, Long size, String extension, String path) {
		super();
		this.name = name;
		this.size = size;
		this.extension = extension;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Image{");
		sb.append("name='").append(name).append('\'');
		sb.append(", size=").append(size);
		sb.append(", extension='").append(extension).append('\'');
		sb.append(", path='").append(path).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
