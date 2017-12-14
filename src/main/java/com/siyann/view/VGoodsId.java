package com.siyann.view;

/**
 * VGoodsId entity. @author MyEclipse Persistence Tools
 */

public class VGoodsId implements java.io.Serializable {

	// Fields
	
	private Long goodsId;
	private String name;		//名称
	private Double price;		//单价
	private String url;
	private Long catalogId;
	private String description;//描述
	private Long time;
	private Short state;
	private Long saleNum;
	private Double originPrice;
	private Integer type;
	private String status;
	private String unit;		//单位
	private String createTime;	//最新修改时间
	private String catalog;		//商品种类
	private Long count;		//商品已售数目
	private Double disPrice;
	private String startDate;
	private String endDate;
	private String goodsUrl;	//商品图片地址
	private String origin;		//原产地

	// Constructors

		/** default constructor */
		public VGoodsId() {
		}

		/** minimal constructor */
		public VGoodsId(Long goodsId, String name, Double price, String url,
				Long catalogId, Long time) {
			this.goodsId = goodsId;
			this.name = name;
			this.price = price;
			this.url = url;
			this.catalogId = catalogId;
			this.time = time;
		}

		/** full constructor */
		public VGoodsId(Long goodsId, String name, Double price, String url,
				Long catalogId, String description, Long time, Short state,
				Long saleNum, Double originPrice, Integer type, String status,
				String unit, String createTime, String catalog, Long count,
				Double disPrice, String startDate, String endDate, String goodsUrl,
				String origin) {
			this.goodsId = goodsId;
			this.name = name;
			this.price = price;
			this.url = url;
			this.catalogId = catalogId;
			this.description = description;
			this.time = time;
			this.state = state;
			this.saleNum = saleNum;
			this.originPrice = originPrice;
			this.type = type;
			this.status = status;
			this.unit = unit;
			this.createTime = createTime;
			this.catalog = catalog;
			this.count = count;
			this.disPrice = disPrice;
			this.startDate = startDate;
			this.endDate = endDate;
			this.goodsUrl = goodsUrl;
			this.origin = origin;
		}

		// Property accessors

		public Long getGoodsId() {
			return this.goodsId;
		}

