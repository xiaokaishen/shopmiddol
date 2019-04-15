package com.test.tools.pojo;

import java.util.List;

/**
 * 
 * @ClassName: GoodsTreeNode
 * @Description: 商品无极分类树pojo(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年6月29日 上午10:41:15
 *
 */
public class GoodsTreeNode {
	private Integer catId;// 分类id
	private Integer catPid;// 上级id
	private String catImg;// 分类图标
	private String catName;// 分类名称

	private List<GoodsTreeNode> children;// 子节点

	public GoodsTreeNode() {
	}

	public GoodsTreeNode(Integer catId, Integer catPid, String catImg, String catName) {
		super();
		this.catId = catId;
		this.catPid = catPid;
		this.catImg = catImg;
		this.catName = catName;
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public Integer getCatPid() {
		return catPid;
	}

	public void setCatPid(Integer catPid) {
		this.catPid = catPid;
	}

	public String getCatImg() {
		return catImg;
	}

	public void setCatImg(String catImg) {
		this.catImg = catImg;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public List<GoodsTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<GoodsTreeNode> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "GoodsTreeNode [catId=" + catId + ", catPid=" + catPid + ", catImg=" + catImg + ", catName=" + catName
				+ ", children=" + children + "]";
	}

}
