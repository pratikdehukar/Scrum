package com.ScrumTool.BacklogItems;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ScrumTool.BacklogItemParentChild.BacklogItemParentChild;
import com.ScrumTool.BacklogItemParentChild.BacklogItemParentChildRepository;

@Component
public class Service {
	

    @Autowired
    private BacklogItemsRepository backlogItemRepository;

	@Autowired
	private BacklogItemParentChildRepository backlogItemParentChildRepository;

	private List<Tree> getTreeList() {
		List<BacklogItemDto> backlogItems = backlogItemRepository.findBacklogItemColumns();
		List<Tree> treeList = new ArrayList<Tree>();

		for (BacklogItemDto backlogItem : backlogItems) {
			long id = backlogItem.getBacklogItemId();
			String backlogName = backlogItem.getBacklogName();
			long backlogType = backlogItem.getBacklogTypeId();

			Tree tree = new Tree(id, backlogName, backlogType);
			treeList.add(tree);
		}

		return treeList;
	}

	private List<Tree> addChild() {
		List<Tree> treeList = getTreeList();
		List<Tree> parentChildTree = new ArrayList<Tree>();
		List<BacklogItemParentChild> backlogItemRelationships = backlogItemParentChildRepository.findAll();

		for (BacklogItemParentChild backlogItemRelationship : backlogItemRelationships) {
			long parentId = backlogItemRelationship.getBacklogItemParentId().getBacklogItemId();
			long childId = backlogItemRelationship.getBacklogItemChildId().getBacklogItemId();

			Tree parent = getTreeNode(treeList, parentId);
			Tree child = getTreeNode(treeList, childId);

			if (hasTreeNode(parentChildTree, parentId)) {
				getTreeNode(parentChildTree, parentId).getChildren().add(child);
			} else {
				parent.getChildren().add(child);
				parentChildTree.add(parent);
			}

		}

		return parentChildTree;
	}

	public List<Tree> getTree() {
		List<Tree> parentChildHierarchy = addChild();
		List<Tree> finalTree = new ArrayList<Tree>();

		for (Tree tree : parentChildHierarchy) {
			if (tree.getType() == 2 || tree.getType() == 3) {
				continue;
			} else {
				finalTree.add(tree);
			}
		}

		System.out.print(parentChildHierarchy);

		return finalTree;
	}

	private Tree getTreeNode(List<Tree> treeList, long id) {
		for (Tree tree : treeList) {
			if (id == tree.getId()) {
				return tree;
			}
		}
		return null;
	}

	private boolean hasTreeNode(List<Tree> treeList, long id) {
		for (Tree tree : treeList) {
			if (id == tree.getId()) {
				return true;
			}
		}
		return false;
	}
}