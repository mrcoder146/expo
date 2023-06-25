package com.ScrumTool.BacklogItems;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ScrumTool.BacklogItemParentChild.BacklogItemParentChild;
import com.ScrumTool.BacklogItemParentChild.BacklogItemParentChildRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class BacklogItemsController {

	@Autowired
	private BacklogItemsRepository backlogItemRepository;
	@Autowired
	private BacklogItemParentChildRepository backlogItemParentChildRepository;
	
	//returns data from backlogItem table
	private List<BacklogItems> getAllBacklogItem() {
		return backlogItemRepository.findAll();
	}
	
	//returns data from backlogItemParentChild table table
	private List<BacklogItemParentChild> getAllBacklogItemParentChild() {
		return backlogItemParentChildRepository.findAll();
	}
	
	//Creating tree node with required fields
	
	private ArrayList<Tree> getTreeNodeList() {
		List<BacklogItems> backlogItems = getAllBacklogItem();
		ArrayList<Tree> treeList = new ArrayList<Tree>();
		
		for(BacklogItems backlogItem: backlogItems ) {
			long id = backlogItem.getBacklogItemId();
			String backlogType = backlogItem.getBacklogName();
			Tree tree = new Tree(id,backlogType);
			treeList.add(tree);
		}
		return treeList;
	}
	
	
	//Establishing the relationship between different backlogs 
	@GetMapping("/Tree")
	public ArrayList<Tree> getTree() {
		List<BacklogItemParentChild> backlogItemParentChildList = getAllBacklogItemParentChild();
		ArrayList<Tree> tree = new ArrayList<Tree>();
		
		for(BacklogItemParentChild backlogItemParentChild: backlogItemParentChildList) {
			long parentId = backlogItemParentChild.getBacklogItemParentId().getBacklogItemId();
			long childId = backlogItemParentChild.getBacklogItemChildId().getBacklogItemId();
			
			
			Tree parentNode = getTreeNode(parentId,getTreeNodeList());
			parentNode.getChildren().add(getTreeNode(childId,getTreeNodeList()));
			Tree grandParent;
			
			boolean added = false;
			
			for(BacklogItemParentChild backlogItemParent: backlogItemParentChildList) {
				if(parentId == backlogItemParent.getBacklogItemChildId().getBacklogItemId()) {
					grandParent =  getTreeNode(backlogItemParent.getBacklogItemParentId().getBacklogItemId(),getTreeNodeList());
					added = true;
					if(hasTree(grandParent.getId(),tree)) {
						getTreeNode(grandParent.getId(),tree).getChildren().add(parentNode);
						
						break;
					}
					grandParent.getChildren().add(parentNode);
					
					tree.add(grandParent);
				
					break;
				} 
			}
			
			if(!added) {
				boolean alreadyExist = false;
				
				for(BacklogItemParentChild backlogItemParent: backlogItemParentChildList) {
					if(childId == backlogItemParent.getBacklogItemParentId().getBacklogItemId()) {
						alreadyExist = true;
						break;
					}
				}
				if(hasTree(parentId,tree) && !alreadyExist) {
					getTreeNode(parentId,tree).getChildren().add(getTreeNode(childId,getTreeNodeList()));
				}else {
					if(!alreadyExist) {
						tree.add(parentNode);
					}
				}
				added = false;
			}  
			
		}
			
		return tree;
	}
	
	//getting the tree node based on id
	private Tree getTreeNode(long id,List<Tree> treeList) {
		//ArrayList<Tree> treeList = getTreeNodeList();
		for(Tree tree: treeList) {
			if(tree.getId() == id) {
				return tree;
			}
		}
		return null;
	}
	
	//getting the tree node based on id
		private boolean hasTree(long id, List<Tree> treeList) {
			for(Tree tree: treeList) {
				if(tree.getId() == id) {
					return true;
				}
			}
			return false;
		}
}
