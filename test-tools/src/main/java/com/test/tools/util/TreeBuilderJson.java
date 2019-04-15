package com.test.tools.util;

import java.util.ArrayList;
import java.util.List;

import com.test.tools.pojo.GoodsTreeNode;

/**
 * 
 * @ClassName: TreeBuilderJson
 * @Description: 构建无极树json(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年6月29日 下午1:09:14
 *
 */
public class TreeBuilderJson {

	public static List<GoodsTreeNode> nodes = null;

	/**
	 * 构建树形结构
	 * 
	 * @return
	 */
	public static List<GoodsTreeNode> buildTree(List<GoodsTreeNode> nodes) {
		TreeBuilderJson.nodes = nodes;
		List<GoodsTreeNode> treeNodes = new ArrayList<>();
		List<GoodsTreeNode> rootNodes = getRootNodes();
		for (GoodsTreeNode rootNode : rootNodes) {
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
	private static void buildChildNodes(GoodsTreeNode node) {
		List<GoodsTreeNode> children = getChildNodes(node);
		if (!children.isEmpty()) {
			for (GoodsTreeNode child : children) {
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
	private static List<GoodsTreeNode> getChildNodes(GoodsTreeNode pnode) {
		List<GoodsTreeNode> childNodes = new ArrayList<>();
		for (GoodsTreeNode n : nodes) {
			if (pnode.getCatId().equals(n.getCatPid())) {
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
	private static boolean rootNode(GoodsTreeNode node) {
		boolean isRootNode = true;
		for (GoodsTreeNode n : nodes) {
			if (node.getCatPid().equals(n.getCatId())) {
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
	private static List<GoodsTreeNode> getRootNodes() {
		List<GoodsTreeNode> rootNodes = new ArrayList<>();
		for (GoodsTreeNode n : nodes) {
			if (rootNode(n)) {
				rootNodes.add(n);
			}
		}
		return rootNodes;
	}

}
