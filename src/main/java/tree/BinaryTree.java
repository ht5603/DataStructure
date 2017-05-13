package tree;

class TreeNode{
	int value;
	TreeNode leftNode;
	TreeNode rightNode;
	public TreeNode(int value){
		this.value = value;
	}
}

public class BinaryTree {
	
	public static int count = 1;

	public static void main(String[] args) {
		System.out.println("start!");
//		int[] vals = {65,66,67,68,69,70};
//		BinaryTree binaryTree = new BinaryTree(vals);
//		System.out.println("build Tree finish!");
//		System.out.println("後序走訪");
//		binaryTree.postOrder(binaryTree.rootNode);
//		System.out.println("前序走訪");
//		binaryTree.preOrder(binaryTree.rootNode);
		
		

	}
	
	public TreeNode rootNode;
	
	public BinaryTree(int[] values){
		for(int val : values){
			addValToTree(val);
		}
	}

	public void addValToTree(int val) {
		TreeNode currentNode = rootNode;
		if (rootNode  == null){
			rootNode = new TreeNode(val);
			return;
		}
		while(true){
			if(val < currentNode.value){//在左子樹
				if (currentNode.leftNode == null){
					currentNode.leftNode = new TreeNode(val);
					return;
				}else {
					 currentNode=currentNode.leftNode;
				}
			}else {//在右子樹
				if(currentNode.rightNode == null){
					currentNode.rightNode = new TreeNode(val);
					return;
				}else {
					currentNode=currentNode.rightNode;
				}
			}
		}
	}
	
	public void inOrder(TreeNode node){
		if(node!=null){
			System.out.println("node: " + (char)node.value);
			inOrder(node.leftNode);
			inOrder(node.rightNode);
		}
	}
	
    public void preOrder(TreeNode node){

        if(node!=null){
        	System.out.println("node: " +  (char)node.value);
        	preOrder(node.leftNode);
        	preOrder(node.rightNode);
			
		}
	}

    public void postOrder(TreeNode node){
	
        if(node!=null){
        	postOrder(node.leftNode);
        	postOrder(node.rightNode);
        	System.out.println("node: " +  (char)node.value);
		}
    }
    
    public boolean findTree(TreeNode node, int value){
    	
    	if (node == null) {
    		return false;
    	} else if (node.value == value) {
    		System.out.print("共搜尋"+count+"次\n");
			return true;
    	} else if (node.value > value){
    		count += 1;
    		return findTree(node.leftNode,value);
    	} else{
    		count += 1;
    		return findTree(node.rightNode,value);
    	}
    }
	

}
