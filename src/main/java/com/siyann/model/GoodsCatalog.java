package com.siyann.model;

/**
 * GoodsCatalog entity. @author MyEclipse Persistence Tools
 */

public class GoodsCatalog implements java.io.Serializable {

	// Fields

	private Long id;
	private String catalog;
	private String url;
	private String description;
	private Integer type;

	// Constructors

	/** default constructor */
	public GoodsCatalog() {
	}

	/** minimal constructor */
	public GoodsCatalog(String catalog) {
		this.catalog = catalog;
	}

	/** full constructor */
	public GoodsCatalog(String catalog, String url, String description,
			Integer type) {
		this.catalog = catalog;
		this.url = url;
		this.description = description;
		this.type = type;
	}

	public GoodsCatalog(Long id, String catalog, String url,
			String description, Integer type) {
		super();
		this.id = id;
		this.catalog = catalog;
		this.url = url;
		this.description = description;
		this.type = type;
	}
	// Property accessors


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCatalog() {
		return this.catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}