		public void setGoodsId(Long goodsId) {
			this.goodsId = goodsId;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getPrice() {
			return this.price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getUrl() {
			return this.url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public Long getCatalogId() {
			return this.catalogId;
		}

		public void setCatalogId(Long catalogId) {
			this.catalogId = catalogId;
		}

		public String getDescription() {
			return this.description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getTime() {
			return this.time;
		}

		public void setTime(Long time) {
			this.time = time;
		}

		public Short getState() {
			return this.state;
		}

		public void setState(Short state) {
			this.state = state;
		}

		public Long getSaleNum() {
			return this.saleNum;
		}

		public void setSaleNum(Long saleNum) {
			this.saleNum = saleNum;
		}

		public Double getOriginPrice() {
			return this.originPrice;
		}

		public void setOriginPrice(Double originPrice) {
			this.originPrice = originPrice;
		}

		public Integer getType() {
			return this.type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public String getStatus() {
			return this.status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getUnit() {
			return this.unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public String getCreateTime() {
			return this.createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

		public String getCatalog() {
			return this.catalog;
		}

		public void setCatalog(String catalog) {
			this.catalog = catalog;
		}

		public Long getCount() {
			return this.count;
		}

		public void setCount(Long count) {
			this.count = count;
		}

		public Double getDisPrice() {
			return this.disPrice;
		}

		public void setDisPrice(Double disPrice) {
			this.disPrice = disPrice;
		}

		public String getStartDate() {
			return this.startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getEndDate() {
			return this.endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public String getGoodsUrl() {
			return this.goodsUrl;
		}

		public void setGoodsUrl(String goodsUrl) {
			this.goodsUrl = goodsUrl;
		}

		public String getOrigin() {
			return this.origin;
		}

		public void setOrigin(String origin) {
			this.origin = origin;
		}

		public boolean equals(Object other) {
			if ((this == other))
				return true;
			if ((other == null))
				return false;
			if (!(other instanceof VGoodsId))
				return false;
			VGoodsId castOther = (VGoodsId) other;

			return ((this.getGoodsId() == castOther.getGoodsId()) || (this
					.getGoodsId() != null && castOther.getGoodsId() != null && this
					.getGoodsId().equals(castOther.getGoodsId())))
					&& ((this.getName() == castOther.getName()) || (this.getName() != null
							&& castOther.getName() != null && this.getName()
							.equals(castOther.getName())))
					&& ((this.getPrice() == castOther.getPrice()) || (this
							.getPrice() != null && castOther.getPrice() != null && this
							.getPrice().equals(castOther.getPrice())))
					&& ((this.getUrl() == castOther.getUrl()) || (this.getUrl() != null
							&& castOther.getUrl() != null && this.getUrl().equals(
							castOther.getUrl())))
					&& ((this.getCatalogId() == castOther.getCatalogId()) || (this
							.getCatalogId() != null
							&& castOther.getCatalogId() != null && this
							.getCatalogId().equals(castOther.getCatalogId())))
					&& ((this.getDescription() == castOther.getDescription()) || (this
							.getDescription() != null
							&& castOther.getDescription() != null && this
							.getDescription().equals(castOther.getDescription())))
					&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
							&& castOther.getTime() != null && this.getTime()
							.equals(castOther.getTime())))
					&& ((this.getState() == castOther.getState()) || (this
							.getState() != null && castOther.getState() != null && this
							.getState().equals(castOther.getState())))
					&& ((this.getSaleNum() == castOther.getSaleNum()) || (this
							.getSaleNum() != null && castOther.getSaleNum() != null && this
							.getSaleNum().equals(castOther.getSaleNum())))
					&& ((this.getOriginPrice() == castOther.getOriginPrice()) || (this
							.getOriginPrice() != null
							&& castOther.getOriginPrice() != null && this
							.getOriginPrice().equals(castOther.getOriginPrice())))
					&& ((this.getType() == castOther.getType()) || (this.getType() != null
							&& castOther.getType() != null && this.getType()
							.equals(castOther.getType())))
					&& ((this.getStatus() == castOther.getStatus()) || (this
							.getStatus() != null && castOther.getStatus() != null && this
							.getStatus().equals(castOther.getStatus())))
					&& ((this.getUnit() == castOther.getUnit()) || (this.getUnit() != null
							&& castOther.getUnit() != null && this.getUnit()
							.equals(castOther.getUnit())))
					&& ((this.getCreateTime() == castOther.getCreateTime()) || (this
							.getCreateTime() != null
							&& castOther.getCreateTime() != null && this
							.getCreateTime().equals(castOther.getCreateTime())))
					&& ((this.getCatalog() == castOther.getCatalog()) || (this
							.getCatalog() != null && castOther.getCatalog() != null && this
							.getCatalog().equals(castOther.getCatalog())))
					&& ((this.getCount() == castOther.getCount()) || (this
							.getCount() != null && castOther.getCount() != null && this
							.getCount().equals(castOther.getCount())))
					&& ((this.getDisPrice() == castOther.getDisPrice()) || (this
							.getDisPrice() != null
							&& castOther.getDisPrice() != null && this
							.getDisPrice().equals(castOther.getDisPrice())))
					&& ((this.getStartDate() == castOther.getStartDate()) || (this
							.getStartDate() != null
							&& castOther.getStartDate() != null && this
							.getStartDate().equals(castOther.getStartDate())))
					&& ((this.getEndDate() == castOther.getEndDate()) || (this
							.getEndDate() != null && castOther.getEndDate() != null && this
							.getEndDate().equals(castOther.getEndDate())))
					&& ((this.getGoodsUrl() == castOther.getGoodsUrl()) || (this
							.getGoodsUrl() != null
							&& castOther.getGoodsUrl() != null && this
							.getGoodsUrl().equals(castOther.getGoodsUrl())))
					&& ((this.getOrigin() == castOther.getOrigin()) || (this
							.getOrigin() != null && castOther.getOrigin() != null && this
							.getOrigin().equals(castOther.getOrigin())));
		}

		public int hashCode() {
			int result = 17;

			result = 37 * result
					+ (getGoodsId() == null ? 0 : this.getGoodsId().hashCode());
			result = 37 * result
					+ (getName() == null ? 0 : this.getName().hashCode());
			result = 37 * result
					+ (getPrice() == null ? 0 : this.getPrice().hashCode());
			result = 37 * result
					+ (getUrl() == null ? 0 : this.getUrl().hashCode());
			result = 37 * result
					+ (getCatalogId() == null ? 0 : this.getCatalogId().hashCode());
			result = 37
					* result
					+ (getDescription() == null ? 0 : this.getDescription()
							.hashCode());
			result = 37 * result
					+ (getTime() == null ? 0 : this.getTime().hashCode());
			result = 37 * result
					+ (getState() == null ? 0 : this.getState().hashCode());
			result = 37 * result
					+ (getSaleNum() == null ? 0 : this.getSaleNum().hashCode());
			result = 37
					* result
					+ (getOriginPrice() == null ? 0 : this.getOriginPrice()
							.hashCode());
			result = 37 * result
					+ (getType() == null ? 0 : this.getType().hashCode());
			result = 37 * result
					+ (getStatus() == null ? 0 : this.getStatus().hashCode());
			result = 37 * result
					+ (getUnit() == null ? 0 : this.getUnit().hashCode());
			result = 37
					* result
					+ (getCreateTime() == null ? 0 : this.getCreateTime()
							.hashCode());
			result = 37 * result
					+ (getCatalog() == null ? 0 : this.getCatalog().hashCode());
			result = 37 * result
					+ (getCount() == null ? 0 : this.getCount().hashCode());
			result = 37 * result
					+ (getDisPrice() == null ? 0 : this.getDisPrice().hashCode());
			result = 37 * result
					+ (getStartDate() == null ? 0 : this.getStartDate().hashCode());
			result = 37 * result
					+ (getEndDate() == null ? 0 : this.getEndDate().hashCode());
			result = 37 * result
					+ (getGoodsUrl() == null ? 0 : this.getGoodsUrl().hashCode());
			result = 37 * result
					+ (getOrigin() == null ? 0 : this.getOrigin().hashCode());
			return result;
		}

}