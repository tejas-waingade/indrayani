package com.indrayani.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_video")
public class VideoInfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "type")
	private String type;

	@Column(name = "image")
	private String image;

	@Column(name = "external_url")
	private String external_url;

	@Column(name = "created_at")
	private Long created_at;

	@Column(name = "created_by")
	private String created_by;

	@Column(name = "updated_at")
	private String updated_at;

	@Column(name = "updated_by")
	private String updated_by;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getExternal_url() {
		return external_url;
	}

	public void setExternal_url(String external_url) {
		this.external_url = external_url;
	}

	public Long getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Long created_at) {
		this.created_at = created_at;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public VideoInfoEntity(long id, String title, String content, String type, String image, String external_url,
			Long created_at, String created_by, String updated_at, String updated_by) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.type = type;
		this.image = image;
		this.external_url = external_url;
		this.created_at = created_at;
		this.created_by = created_by;
		this.updated_at = updated_at;
		this.updated_by = updated_by;
	}

	public VideoInfoEntity() {
		super();
	}

}
