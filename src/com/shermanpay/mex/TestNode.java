package com.shermanpay.mex;

/**
 * Node class for testing
 * @author Sherman Pay Jing Hao
 * @version 0.1
 */
public class TestNode {
    TestNode left;
    String data;
    TestNode right;

    public TestNode(){}

    public TestNode(String data) {
	this.data = data;
    }

    public TestNode(TestNode left, String data, TestNode right) {
	this.left = left;
	this.data = data;
	this.right = right;
    }

    public String toString() {
	return data;
    }
}
