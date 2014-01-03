package com.shermanpay.mex;

/**
 * Tree class for testing
 * @author Sherman Pay Jing Hao
 */
public class TestTree {
    TestNode overallRoot;    
    public TestTree() {};
    
    public TestTree(String data) {
	overallRoot = new TestNode(data);
    }

    public String toString() {
	return toStringHelper(overallRoot);
    }

    private String toStringHelper(TestNode root) {
	if (root == null) {
	    return "";
	} else {
	    return toStringHelper(root.left) + root.toString()
		+ toStringHelper(root.right);
	}
    }


}
