package com.test.tools.util;

import java.util.ArrayList;
import java.util.List;

import com.test.tools.pojo.CascaderTreeNode;

/**
 * 
 * @ClassName: TreeBuilderJson
 * @Description: 构建无极树json(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年6月29日 下午1:09:14
 *
 */
public class CascaderTreeBuilderJson {

	public static List<CascaderTreeNode> nodes = null;

	/**
	 * 构建树形结构
	 * 
	 * @return
	 */
	public static List<CascaderTreeNode> buildTree(List<CascaderTreeNode> nodes) {
		CascaderTreeBuilderJson.nodes = nodes;
		List<CascaderTreeNode> treeNodes = new ArrayList<>();
		List<CascaderTreeNode> rootNodes = getRootNodes();
		for (CascaderTreeNode rootNode : rootNodes) {
			buildChildNodes(rootNode);
			treeNodes.add(rootNode);
		}
		return treeNodes;
	}

	/**
	 * 递归子节点
	 * 
	 * @param node
	 */
	private static void buildChildNodes(CascaderTreeNode node) {
		List<CascaderTreeNode> children = getChildNodes(node);
		if (!children.isEmpty()) {
			for (CascaderTreeNode child : children) {
				buildChildNodes(child);
			}
			node.setChildren(children);
		}
	}

	/**
	 * 获取父节点下所有的子节点
	 * 
	 * @param pnode
	 * @return
	 */
	private static List<CascaderTreeNode> getChildNodes(CascaderTreeNode pnode) {
		List<CascaderTreeNode> childNodes = new ArrayList<>();
		for (CascaderTreeNode n : nodes) {
			if (pnode.getValue().equals(n.getCatPid())) {
				childNodes.add(n);
			}
		}
		return childNodes;
	}

	/**
	 * 判断是否为根节点
	 * 
	 * @param node
	 * @return
	 */
	private static boolean rootNode(CascaderTreeNode node) {
		boolean isRootNode = true;
		for (CascaderTreeNode n : nodes) {
			if (node.getCatPid().equals(n.getValue())) {
				isRootNode = false;
				break;
			}
		}
		return isRootNode;
	}

	/**
	 * 获取集合中所有的根节点
	 * 
	 * @return
	 */
	private static List<CascaderTreeNode> getRootNodes() {
		List<CascaderTreeNode> rootNodes = new ArrayList<>();
		for (CascaderTreeNode n : nodes) {
			if (rootNode(n)) {
				rootNodes.add(n);
			}
		}
		return rootNodes;
	}

}
