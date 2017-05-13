package tree;

import org.junit.Assert;
import org.junit.Test;


public class BinaryTreeTest {

	/**
	 * 可被搜尋到的結果
	 */
	@Test
	public void findTreeTest() {
		int arr[]={7,4,1,5,13,8,11,12,15,9,2};
		BinaryTree tree = new BinaryTree(arr);
		Assert.assertEquals(true,tree.findTree(tree.rootNode, 15));
	}

}
