package com.test.tools.pojo;

import java.util.List;

/**
 * 
 * @ClassName: CascaderTreeNode
 * @Description: Cascader 级联选择器 封装tree(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年7月5日 下午1:32:36
 *
 */
public class CascaderTreeNode {

	private Integer value;

	private String label;
	private Integer catPid;// 上级id

	private List<CascaderTreeNode> children;// 子节点

	public CascaderTreeNode() {
		super();
	}

	public CascaderTreeNode(Integer value, String label, Integer catPid) {
		super();
		this.value = value;
		this.label = label;
		this.catPid = catPid;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<CascaderTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<CascaderTreeNode> children) {
		this.children = children;
	}

	public Integer getCatPid() {
		return catPid;
	}

	public void setCatPid(Integer catPid) {
		this.catPid = catPid;
	}

	@Override
	public String toString() {
		return "CascaderTreeNode [value=" + value + ", label=" + label + ", catPid=" + catPid + ", children=" + children
				+ "]";
	}

}
